# Make Spring Project

    Spring Initializr
    https://start.spring.io/

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

# application.properties

    server.port = 8090 or 8080

#

| 22                       | 22                                                                    |
| ------------------------ | --------------------------------------------------------------------- |
| @SpringBootApplication   | 기본적인 스프링부트 앱 개발환경과 설정을 해주는 어노테이션            |
| @ComponentScan           | @Component가 붙은 클래스를 Bean으로 등록                              |
| @EnableAutoConfiguration | 스프링 프레임워크의 기본적인 기능을 활성화할때 사용하는 어노테이션    |
| @SpringBootConfiguration | @Configuration이 붙은 클래스를 스프링 프레임워크의 설정 클래스로 등록 |
| @Configuration           | 스프링 설정 클래스                                                    |
| @Controller              | HTTP Request를 처리하는 클래스                                        |
| @Bean                    | @Bean이 붙은 함수의 반환 객체를 빈으로 등록                           |
| @Component               | @Component가 붙은 클래스를 자바 빈으로 등록                           |

ApplicationContext : 자바 빈을 관리하는 클래스이며 스프링 컨텍스트 또는 스프링 풀이라고도 함
@Autowired : 자동 객체 생성

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

### Use Bean

### Add to Bean

```
@Bean
public ObjectName function(){
  return new ObjectName();
}
```

```
@Component
public class ObjectName {

}
```

### Get from Bean

```
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
ObjectName object = (ObjectName)context.getBean("objectName");
```

```
// 멤버변수 주입

@Autowired
private ObjectName object;
```

```
// setter 주입

private ObjectName object;

@Autowired
public void setObjectName(ObjectName object){
    this.object = object;
}
```

```
// constructor 주입 (final 사용 가능)

private final ObjectName object;

@Autowired
public Constructor(ObjectName object){
    this.object = object;
}
```

# Test

- MockMvc : 가상으로 HTTP 요청을 보내줌
- @Test : 테스트 케이스 메서드임을 알려주며 단돋 실행이 가능

```
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = javaFile.class)
class javaFileTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void main() throws Exception{
      String hello = "Hello Springboot~!!";
      mockMvc.perform(get("/"))
              .andExpect(status().isOk())
              .andExpect(content().string(hello));
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
