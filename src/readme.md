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


###定义一个名为my2.properties的资源文件，自定义配置文件的命名不强制application开头


`@Component
 @PropertySource("classpath:my.properties")
 @ConfigurationProperties(prefix = "my")
 public class MyProperties {
     private int age;
     private String name;
 
     @Override
     public String toString() {
         return "MyProperties{" +
                 "age=" + age +
                 ", name='" + name + '\'' +
                 '}';
     }
 
     public int getAge() {
         return age;
     }
 
     public void setAge(int age) {
         this.age = age;
     }
 
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 }`
 
 ###多环境的配置
 在真实的应用中，常常会有多个环境（如：开发，测试，生产等），不同的环境数据库连接都不一样，
 这个时候就需要用到spring.profile.active的强大功能了，它的格式为application-{profile}.properties，
 这里的application为前缀不能改，{profile}是我们自己定义的。
 
 
 创建application-dev.properties、application-test.properties、application-prod.properties
 
 在application.properties配置文件中写入spring.profiles.active=dev，
 
 ##SpringBoot日志配置
 
 
 Java 虽然有很多可用的日志框架，但请不要担心，一般来说，使用SpringBoot默认的Logback就可以了。
 
 Logback是没有FATAL级别的日志，它将被映射到ERROR
 
 时间日期：精确到毫秒,可以用于排序
 日志级别：ERROR、WARN、INFO、DEBUG、TRACE
 进程ID
 分隔符：采用---来标识日志开始部分
 线程名：方括号括起来（可能会截断控制台输出）
 Logger名：通常使用源代码的类名
 日志内容：我们输出的消息
 
 SpringBoot默认为我们输出的日志级别为INFO、WARN、ERROR，如需要输出更多日志的时候，可以通过以下方式开启
 
 命令模式配置：java -jar app.jar --debug=true， 这种命令会被SpringBoot解析，且优先级最高
 资源文件配置：application.properties配置debug=true即可。
 该配置只对 嵌入式容器、Spring、Hibernate生效，
 我们自己的项目想要输出DEBUG需要额外配置（配置规则：logging.level.<logger-name>=<level>）
 
 
##   整合thymeleaf模板
 
 Thymeleaf是现代化服务器端的Java模板引擎，不同与其它几种模板的是Thymeleaf的语法更加接近HTML，并且具有很高的扩展性。
 
 ####特点
 .支持无网络环境下运行，由于它支持 html 原型，然后在 html 标签里增加额外的属性来达到模板+数据的展示方式。
 浏览器解释 html 时会忽略未定义的标签属性，所以 thymeleaf 的模板可以静态地运行；
 当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。所以它可以让前端小姐姐在浏览器中查看页面的静态效果，又可以让程序员小哥哥在服务端查看带数据的动态页面效果。
 
 
 .开箱即用，为Spring提供方言，可直接套用模板实现JSTL、 OGNL表达式效果，避免每天因套用模板而修改JSTL、 OGNL标签的困扰。同时开发人员可以扩展自定义的方言。
 
 .SpringBoot官方推荐模板，提供了可选集成模块(spring-boot-starter-thymeleaf)，可以快速的实现表单绑定、属性编辑器、国际化等功能。
 
 
 ####使用
 
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-thymeleaf</artifactId>
 </dependency>
 
 ####注意：Spring4.3以后为简化@RequestMapping(method = RequestMethod.XXX)的写法，
 ####故而将其做了一层包装，也就是现在的GetMapping、PostMapping、PutMapping、DeleteMapping、PatchMapping
 
 为了提高响应速度，默认情况下会缓存模板。
 如果是在开发中请将spring.thymeleaf.cache 属性设置成 false。在每次修改静态内容时按Ctrl+Shift+F9即可重新加载了
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 










