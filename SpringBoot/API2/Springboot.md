# Make Spring Project

> [Spring Initializr](https://start.spring.io/)

| Name             | Sub Name                       | Explanation                                                   | Example                          |
| ---------------- | ------------------------------ | ------------------------------------------------------------- | -------------------------------- |
| Project          |                                | 빌드 툴                                                       | Gradle - Groovy                  |
| Language         |                                | JVM 상에서 동작하는 언어                                      | Java                             |
| Spring Boot      |                                | Spring Boot 버전                                              | (SNAPSHOT)이 없는 가장 최신 버전 |
| Project Metadata | Group                          | 프로젝트를 정의하는 고유한 식별자 정보인 그룹을 설정          | com.companyName                  |
|                  | Artifact                       | 세부 프로젝트를 식별하는 정보                                 | AppName                          |
|                  | Name                           | 프로젝트 이름                                                 | AppName                          |
|                  | Description                    | 프로젝트 설명                                                 | 빈칸                             |
|                  | Package name                   | Group + Artifact                                              | com.companyName.AppName          |
|                  | Packaging                      | 애플리케이션을 쉽게 배포하고 동작하게 할 파일들의 패키징 옵션 | Jar                              |
|                  | Java                           | Java 버전                                                     | 17                               |
| Dependencies     | Spring Boot Dev Tools          | 소스파일의 변화를 감지하여 자동으로 빌드해주는 라이브러리     |
|                  | Spring Web                     | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Lombok                         | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Thymeleaf                      | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Swagger                        | API 명세 관리 라이브러리                                      |
|                  | Spring Configuration Processor | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Spring Data JPA                | JPA 라이브러리                                                |
|                  | MariaDB Driver                 | MariaDB와 연동하기 위한 라이브러리                            |

# Request

### Method

> @Controller 클래스 안에 함수 선언
>
> Talend API Tester로 테스트

```
// Get, Post, Put, Patch, Delete Request

@RequestMapping(value = "/", method = RequestMethod.GET) // GET, POST, PUT, PATCH, DELETE
public String function(){
    return "index"
}
```

```
// Get Request

@GetMapping("/")
public String function(){
    return "index"
}
```

```
// Post Request

@PostMapping("/")
public String function(){
    return "index"
}
```

```
// Put Request

@PutMapping("/")
public String function(){
    return "index"
}
```

```
// Patch Request

@PatchMapping("/")
public String function(){
    return "index"
}
```

```
// Delete Request

@DeleteMapping("/")
public String function(){
    return "index"
}
```

### Get Value

> HttpEntity<T>: Header와 Body로 구성된 HTTP 요청과 응답을 구성
>
> RequestEntity: HTTP 요청 구성
>
> ResponseEntity: HTTP 응답 구성
>
> 아래 예제에서 ResponseEntity로도 return 가능 (status, headers, body 구성)

```
/* URL에 값을 담은 요청을 받음
   localhost:8080/variable */

@RequestMapping("/{variable}")
public String function(@PathVariable("variable") String variable){
    return "index";
}
```

```
/* URI에서 ?을 기준으로 우측에 키=값 형태로 구성한 요청을 받음
   localhost:8080?variable=value                        */

@RequestMapping("/")
public String function(@RequestParam("variable") String variable){
    return "index";
}

@RequestMapping("/")
public String function(@RequestParam Map<String, String> map){
    return "index";
}

@RequestMapping("/")
public String function(Class object){
    return "index";
}
```

```
/* HTTP Body 내용에 값을 포함한 요청을 받음 (보통 JSON 형식)
   localhost:8080                                    */

@RequestMapping("/")
public String function(@RequestBody Map<String, String> map){
    return "index";
}

@RequestMapping("/")
public String function(@RequestBody Class object){
    return "index";
}
```

# Swagger

### Dependency

> build.gradle의 dependencies에 넣기

```
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
```

### Property

> application.properties에 넣기

```
spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```

### Configuration

```
@Configuration
@EnableSwagger2
public class Configuration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(function())                                                  // ApiInfo object
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.companyName.AppName")) // 스캔할 패키지 범위
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo function() {
        return new ApiInfoBuilder()
                .title("Title")      // API 페이지 제목
                .description("설명") // API 페이지 설명
                .version("1.0.0")    // API 페이지 버전
                .build();
    }
}
```

### Controller

> @Controller 클래스 안에 사용

```
@ApiOperation(value = "Title", notes = "설명") // API 함수 제목과 설명
@RequestMapping("/")
public String function(@ApiParam(value = "설명", required = true) @RequestParam String variable){ /* API 함수의 파라미터 설명
                                                                                                     DTO 클래스 내의 매개변수에도 정의 가능 */
    return "index";
}
```

### Access

> https://localhost:8080/swagger-ui.html

# Logback

### Configuration

> resources/logback-spring.xml을 만들고 넣기

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <property name="LOG_PATH" value="./logs"/>

    <appender name="console" class="ch.qos.logback.core.ConsoleAppender"> <!-- appender type -->
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>INFO</level> <!-- 레벨 -->
        </filter>
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] [%thread] %logger %msg%n</pattern> <!-- pattern -->
        </encoder>
    </appender>

    <root level="INFO"> <!-- 레벨 -->
        <appender-ref ref="console"/> <!-- appender -->
    </root>
