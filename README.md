# YaGaoComponent
这是一个快速组件化开发的框架
##简介
###该框架的组件化插件来自DDComponent
**链接：**[Android彻底组件化方案实践](https://www.jianshu.com/p/1b1d77f58e84)
插件核心：
![Alt text](./YaGaoTree.png)
各目录介绍：
   1. app:主项目的APP壳，不算是一个组件，是搭载其他组件的框架
   2. basiclib：mvp、retrofit等
   3. basicres：整个APP的公用资源文件,drawble等
   4. build-gradle:自动组件化插件
   5. commonlib:整个组件化框架的依赖库
   6. componentlib:被commonlib替代
   7. logincomponent:登录、注册组件(PS:各组件如果需要登录信息，可以在登录组件下进行配置跳转)
   ![Alt text](./QQ图片20180427113633.png)
   8. otherlib:配置第三方库和存放自定义view等工具lib
###使用介绍：
    将demo中的build-gradle 拷贝出来，自己的项目导入该插件，在自己主项目中的build.gradle 添加以下代码：
  ![Alt text](./111.png)
		在所有的组件中应用插件：
		apply plugin: 'com.dd.comgradle'
![Alt text](./1524801373915.png)
		 组件单独运行配置Application：
 ![Alt text](./1524801420640.png)
 ![Alt text](./1524801459932.png)
   1.isRunalone:表示组件单独打包运行
   2.debugComponent：表示调试模式下的打包运行依赖
   3.compileComponent：表示正式发布下的打包
   在主项目中配置mainmodulename=app，来标识app壳(PS插件能不默认""app"为app壳)
![Alt text](./1524801609836.png)
##UI跳转
**链接：**[ARouter](https://github.com/alibaba/ARouter)
相关配置请参照官方
