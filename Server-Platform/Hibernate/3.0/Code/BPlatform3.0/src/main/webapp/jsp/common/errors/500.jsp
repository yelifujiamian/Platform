<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %> 
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>500 - 系统内部错误</title>
</head>

<body>
<div><h1>系统发生内部错误.</h1></div>

<H2>错误异常: <%= ex.getClass().getSimpleName()%></H2>
<hr />
<P>错误描述：</P>
<%= ex.getMessage()%>
<P>错误信息：</P>
<% ex.printStackTrace(new java.io.PrintWriter(out)); %>


<div><a href="/">返回首页</a></div>
<div style="">
	Copyright &copy; 2011-2013 Power By <a href="http://www.whcd.com">memory</a> & marker
</div>
</body>
</html>
