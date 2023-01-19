request.getSession().setAttribute("variable", value);

> Get variable
>
> <form action="/formAction" method="post">
>   <input type="text" name="name" value="">
>   <input type="submit">
> </form>

> Set variable
>
> `<p th:text="${name}"></p>` > `<p th:text="${session.name}"></p>`
>
> `<p th:text="${member.name}"></p>` > `<p th:text="${map.name}"></p>`

### Way1

```
@RequestMapping("/formAction")
public String function(HttpServletRequest request){

    String username = request.getParameter("username"); // get variable
    String password = request.getParameter("password");

    request.setAttribute("username", username);         // set variable
    request.setAttribute("password", password);

    return "index";

}
```

### Way2

```
@RequestMapping("/formAction")
public String function(HttpServletRequest request, Model model){

    String username = request.getParameter("username"); // get variable
    String password = request.getParameter("password");

    model.addAttribute("username", username);           // set variable
    model.addAttribute("password", password);

    return "index";

}
```

### Way3

```
@RequestMapping("/formAction")
public ModelAndView function(HttpServletRequest request, ModelAndView mv){

    String username = request.getParameter("username"); // get variable
    String password = request.getParameter("password");

    mv.addObject("username", username);                 // set variable
    mv.addObject("password", password);

    mv.setViewName("index");
    return mv;

}
```

### Way4

```
@RequestMapping("/formAction/{username}/{password}")
public String function(@PathVariable("username") String username, // get variable
                       @PathVariable("password") String password,
                       Model model){

    model.addAttribute("username", username);                     // set variable
    model.addAttribute("password", password);

    return "loginResult";

}
```

### Way5

```
@RequestMapping("/formAction")
public String function(@RequestParam(value="username", required = false, defaultValue = "홍길동") String username, // get variable (null is ok)
                       @RequestParam("password") String password,                                                  // get variable (null is not ok)
                       Model model){

    model.addAttribute("username", username);                                                                      // set variable
    model.addAttribute("password", password);

    return "loginResult";

}
```

### Way6

```
@RequestMapping("/formAction")
public String function(Member member, Model model){ // get variable

  model.addAttribute("member", member);             // set variable

  return "index";

}
```

### Way7

```
@RequestMapping("/formAction")
public String function(@RequestParam Map<String,Object> map, Model model){ // get variable

    model.addAttribute("map", map);                                        // set variable

    return "index";

}
```

# Attribute th

### th:text

```

<p th:text = "${variable}">innerText로 출력</p>
```

### th:utext

```
<p th:utext = "${variable}">innerHTML로 출력</p>
```

### th:value

```
<input type="text" th:value="${variable}" value="">
```

### th:with

```
<p th:with="variable2=${variable1}" text="${variable2}">값 넣기</p>
```

### th:href

```
<a th:href="@{index}">Redirect</a>
```

# Logic

### If Else Statement

```
<th:block th:if="${expression}">
    <p>if문</p>
</th:block>
<th:block th:unless="${expression}">
    <p>else문</p>
</th:block>
```

### Switch Case Statement

```
<div th:switch="${variable}">
  <p th:case="value1">case1</p>
  <p th:case="value2">case2</p>
  <p th:case="*">default</p>
</div>
```

### Not Condition

```
<p th:if="${not expression}" th:text="${variable}">not 조건</p>
```

### Ternary Operator

```
<p th:text="${expression} ? 'true' : 'false'">삼항연산자</p>
```

# Expression

### String

```
<p th:text="'string'+ ${variable}">문자열</p>
```

```
<p th:text="|string + ${variable}|">문자열</p>
```

### Object

```
<p th:text="${object.member_var}"></p>
```

```
<th:block th:object="${object}">
  <p th:text="*{member_var}"></p>
</th:block>
```

### List

```
<table>
  <tr th:each="element, status: ${list}">
    <td><span th:text="${status.count}"></span></td>
    <td><span th:text="${element.member_var}"></span></td>
  </tr>
</table>
```

| Status         | Explanation                   |
| -------------- | ----------------------------- |
| status.index   | 현재 반복 인덱스 (0부터 시작) |
| status.count   | 현재 반복 인덱스 (1부터 시작) |
| status.size    | 총 요소 수                    |
| status.current | 현재 요소                     |
| status.even    | 현재 반복이 짝수인지 여부     |
| status.odd     | 현재 반복이 홀수인지 여부     |
| status.first   | 현재 반복이 첫번째인지 여부   |
| status.last    | 현재 반복이 마지막인지 여부   |

# Function

### strings.defaultString

```
<p th:text="${#strings.defaultString(variable, 'string')}">defaultString</p>
```

### strings.isEmpty

```
<p th:text="${#strings.isEmpty(variable)}">isEmpty</p>
```

### dates.format

```
<p th:text="${#dates.format(variable,'yyyy/MM/dd HH:mm:ss')}"></p>
```

### temporals.format

```
<p th:text="${#temporals.format(variable,'yyyy/MM/dd HH:mm:ss')}"></p>
```

### numbers.formatInteger

```
<p th:text="${#numbers.formatInteger(variable, comma_num, 'COMMA')}"></p>
```

### numbers.formatDecimal

```
<p th:text="${#numbers.formatDecimal(variable, comma_num, 'COMMA', point_num, 'POINT')}"></p>
```
