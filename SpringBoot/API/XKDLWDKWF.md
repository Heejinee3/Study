    @GetMapping("/index1")
    public String index1(Model model){
        model.addAttribute("name_text","홍길동");
        model.addAttribute("name_html","<ins>홍길동</ins>");
        model.addAttribute("server_value","Hong");
        return "index1"; // 일단 타임리브 디펜던시를 사용하면, "index1" -> templates/index1.html 으로 응답함
    }


    <html xmlns:th="http://www.thymeleaf.org">

      th: text : innerText로 출력 <br>

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

# Logic

### th:if th:unless

```
<th:block th:if="${expression}">
    <p>if문</p>
</th:block>
<th:block th:unless="${expression}">
    <p>else문</p>
</th:block>
```

### th:switch th:case

```
<div th:switch="${variable}">
  <p th:case="value1">case1</p>
  <p th:case="value2">case2</p>
  <p th:case="*">default</p>
</div>
```

### not

<p th:if="${not #strings.isEmpty(address)}" th:text="|address는 empty가 아닙니다.|">not isEmpty 함수 결과</p>

<p th:text="${expression} ? 'true' : 'false'">삼항연산자</p>

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

객체 리스트 출력 <br>

  <table border="1">
    <tr th:each="member, status: ${list}">
      <td><span th:text="${status.count}"></span></td>
      <td><span th:text="${member.username}"></span></td>
      <td><span th:text="${member.password}"></span></td>
    </tr>
  </table>

status.index : 현재 반복 인덱스 (0부터 시작합니다.)<br>
status.count : 현재 반복 인덱스 (1부터 시작합니다.)<br>
status.size : 총 요소 수<br>
status.current : 현재 요소 (0부터 시작합니다.)<br>
status.even : 현재 반복이 짝수인지 여부 (boolean값)<br>
status.odd : 현재 반복이 홀수인지 여부 (boolean값)<br>
status.first : 현재 반복이 첫번째인지 여부 (boolean값)<br>
status.last : 현재 반복이 마지막인지 여부 (boolean값)<br>

<a th:href="@{ index7 }">타임리프 링크입니다. /index7로 redirect 됩니다.</a>