</configuration>
```

| Appender Type       | Explanation                            |
| ------------------- | -------------------------------------- |
| ConsoleAppender     | 콘솔에 로그를 출력                     |
| FileAppender        | 파일에 로그를 저장                     |
| RollingFileAppender | 여러개의 파일을 순회하면서 로그를 저장 |
| SWTPAppender        | 메일로 로그를 전송                     |
| DBAppender          | 데이터베이스에 로그를 저장             |

| Pattern            | Mean                                               |
| ------------------ | -------------------------------------------------- |
| %Logger{length}    | 로거의 이름                                        |
| %-5level           | 로그 레벨, -5는 출력 고정폭의 값                   |
| %msg, %message, %m | 로그 메세지                                        |
| %d                 | 로그 기록 시간                                     |
| %p                 | 로깅 레벨                                          |
| %F                 | 로깅이 발생한 애플리케이션 파일명                  |
| %M                 | 로깅이 발생한 메서드 이름                          |
| %I                 | 로깅이 발생한 호출지의 정보                        |
| %thread, %t        | 현재 스레드명                                      |
| %c                 | 로깅이 발생한 카테고리                             |
| %C                 | 로깅이 발생한 클래스명                             |
| %n                 | 줄바꿈                                             |
| %r                 | 애플리케이션 실행 후 로깅이 발생한 시점까지의 시간 |
| %L                 | 로깅이 발생한 로출 지점의 라인 수                  |

### Controller

> @Controller 클래스 안에 사용

```
private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

@RequestMapping("/")
public String function(@RequestParam String variable){

    LOGGER.info("메세지"); // 레벨 이름으로 함수명 결정

    return "index";
}
```

# MariaDB Connection

### Property

> application.properties에 넣기

```
# JPA

spring.jpa.hibernate.ddl-auto=none
spring.jpa.generate-ddl=false
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MariaDB103Dialect
logging.level.org.hibernate=info
```

```
# MariaDB

spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234
```

# Entity

```
@Entity
@Table(name="table")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Entity {

    // MySQL, MariaDB, PostgreSQL, H2DB
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Oracle, PostgreSQL
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(sequenceName = "table_seq", allocationSize = 1, name = "generator")
    private Long id;
    */

    // DB 열 매칭
    @Column(name = "column", nullable = false, unique = true, length = 255)
    private String column;

    // pattern 형식의 string으로 들어올 경우 잘 동작
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    // cf. @Transient: 엔티티 클래스에는 선언했지만 데이터베이스에는 필요 없을 경우 사용

    @Builder
    public Board(String column, LocalDate date) {
        this.column = column;
        this.date = date;
    }

}
```

# Repository

```
@Repository
public interface Repository extends JpaRepository<Entity, Long> {

    // 기본 함수에서 변형
    List<Entity> findByColumn(String column);

    // Native Query
    @Query(value = "SELECT * FROM table WHERE column = :column", nativeQuery = true)
    List<Entity> funciton(String column);

    @Modifying
    @Transactional
    @Query(value = "UPDATE table SET column = :column WHERE id = :id", nativeQuery = true)
    int funciton(String column, Long id); // Update, Insert, Delete문은 @Modifying, @Transactional을 추가해야됨

    // JPQL
    @Query(value = "SELECT * FROM table t WHERE t.column = :column")
    List<Entity> funciton(String column);

