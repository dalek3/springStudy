## 스프링 설정
### 1. pom.xml
1. 기본 설정
    1. properties 설정

    ```xml
    <properties>
        <java-version>1.8</java-version>
        <org.springframework-version>4.3.8.RELEASE</org.springframework-version>
        <org.aspectj-version>1.8.9</org.aspectj-version>
        <org.slf4j-version>1.6.6</org.slf4j-version>
    </properties>
    ```
    2. servlet 버전 확인 후 변경

    ```xml
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    ```

    3. json

    ```xml
    <!-- json -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.8.8</version>
    </dependency>
    ```
2. DB
    1. mysql-connector-java 
    
    ```xml
    <!-- mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.11</version>
    </dependency>
    ```
3. Test
    1. junit

    ```xml
    <!-- Test -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-core</artifactId>
        <version>1.3</version>
    </dependency>
    ```
    3. log4j : mybatis로그를 알기위한 모듈 (선택사항) 코딩단 p138 참조
        - `/src/main/resources` 폴더에 `log4jdbc.log4j2.properties`파일과 `logback.xml`파일을 추가해야 한다.
    
    ```xml
    <!-- log4jdbc-log4j2 -->
    <dependency>
        <groupId>org.bgee.log4jdbc-log4j2</groupId>
        <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
        <version>1.16</version>
    </dependency>
    ```
4. mybatis
    1. mybatis

    ```xml
    <!-- mybatis -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.6</version>
    </dependency>
    ```
    2. mybatis-spring : spring, mybatis 사이에 두 프레임워크의 접착제 역할을 하는 모듈

    ```xml
    <!-- mybatis-spring -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.2</version>
    </dependency>
    ```
    3. spring-jdbc : spring과 mybatis를 같이 사용하는 경우에는 주로 spring의 설정으로 jdbc 연결을 처리하는 경우가 많기 때문에 사용
    
    ```xml
    <!-- spring-jdbc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    ```
    4. spring-test : 스프링과 mybatis가 정상적으로 연동되었는지를 확인하는 용도
    
    ```xml
    <!-- spring-test -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${org.springframework-version}</version>
        <scope>test</scope>
    </dependency>
    ```
5. aop
    1. aop
    
    ```xml
    <!-- spring-aop -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    ```
    2. tx
    
    ```xml
    <!-- spring-tx -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    ```
    3.aspectJ
    
    ```xml
    <!-- AspectJ -->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjrt</artifactId>
        <version>${org.aspectj-version}</version>
    </dependency>

    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjtools</artifactId>
        <version>${org.aspectj-version}</version>
    </dependency>
    ```
### 2. root-content.xml
1. DB
    - namespaces: aop, context, jdbc, mybatis-spring
    1. dataSource : jdbc의 커넥션을 처리하는 기능을 가지고 있기 때문에 db와 연동 작업에 반드시 필요(spring-jdbc 모듈 이용)
        - class속성의 값을 보면 `org.springframework.jdbc.datasource.xxx`로 시작하는 것을 볼 수 있다.
        - 이 속성의 값에 해당하는 클래스가 존재해야 하기 때문에 이전 단계에 spring-jdbc 모듈을 추가해 준 것이다.
        <br>.
        - id라는 속성은 Bean(스프링 내에 특정한 객체)을 찾기 위해서 사용하는 일종의 alias에 속한다.
        - 뒤에 이 속성의 값을 이용해서 다른 객체와 연결하는 모습을 볼 수 있다.
        - (dataSource 값을 그대로 사용하는 것이 향후에 에러가 발생할 가능성이 적다.) 
    ```xml
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value=""></property>
        <property name="url"             value=""></property>
        <property name="username"        value=""></property>
        <property name="password"        value=""></property>
    </bean>
    ```
    
2. mybatis
    1. sqlSessionFactory
        - mybatis와 spring 연동 작업에서의 핵심은 Connection을 생성하고, 처리한다.
        - 데이터베이스와의 연결과 sql의 실행에 대한 모든 것을 가진 가장 중요한 객체
        - spring을 이용할 때는 sqlSessionFactory를 생성해 주는 특별한 객체를 설정
        - class 속성값 `org.mybatis.spring.xxx`은 mybatis-spring 모듈을 다운로드 받아야만 사용할 수 있다.

    ```xml
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!-- 1. mybatis-config.xml파일이 스프링이 동작할 때 같이 동작하도록 설정해 주는 작업 -->
        <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"></property>
        <!-- 2. mybatis가 동작하면 XML Mapper를 인식해야만 정상적인 동작이 가능.
            mappers폴더 내에 어떤폴더이건 관계없이 파일이름이 Mapper.xml로 끝나면 자동으로 인식하도록 설정. -->
        <property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"></property>
    </bean>
    ```
    3. sqlSessionTemplate 설정
        - dao 인터페이스와 Mapper의 작성이 완료됐다면 실제 이를 구현하는 구현 클래스를 작성해야만 한다.
        - mybatis에서 dao를 이용하는 경우는 SqlSessionTemplate이라는 것을 이용해서 dao를 구현하므로,
        - 우선적으로 SqlSessionTemplate을 설정하는 작업부터 시작한다.
        - dao의 작업에서 가장 번거로운 작업은 DB와 연결을 맺고, 작없이 완료된 후에 연결을 close()하는 작업이다.
        - mybatis-spring라이브러리에는 이것을 처리할 수 있는 SqlSessionTemplate이라는 클래스를 제공하므로,
        - 이를 이용하면 개발자들이 직접 연결을 맺고, 종료하는 작업을 줄일 수 있다.
        - 정리하면 mybatis-spring에서 제공하는 SqlSessionTemplate은 mybatis의 sqlSession인터페이스를 구현한
        <br>클래스로 기본적인 트랜잭션의 관리나 쓰레드 처리의 안정성 등을 보장해 주고, DB의 연결과 종료를 책임진다.
    
    ```xml
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
        <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
    </bean>
    ```
