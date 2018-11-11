#### 项目描述
1.名称：基于Spring Boot 的博客系统  
2.功能：注册博主、发博客、评论、点赞、全文检索、文件上传  
3.技术：前端、后端、数据库、NoSQL、文件存储、大数据  

#### Thymeleaf 
https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#introducing-thymeleaf  
1.Java模板引擎，能够处理HTML,XML,JavaScript,CSS甚至纯文本,类似JSP,Freemarker  
2.自然模板，原型即页面  
3.语法优雅易懂，OGNL,SpringEL  
4.遵从Web标准，支持HTML5  
```
变表量表达式: ${...}
消息达式(也称为文本外部化，国际化，或者i18n): #{...}
选择表达式:(获取book的title属性)  ${book} ... *{title}
与变量表达式的区别：它们是在当前选择对象而不是整个上下文变量映射上执行
链接表达式：@{...}
分段表达式: th:insert 或者 th:replace
字面量：文本、数字、算术操作、比较和等级、条件运算符、无操作
设置任意属性值: th：attr
设置属性值(固定值boolean属性):checked="checked"
迭代器: th:each
状态变量：index/count/size/current/even/odd/first/last
条件语句:th:if 、 th:unless、switch
模板布局:定义和引用片段 th:fragment="copy"  th:insert="~{footer :: copy}"
不使用th:fragment: id="copy-section" th:insert="~{footer :: #copy-section}"
th:insert th:replace th:include三者的区别
th:insert 它将简单地插入指定的片段作为正文的主标签
th:replace 用指定实际片段来替换主标签。
th:include 类似于th:insert，但是不是插入片段，它只插入此片段的内容(3.x版本之后，不再推荐使用)
属性优先级:Fragment inclusion/Fragment iteration/Conditional evaluation/Local variable definition/General attribute modification/Specific attribute modification/Text(tag body modification)/Fragment specification/Fragment removal
注释:标准HTML/XML注释 解析器级别注释块(删除<!-- /*和 */ -->之间的所有内容) 原型注释块:当静态模板打开的时候，原型注释块所注释的代码将被注释，而在模板执行的时候，这些注释块就会显示出来
内联：
    内联表达式：[[]] [()]分别对应于th:text 和th:utext
禁用内联： th:inline="none"
基本对象
    #ctx:上下文对象 是org.thymeleaf.context.IContext或者org.thymeleaf.context.IWebContext的实现
    #locale:直接访问与java.util.Locale关联的当前请求
request/session等属性:
    param:用于检索请求参数
    session:用于检索session属性
    application:用于检索application/servlet上下文属性
表达式基本对象:
    Web上下文对象
    #request:直接访问当前请求关联的javax.servlet.http.HttpServletRequest对象
    #session:直接访问与当前请求关联的javax.servlet.http.HttpSession对象
    #servletContext:直接访问与当前请求关联的javax.servlet.ServletContext对象
    
```
#### Thymeleaf和Spring boot 集成
```
此依赖可以排除
// https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf
compile group: 'org.thymeleaf', name: 'thymeleaf', version: '3.0.11.RELEASE'

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-thymeleaf', version: '2.1.0.RELEASE'

// https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect
compile group: 'nz.net.ultraq.thymeleaf', name: 'thymeleaf-layout-dialect', version: '2.3.0'


```
#### Thymeleaf实战
**API设计(非restful 风格)**  
GET /users:返回用于展现用户列表的list.html页面  
GET /users/{id}:返回用于展现用户的view.html页面  
GET /users/form:返回用于新增或者修改用户的form.html  
POST /users:新增或者修改用户，成功后重定向到list.html页面  
GET /users/delete/{id}:根据id删除相应的用户数据，成功后重定向到list.html页面  
GET /users/modify/{id}:根据id获取响应的用户数据，并返回form.html页面来执行修改    

Thymeleaf命名空间： xmlns:th="http://www.thymeleaf.org" 
#### Spring Data JPA 
JPA简介  
JPA（Java Persistence API）是用于管理Java EE和Java SE环境中的持久化，以及对象/关系映射的Java API  
实体：  
```
         实体表示关系数据库中的表     
         每个实体实例对应于该表中的行     
         类必须用javax.persistence.Entity注解  
         类必须有一个public或者protected的无参构造函数  
         实体实例被当做值以分离对象方式进行传递(例如通过会话bean的远程业务接口)，则该类必须实现Serializable接口
         唯一的对象标识符:简单注解(javax.persistence.id) 复合主键(javax.persistence.Embedddedld和javax.persistence.IdClass)
```
    
    
Spring Data JPA用法介绍  
Spring Data JPA 、Hibernate、Spring Boot集成  
数据持久化实战  