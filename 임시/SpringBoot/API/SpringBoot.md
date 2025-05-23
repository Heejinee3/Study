해야할 거
ex15_jpa_realdb_crud

# Annotation

| Annotation               | Explanation                                                               |
| ------------------------ | ------------------------------------------------------------------------- |
| @SpringBootApplication   | @ComponentScan, @EnableAutoConfiguration, @SpringBootConfiguration        |
| @ComponentScan           | @Component가 붙은 클래스를 Bean으로 등록                                  |
| @EnableAutoConfiguration | 스프링 프레임워크의 기본적인 기능을 활성화할때 사용하는 어노테이션        |
| @SpringBootConfiguration | @Configuration이 붙은 클래스를 스프링 프레임워크의 설정 클래스로 등록     |
| @Configuration           | 스프링 설정 클래스                                                        |
| @Controller              | HTTP Request를 처리하는 클래스, @Component가 적용됨                       |
| @Bean                    | @Bean이 붙은 함수의 반환 객체를 빈으로 등록                               |
| @Component               | @Component가 붙은 클래스를 자바 빈으로 등록                               |
| @Autowired               | 자동 객체 생성                                                            |
| @SpringBootTest          | 통합 테스트                                                               |
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
| @Entity                  | DB 테이블과 1:1로 매칭되는 JPA 클래스에 사용                              |
| @Table                   | 클래스 이름이 테이블 이름으로 기본 설정되는데, 테이블의 이름을 바꿔줌     |
| @Id                      | 기본키 id열로 사용                                                        |
| @GeneratedValue          | 해당 ID값을 어떻게 생성할지 전략을 선언                                   |
| @Column                  | DB 열과 매칭                                                              |
| @DateTimeFormat          | 자바 클래스와 DB/Form Data와 매핑시 형식을 정해줌                         |
| @Repository              | JPA DAO클래스에 적용, @Component가 적용됨                                 |
| @Service                 | 서비스 로직 클래스에 적용, @Component가 적용됨                            |
| @BeforeAll               | 클래스를 초기화시 한번 수행                                               |
| @BeforeEach              | 메소드 호출시마다 한번 수행"                                              |
| @DisplayName             | 테스트 이름 설정                                                          |

| Class              | Explanation                                                                                          |
| ------------------ | ---------------------------------------------------------------------------------------------------- |
| MockMvc            | 가상으로 HTTP 요청을 보내줌                                                                          |
| ApplicationContext | 자바 빈을 관리하는 클래스이며 스프링 컨텍스트 또는 스프링 풀이라고도 함                              |
| JpaRepository      | 스프링 JPA 라이브러리에서 Entity에 대한 기복적인 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스 |

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
