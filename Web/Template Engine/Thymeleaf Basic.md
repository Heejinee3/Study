<br />

## Thymeleaf 적용

#### build.gradle

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
}
```

#### application.properties

```
spring.thymeleaf.enabled=true
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:templates/
spring.thymeleaf.suffix=.html
```

#### html

```html
<html xmlns:th="http://www.thymeleaf.org"></html>
```

<br />

## 표준 표현식 및 객체

#### Simple expressions

| 종류                           | 표현    |
| ------------------------------ | ------- |
| Variable Expressions           | ${...}  |
| Selection Variable Expressions | \*{...} |
| Message Expressions            | #{...}  |
| Link URL Expressions           | @{...}  |
| Fragment Expressions           | ~{...}  |

<p></p>

#### Literals

| 종류             | 표현                         |
| ---------------- | ---------------------------- |
| Text literals    | 'one text', 'Another one!',… |
| Number literals  | 0, 34, 3.0, 12.3,…           |
| Boolean literals | true, false                  |
| Null literal     | null                         |
| Literal tokens   | one, sometext, main,…        |

<p></p>

#### Text operations

| 기능                  | 표현                      |
| --------------------- | ------------------------- |
| String concatenation  | +                         |
| Literal substitutions | \| The name is ${name} \| |

<p></p>

#### Arithmetic operations

| 종류                        | 표현           |
| --------------------------- | -------------- |
| Binary operators            | +, -, \*, /, % |
| Minus sign (unary operator) | -              |

<p></p>

#### Boolean operations

| 종류                              | 표현    |
| --------------------------------- | ------- |
| Binary operators                  | and, or |
| Boolean negation (unary operator) | !, not  |

<p></p>

#### Comparisons and equality

| 종류               | 표현         |
| ------------------ | ------------ |
| Comparators        | >, <, >=, <= |
| Equality operators | ==, !=       |

<p></p>

#### Conditional operators

| 종류         | 표현                      |
| ------------ | ------------------------- |
| If-then      | (if) ? (then)             |
| If-then-else | (if) ? (then) : (else)    |
| Default      | (value) ?: (defaultvalue) |

<p></p>

#### Special tokens

| 종류         | 표현 |
| ------------ | ---- |
| No-Operation | \_   |

<p></p>

#### Expression Basic Objects

| 표현                   | 설명                                             |
| ---------------------- | ------------------------------------------------ |
| #ctx                   | Context Object                                   |
| #vars                  | Context Variable                                 |
| #locale                | Context Locale                                   |
| #request               | HttpServletRequest (스프링 부트 3.0부터 지원 X)  |
| #response              | HttpServletResponse (스프링 부트 3.0부터 지원 X) |
| #session               | HttpSession (스프링 부트 3.0부터 지원 X)         |
| #servletContext        | ServletContext (스프링 부트 3.0부터 지원 X)      |
| session                | HttpSession                                      |
| param                  | Request Parameter                                |
| @helloBean (Bean name) | Spring Bean                                      |

[공식 문서 보기](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#appendix-a-expression-basic-objects)

<p></p>

#### Expression Utility Objects

| 표현         | 설명                                                                  |
| ------------ | --------------------------------------------------------------------- |
| #execInfo    | 템플릿 처리에 대한 정보를 제공                                        |
| #messages    | 변수 표현식 내에서 외부화된 메시지를 가져오는 방법을 제공하는 메서드  |
| #uris        | URL/URI의 일부를 이스케이핑하는 방법을 제공하는 메서드                |
| #conversions | 구성된 변환 서비스를 실행하는 메서드를 제공                           |
| #dates       | java.util.Date 객체에 대한 형식 지정, 구성 요소 추출 등을 위한 메서드 |
| #calendars   | java.util.Calendar 객체에 대한 #dates와 유사한 메서드                 |
| #temporals   | 자바 8 날짜 서식 지원 메서드                                          |
| #numbers     | 숫자 객체에 대한 형식 지정 메서드                                     |
| #strings     | String 객체에 대한 메서드: contains, startsWith, 추가/추가 등         |
| #objects     | 일반 객체에 대한 메서드                                               |
| #bools       | boolean evaluation에 대한 메서드                                      |
| #arrays      | 배열에 대한 메서드                                                    |
| #lists       | 리스트에 대한 메서드                                                  |
| #sets        | 세트에 대한 메서드                                                    |
| #maps        | 맵에 대한 메서드                                                      |
| #aggregates  | 배열이나 컬렉션에서 집계를 생성하는 메서드                            |
| #ids         | 반복될 수 있는 id 속성 처리를 위한 메서드                             |

[공식 문서 보기](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html#appendix-b-expression-utility-objects)

<br />

## ${...}

서버 측의 값을 참조하고 해당 값을 HTML에 삽입하는 데 사용된다.

1. controller에서 model.addAttribute() 함수를 사용하여 모델에 데이터(name)를 추가한다.

```java
@GetMapping
public String items(Model model) {
    String name = "Hong Gildong";
    model.addAttribute("name", name);
    return "form";
}
```

2. view(html)에서 모델의 데이터를 사용한다.

```html
<p>Welcome, <span th:text="${name}"></span>!</p>
```

<br />

## #{...}

1. src/main/resources 폴더 아래에 messages.properties 파일을 생성한다.
2. 다음처럼 메시지를 입력한다.

```
home.message=Welcome to our website!
```

3. html 코드에서 다음을 입력하면 메시지가 나타난다.

```html
<p th:text="#{home.message}"></p>
```

4. 만약, 지역에 따라 언어를 다르게 나타내고 싶다면 파일 이름으로 지역을 구분한 후, 메시지를 다르게 입력한다.

   | 파일 이름              | 언어        |
   | ---------------------- | ----------- |
   | messages.properties    | 기본 메시지 |
   | messages_ko.properties | 한국어      |
   | messages_fr.properties | 프랑스어    |
   | messages_es.properties | 스페인어    |

5. 메시지 안에 변수를 설정하고 싶으면 다음과 같이 변경하면 된다.

```
# message.properties
home.message=Welcome to our website, {0}!
```

```html
<!-- html 파일 -->
<p th:text="#{home.message(${session.user.name})}"></p>
```

<br />

## \*{...}

th:object를 사용하여 선택된 객체에 대해서 표현식을 사용할 수 있다.

```html
<div th:object="${session.user}">
  <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
  <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
  <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
