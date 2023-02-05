# Make Spring Project

> [Spring Initializr](https://start.spring.io/)

| Name             | Sub Name              | Explanation                                                   | Example                          |
| ---------------- | --------------------- | ------------------------------------------------------------- | -------------------------------- |
| Project          |                       | 빌드 툴                                                       | Gradle - Groovy                  |
| Language         |                       | JVM 상에서 동작하는 언어                                      | Java                             |
| Spring Boot      |                       | Spring Boot 버전                                              | (SNAPSHOT)이 없는 가장 최신 버전 |
| Project Metadata | Group                 | 프로젝트를 정의하는 고유한 식별자 정보인 그룹을 설정          | com.companyName                  |
|                  | Artifact              | 세부 프로젝트를 식별하는 정보                                 | AppName                          |
|                  | Name                  | 프로젝트 이름                                                 | AppName                          |
|                  | Description           | 프로젝트 설명                                                 | 빈칸                             |
|                  | Package name          | Group + Artifact                                              | com.companyName.AppName          |
|                  | Packaging             | 애플리케이션을 쉽게 배포하고 동작하게 할 파일들의 패키징 옵션 | Jar                              |
|                  | Java                  | Java 버전                                                     | 17                               |
| Dependencies     | Spring Boot Dev Tools | 소스파일의 변화를 감지하여 자동으로 빌드해주는 라이브러리     |
|                  | Spring Web            | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Lombok                | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Thymeleaf             | 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리         |
|                  | Swagger               | API 명세 관리 라이브러리                                      |

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

```
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
```

### Property

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

# 그외

@RestController: @Controller + @ResponseBody
@Controller
@ResponseBody
