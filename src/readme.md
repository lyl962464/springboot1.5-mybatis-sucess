##SpringBoot的异常处理
springboot默认提供了对异常的处理 有两个地方可以存放展示给用户看的错误页面，
一个是在static下，一个是在templates下
##SpringBoot  热部署
spring-boot-devtools 是一个为开发者服务的一个模块，其中最重要的功能就是自动应用代码更改到最新的App上面去。原理是在发现代码有更改之后，重新启动应用，但是速度比手动停止后再启动还要更快，更快指的不是节省出来的手工操作的时间。  
其深层原理是使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为  restart ClassLoader  
,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间（5秒以内）



1. devtools会监听classpath下的文件变动，并且会立即重启应用（发生在保存时机），注意：因为其采用的虚拟机机制，该项重启是很快的。  
2. devtools可以实现页面热部署（即页面修改后会立即生效，这个可以直接在application.properties文件中配置spring.thymeleaf.cache=false来实现(这里注意不同的模板配置不一样)   

##springboot + shiro的配置


##SpringBoot配置详解 2018-06-08
SpringBoot是为了简化Spring应用的创建、运行、调试、部署等一系列问题而诞生的产物，
自动装配的特性让我们可以更好的关注业务本身而不是外部的XML配置，我们只需遵循规范，引入相关的依赖就可以轻易的搭建出一个 WEB 工程



/*可以发现SpringBoot虽然干掉了
 XML 但未做到零配置，它体现出了一种约定优于配置，也称作按约定编程，
 是一种软件设计范式，旨在减少软件开发人员需做决定的数量，获得简单的好处
 ，而又不失灵活性。一般情况下默认的配置足够满足日常开发所需，但在特殊的情况下，我们往往需要用到自定义属性配置、
自定义文件配置、多环境配置、外部命令引导等一系列功能。不用担心，这些SpringBoot都替我们考虑好了，我们只需要遵循它的规则配置即可*/
***


为了让SpringBoot更好的生成数据，我们需要添加如下依赖（该依赖可以不添加，但是在 IDEA 和 STS 中不会有属性提示，没有提示的配置就跟你用记事本写代码一样苦逼，出个问题弄哭你去），该依赖只会在编译时调用，所以不用担心会对生产造成影响…

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>