</div>
```

위의 사용식은 아래의 표현식과 같다.

```html
<div>
  <p>Name: <span th:text="${session.user.firstName}">Sebastian</span>.</p>
  <p>Surname: <span th:text="${session.user.lastName}">Pepper</span>.</p>
  <p>Nationality: <span th:text="${session.user.nationality}">Saturn</span>.</p>
</div>
```

<br />

## @{...}

URL 링크를 표현할 때 사용하는 표현식이다.

```html
<!-- /order/details?orderId=3 -->
<a th:href="@{/order/details(orderId=${o.id})}">view</a>

<!-- /order/3/details -->
<a th:href="@{/order/{orderId}/details(orderId=${o.id})}">view</a>
```

<br />

## ~{...}

fragment을 표현할 때 사용하는 표현식이다.

해당 표현식과 관련된 내용은 다음의 링크에서 확인할 수 있다.

[타임리프 Layout, Fragment 적용하기](https://heejinee3.tistory.com/42)

<br />

## 텍스트 연산

변수 값이 포함된 문자열의 형식을 쉽게 지정할 수 있다.

```html
<span th:text="|Welcome to our application, ${user.name}!|"></span>

<span th:text="'Welcome to our application, ' + ${user.name} + '!'"></span>
```

<br />

## 그외 연산

산술, 논리, 비교 연산은 다음과 같이 표현하면 된다.

```html
<!-- Thymeleaf Standard Expression engine으로 실행 -->
<div th:with="isEven=(${prodStat.count} % 2 == 0)"></div>

<!-- OGNL으로 실행 -->
<div th:with="isEven=${prodStat.count % 2 == 0}"></div>
```

<p></p>

삼항 연산자는 다음과 같이 표현하면 된다.

```html
<tr th:class="${row.even}? 'even' : 'odd'"></tr>
```

<p></p>

연산을 하지 않는다는 의미로 \_ 표현을 쓸 수 있다.

```html
<span th:text="${user.name} ?: _">no user authenticated</span>
```

<br />

## th:attr / th:<속성>

속성 값을 설정할 때, th:attr을 사용할 수 있다.

```html
<img
  src="../../images/gtvglogo.png"
  th:attr="src=@{/images/gtvglogo.png},title=#{logo},alt=#{logo}"
/>
```

위의 사용식은 아래의 표현식과 같다.

```html
<img
  src="/gtgv/images/gtvglogo.png"
  title="Logo de Good Thymes"
  alt="Logo de Good Thymes"
