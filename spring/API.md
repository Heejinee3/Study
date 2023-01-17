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

| Annotation               | Explanation                                                             |
| ------------------------ | ----------------------------------------------------------------------- |
| @SpringBootApplication   | 기본적인 스프링부트 앱 개발환경과 설정을 해주는 어노테이션              |
| @ComponentScan           | @Component가 붙은 클래스를 Bean으로 등록                                |
| @EnableAutoConfiguration | 스프링 프레임워크의 기본적인 기능을 활성화할때 사용하는 어노테이션      |
| @SpringBootConfiguration | @Configuration이 붙은 클래스를 스프링 프레임워크의 설정 클래스로 등록   |
| @Configuration           | 스프링 설정 클래스                                                      |
| @Controller              | HTTP Request를 처리하는 클래스                                          |
| @Bean                    | @Bean이 붙은 함수의 반환 객체를 빈으로 등록                             |
| @Component               | @Component가 붙은 클래스를 자바 빈으로 등록                             |
| ApplicationContext       | 자바 빈을 관리하는 클래스이며 스프링 컨텍스트 또는 스프링 풀이라고도 함 |
| @Autowired               | 자동 객체 생성                                                          |
| MockMvc                  | 가상으로 HTTP 요청을 보내줌                                             |
| @Test                    | 테스트 케이스 메서드임을 알려주며 단돋 실행이 가능                      |
| @WebMvcTest              | 웹 영역만을 테스트 하기 위한 지시어                                     |
| @Test                    | 테스트 케이스 메서드를 지정                                             |
| @Getter                  | getter 자동생성                                                         |

// @Setter : setter 자동생성
// @NoArgsConstructor : 매개변수 없는 기본생성자 자동생성
// @AllArgsConstructor : 모든 필드를 파라미터로 받는 생성자 자동생성
// @RequiredArgsConstructor : final이나 @NonNull인 필드만 매개변수로 받는 생성자 자동생성
// : 생성자 주입에 사용
// @NonNull : null을 허용하지 않는 객체 Bean 자동생성
// @Nullable : null을 허용하는 객체 Bean 자동생성
// @Data : @Getter, @Setter,@RequiredArgsConstructor,
// @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 어노테이션
// @ToString : toString 메소드 자동생성
// @EqualsAndHashCode : equals, hashCode 메서드 생성

# File

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

### Add to Bean

```
@Bean
public ObjectName function(){
  return new ObjectName();
}
```

```
@Component("component")
public class ObjectName {

}
```

### Get from Bean

```
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
ObjectName object = (ObjectName)context.getBean("component");
```

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

# Test

```
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = javaFile.class)
class javaFileTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void function() throws Exception{ // perform()은 RuntimeException이 발생할 수 있는 코드이므로 예외 처리 해주어야함

      String str = "str";

      mockMvc.perform(get("/")) // HTTP GET방식으로 루트 경로(/)를 호출
              .andExpect(status().isOk()) // HTTP 응답이 200으로 성공적인 응답인지를 확인
              .andExpect(content().string(str)); // 응답의 내용이 문자열 str과 같은지를 확인
  }
}
```

# build.gradle

    plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.7'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
    }

    group = 'com.study'
    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = '17'

    configurations {
      compileOnly {
        extendsFrom annotationProcessor
      }
    }

    // 라이브러리 저장소
    repositories {
    mavenCentral()
    // jcenter()
    }

    // 임포트하는 라이브러리들
    dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.mockito:mockito-core:4.11.0'

}

    tasks.named('test') {
    useJUnitPlatform()
    }

```

```

# HTML

    @Controller
    public class MainController {
        // 요청 URL: localhost:8080/
        @GetMapping("/")// GET
        @ResponseBody // HTTP 응답으로 순수한 문자열로 반환한다는 의미
        public String main(){
            return "Hello Springboot~!!";
        }
    }

# application.properties

    server.port = 8090 or 8080

#

@Component
@RequiredArgsConstructor
@NoArgsConstructor(force = true) // final 필드를 0이나 null이나 false로 설정합니다
public class Member {
// Spring Security에서 기본적으로 사용하는 id/pw
private final String username; // user id
@NonNull
private String password; // user pw
}