    // 메소드 이름 추가
    List<Entity> findFirst5ByColumnOrderByIdDesc(String column);

}
```

### Basic Function

| Function                                       | Return             | Explanation                                                        |
| ---------------------------------------------- | ------------------ | ------------------------------------------------------------------ |
| count()                                        | long               | returns the number of entities available                           |
| delete(Entity entity)                          | void               | deletes an entity                                                  |
| deleteAll()                                    | void               | deletes all the entities                                           |
| deleteAll(Iterable< extends Entity > entities) | void               | deletes the entities passed as argument                            |
| deleteAll(Iterable< extends Long > ids)        | void               | deletes the entities identified using their ids passed as argument |
| existsById(Long id)                            | boolean            | checks if an entity exists using its id                            |
| findAll()                                      | Iterable< Entity > | returns all the entities                                           |
| findAllByIds(Iterable< Long > ids)             | Iterable< Entity > | returns all the entities identified using ids passed as argument   |
| findById(Long id)                              | Optional< Entity > | returns an entity identified using id                              |
| save(Entity entity)                            | Entity             | saves an entity and return the updated one                         |
| saveAll(Iterable< Entity> entities)            | Iterable< Entity>  | saves all entities passed and return the updated entities          |

### Naming Convention

| Keyword            | Sample                                                  | JPQL snippet                                                   |
| ------------------ | ------------------------------------------------------- | -------------------------------------------------------------- |
| Distinct           | findDistinctByLastnameAndFirstname                      | select distinct …​ where x.lastname = ?1 and x.firstname = ?2  |
| Firstn             | findFirst5                                              | …​ limit 5                                                     |
| Lastn              | findLast5                                               | …​ order by x.id limit 5                                       |
| Asc                | findByAgeOrderByIdAsc                                   | …​ order by x.id asc                                           |
| Desc               | findByAgeOrderByIdDesc                                  | …​ order by x.id desc                                          |
| And                | findByLastnameAndFirstname                              | … where x.lastname = ?1 and x.firstname = ?2                   |
| Or                 | findByLastnameOrFirstname                               | … where x.lastname = ?1 or x.firstname = ?2                    |
| Is, Equals         | findByFirstname,findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                                       |
| Between            | findByStartDateBetween                                  | … where x.startDate between ?1 and ?2                          |
| LessThan           | findByAgeLessThan                                       | … where x.age < ?1                                             |
| LessThanEqual      | findByAgeLessThanEqual                                  | … where x.age <= ?1                                            |
| GreaterThan        | findByAgeGreaterThan                                    | … where x.age > ?1                                             |
| GreaterThanEqual   | findByAgeGreaterThanEqual                               | … where x.age >= ?1                                            |
| After              | findByStartDateAfter                                    | … where x.startDate > ?1                                       |
| Before             | findByStartDateBefore                                   | … where x.startDate < ?1                                       |
| IsNull, Null       | findByAge(Is)Null                                       | … where x.age is null                                          |
| IsNotNull, NotNull | findByAge(Is)NotNull                                    | … where x.age not null                                         |
| Like               | findByFirstnameLike                                     | … where x.firstname like ?1                                    |
| NotLike            | findByFirstnameNotLike                                  | … where x.firstname not like ?1                                |
| StartingWith       | findByFirstnameStartingWith                             | … where x.firstname like ?1 (parameter bound with appended %)  |
| EndingWith         | findByFirstnameEndingWith                               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing         | findByFirstnameContaining                               | … where x.firstname like ?1 (parameter bound wrapped in %)     |
| OrderBy            | findByAgeOrderByLastnameDesc                            | … where x.age = ?1 order by x.lastname desc                    |
| Not                | findByLastnameNot                                       | … where x.lastname <> ?1                                       |
| In                 | findByAgeIn(Collection<Age> ages)                       | … where x.age in ?1                                            |
| NotIn              | findByAgeNotIn(Collection<Age> ages)                    | … where x.age not in ?1                                        |
| True               | findByActiveTrue()                                      | … where x.active = true                                        |
| False              | findByActiveFalse()                                     | … where x.active = false                                       |
| IgnoreCase         | findByFirstnameIgnoreCase                               | … where UPPER(x.firstname) = UPPER(?1)                         |

# DAO

### Interface

```
public interface DAO {

    Entity insert(Entity entity);

    Entity select(Long id);

    Entity update(Long id, String column);

    void deleteProduct(Long id);

}
```

### Implementation

```
@RequiredArgsConstructor
@Component
public class ImplementDAO implements DAO {

    private final Repository repository;

    @Override
    public Entity insert(Entity entity) {
        ...
    }

    @Override
    public Entity select(Long id) {
        ...
    }

    @Override
    public Entity update(Long id, String column) {
        ...
    }

    @Override
    public void delete(Long id) {
        ...
    }
}
```

# DTO

```
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Dto {

    private long id;

    private String column;

    private LocalDate date;

}
```

# Service

### Interface

```
public interface Service {

    Dto select(Long id);

    Dto insert(Dto dto);

    Dto update(Long id, String column);

    void delete(Long id);

}
```

### Implementation

```
@Service
@RequiredArgsConstructor
public class ImplementService implements Service {

    private final DAO dao;

    @Override
    public Dto select(Long id) {
        ...
    }

    @Override
    public Dto insert(Dto dto) {
        ...
    }

    @Override
    public Dto update(Long id, String column) {
        ...
    }

    @Override
    public void delete(Long id) {
        ...
    }
}
```

# Controller

```
@RequiredArgsConstructor
@Controller
public class Controller {

    private final Service service;

    ...

}
```

# 그외

@RestController: @Controller + @ResponseBody
@Controller
@ResponseBody