/>
```

<p></p>

이 외로 특성 속성 값을 설정할 때, 다음과 같이 사용할 수 있다.

```html
<input type="submit" value="Subscribe!" th:value="#{subscribe.submit}" />
```

이와 같은 속성은 다음 표에 나타나있다.

<details>
  <summary>속성 종류 보기</summary>
<table>
  <tr>
    <th colspan="3">Specific Attributes</th>
  </tr>
  <tr>
    <td>th:abbr</td>
    <td>th:accept</td>
    <td>th:accept-charset</td>
  </tr>
  <tr>
    <td>th:accesskey</td>
    <td>th:action</td>
    <td>th:align</td>
  </tr>
  <tr>
    <td>th:alt</td>
    <td>th:archive</td>
    <td>th:audio</td>
  </tr>
  <tr>
    <td>th:autocomplete</td>
    <td>th:axis</td>
    <td>th:background</td>
  </tr>
  <tr>
    <td>th:bgcolor</td>
    <td>th:border</td>
    <td>th:cellpadding</td>
  </tr>
  <tr>
    <td>th:cellspacing</td>
    <td>th:challenge</td>
    <td>th:charset</td>
  </tr>
  <tr>
    <td>th:cite</td>
    <td>th:class</td>
    <td>th:classid</td>
  </tr>
  <tr>
    <td>th:codebase</td>
    <td>th:codetype</td>
    <td>th:cols</td>
  </tr>
  <tr>
    <td>th:colspan</td>
    <td>th:compact</td>
    <td>th:content</td>
  </tr>
  <tr>
    <td>th:contenteditable</td>
    <td>th:contextmenu</td>
    <td>th:data</td>
  </tr>
  <tr>
    <td>th:datetime</td>
    <td>th:dir</td>
    <td>th:draggable</td>
  </tr>
  <tr>
    <td>th:dropzone</td>
    <td>th:enctype</td>
    <td>th:for</td>
  </tr>
  <tr>
    <td>th:form</td>
    <td>th:formaction</td>
    <td>th:formenctype</td>
  </tr>
  <tr>
    <td>th:formmethod</td>
    <td>th:formtarget</td>
    <td>th:fragment</td>
  </tr>
  <tr>
    <td>th:frame</td>
    <td>th:frameborder</td>
    <td>th:headers</td>
  </tr>
  <tr>
    <td>th:height</td>
    <td>th:high</td>
    <td>th:href</td>
  </tr>
  <tr>
    <td>th:hreflang</td>
    <td>th:hspace</td>
    <td>th:http-equiv</td>
  </tr>
  <tr>
    <td>th:icon</td>
    <td>th:id</td>
    <td>th:inline</td>
  </tr>
  <tr>
    <td>th:keytype</td>
    <td>th:kind</td>
    <td>th:label</td>
  </tr>
  <tr>
    <td>th:lang</td>
    <td>th:list</td>
    <td>th:longdesc</td>
  </tr>
  <tr>
    <td>th:low</td>
    <td>th:manifest</td>
    <td>th:marginheight</td>
  </tr>
  <tr>
    <td>th:marginwidth</td>
    <td>th:max</td>
    <td>th:maxlength</td>
  </tr>
  <tr>
    <td>th:media</td>
    <td>th:method</td>
    <td>th:min</td>
  </tr>
  <tr>
    <td>th:name</td>
    <td>th:onabort</td>
    <td>th:onafterprint</td>
  </tr>
  <tr>
    <td>th:onbeforeprint</td>
    <td>th:onbeforeunload</td>
    <td>th:onblur</td>
  </tr>
  <tr>
    <td>th:oncanplay</td>
    <td>th:oncanplaythrough</td>
    <td>th:onchange</td>
  </tr>
  <tr>
    <td>th:onclick</td>
    <td>th:oncontextmenu</td>
    <td>th:ondblclick</td>
  </tr>
  <tr>
    <td>th:ondrag</td>
    <td>th:ondragend</td>
    <td>th:ondragenter</td>
  </tr>
  <tr>
    <td>th:ondragleave</td>
    <td>th:ondragover</td>
    <td>th:ondragstart</td>
  </tr>
  <tr>
    <td>th:ondrop</td>
    <td>th:ondurationchange</td>
    <td>th:onemptied</td>
  </tr>
  <tr>
    <td>th:onended</td>
    <td>th:onerror</td>
    <td>th:onfocus</td>
  </tr>
  <tr>
    <td>th:onformchange</td>
    <td>th:onforminput</td>
    <td>th:onhashchange</td>
  </tr>
  <tr>
    <td>th:oninput</td>
    <td>th:oninvalid</td>
    <td>th:onkeydown</td>
  </tr>
  <tr>
    <td>th:onkeypress</td>
    <td>th:onkeyup</td>
    <td>th:onload</td>
  </tr>
  <tr>
    <td>th:onloadeddata</td>
    <td>th:onloadedmetadata</td>
    <td>th:onloadstart</td>
  </tr>
  <tr>
    <td>th:onmessage</td>
    <td>th:onmousedown</td>
    <td>th:onmousemove</td>
  </tr>
  <tr>
    <td>th:onmouseout</td>
    <td>th:onmouseover</td>
    <td>th:onmouseup</td>
  </tr>
  <tr>
    <td>th:onmousewheel</td>
    <td>th:onoffline</td>
    <td>th:ononline</td>
  </tr>
  <tr>
    <td>th:onpause</td>
    <td>th:onplay</td>
    <td>th:onplaying</td>
  </tr>
  <tr>
    <td>th:onpopstate</td>
    <td>th:onprogress</td>
    <td>th:onratechange</td>
  </tr>
  <tr>
    <td>th:onreadystatechange</td>
    <td>th:onredo</td>
    <td>th:onreset</td>
  </tr>
  <tr>
    <td>th:onresize</td>
    <td>th:onscroll</td>
    <td>th:onseeked</td>
  </tr>
  <tr>
    <td>th:onseeking</td>
    <td>th:onselect</td>
    <td>th:onshow</td>
  </tr>
  <tr>
    <td>th:onstalled</td>
    <td>th:onstorage</td>
    <td>th:onsubmit</td>
  </tr>
  <tr>
    <td>th:onsuspend</td>
    <td>th:ontimeupdate</td>
    <td>th:onundo</td>
  </tr>
  <tr>
    <td>th:onunload</td>
    <td>th:onvolumechange</td>
    <td>th:onwaiting</td>
  </tr>
  <tr>
    <td>th:optimum</td>
    <td>th:pattern</td>
    <td>th:placeholder</td>
  </tr>
  <tr>
    <td>th:poster</td>
    <td>th:preload</td>
    <td>th:radiogroup</td>
  </tr>
  <tr>
    <td>th:rel</td>
    <td>th:rev</td>
    <td>th:rows</td>
  </tr>
  <tr>
    <td>th:rowspan</td>
    <td>th:rules</td>
    <td>th:sandbox</td>
  </tr>
  <tr>
    <td>th:scheme</td>
    <td>th:scope</td>
    <td>th:scrolling</td>
  </tr>
  <tr>
    <td>th:size</td>
    <td>th:sizes</td>
    <td>th:span</td>
  </tr>
  <tr>
    <td>th:spellcheck</td>
    <td>th:src</td>
    <td>th:srclang</td>
  </tr>
  <tr>
    <td>th:standby</td>
    <td>th:start</td>
    <td>th:step</td>
  </tr>
  <tr>
    <td>th:style</td>
    <td>th:summary</td>
    <td>th:tabindex</td>
  </tr>
  <tr>
    <td>th:target</td>
    <td>th:title</td>
    <td>th:type</td>
  </tr>
  <tr>
    <td>th:usemap</td>
    <td>th:value</td>
    <td>th:valuetype</td>
  </tr>
  <tr>
    <td>th:vspace</td>
    <td>th:width</td>
    <td>th:wrap</td>
  </tr>
  <tr>
    <td>th:xmlbase</td>
    <td>th:xmllang</td>
    <td>th:xmlspace</td>
  </tr>
</table>

<table>
  <tr>
    <th colspan="3">Boolean Attributes</th>
  </tr>
  <tr>
    <td>th:async</td>
    <td>th:autofocus</td>
    <td>th:autoplay</td>
  </tr>
  <tr>
    <td>th:checked</td>
    <td>th:controls</td>
    <td>th:declare</td>
  </tr>
  <tr>
    <td>th:default</td>
    <td>th:defer</td>
    <td>th:disabled</td>
  </tr>
  <tr>
    <td>th:formnovalidate</td>
    <td>th:hidden</td>
    <td>th:ismap</td>
  </tr>
  <tr>
    <td>th:loop</td>
    <td>th:multiple</td>
    <td>th:novalidate</td>
  </tr>
  <tr>
    <td>th:nowrap</td>
    <td>th:open</td>
    <td>th:pubdate</td>
  </tr>
  <tr>
    <td>th:readonly</td>
    <td>th:required</td>
    <td>th:reversed</td>
  </tr>
  <tr>
    <td>th:scoped</td>
    <td>th:seamless</td>
    <td>th:selected</td>
  </tr>
</table>
</details>

<br />

## th:attrappend / th:attrprepend / th:classappend

속성 값을 추가하고 싶을 때, th:attrappend, th:attrprepend을 이용하면 된다.

```html
<input
  type="button"
  value="Do it!"
  class="btn"
  th:attrappend="class=${' ' + cssStyle}"
