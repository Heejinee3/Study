# Make Spring Project

> Spring Initializr
>
> https://start.spring.io/

| Name             | Sub Name              | Explanation                                               | Example                          |
| ---------------- | --------------------- | --------------------------------------------------------- | -------------------------------- |
| Project          |                       |                                                           | Gradle - Groovy                  |
| Language         |                       |                                                           | Java                             |
| Spring Boot      |                       |                                                           | (SNAPSHOT)이 없는 가장 최신 버전 |
| Project Metadata | Group                 | 프로젝트 집합                                             | com.companyName                  |
|                  | Artifact              | 프로젝트 이름                                             | AppName                          |
|                  | Name                  | 프로젝트 이름                                             | AppName                          |
|                  | Description           | 프로젝트 설명                                             | 빈칸                             |
|                  | Package name          | 애플리케이션 id 문구                                      | com.companyName.AppName          |
|                  | Packaging             |                                                           | Jar                              |
|                  | Java                  |                                                           | 17                               |
| Dependencies     | Spring Boot Dev Tools | 소스파일의 변화를 감지하여 자동으로 빌드해주는 라이브러리 |
|                  | Spring Web            | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리     |
|                  | Lombok                | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리     |
|                  | Thymeleaf             | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리     |

# Annotation

| Annotation               | Explanation                                                               |
| ------------------------ | ------------------------------------------------------------------------- |
| @SpringBootApplication   | @ComponentScan, @EnableAutoConfiguration, @SpringBootConfiguration        |
| @ComponentScan           | @Component가 붙은 클래스를 Bean으로 등록                                  |
| @EnableAutoConfiguration | 스프링 프레임워크의 기본적인 기능을 활성화할때 사용하는 어노테이션        |
| @SpringBootConfiguration | @Configuration이 붙은 클래스를 스프링 프레임워크의 설정 클래스로 등록     |
| @Configuration           | 스프링 설정 클래스                                                        |
| @Controller              | HTTP Request를 처리하는 클래스                                            |
| @Bean                    | @Bean이 붙은 함수의 반환 객체를 빈으로 등록                               |
| @Component               | @Component가 붙은 클래스를 자바 빈으로 등록                               |
| @Autowired               | 자동 객체 생성                                                            |
| @Test                    | 테스트 케이스 메서드임을 알려주며 단돋 실행이 가능                        |
| @WebMvcTest              | 웹 영역만을 테스트 하기 위한 지시어                                       |
| @Test                    | 테스트 케이스 메서드를 지정                                               |
| @Getter                  | getter 자동생성                                                           |
| @Setter                  | setter 자동생성                                                           |
| @NoArgsConstructor       | 매개변수 없는 기본생성자 자동생성                                         |
| @AllArgsConstructor      | 모든 필드를 파라미터로 받는 생성자 자동생성                               |
| @RequiredArgsConstructor | final이나 @NonNull인 필드만 매개변수로 받는 생성자 자동생성               |
| @NonNull                 | null을 허용하지 않는 객체 Bean 자동생성                                   |
| @Nullable                | null을 허용하는 객체 Bean 자동생성                                        |
| @Data                    | @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode |
| @ToString                | toString 메소드 자동생성                                                  |
| @EqualsAndHashCode       | equals, hashCode 메서드 생성                                              |
| @GetMapping              | 사용자의 HTTP Get요청에 대한 응답 경로와 메서드를 정의                    |
| @PostMapping             | 사용자의 HTTP Post요청에 대한 응답 경로와 메서드를 정의                   |
| @PutMapping              | 사용자의 HTTP Put요청에 대한 응답 경로와 메서드를 정의                    |
| @DeleteMapping           | 사용자의 HTTP Delete요청에 대한 응답 경로와 메서드를 정의                 |
| @PatchMapping            | 사용자의 HTTP Patch요청에 대한 응답 경로와 메서드를 정의                  |
| @RequestMapping          | 모든 타입의 요청을 처리                                                   |

| Class              | Explanation                                                             |
| ------------------ | ----------------------------------------------------------------------- |
| MockMvc            | 가상으로 HTTP 요청을 보내줌                                             |
| ApplicationContext | 자바 빈을 관리하는 클래스이며 스프링 컨텍스트 또는 스프링 풀이라고도 함 |

# Annotation

### SpringBootApplication

