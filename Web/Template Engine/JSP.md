<br />

## JSP 관련 dependency 추가하기

build.gradle에 dependency를 추가한다.

```
dependencies {
	...
	implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
	implementation 'jakarta.servlet:jakarta.servlet-api'
	implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api'
	implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl'
	...
}
```

<br />

## Scriptlet

> <% %>
>
> Java 코드를 실행하는 데 사용된다.

```xml
<body>
    <% System.out.println("Hello!");%>
</body>
```

<br />

## Declaration

> <%! %>
>
> 멤버 변수 또는 메서드를 선언하는 데 사용된다.

```xml
<body>
    <%! String message = "Hello, JSP!"; %>
</body>
```

<br />

## Expession

> <%= %>
>
> Java 코드의 결과를 출력하는 데 사용된다.

```xml
<body>
    <%= message %>
</body>
```

<br />

## Directive

| 태그               | 설명                                                                                                                     |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| <%@ page ... %>    | JSP 페이지에 대한 속성을 지정한다. 언어, 콘텐츠 타입, 인코딩 등을 설정할 수 있다.                                        |
| <%@ include ... %> | 다른 페이지를 현재 페이지에 포함시킨다. 해당 위치에 다른 페이지의 내용이 삽입된다.                                       |
| <%@ taglib ... %>  | 커스텀 태그 라이브러리를 JSP 페이지에 추가하고 사용하기 위해 선언된다. 태그 라이브러리의 URI와 태그 프리픽스를 정의한다. |

<br />

## JSP Action

| 태그                | 설명                                                                                                     |
| ------------------- | -------------------------------------------------------------------------------------------------------- |
| `<jsp:include>`     | 다른 페이지를 현재 페이지에 동적으로 포함시킨다.                                                         |
| `<jsp:useBean>`     | JavaBean을 사용하도록 지정하고, 필요할 경우 생성한다.                                                    |
| `<jsp:setProperty>` | JavaBean에 값을 설정한다.                                                                                |
| `<jsp:getProperty>` | JavaBean으로부터 값을 가져온다.                                                                          |
| `<jsp:forward>`     | 현재 요청을 다른 리소스(페이지 또는 서블릿)로 전달한다.                                                  |
| `<jsp:plugin>`      | 브라우저 플러그인을 삽입하기 위한 태그로, 오래된 방식의 기능이므로 현대 웹 개발에서는 사용이 줄어들었다. |
| `<jsp:element>`     | XML 요소를 생성한다.                                                                                     |
| `<jsp:attribute>`   | XML 요소의 속성을 정의한다.                                                                              |
| `<jsp:body>`        | 커스텀 태그의 내용을 정의한다.                                                                           |
| `<jsp:text>`        | 태그 본문에 포함된 텍스트를 정의한다.                                                                    |

<br />

## JSP 내장 객체

| 내장 객체   | 위치                                   | 설명                                                                                                   |
| ----------- | -------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| request     | javax.servlet.http.HttpServletRequest  | 클라이언트에서 서버로의 HTTP 요청을 나타냄                                                             |
| response    | javax.servlet.http.HttpServletResponse | 서버에서 클라이언트로의 HTTP 응답을 나타냄                                                             |
| session     | javax.servlet.http.HttpSession         | 웹 애플리케이션에서 사용자 세션을 나타냄                                                               |
| application | javax.servlet.ServletContext           | 전체 웹 애플리케이션을 나타내며, 구성 및 환경 정보를 제공                                              |
| config      | javax.servlet.ServletConfig            | 서블릿의 구성을 나타냄                                                                                 |
| out         | javax.servlet.jsp.JspWriter            | 서블릿이나 JSP에서 클라이언트의 웹 브라우저로 콘텐츠(HTML, XML 등)를 보낼 수 있는 출력 스트림을 나타냄 |
| pageContext | javax.servlet.jsp.PageContext          | JSP 페이지 실행 중에 JSP 페이지와 관련된 여러 객체와 정보에 액세스할 수 있게 함                        |

<br />

## 사용 예시

```xml
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <body>
        <table>
        <thead>
            <th>id</th>
            <th>username</th>
            <th>age</th>
        </thead>
        <tbody>
            <%
                for (Member member : members) {
                    out.write(" <tr>");
                    out.write(" <td>" + member.getId() + "</td>");
                    out.write(" <td>" + member.getUsername() + "</td>");
                    out.write(" <td>" + member.getAge() + "</td>");
                    out.write(" </tr>");
                }
            %>
        </tbody>
        </table>
    </body>
</html>
```

<br />
<br />
<br />

[출처: 김영한, 「스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술」, 인프런](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1)

<br />