/>
```

```html
<input
  type="button"
  value="Do it!"
  class="btn"
  th:attrprepend="class=${cssStyle + ' '}"
/>
```

<p></p>

특별히, class을 추가하고 싶을 때는 th:classappend을 이용하면 된다.

```html
<tr
  th:each="prod : ${prods}"
  class="row"
  th:classappend="${prodStat.odd}? 'odd'"
></tr>
```

<br />

## th:each

반복문을 사용하고 싶을 때, th:each을 사용하면 된다.

```html
<table>
  <tr>
    <th>NAME</th>
    <th>PRICE</th>
    <th>IN STOCK</th>
  </tr>
  <tr th:each="prod,iterStat : ${prods}" th:class="${iterStat.odd}? 'odd'">
    <td th:text="${prod.name}">Onions</td>
    <td th:text="${prod.price}">2.41</td>
    <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
  </tr>
</table>
```

다음의 표처럼 반복 상태 값을 얻을 수도 있다.

| 속성     | 설명                               |
| -------- | ---------------------------------- |
| index    | 0부터 시작하는 현재 반복 인덱스    |
| count    | 1부터 시작하는 현재 반복 인덱스    |
| size     | 반복되는 변수의 총 요소 수         |
| current  | 각 반복마다의 iter 변수            |
| even/odd | 현재 반복이 짝수인지 홀수인지 여부 |
| first    | 현재 반복이 첫 번째인지 여부       |
| last     | 현재 반복이 마지막인지 여부        |

<br />

## th:if / th:unless

th:if는 해당 표현식이 true인 경우에만 해당 HTML 요소가 렌더링된다.

```html
<a
  href="comments.html"
  th:href="@{/product/comments(prodId=${prod.id})}"
  th:if="${not #lists.isEmpty(prod.comments)}"
  >view
