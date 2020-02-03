package db.kl.dao;


import db.kl.dto.Articles;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ArticlesMapperTest {
    ArticlesMapper articlesMapper=null;
    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
         articlesMapper = (ArticlesMapper)context.getBean("articlesMapper");
    }

    @Test
    public void getArticleId(){

        Articles articles = articlesMapper.getArticleId(4);
        System.out.println(articles);
    }
    @Test
    public void getAllArticlesInfo(){

        List<Map<String,Object>> articlesList = articlesMapper.getAllArticlesInfo();
        System.out.println(articlesList);
    }
    @Test
    public void insertArticle(){
        Articles articles=new Articles();
        articles.setTitle("Apollo使用手册");
        articles.setArticledirid(1);
        articles.setArticletype("3");
        articles.setContent("# Apollo使用手册\n" +
                "\n" +
                "##### 更新：2019-11-04\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 1.What is Apollo\n" +
                "\n" +
                "### \uD83D\uDD0D1.1背景\n" +
                "\n" +
                "> 随着程序功能的日益复杂，程序的配置日益增多：各种功能的开关、参数的配置、服务器的地址……\n" +
                ">\n" +
                "> 对程序配置的期望值也越来越高：配置修改后实时生效，灰度发布，分环境、分集群管理配置，完善的权限、审核机制……\n" +
                ">\n" +
                "> 在这样的大环境下，传统的通过配置文件、数据库等方式已经越来越无法满足开发人员对配置管理的需求。\n" +
                ">\n" +
                "> Apollo配置中心应运而生！\n" +
                "\n" +
                "### \uD83D\uDD0D1.2Apollo简介\n" +
                "\n" +
                "> Apollo（阿波罗）是携程框架部门研发的开源配置管理中心，能够集中化管理应用不同环境、不同集群的配置，配置修改后能够实时推送到应用端，并且具备规范的权限、流程治理等特性。\n" +
                ">\n" +
                "> Apollo支持4个维度管理Key-Value格式的配置：\n" +
                ">\n" +
                "> 1. application (应用)\n" +
                "> 2. environment (环境)\n" +
                "> 3. cluster (集群)\n" +
                "> 4. namespace (命名空间)\n" +
                ">\n" +
                "> 同时，Apollo基于开源模式开发，开源地址：https://github.com/ctripcorp/apollo\n" +
                "\n" +
                "### \uD83D\uDD0D1.3配置基本概念\n" +
                "\n" +
                "> 既然Apollo定位于配置中心，那么在这里有必要先简单介绍一下什么是配置。\n" +
                ">\n" +
                "> 按照我们的理解，配置有以下几个属性：\n" +
                ">\n" +
                "> - **配置是独立于程序的只读变量**\n" +
                ">   - 配置首先是独立于程序的，同一份程序在不同的配置下会有不同的行为。\n" +
                ">   - 其次，配置对于程序是只读的，程序通过读取配置来改变自己的行为，但是程序不应该去改变配置。\n" +
                ">   - 常见的配置有：DB Connection Str、Thread Pool Size、Buffer Size、Request Timeout、Feature Switch、Server Urls等。\n" +
                "> - **配置伴随应用的整个生命周期**\n" +
                ">   - 配置贯穿于应用的整个生命周期，应用在启动时通过读取配置来初始化，在运行时根据配置调整行为。\n" +
                "> - **配置可以有多种加载方式**\n" +
                ">   - 配置也有很多种加载方式，常见的有程序内部hard code，配置文件，环境变量，启动参数，基于数据库等\n" +
                "> - **配置需要治理**\n" +
                ">   - 权限控制\n" +
                ">     - 由于配置能改变程序的行为，不正确的配置甚至能引起灾难，所以对配置的修改必须有比较完善的权限控制\n" +
                ">   - 不同环境、集群配置管理\n" +
                ">     - 同一份程序在不同的环境（开发，测试，生产）、不同的集群（如不同的数据中心）经常需要有不同的配置，所以需要有完善的环境、集群配置管理\n" +
                ">   - 框架类组件配置管理\n" +
                ">     - 还有一类比较特殊的配置 - 框架类组件配置，比如CAT客户端的配置。\n" +
                ">     - 虽然这类框架类组件是由其他团队开发、维护，但是运行时是在业务实际应用内的，所以本质上可以认为框架类组件也是应用的一部分。\n" +
                ">     - 这类组件对应的配置也需要有比较完善的管理方式。\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 2.Why Apollo\n" +
                "\n" +
                "> 正是基于配置的特殊性，所以Apollo从设计之初就立志于成为一个有治理能力的配置发布平台，目前提供了以下的特性：\n" +
                ">\n" +
                "> - **统一管理不同环境、不同集群的配置**\n" +
                ">   - Apollo提供了一个统一界面集中式管理不同环境（environment）、不同集群（cluster）、不同命名空间（namespace）的配置。\n" +
                ">   - 同一份代码部署在不同的集群，可以有不同的配置，比如zookeeper的地址等\n" +
                ">   - 通过命名空间（namespace）可以很方便地支持多个不同应用共享同一份配置，同时还允许应用对共享的配置进行覆盖\n" +
                "> - **配置修改实时生效（热发布）**\n" +
                ">   - 用户在Apollo修改完配置并发布后，客户端能实时（1秒）接收到最新的配置，并通知到应用程序\n" +
                "> - **版本发布管理**\n" +
                ">   - 所有的配置发布都有版本概念，从而可以方便地支持配置的回滚\n" +
                "> - **灰度发布**\n" +
                ">   - 支持配置的灰度发布，比如点了发布后，只对部分应用实例生效，等观察一段时间没问题后再推给所有应用实例\n" +
                "> - **权限管理、发布审核、操作审计**\n" +
                ">   - 应用和配置的管理都有完善的权限管理机制，对配置的管理还分为了编辑和发布两个环节，从而减少人为的错误。\n" +
                ">   - 所有的操作都有审计日志，可以方便地追踪问题\n" +
                "> - **客户端配置信息监控**\n" +
                ">   - 可以在界面上方便地看到配置在被哪些实例使用\n" +
                "> - **提供Java和.Net原生客户端**\n" +
                ">   - 提供了Java和.Net的原生客户端，方便应用集成\n" +
                ">   - 支持Spring Placeholder, Annotation和Spring Boot的ConfigurationProperties，方便应用使用（需要Spring 3.1.1+）\n" +
                ">   - 同时提供了Http接口，非Java和.Net应用也可以方便地使用\n" +
                "> - **提供开放平台API**\n" +
                ">   - Apollo自身提供了比较完善的统一配置管理界面，支持多环境、多数据中心配置管理、权限、流程治理等特性。不过Apollo出于通用性考虑，不会对配置的修改做过多限制，只要符合基本的格式就能保存，不会针对不同的配置值进行针对性的校验，如数据库用户名、密码，Redis服务地址等\n" +
                ">   - 对于这类应用配置，Apollo支持应用方通过开放平台API在Apollo进行配置的修改和发布，并且具备完善的授权和权限控制\n" +
                "> - **部署简单**\n" +
                ">   - 配置中心作为基础服务，可用性要求非常高，这就要求Apollo对外部依赖尽可能地少\n" +
                ">   - 目前唯一的外部依赖是MySQL，所以部署非常简单，只要安装好Java和MySQL就可以让Apollo跑起来\n" +
                ">   - Apollo还提供了打包脚本，一键就可以生成所有需要的安装包，并且支持自定义运行时参数\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 3.部署\n" +
                "\n" +
                "### \uD83D\uDD0D3.1 准备工作\n" +
                "\n" +
                "#### 3.1.1 OS(运行服务器)\n" +
                "\n" +
                "服务端基于Spring Boot，启动脚本理论上支持所有Linux发行版，建议[CentOS 7](https://www.centos.org/)\n" +
                "\n" +
                "#### 3.1.2 Java(运行Jvm环境)\n" +
                "\n" +
                "- Apollo服务端：1.8+\n" +
                "\n" +
                "- Apollo客户端：1.7+\n" +
                "\n" +
                "由于需要同时运行服务端和客户端，所以建议安装Java 1.8+。\n" +
                "\n" +
                "环境配置完成后，可以通过如下命令检查：\n" +
                "\n" +
                "```\n" +
                "java -version\n" +
                "```\n" +
                "\n" +
                "样例输出：\n" +
                "\n" +
                "```\n" +
                "java version \"1.8.0_74\"\n" +
                "Java(TM) SE Runtime Environment (build 1.8.0_74-b02)\n" +
                "Java HotSpot(TM) 64-Bit Server VM (build 25.74-b02, mixed mode)\n" +
                "```\n" +
                "\n" +
                "#### 3.1.3 MySQL\n" +
                "\n" +
                "- 版本要求：5.6.5+\n" +
                "- 安装可参照[MySQL安装手册](/使用文档/服务使用手册/mysql安装手册.md)\n" +
                "\n" +
                "连接上MySQL后，可以通过如下命令检查：\n" +
                "\n" +
                "```sql\n" +
                "SHOW VARIABLES WHERE Variable_name = 'version';\n" +
                "```\n" +
                "\n" +
                "| Variable_name | Value    |\n" +
                "| ------------- | -------- |\n" +
                "| version       | xx.xx.xx |\n" +
                "\n" +
                "> 注1：如果希望使用Oracle的话，可以参考[vanpersl](https://github.com/vanpersl)在Apollo 0.8.0基础上开发的[Oracle适配代码](https://github.com/ctripcorp/apollo/compare/v0.8.0...vanpersl:db-oracle)，Oracle版本为10.2.0.1.0。(不建议)\n" +
                "\n" +
                "> 注2：如果希望使用Postgres的话，可以参考[oaksharks](https://github.com/oaksharks)在Apollo 0.9.1基础上开发的[Pg适配代码](https://github.com/oaksharks/apollo/compare/ac10768ee2e11c488523ca0e845984f6f71499ac...oaksharks:pg)，Postgres的版本为9.3.20，也可以参考[xiao0yy](https://github.com/xiao0yy)在Apollo 0.10.2基础上开发的[Pg适配代码](https://github.com/ctripcorp/apollo/issues/1293)，Postgres的版本为9.5。\n" +
                "\n" +
                "#### 3.1.4 环境\n" +
                "\n" +
                "分布式部署需要事先确定部署的环境以及部署方式。\n" +
                "\n" +
                "企金Apollo目前支持以下环境：\n" +
                "\n" +
                "- DEV\n" +
                "  - 开发环境\n" +
                "- FAT\n" +
                "  - 测试环境，相当于alpha环境(功能测试)\n" +
                "- UAT\n" +
                "  - 集成环境，相当于beta环境（回归测试）\n" +
                "  - 针对实施部门/客户现场可以作为现场集成测试环境\n" +
                "- PRO\n" +
                "  - 生产环境\n" +
                "\n" +
                "> 如果希望添加自定义的环境名称，具体步骤可以参考[部署&开发遇到的常见问题#42-添加自定义的环境](https://github.com/ctripcorp/apollo/wiki/部署&开发遇到的常见问题#42-添加自定义的环境)\n" +
                "\n" +
                "企金部署策略如下：\n" +
                "\n" +
                "+ 企金研发部门部署一台portal，用于直接管理：dev/fat/uat/pro环境的配置。\n" +
                "\n" +
                "  > 分工如下：\n" +
                "  >\n" +
                "  > 研发同学管理dev环境\n" +
                "  >\n" +
                "  > 测试同学管理fat/uat环境\n" +
                "  >\n" +
                "  > 正式版/补丁版发布前将由配管同学整理一份pro环境配置提供给客户现场\n" +
                "\n" +
                "+ 企金研发部门的config-server和admin-server在每个环境都单独部署，使用独立的同一台数据库\n" +
                "\n" +
                "+ 企金实施部门/客户现场部署一台portal，用于直接管理：uat/pro环境的配置\n" +
                "\n" +
                "+ 企金实施部门/客户现场的config-server和admin-server在每个环境都单独部署，使用独立的同一台数据库\n" +
                "\n" +
                "+ 企金实施部门/客户现场的config-server和admin-server可根据客户要求与资源部署双活（待验证）\n" +
                "\n" +
                "部署图：（TODO）\n" +
                "\n" +
                "####3.1.5 网络策略\n" +
                "\n" +
                "Apollo客户端和Portal会从Meta Server获取服务的地址（IP+端口），然后通过服务地址直接访问（如何配置将在后面贴出）。\n" +
                "\n" +
                "需要注意的是，`apollo-configservice`和`apollo-adminservice`是基于内网可信网络设计的，所以出于安全考虑，请不要将`apollo-configservice`和`apollo-adminservice`直接暴露在公网。\n" +
                "\n" +
                "所以如果实际部署的机器有多块网卡（如docker），或者存在某些网卡的IP是Apollo客户端和Portal无法访问的（如网络安全限制），那么我们就需要在`apollo-configservice`和`apollo-adminservice`中做相关限制以避免Eureka将这些网卡的IP注册到Meta Server（遇到此情况请联系企金研发部处理）。\n" +
                "\n" +
                "\n" +
                "\n" +
                "### \uD83D\uDD0D3.2 部署\n" +
                "\n" +
                "部署步骤共三步：\n" +
                "\n" +
                "1. 创建数据库\n" +
                "\n" +
                "   - Apollo服务端依赖于MySQL数据库，所以需要事先创建并完成初始化\n" +
                "\n" +
                "2. 获取安装包\n" +
                "\n" +
                "   - Apollo服务端安装包共有3个：apollo-configservice, apollo-adminservice, apollo-portal\n" +
                "     - 可以直接下载我们事先打好的安装包。 \uD83D\uDC49[传送门](http://gitlab.fingard.cn/QJ/ats-doc/tree/master/app/apollo.zip)。\n" +
                "\n" +
                "3. 部署Apollo服务端\n" +
                "\n" +
                "   - 获取安装包后就可以部署了\n" +
                "\n" +
                "> 如果部署过程中遇到了问题，可以参考[部署&开发遇到的常见问题](https://github.com/ctripcorp/apollo/wiki/部署&开发遇到的常见问题)，一般都能找到答案。\n" +
                "\n" +
                "#### 3.2.1 创建数据库\n" +
                "\n" +
                "Apollo服务端共需要两个数据库：`ApolloPortalDB`和`ApolloConfigDB`，我们把数据库、表的创建和样例数据都分别准备了sql文件（在安装包中/configdb和/portaldb中），只需要导入数据库即可。 \n" +
                "\n" +
                "需要注意的是ApolloPortalDB只需要在生产环境部署一个即可，而ApolloConfigDB需要在每个环境部署一套，如fat、uat和pro分别部署3套ApolloConfigDB。\n" +
                "\n" +
                "> 注意：如果你本地已经创建过Apollo数据库，请注意备份数据。我们准备的sql文件会清空Apollo相关的表。\n" +
                "\n" +
                "##### 3.2.1.1 创建ApolloPortalDB\n" +
                "\n" +
                "+ 脚本地址：\n" +
                "\n" +
                "  + 企金研发部：/apollo/portaldb/dev/V1.0.0__initialization.sql\n" +
                "  + 企金实施部/客户生产：/apollo/portaldb/pro/V1.0.0__initialization.sql\n" +
                "\n" +
                "+ 执行后验证：\n" +
                "\n" +
                "  + 企金研发部：\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloPortalDB_DEV`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "\n" +
                "  + 企金实施部/客户生产：\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloPortalDB_PRO`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "    \n" +
                "    | Id   | Key                | Value | Comment          |\n" +
                "    | ---- | ------------------ | ----- | ---------------- |\n" +
                "    | 1    | apollo.portal.envs | pro   | 可支持的环境列表 |\n" +
                "\n" +
                "\t> 注：ApolloPortalDB只需要在生产环境部署一个即可\n" +
                "\n" +
                "##### 3.2.1.2 创建创建ApolloConfigDB\n" +
                "\n" +
                "+ 脚本地址:\n" +
                "\n" +
                "  + dev脚本：/apollo/configdb/dev/V1.0.0__initialization.sql\n" +
                "\n" +
                "  + fat脚本：/apollo/configdb/fat/V1.0.0__initialization.sql\n" +
                "\n" +
                "  + uat脚本：/apollo/configdb/uat/V1.0.0__initialization.sql\n" +
                "\n" +
                "  + pro脚本：/apollo/configdb/pro/V1.0.0__initialization.sql\n" +
                "\n" +
                "  > 企金实施部/客户生产只需要部署uat/pro即可\n" +
                "\n" +
                "+ 执行后验证：\n" +
                "\n" +
                "  + 企金研发部：\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_DEV`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_FAT`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_UAT`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "\n" +
                "    ```sql\n" +
                "    select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_PRO`.`ServerConfig` limit 1;\n" +
                "    ```\n" +
                "\n" +
                "  + 企金实施部/客户生产：\n" +
                "\n" +
                "\t  ```sql\n" +
                "\t  select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_UAT`.`ServerConfig` limit 1;\n" +
                "\t  ```\n" +
                "\t\n" +
                "\t  ```sql\n" +
                "\t  select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_PRO`.`ServerConfig` limit 1;\n" +
                "\t  ```\n" +
                "\t  \n" +
                "\t  | Id   | Key                | Value                         | Comment       |\n" +
                "\t  | ---- | ------------------ | ----------------------------- | ------------- |\n" +
                "\t  | 1    | eureka.service.url | http://127.0.0.1:8080/eureka/ | Eureka服务Url |\n" +
                "\t\n" +
                "\t> 注：ApolloConfigDB需要在每个环境部署一套，如fat、uat和pro分别部署3套ApolloConfigDB\n" +
                "\n" +
                "+ 高可用配置\n" +
                "\n" +
                "  在不改动官方源码的情况下，apollo-configservice本身就是一个eureka服务，高可用配置只需要把自身的服务ip端口注册到表中即可，用逗号分隔（注意不要忘了/eureka/后缀）。\n" +
                "\n" +
                "  比如FAT的apollo-configservice是1.1.1.1:8080和2.2.2.2:8080，UAT的apollo-configservice是3.3.3.3:8080和4.4.4.4:8080，PRO的apollo-configservice是5.5.5.5:8080和6.6.6.6:8080，那么：\n" +
                "\n" +
                "  1. 在FAT环境的ApolloConfigDB.ServerConfig表中设置eureka.service.url为：\n" +
                "\n" +
                "  ```\n" +
                "  http://1.1.1.1:8080/eureka/,http://2.2.2.2:8080/eureka/\n" +
                "  ```\n" +
                "\n" +
                "  1. 在UAT环境的ApolloConfigDB.ServerConfig表中设置eureka.service.url为：\n" +
                "\n" +
                "  ```\n" +
                "  http://3.3.3.3:8080/eureka/,http://4.4.4.4:8080/eureka/\n" +
                "  ```\n" +
                "\n" +
                "  1. 在PRO环境的ApolloConfigDB.ServerConfig表中设置eureka.service.url为：\n" +
                "\n" +
                "  ```\n" +
                "  http://5.5.5.5:8080/eureka/,http://6.6.6.6:8080/eureka/\n" +
                "  ```\n" +
                "\n" +
                "  **配置**：在表ApolloConfigDB_XXX.ServerConfig的key为`eureka.service.url`中配置多个ip,例如：`http://1.1.1.1:8080/eureka/,http://2.2.2.2:8080/eureka/`\n" +
                "\n" +
                "  | Id   | Key                | Value                                                   | Comment       |\n" +
                "  | ---- | ------------------ | ------------------------------------------------------- | ------------- |\n" +
                "  | 1    | eureka.service.url | http://1.1.1.1:8080/eureka/,http://2.2.2.2:8080/eureka/ | Eureka服务Url |\n" +
                "\n" +
                "\n" +
                "\n" +
                "#### 3.2.2 获取安装包\n" +
                "\n" +
                "##### 3.2.2.1 安装包\n" +
                "\n" +
                "+ 路径：`/apollo/apollo-adminservice-1.4.0-github.zip , /apollo/apollo-configservice-1.4.0-github.zip , apollo-configservice-1.4.0-github.zip`\n" +
                "\n" +
                "##### 3.2.2.2 配置数据库连接\n" +
                "\n" +
                "+ Apollo服务端需要知道如何连接到你前面创建的数据库，数据库连接串信息位于上一步下载的压缩包中的`config/application-github.properties`中。\n" +
                "\n" +
                "  + **配置apollo-configservice的数据库连接信息**\n" +
                "\n" +
                "    1. 解压`apollo-configservice-x.x.x-github.zip`\n" +
                "    2. 用编辑器（如vim，notepad++，sublime等）打开`config`目录下的`application-github.properties`文件\n" +
                "    3. 填写正确的ApolloConfigDB数据库连接串信息，注意用户名和密码后面不要有空格!\n" +
                "    4. 修改完的效果如下：\n" +
                "\n" +
                "    ```\n" +
                "    # DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://localhost:3306/ApolloConfigDB_XXX?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = someuser\n" +
                "    spring.datasource.password = somepwd\n" +
                "    ```\n" +
                "\n" +
                "    > 注：由于ApolloConfigDB在每个环境都有部署，所以对不同的环境config-service需要配置对应环境的数据库参数\n" +
                "    >\n" +
                "    > 企金研发部需要配置dev/fat/uat/pro环境\n" +
                "    >\n" +
                "    > 企金实施部/客户现场只需要配置uat/pro环境\n" +
                "\n" +
                "  + **配置apollo-adminservice的数据库连接信息**\n" +
                "\n" +
                "    1. 解压`apollo-adminservice-x.x.x-github.zip`\n" +
                "    2. 用编辑器（如vim，notepad++，sublime等）打开`config`目录下的`application-github.properties`文件\n" +
                "    3. 填写正确的ApolloConfigDB数据库连接串信息，注意用户名和密码后面不要有空格!\n" +
                "    4. 修改完的效果如下：\n" +
                "\n" +
                "    ```\n" +
                "    # DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://localhost:3306/ApolloConfigDB_XXX?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = someuser\n" +
                "    spring.datasource.password = somepwd\n" +
                "    ```\n" +
                "\n" +
                "    > 注：由于ApolloConfigDB在每个环境都有部署，所以对不同的环境admin-service需要配置对应环境的数据库参数\n" +
                "    >\n" +
                "    > 企金研发部需要配置dev/fat/uat/pro环境\n" +
                "    >\n" +
                "    > 企金实施部/客户现场只需要配置uat/pro环境\n" +
                "\n" +
                "  + **配置apollo-portal的数据库连接信息**\n" +
                "\n" +
                "    1. 解压`apollo-portal-x.x.x-github.zip`\n" +
                "    2. 用编辑器（如vim，notepad++，sublime等）打开`config`目录下的`application-github.properties`文件\n" +
                "    3. 填写正确的ApolloPortalDB数据库连接串信息，注意用户名和密码后面不要有空格!\n" +
                "    4. 修改完的效果如下：\n" +
                "\n" +
                "    ```\n" +
                "    # DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://localhost:3306/ApolloPortalDB_XXX?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = someuser\n" +
                "    spring.datasource.password = somepwd\n" +
                "    ```\n" +
                "\n" +
                "    > 注：企金研发为：ApolloPortalDB_DEV, 企金实施/客户现场：ApolloPortalDB_PRO\n" +
                "    \n" +
                "  + **配置apollo-portal的meta service信息**\n" +
                "\n" +
                "    1. 用编辑器（如vim，notepad++，sublime等）打开`config`目录下的`apollo-env.properties`文件\n" +
                "\n" +
                "    2. 填写正确的xxx.meta地址\n" +
                "\n" +
                "    3. 修改完效果如下\n" +
                "\n" +
                "       ```\n" +
                "       dev.meta=http://xxx.xxx.xxx.xxx:8080\n" +
                "       fat.meta=http://xxx.xxx.xxx.xxx:8080\n" +
                "       uat.meta=http://xxx.xxx.xxx.xxx:8080\n" +
                "       pro.meta=http://xxx.xxx.xxx.xxx:8080\n" +
                "       ```\n" +
                "\n" +
                "    > 注：企金研发部需要配置dev/fat/uat/pro环境\n" +
                "    >\n" +
                "    > 企金实施部/客户现场只需要配置uat/pro环境\n" +
                "\n" +
                "#### 3.2.3 部署Apollo服务端\n" +
                "\n" +
                "##### 3.2.3.1部署apollo-configservice\n" +
                "\n" +
                "+ 运行../apollo-configservice-1.4.0-github/scripts/startup.sh\n" +
                "\n" +
                "##### 3.2.3.2部署apollo-adminservice\n" +
                "\n" +
                "+ 运行../apollo-adminservice-1.4.0-github/scripts/startup.sh\n" +
                "\n" +
                "##### 3.2.3.3部署apollo-portal\n" +
                "\n" +
                "+ 运行../apollo-portal-1.4.0-github/scripts/startup.sh\n" +
                "\n" +
                "### \uD83D\uDD0D3.3 验证\n" +
                "\n" +
                "参考[登陆Apollo配置中心](/ats-doc/使用文档/服务使用手册/Apollo使用手册.html#\uD83D\uDD0D4-6登陆apollo配置中心)\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 4.快速部署（针对单机环境）--待重新整理\n" +
                "\n" +
                "此教程针对apollo三大组件快速部署，客户如无特殊要求可采用此教程快速部署。\n" +
                "\n" +
                "### \uD83D\uDD0D4.1 安装MySQL环境\n" +
                "\n" +
                "- 版本要求：5.6.5+\n" +
                "- 安装可参照[MySQL安装手册](/使用文档/服务使用手册/mysql安装手册.md)\n" +
                "\n" +
                "### \uD83D\uDD0D4.2 配置Java环境\n" +
                "\n" +
                "+ 配置JDK8\n" +
                "\n" +
                "### \uD83D\uDD0D4.3 执行脚本\n" +
                "\n" +
                "+ 执行portal脚本：\n" +
                "  + 脚本地址：`/apollo/portaldb/pro/V1.0.0__initialization.sql`\n" +
                "  + 验证：```select `Id`, `Key`, `Value`, `Comment` from `ApolloPortalDB_PRO`.`ServerConfig` limit 1;```\n" +
                "\n" +
                "+ 执行config脚本\n" +
                "\n" +
                "  + 脚本地址：\n" +
                "    + uat环境：`/apollo/configdb/uat/V1.0.0__initialization.sql`\n" +
                "    + pro环境：`/apollo/configdb/pro/V1.0.0__initialization.sql`\n" +
                "\n" +
                "  + 验证：\n" +
                "    + uat环境：```select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_UAT`.`ServerConfig` limit 1;```\n" +
                "    + pro环境：```select `Id`, `Key`, `Value`, `Comment` from `ApolloConfigDB_PRO`.`ServerConfig` limit 1;```\n" +
                "\n" +
                "### \uD83D\uDD0D4.4配置服务端信息\n" +
                "\n" +
                "+ 配置apollo-configservice的数据库连接信息\n" +
                "\n" +
                "  + 配置文件地址：`/apollo/apollo-configservice-x.x.x-github/config/application-github.properties`\n" +
                "\n" +
                "  + 修改效果：\n" +
                "\n" +
                "    ```\n" +
                "    # uat环境 DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://{ip}:{port}/ApolloConfigDB_UAT?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = {用户名}\n" +
                "    spring.datasource.password = {密码}\n" +
                "    ```\n" +
                "\n" +
                "    ```\n" +
                "    # pro环境 DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://{ip}:{port}/ApolloConfigDB_PRO?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = {用户名}\n" +
                "    spring.datasource.password = {密码}\n" +
                "    ```\n" +
                "\n" +
                "+ 配置apollo-adminservice的数据库连接信息\n" +
                "\n" +
                "  + 配置文件地址：`/apollo/apollo-adminservice-x.x.x-github/config/application-github.properties`\n" +
                "\n" +
                "  + 修改效果：\n" +
                "\n" +
                "    ```\n" +
                "    # uat环境 DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://{ip}:{port}/ApolloConfigDB_UAT?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = {用户名}\n" +
                "    spring.datasource.password = {密码}\n" +
                "    ```\n" +
                "\n" +
                "    ```\n" +
                "    # pro环境 DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://{ip}:{port}/ApolloConfigDB_PRO?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = {用户名}\n" +
                "    spring.datasource.password = {密码}\n" +
                "    ```\n" +
                "\n" +
                "+ 配置apollo-portal的数据库连接信息\n" +
                "\n" +
                "  + 配置文件地址：`/apollo/apollo-portal-x.x.x-github/config/application-github.properties`\n" +
                "\n" +
                "  + 修改效果：\n" +
                "\n" +
                "    ```\n" +
                "    # pro环境 DataSource\n" +
                "    spring.datasource.url = jdbc:mysql://{ip}:{port}/ApolloPortalDB_PRO?useSSL=false&characterEncoding=utf8\n" +
                "    spring.datasource.username = {用户名}\n" +
                "    spring.datasource.password = {密码}\n" +
                "    ```\n" +
                "\n" +
                "+ **配置apollo-portal的meta service信息**\n" +
                "  + 配置文件地址：`/apollo/apollo-portal-x.x.x-github/config/apollo-env.properties`\n" +
                "\n" +
                "  + 修改效果：\n" +
                "\n" +
                "    ```\n" +
                "    uat.meta=http://{uat.configservice.ip}:{uat.configservice.port}\n" +
                "    pro.meta=http://{pro.configservice.ip}:{pro.configservice.port}\n" +
                "    ```\n" +
                "\n" +
                "### \uD83D\uDD0D4.5启动\n" +
                "\n" +
                "+ 依次运行：\n" +
                "  + `/apollo/apollo-configservice-xx.xx.xx-github/scripts/startup.sh`\n" +
                "  + `/apollo/apollo-adminservice-xx.xx.xx-github/scripts/startup.sh`\n" +
                "  + `/apollo/apollo-portal-xx.xx.xx-github/scripts/startup.sh`\n" +
                "\n" +
                "### \uD83D\uDD0D4.6登陆Apollo配置中心\n" +
                "\n" +
                "\u200B\t地址：{portal.ip}:8070\n" +
                "\n" +
                "\u200B\t默认超级管理员账号密码：apollo/admin\n" +
                "\n" +
                "#### 4.6.1 首次登陆建议修改超级管理员密码\n" +
                "\n" +
                "+ 地址：[管理员工具]--[用户管理]\n" +
                "+ 变更：用户名输入apollo, 密码输入自定义密码，邮箱输入自定义\n" +
                "\n" +
                "#### 4.6.2 创建微服务配置\n" +
                "\n" +
                "+ 点击左上角`创建项目`按钮：\n" +
                "  + `部门`，`应用Id`，`应用名称`，请根据[服务信息](/服务信息/ATS3.x/)指定的微服务填写项目服务信息\n" +
                "  + `应用负责人`请选择默认的`apollo`\n" +
                "\n" +
                "+ 在默认的Namespace `application`导入配置\n" +
                "  + 拷贝[服务信息](/服务信息/ATS3.x/)指定的微服务的配置属性\n" +
                "  + 选择`文本->修改配置`，将配置粘贴到文本框中\n" +
                "  + 点击`发布`按钮\n" +
                "\n" +
                "#### 4.6.3 启动微服务，验证连接状态\n" +
                "\n" +
                "+ 微服务成功启动后，点击`实例列表`查看客户端ip信息\n" +
                "\n" +
                "## 5.使用手册\n" +
                "\n" +
                "### \uD83D\uDD0D5.1 针对开发同学\n" +
                "\n" +
                "#### 5.1.1 灰度发布\n" +
                "\n" +
                "apollo部署基于公用原则，所以每个配置项的正式发布需要进行灰度测试\n" +
                "\n" +
                "+ 步骤一：点击dev环境的灰度发布，添加灰度发布配置\n" +
                "\n" +
                "+ 步骤二：配置灰度规则，配置本机ip，这样你所创建的灰度配置项将只有你的机子能读取\n" +
                "\n" +
                "#### 5.1.2 全量发布\n" +
                "\n" +
                "灰度测试通过后，点击全量发布按钮，将配置项发布到dev环境（放弃灰度配置项请点击放弃灰度发布）\n" +
                "\n" +
                "#### 5.1.3 自动发布到FAT环境\n" +
                "\n" +
                "后台有自动任务将DEV配置增量发布到FAT环境\n" +
                "\n" +
                "> 注：为了减少冗余配置，后台有定时任务比较DEV与FAT配置，并通过钉钉通知到开发群，请及时确认所发布的配置项是否必须（防止自测的配置项不小心发布到FAT）\n" +
                ">\n" +
                "> FAT环境的配置在正式发布之前，将会全量同步搭配UAT环境，UAT环境的配置将作为发完现场的最终配置项\n" +
                "\n" +
                "### \uD83D\uDD0D5.2 针对测试同学\n" +
                "\n" +
                "+ 核对配置\n" +
                "\n" +
                "### \uD83D\uDD0D5.3 针对实施同学/客户现场人员\n" +
                "\n" +
                "+ 核对配置\n");
        articles.setSource("1");
        articles.setCreatedby("1");
        articles.setCreatedon(new Date());
        articles.setLastmodifiedby("1");
        articles.setLastmodifiedon(new Date());
        articlesMapper.insertArticle(articles);
    }
    @Test
    public void updateArticle(){
        Articles articles = articlesMapper.getArticleId(4);
        System.out.println(articles);
        articles.setLastmodifiedon(new Date());
        articles.setLastmodifiedby("test");
        articles.setContent("测试修改"+articles.getContent());
        articlesMapper.updateArticle(articles);

    }
    @Test
    public void getAllArticles(){
        List<Articles> articlesList=articlesMapper.getAllArticles();
        for (Articles articles : articlesList){
            System.out.println(articles);
        }
    }
}