2. component-scan
    - *DAOImpl, *ServiceImpl이 @Repository에노테이션이 설정되더라도 스프링에서 해당 패키지를 스캔하지 않으면 
    <br>제대로 스프링의 빈으로 등록되지 못하므로 아래와 같이 작성한다.
    ```xml
    <context:component-scan base-package="org.zerock.dao"></context:component-scan>
    <context:component-scan base-package="org.zerock.service"></context:component-scan>
    ```
3. aop
    - namespaces: aop, tx / servlet-content.xml에도 추가
    1. aop

    ```xml
    <aop:config></aop:config>

    <context:component-scan base-package="org.zerock.aop"></context:component-scan>

    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
    ```
    2. transaction

    ```xml
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <tx:annotation-driven/>
    ```
### 3. servlet-content.xml
1. 기본 설정
    1. 클래스 선언에 애노테이션을 이용해서 컨트롤러를 작성할 수 있다는 선언
    
    ```xml
    <!-- Enables the Spring MVC @Controller programming model -->
    <annotation-driven />
    ```
    2. 웹에서 이미지나 css, javascript 파일과 같이 고정된 자원들의 위치를 의미

    ```xml
    <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
    <resources mapping="/resources/**" location="/resources/" />
    ```
    3. 뷰를 어떻게 처리하는가에대한 설정
    
    ```xml
    <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
    <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".jsp" />
    </beans:bean>
    ```
    4. component-scan
        - `base-package` 속성값에 해당하는 패키지 내부의 클래스들을 조사한다는 뜻
        - 이는 `<annotation-driven>`과 같이 결합해서 해당 패키지에 애노테이션 처리가 된 컨트롤러를 작성만 해주면 자동으로 인식되게 한다.
    
    ```xml
    <!-- Controller 객체 위치 등록 -->
    <context:component-scan base-package="org.zerock.controller" />
    ```
2. Interceptor 설정

```xml
<beans:bean id="authInterceptor" class="org.zerock.interceptor.AuthInterceptor"></beans:bean>
<beans:bean id="loginInterceptor" class="org.zerock.interceptor.LoginInterceptor"></beans:bean>
<interceptors>
    <interceptor>
        <mapping path="/user/loginPost"/>
        <beans:ref bean="loginInterceptor"/>
    </interceptor>
    
    <interceptor>
        <mapping path="/sboard/register"/>
        <mapping path="/sboard/modifyPage"/>
        <mapping path="/sboard/removePage"/>
        <beans:ref bean="authInterceptor"/>
    </interceptor>
</interceptors>
```
### 4. mybatis 관련
1. mybatis-config.xml (root-content.xml -> sqlSessionFactory -> configLocation랑 같이 볼 것)
    - mybatis는 sql mapping 프레임워크로 별도의 설정 파일을 가질 수 있다.
    - 이를 이용하면 스프링의 설정과 별도로 사용하는 모든 mybatis의 설정 기능을 활용할 수 있다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!-- 마이바티스의 작동 규칙정의 : 기본 캐시 사용여부 -->
    <settings>
        <setting name="cacheEnabled" value="false"/>
    </settings>

    <!-- XML Mapper에서 paramType이나 resultType에 사용하는 클래스의 이름을 축약해서 사용가능하게 해줌 -->
    <typeAliases>
        <package name="org.zerock.domain"/>
    </typeAliases>

</configuration>
```
2. mappers/**/*Mapper.xml (root-content.xml -> sqlSessionFactory -> mapperLocations랑 같이 볼 것)
    - `namespace`라는 설정에 가장 신경을 많이 써야만 한다.(`<mapper>`)
    - `namespace`속성은 클래스의 패키지와 유사한 용도로, mybatis 내에서 원하는 sql 문을 찾아서 실행할 때 동작한다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace에 원하는 mapper경로 입력 ex) org.zerock.mapper.BoardMapper-->
<mapper namespace="">
    sql문
</mapper>
```
### web.xml
- utf-8 처리 필터등록

```xml
<filter>
    <filter-name>encoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encoding</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```
- get/post방식만 지원하는 브라우저에서 REST방식을 사용할 수 있도록 설정

```xml
<filter>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```
### 6. Junit을 이용한 테스트
1. mysqlConnectTest
2. DataSourceTest
3. MyBatisTest
4. *ContrllerTest - sevlret 3.1.0이상 / 잘안쓰는거 같음
5. *DAOTest