</a>
```

<p></p>

th:unless는 해당 표현식이 false인 경우에만 해당 HTML 요소가 렌더링된다.

```html
<a
  href="comments.html"
  th:href="@{/comments(prodId=${prod.id})}"
  th:unless="${#lists.isEmpty(prod.comments)}"
  >view
</a>
```

<br />

## th:switch / th:case

th:switch 속성의 표현식 값을 기준으로 렌더링될 HTML요소를 결정한다.

이때, th:case="\*"는 어떤 경우에도 해당되지 않을 때 렌더링 된다.

```html
<div th:switch="${user.role}">
  <p th:case="'admin'">User is an administrator</p>
  <p th:case="#{roles.manager}">User is a manager</p>
  <p th:case="*">User is some other thing</p>
</div>
```

<br />

## th:with

th:with을 사용하면 지역변수를 선언할 수 있다.

```html
<div th:with="firstPer=${persons[0]}">
  <p>
    The name of the first person is
    <span th:text="${firstPer.name}">Julius Caesar</span>.
  </p>
</div>
```

<br />

## th:block

단순한 컨테이너를 뜻한다.

속성을 실행한 후에 th:block은 사라지지만, 그 안의 내용은 사라지지 않는다.

```html
<table>
  <th:block th:each="user : ${users}">
    <tr>
      <td th:text="${user.login}">...</td>
      <td th:text="${user.name}">...</td>
    </tr>
    <tr>
      <td colspan="2" th:text="${user.address}">...</td>
    </tr>
  </th:block>
</table>
```

<br />

## th:inline

text에서 inline 기법을 사용하여 [[...]]는 th:text처럼, [(...)]는 th:utext처럼 사용할 수 있다. (th:inline="text")

```html
<p>The message is "[(${msg})]"</p>

<p>The message is "[[${msg}]]"</p>
```

<p></p>

th:inline="none"을 사용하여 [[...]] 또는 [(...)] inlining을 비활성화 할 수 있다.

```html
<p th:inline="none">A double array looks like this: [[1, 2, 3], [4, 5]]!</p>
```

<p></p>

javascript에서도 마찬가지로 inline 기법을 사용할 수 있다.

이때, 이스케이프된 형식은 [[...]], 이스케이프되지 않은 형식은 [(...)]이다.

```html
<script th:inline="javascript">
  var username = [[${session.user.name}]];
</script>
```

<p></p>

마찬가지로 css에서도 사용할 수 있다.

```html
<style th:inline="css">
  .[[${classname}]] {
    text-align: [[${align}]];
  }
</style>
```

<br />

## th:fragment / th:insert / th:replace / layout:fragment

해당 속성과 관련된 내용은 다음 링크에서 확인할 수 있다.

[타임리프 Layout, Fragment 적용하기](https://heejinee3.tistory.com/42)

<br />
<br />
<br />

[출처: Thymeleaf 공식 문서](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

<br />