```
@SpringBootApplication
public class AppNameApplication {

}
```

### Configuration

```
@Configuration
public class AppConfig {

}
```

### Controller

```
@Controller
public class MainController {

}
```

# Bean

### Bean: Add

```
@Bean
public ObjectName function(){
  return new ObjectName();
}
```

### Component: Add

```
@Component("component") // parameter가 없으면 이름은 objectName
public class ObjectName {

}
```

### ApplicationContext : Get

```
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
ObjectName object = (ObjectName)context.getBean("component");
```

### Autowired : Get

```
// 멤버변수 주입

@Autowired
@Qualifier("component")
private ObjectName object;
```

```
// setter 주입

private ObjectName object;

@Autowired
@Qualifier("component")
public void setObjectName(ObjectName object){

    this.object = object;

}
```

```
// constructor 주입 (final 사용 가능)

private final ObjectName object;

@Autowired
@Qualifier("component")
public Constructor(ObjectName object){

    this.object = object;

}
```

# Class Initialize

### Getter

```
@Getter
public class ObjectName {

    private type variable;

}
```

### Setter

```
@Setter
public class ObjectName {

    private type variable;

}
```

### NoArgsConstructor

```
@NoArgsConstructor // force = true로 설정하면 final 변수에서 에러가 안나옴
public class ObjectName {

    private type variable;

}
```

### AllArgsConstructor

```
@AllArgsConstructor
public class ObjectName {

    private type variable;

}
```

### RequiredArgsConstructor

```
@RequiredArgsConstructor
public class ObjectName {

    private final type variable1;

    @NonNull
    private type variable2;

    @Nullable
    private type variable3;

}
```

### Data

```
@Data
public class ObjectName {

    private type variable;

}
```

### ToString

```
@ToString
public class ObjectName {

    private type variable;

}
```

### EqualsAndHashCode

```
@EqualsAndHashCode
public class ObjectName {

    private type variable;

}
```

# HTML Request

### Get

```
@GetMapping("/")    // localhost:8080
public Type function(){

    return "index"; // @ResponseBody를 사용하면 HTTP 응답으로 순수한 문자열로 반환

}
```

### Post

```
@PostMapping("/")
public Type function(){

    return "index";

}
```

### Put

```
@PutMapping("/")
public Type function(){

    return "index";

}
```

### Delete

```
@DeleteMapping("/")
public Type function(){

    return "index";

}
```

### Patch

```
@PatchMapping("/")
public Type function(){

    return "index";

}
```

### Request

```
@RequestMapping(value = "/", method = RequestMethod.GET) // GET, POST, PUT, DELETE, PATCH
public Type function(){

    return "index";

}
```

# Test

```
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = javaFile.class)
class javaFileTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void function() throws Exception{          // perform()은 RuntimeException이 발생할 수 있는 코드이므로 예외 처리 해주어야함

        String str = "str";

        mockMvc.perform(get("/"))              // HTTP GET방식으로 루트 경로(/)를 호출
            .andExpect(status().isOk())        // HTTP 응답이 200으로 성공적인 응답인지를 확인
            .andExpect(content().string(str)); // 응답의 내용이 문자열 str과 같은지를 확인
    }
}
```

# build.gradle

```
configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

dependencies {
    implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect'       // Thymeleaf Layout
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf' // Thymeleaf
    implementation 'org.springframework.boot:spring-boot-starter-web'       // Spring Web
    compileOnly 'org.projectlombok:lombok'                                  // Lombok
    developmentOnly 'org.springframework.boot:spring-boot-devtools'         // Spring Boot Dev Tools
    annotationProcessor 'org.projectlombok:lombok'                          // Lombok
    testImplementation 'org.springframework.boot:spring-boot-starter-test'  // Spring
    testImplementation 'org.mockito:mockito-core:4.11.0'                    // Mock
}
```

# application.properties

### Port

```
server.port = 8090 or 8080
```

### Thymeleaf

```
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### H2 Database

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

```
# in-memory DB
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
```

```
# file DB
user home directory is C:\Users(user name) in Windows OS.
testdb.mv.db file make ( file is empty file ).
cmd console : type nul > testdb.mv.db
spring.datasource.url=jdbc:h2:~/testdb
spring.datasource.driverClassName=org.h2.Driver
```

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update                                    # 상용 DB에서는 none이나 validate
```
