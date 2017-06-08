define([
	"./core"
], function (jTeddy) {

	var escapeable = /["\\\x00-\x1f\x7f-\x9f]/g;
	var meta = {    // table of character substitutions
		'\b': '\\b',
		'\t': '\\t',
		'\n': '\\n',
		'\f': '\\f',
		'\r': '\\r',
		'"': '\\"',
		'\\': '\\\\'
	}

	 // JSON RegExp
	var rvalidchars = /^[\],:{}\s]*$/,
		rvalidbraces = /(?:^|:|,)(?:\s*\[)+/g,
		rvalidescape = /\\(?:["\\\/bfnrt]|u[\da-fA-F]{4})/g,
		rvalidtokens = /"[^"\\\r\n]*"|true|false|null|-?(?:\d+\.|)\d+(?:[eE][+-]?\d+|)/g;

	jTeddy.quoteString = function (string)
		// Places quotes around a string, inteligently.
		// If the string contains no control characters, no quote characters, and no
		// backslash characters, then we can safely slap some quotes around it.
		// Otherwise we must also replace the offending characters with safe escape
		// sequences.
	{
		if (escapeable.test(string)) {
			return '"' + string.replace(escapeable, function (a) {
					var c = meta[a];
					if (typeof c === 'string') {
						return c;
					}
					c = a.charCodeAt();
					return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
				}) + '"'
		}
		return '"' + string + '"';
	}

	jTeddy.toJSON = function (o, compact) {
		var type = typeof(o);

		if (type == "undefined")
			return "undefined";
		else if (type == "number" || type == "boolean")
			return o + "";
		else if (o === null)
			return "null";

		// Is it a string?
		if (type == "string") {
			return jTeddy.quoteString(o);
		}

		// Does it have a .toJSON function?
		if (type == "object" && typeof o.toJSON == "function")
			return o.toJSON(compact);

		// Is it an array?
		if (type != "function" && typeof(o.length) == "number") {
			var ret = [];
			for (var i = 0; i < o.length; i++) {
				ret.push(jTeddy.toJSON(o[i], compact));
			}
			if (compact)
				return "[" + ret.join(",") + "]";
			else
				return "[" + ret.join(", ") + "]";
		}

		// If it's a function, we have to warn somebody!
		if (type == "function") {
			throw new TypeError("Unable to convert object of type 'function' to json.");
		}

		// It's probably an object, then.
		ret = [];
		for (var k in o) {
			var name;
			var type = typeof(k);

			if (type == "number")
				name = '"' + k + '"';
			else if (type == "string")
				name = jTeddy.quoteString(k);
			else
				continue;  //skip non-string or number keys

			val = jTeddy.toJSON(o[k], compact);
			if (typeof(val) != "string") {
				// skip non-serializable values
				continue;
			}

			if (compact)
				ret.push(name + ":" + val);
			else
				ret.push(name + ": " + val);
		}
		return "{" + ret.join(", ") + "}";
	}
	jTeddy.compactJSON = function (o) {
		return jTeddy.toJSON(o, true);
	}

	jTeddy.evalJSON = function (src)
		// Evals JSON that we know to be safe.
	{
		return eval("(" + src + ")");
	}

	jTeddy.secureEvalJSON = function (src)
		// Evals JSON in a way that is *more* secure.
	{
		var filtered = src;
		filtered = filtered.replace(/\\["\\\/bfnrtu]/g, '@');
		filtered = filtered.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']');
		filtered = filtered.replace(/(?:^|:|,)(?:\s*\[)+/g, '');

		if (/^[\],:{}\s]*$/.test(filtered))
			return eval("(" + src + ")");
		else
			throw new SyntaxError("Error parsing JSON, source is not valid.");
	}

	jTeddy.parseJSON = function( data ) {
		// Attempt to parse using the native JSON parser first
		if ( window.JSON && window.JSON.parse ) {
			return window.JSON.parse( data );
		}

		if ( data === null ) {
			return data;
		}

		if ( typeof data === "string" ) {

			// Make sure leading/trailing whitespace is removed (IE can't handle it)
			data = jTeddy.trim( data );

			if ( data ) {
				// Make sure the incoming data is actual JSON
				// Logic borrowed from http://json.org/json2.js
				if ( rvalidchars.test( data.replace( rvalidescape, "@" )
						.replace( rvalidtokens, "]" )
						.replace( rvalidbraces, "")) ) {

					return ( new Function( "return " + data ) )();
				}
			}
		}

		jTeddy.error( "Invalid JSON: " + data );
	}

	return jTeddy;
});
