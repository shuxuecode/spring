## ioc



## aop



## 下载源码后编译

- 修改 spring-framework\gradle\wrapper\gradle-wrapper.properties

改为本地
distributionUrl=file:///D:/gradle/gradle-5.6.4-bin.zip

- 修改 build.gradle

repositories
添加
maven { url "http://maven.aliyun.com/nexus/content/groups/public/"}


执行
gradlew.bat

如果编译失败则根据提示修改，直到编译成功。


## mac系统上编译

首先还是修改修改 spring-framework\gradle\wrapper\gradle-wrapper.properties
改为本地的压缩包

然后修改 gradle.properties 文件，
添加 org.gradle.java.home 配置项，如下：

org.gradle.java.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_291.jdk/Contents/Home




