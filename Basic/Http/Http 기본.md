<br />

## URL

형식: scheme://[userinfo@]host[:port][/path][?query][#fragment]

예시: https://www.google.com:443/search?q=hello&hl=ko

<table>
    <thead>
        <tr>
            <th>구성 요소</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>scheme</td>
            <td>주로 프로토콜 사용</td>
        </tr>
        <tr>
            <td rowspan="2">userinfo</td>
            <td>URL에 사용자정보를 포함해서 인증</td>
        </tr>
        <tr>
            <td>거의 사용하지 않음</td>
        </tr>
        <tr>
            <td>host</td>
            <td>도메인명 또는 IP 주소를 직접 사용 가능</td>
        </tr>
        <tr>
            <td rowspan="2">port</td>
            <td>포트</td>
        </tr>
        <tr>
            <td>일반적으로 생략</td>
        </tr>
        <tr>
            <td>path</td>
            <td>리소스 경로</td>
        </tr>
        <tr>
            <td>query</td>
            <td>query parameter, query string</td>
        </tr>
        <tr>
            <td rowspan="2">fragment</td>
            <td>HTML 내부 북마크 등에 사용</td>
        </tr>
        <tr>
            <td>서버에 전송하는 정보 아님</td>
        </tr>
    </tbody>

</table>

<br />

## HTTP의 기반 프로토콜

| 프로토콜 | 전송 방식 | 설명                    |
| -------- | --------- | ----------------------- |
| HTTP/1.1 | TCP       | 현재 HTTP/1.1 주로 사용 |
| HTTP/2   | TCP       | HTTP/2도 점점 증가      |
| HTTP/3   | UDP       | HTTP/3도 점점 증가      |

<br />

## Stateful vs. Stateless

### Stateful

```java
고객: 이 노트북 얼마인가요?
점원: 100만원 입니다. (노트북 상태 유지)

고객: 2개 구매하겠습니다.
점원: 200만원 입니다. 신용카드, 현금중에 어떤 걸로 구매 하시겠어요? (노트북, 2개 상태 유지)

고객: 신용카드로 구매하겠습니다.
점원: 200만원 결제 완료되었습니다. (노트북, 2개, 신용카드 상태 유지)
```

- 항상 같은 서버가 유지되어야 함
- 최소한만 사용
- 예) 로그인

<p></p>

### Stateless

```java
고객: 이 노트북 얼마인가요?
점원: 100만원 입니다.

고객: 노트북 2개 구매하겠습니다.
점원: 노트북 2개는 200만원 입니다. 신용카드, 현금중에 어떤 걸로 구매 하시겠어요?

고객: 노트북 2개를 신용카드로 구매하겠습니다.
점원: 200만원 결제 완료되었습니다
```

- 아무 서버나 호출해도 됨
- 수평 확장 유리
- 예) 로그인이 필요없는 단순한 서비스 소개 화면

<br />

## Connectionless

- 요청과 응답 후 TCP/IP 연결을 종료함
- HTTP는 기본이 연결을 유지하지 않는 모델
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
- 서버 자원을 매우 효율적으로 사용할 수 있음
- TCP/IP 연결을 새로 맺어야 함 (3 way handshake 시간 추가)
- 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수 많은 자원이 함께 다운로드
- 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
- HTTP/2, HTTP/3에서 더 많은 최적화

<p></p>

<div style="display: flex; gap: 10px;">
<div style="flex: 1;">
Persistent Connections 적용 X

![alt text](./Figure/Figure1.png)

</div>
<div style="flex: 1;">
Persistent Connections 적용 O

![alt text](./Figure/Figure2.png)

</div>
</div>

<br />

## HTTP 메시지 구조

메시지 구조

![alt text](./Figure/Figure3.png)

<div style="display: flex; gap: 10px;">
<div style="flex: 1">
요청

![alt text](./Figure/Figure4.png)

</div>
<div style="flex: 1">
응답

![alt text](./Figure/Figure5.png)

</div>
</div>

<p></p>

<table>
    <thead>
        <tr>
            <th>구성 요소</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>start line (request)</td>
            <td>method SP request-target SP HTTP-version CRLF</td>
        </tr>
        <tr>
            <td>start line (response)</td>
            <td>HTTP-version SP status-code SP reason-phrase CRLF</td>
        </tr>
        <tr>
            <td rowspan="3">header</td>
            <td>field-name ":" OWS field-value OWS</td>
        </tr>
        <tr>
            <td>HTTP 전송에 필요한 모든 부가정보</td>
        </tr>
        <tr>
            <td>표준 헤더 및 필요시 임의의 헤더 추가 가능</td>
        </tr>
        <tr>
            <td>message body</td>
            <td>실제 전송할 데이터</td>
        </tr>
    </tbody>
</table>

<br />
<br />
<br />

[출처: 김영한, 「모든 개발자를 위한 HTTP 웹 기본 지식」, 인프런](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

<br />
