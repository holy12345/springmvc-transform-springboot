# SpringMVC项目在PCF上运行

SpringMVC项目怎样在PCF运行

## 不转换为SpringBoot项目

- 执行`mvn clean package`
- 执行`cf push {YOUR_APPP_NAME} -p {YOUR_WAR_PATH} -b https://github.com/cloudfoundry-community/tomee-buildpack.git `

## 转换为SpringBoot项目

- 添加SpringBoot启动函数

```
@SpringBootApplication
public class SpringMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class, args);
    }
}
```

- 在POM中添加对应依赖
```
  <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
```
- 修改POM中对应依赖
```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <scope>provided</scope> ---设置为provided
    </dependency>

```

- 修改POM打包方式

```
<packaging>war</packaging>
```

- 在`application.properties`中添加如下配置
```
spring.mvc.view.prefix={YOUR_JSP_PATH}
spring.mvc.view.suffix=.jsp
```
- 执行`mvn clean package`
- 执行`cf push {YOUR_APPP_NAME} -p {YOUR_WAR_PATH}`

