# 2017/09/28：DroidVR-master by WGY
## 
	360°全景，即通过对专业相机捕捉整个场景的图像信息或者使用建模软件渲染过后的图片，
	使用软件进行图片拼合，并用专门的播放器进行播放，即将平面照片或者计算机建模图片变为360度全观，
	用于虚拟现实浏览，把二维的平面图模拟成真实的三维空间，呈现给观赏者。

### 效果图

<img src="/DroidVR.gif">

# 2017/08/30：okhttp-OkGo-master by WGY
## 
	一个基于okhttp的标准RESTful风格的网络框架

# 2017/08/12：swipeitemlayout-master by WGY
## 
	这是一款仿iOS的PickerView控件，仿qq侧滑


# 2017/08/11：Android-PickerView-master by WGY
## 
	这是一款仿iOS的PickerView控件，有时间选择和选项选择，并支持一二三级联动，支持自定义样式

# 2017/08/09：ToggleButton-master by WGY
## 
	ToggleButton仿苹果的

# 2017/08/02：banner-master by WGY
## 
	轮播图

# 2017/08/01：BaseProject-master by WGY
## 
	基础的框架


# 2017/08/01：StickyHeaderView-master by WGY
## 
	吸顶文本recyclerView

# 2017/07/31：MatthewBases-master by WGY
## 
	详细介绍

### [Android 快速开发（一），封装一个 TopBarBaseActivity](https://blog.ifmvo.cn/2017/04/14/package-topbarbaseactivity-by-toolbar/)

### [Android 快速开发（二），封装一个 BottomTabBaseActivity](https://blog.ifmvo.cn/2017/05/03/package-bottomtabbaseactivity/)

# 2017/07/20：StickerView-master by WGY

###   
    介绍 https://github.com/wuapnjie/StickerView
	关于控件放大缩小拖动
    
# 2017/07/07：PermissionsDispatcher by WGY

###   
    介绍 http://www.jianshu.com/p/07e1a1cff5ad
    PermissionsDispatcher还在AndroidStudio做了插件，只要在setting设置里的plugins界面里搜索PermissionsDispatcher就可以安装.   

# 2017/07/07：FlycoSystemBar-master by WGY
###
	沉浸式状态栏

# 2017/07/06：BaseRecyclerViewAdapterHelper by WGY

# 2017/06/27：6.0权限管理框架 by WGY

# 2017/06/26：CustomActionWebView

###
	自定义webview长按文本弹出选项，并且点击后返回选项与所选中的文本，你的webview不再只支持系统的复制等功能了，长按web文本实现文本一键收藏、分享，就是这么简单。Demo中附带对webView的详细使用：api详解，配置详解，js多种通信方式详解。 http://www.jianshu.com/p/16713361bbd3

# 2017/06/26：NetSpeedTest
###
	Android测试网速的APP

###   
    首先这个APP是学习网上的开源代码，吸收和优化得到的，所以当然也是开源给大家一起学习的啦
    优化的地方有：禁止测试途中再开新线程测试；测试中途退出关闭线程避免后台继续下载；补充连接方式的获取
    测网速用到的思路就是有个Info结构体，里面有当前网速speed,已经下载的字节数:hadfinishBytes,总共要下载的字节数:totalBytes   
    然后开2个线程，线程A利用java.net的URL类去下载一个文件，例如一张几M大的图片，并且一直修改Info结构体的内容    
    线程B就每1秒读一次结构体的speed来更新UI，思路就这样。

# 2017/06/25：SuperTextView

###
	是一个功能强大的View，可以满足日常大部分布局样式，开发者可已自行组合属性配置出属于自己风格的样式!可能描述起来没有概念，还是直接看效果图吧！

# 2017/06/25：Gradle版本控制下载网址

# 2017/06/23：GlideImageView
###
	该库是基于Glide V4.0设计的，实现如下特性:

	1、通过提供的属性可以设置图片的圆角、边框

	2、可以设置点击触摸图片时的颜色、透明度

	3、一行代码加载来自网络、res、SDCard中的图片，可加载成圆形。

	4、可以监听加载图片时的进度。


# 2017/06/22：AndroidStudy

# 扫描二维码下载APK示例：
![image](http://upload-images.jianshu.io/upload_images/587163-f258a65074ff6b36.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240) 

# 更新日志：

**2017/06/19**
 Android仿QQ小红点 （ http://www.jianshu.com/p/9f0736c24029 ）

**2017/06/12**
 Android仿QQ侧滑菜单( http://www.jianshu.com/p/1834ce7a2ce7 )

**2017/05/27**
 仿魅族通讯录( http://www.jianshu.com/p/7b7b7ee80c44 )

**2017/05/06**
 封装一个通用的PopupWindow( http://www.jianshu.com/p/799dbb86f908 )
 
 **2017/03/28**
 添加buid.gradle配置信息，支持多渠道打包（ http://www.jianshu.com/p/11484fddda23 ）
 
 **2017/03/24**
 添加进程间通信Demo (Bundle、AIDL、Messager、自定义Binder)
 
  **2017/01/20**
 添加自定义View（饼形图）、自定义ViewGroup（五环图）
 
 
 # 仿QQ侧滑菜单、小红点：
  ![image]( https://github.com/crazyqiang/AndroidStudy/blob/master/pic/Swipe_menu.gif) 
  ![image]( https://github.com/crazyqiang/AndroidStudy/blob/master/pic/qq_point.gif) 
 
 # 仿魅族通讯录、通用PopupWindow： 
  ![image]( https://github.com/crazyqiang/AndroidStudy/blob/master/pic/Contacts.gif) 
  ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/PopupWindow.gif) 
 
 # Bundle、AIDL、Messenger、Binder：
 ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/intent.gif) 
 ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/aidl.gif) 
 ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/messenger.gif) 
 ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/binder.gif) 

# 自定义View、ViewGroup：
 ![image](https://github.com/crazyqiang/AndroidStudy/blob/master/pic/initpintu.jpg) 


# 2017/06/21：更新RN视频txt文件
