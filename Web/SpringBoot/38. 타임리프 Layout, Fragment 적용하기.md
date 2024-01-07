<br />

## Thymeleaf, Layout 적용하기

#### Dependency 추가하기

build.gradle에 타임리프와 레이아웃 관련 dependency를 추가한다.

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect'
}
```

<p></p>

#### html에 적용하기

적용하고자 하는 html 파일에 해당 코드를 넣는다.

```html
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
></html>
```

<br />

## th:fragment

th:fragment="selector name"을 이용하여 옮기고자 하는 프래그먼트를 지정할 수 있다.

```html
<div th:fragment="copy">&copy; 2011 The Good Thymes Virtual Grocery</div>
```

<br />

## th:insert

th:insert를 사용하여 지정된 프래그먼트를 삽입할 수 있다.

이때, th:insert="~{template name :: selector name}"으로 표현하는데,

template name은 fragment를 지정한 파일의 절대 경로이고,

selector name은 fragment를 지정할 때 사용했던 이름을 뜻한다.

특히 template name은 /footer.html, footer.html, footer, /footer 등으로 나타낼 수 있다.

```html
<div th:insert="~{footer :: copy}"></div>
```

<br />

## th:replace

th:replace 사용하여 지정된 프래그먼트를 대체할 수 있다.

th:insert와 거의 유사하지만, insert의 경우 해당 태그 안에 삽입하고,

replace의 경우 해당 태그를 대체한다는 점이 다를 수 있다.

```html
<div th:replace="~{footer :: copy}"></div>
```

<br />

## layout:fragment

layout:fragment을 사용하기 위해서 먼저 레이아웃 파일과 레이아웃을 적용할 페이지 파일로 나눌 수 있다.

<hr>

#### layout 파일

레이아웃 파일은 페이지에 적용할 틀(레이아웃)을 지정한 파일이다.

레이아웃 파일을 간략히 표현하면 다음 코드처럼 적용할 수 있다.

```html
<!-- layout.html -->
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
>
  <head> </head>
  <body>
    <div layout:fragment="content"></div>
    <footer th:replace="footer :: copy"></footer>
  </body>
</html>
```

위 코드를 보면, th:replace을 사용하여 fragement를 적용할 수도 있다.

또한, 해당 레이아웃에서 콘텐츠가 어디쯤에 위치할지 적용시키기 위하여 layout:fragment="content"을 사용하였다.

해당 콘텐츠 내용은 페이지 파일에서 확인할 수 있다.

<p></p>

<hr>

#### page 파일

다음은 페이지 파일이다.

페이지 파일은 페이지에 표시될 내용을 정리한 파일이다.

즉, 레이아웃 파일에서 페이지의 레이아웃와 콘텐츠의 위치를 지정했다면,

페이지 파일에서는 페이지에 들어갈 내용을 주로 다룬다고 생각하면 된다.

페이지 파일을 간략히 표현하면 다음 코드처럼 적용할 수 있다.

```html
<!-- page.html -->
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
  layout:decorate="~{ layout }"
>
  <th:block layout:fragment="content">
    <h2>안녕하세요!</h2>
  </th:block>
</html>
```

위 코드를 보면, layout:decorate="~{ layout }"을 통해 layout.html 레이아웃 파일을 적용한다는 걸 알 수 있다.

또한, layout:fragment="content" 블럭안에 콘텐츠 내용을 적용한 것을 볼 수 있다.

<p></p>

<hr>

#### 참고

먼저 두 코드를 보자.

```html
<!-- layout.html -->
<div layout:fragment="content"></div>
```

```html
<!-- page.html -->
<th:block layout:fragment="content">
  <h2>안녕하세요!</h2>
</th:block>
```

layout.html에서는 해당 레이아웃 프래그먼트가 div 태그로 감싸져있지만,

page.html에서는 th.block으로 감싸져있다.

그렇다면 실제로 렌더링을 할 경우 page.html처럼 적용된다.

이 외에도, 레이아웃 파일에 있는 내용과 페이지 파일에 있는 내용이 있을 경우

레이아웃 파일에 있는 구성을 먼저 적용한 뒤, 페이지 파일에 있는 구성이 적용된다.

<br />

## 적용 예시

```html
<!-- layout.html -->
<!DOCTYPE html>
<html
  lang="ko"
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
>
  <head>
    <th:block th:replace="fragments/head :: headFragment"></th:block>
  </head>
  <body>
    <header th:replace="fragments/header :: headerFragment"></header>
    <div layout:fragment="content"></div>
    <footer th:replace="fragments/footer :: footerFragment"></footer>
    <th:block th:replace="fragments/javascript :: jsFragment"></th:block>
    <div layout:fragment="javascript"></div>
  </body>
</html>
```

```html
<!-- index.html -->
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
  layout:decorate="~{ layout }"
>
  <head>
    <!-- <link rel="stylesheet" href="/css/basic.css" /> -->
  </head>
  <div layout:fragment="content">
    <h2>index.html 화면</h2>
  </div>
  <div layout:fragment="javascript">
    <script></script>
  </div>
</html>
```

```html
<!-- fragments/footer.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <footer th:fragment="footerFragment">
    <h2 id="footer">푸터입니다.</h2>
  </footer>
</html>
```

```html
<!-- fragments/head.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <th:block th:fragment="headFragment">
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>head.html 타이틀</title>
    <!-- <link rel="stylesheet" href="/css/header.css" /> -->
    <!-- <link rel="stylesheet" href="/css/footer.css" /> -->
  </th:block>
</html>
```

```html
<!-- fragments/header.html -->
<!DOCTYPE html>
<html
  xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
>
  <header th:fragment="headerFragment">
    <h2 id="header">헤더입니다.</h2>
  </header>
</html>
```

```html
<!-- fragments/javascript.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <th:block th:fragment="jsFragment">
    <script></script>
  </th:block>
</html>
```

<br />
<br />
<br />

[출처: Thymeleaf 공식 문서](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

<br />
