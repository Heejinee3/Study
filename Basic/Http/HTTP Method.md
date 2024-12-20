<br />

## HTTP Method 종류

<table>
    <thead>
        <tr>
            <th>HTTP Method</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>GET</td>
            <td>
                <p>리소스 조회</p>
                <p>서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달</p>
                <p>메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않음</p>
            </td>
        </tr>
        <tr>
            <td>POST</td>
            <td>
                <p>요청 데이터 처리, 주로 등록에 사용</p>
                <p>메시지 바디를 통해 서버로 요청 데이터 전달</p>
            </td>
        </tr>
        <tr>
            <td>PUT</td>
            <td>
                <p>리소스를 완전 대체, 해당 리소스가 없으면 생성</p>
                <p>클라이언트가 리소스 위치를 알고 URI 지정</p>
            </td>
        </tr>
        <tr>
            <td>PATCH</td>
            <td><p>리소스 부분 변경</p></td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td><p>리소스 삭제</p></td>
        </tr>
    </tbody>
</table>

<br />

## HTTP Method 속성

![alt text](./Figure/Figure6.png)

<p></p>

<table>
    <thead>
        <tr>
            <th>특성</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>안전 (Safe)</td>
            <td><p>호출해도 리소스를 변경하지 않음</p></td>
        </tr>
        <tr>
            <td>멱등 (Idempotent)</td>
            <td>
                <p>f(f(x)) = f(x)</p>
                <p>한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 똑같음</p>
            </td>
        </tr>
        <tr>
            <td>캐시가능 (Cacheable)</td>
            <td>
                <p>응답 결과 리소스를 캐시해서 사용해도 되는지</p>
                <p>실제로는 GET, HEAD 정도만 캐시로 사용</p>
                <p>POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않음</p>
            </td>
        </tr>
    </tbody>
</table>

<br />

## URI 설계 개념

#### 문서 (Document)

- 단일 개념, 파일 하나, 객체 인스턴스, 데이터베이스 row
- 예) /members/100, /files/star.jpg

<p></p>

#### 컬렉션 (Collection)

- 서버가 관리하는 리소스 디렉터리
- 서버가 리소스의 URI를 생성하고 관리
- POST 기반 API 설계
- 예) /members

<p></p>

#### 스토어 (Store)

- 클라이언트가 관리하는 자원 저장소
- 클라이언트가 리소스의 URI를 알고 관리
- PUT 기반 API 설계
- 예) /files

<p></p>

#### 컨트롤러 (Controller, Control URI)

- 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
- 동사를 직접 사용
- 예) /members/{id}/delete

<br />
<br />
<br />

[출처: 김영한, 「모든 개발자를 위한 HTTP 웹 기본 지식」, 인프런](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

<br />
