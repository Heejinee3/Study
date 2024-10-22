<br />

## 1xx (Informational)

요청이 수신되어 처리중

<br />

## 2XX (Successful)

요청 정상 처리

<p></p>

<table>
    <thead>
        <tr>
            <th>상태 코드</th>
            <th>상태 메시지</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>200</td>
            <td>OK</td>
            <td><p>요청 성공</p></td>
        </tr>
        <tr>
            <td>201</td>
            <td>Created</td>
            <td><p>요청 성공해서 새로운 리소스가 생성됨</p></td>
        </tr>
        <tr>
            <td>202</td>
            <td>Accepted</td>
            <td>
                <p>요청이 접수되었으나 처리가 완료되지 않았음</p>
                <p>배치 처리 같은 곳에서 사용</p>
            </td>
        </tr>
        <tr>
            <td>204</td>
            <td>No Content</td>
            <td><p>서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음</p></td>
        </tr>
    </tbody>
</table>

<br />

## 3xx (Redirection)

요청을 완료하려면 추가 행동이 필요

웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동

<p></p>

<table>
    <thead>
        <tr>
            <th>상태 코드</th>
            <th>상태 메시지</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>300</td>
            <td>Multiple Choices</td>
            <td><p>안 씀</p></td>
        </tr>
        <tr>
            <td>301</td>
            <td>Moved Permanently</td>
            <td>
                <p>리소스의 URI가 영구적으로 이동</p>
                <p>리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음</p>
            </td>
        </tr>
        <tr>
            <td>302</td>
            <td>Found</td>
            <td>
                <p>리소스의 URI가 일시적으로 변경</p>
                <p>리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음</p>
            </td>
        </tr>
        <tr>
            <td>303</td>
            <td>See Other</td>
            <td>
                <p>리소스의 URI가 일시적으로 변경</p>
                <p>리다이렉트시 요청 메서드가 GET으로 변경</p>
            </td>
        </tr>
        <tr>
            <td>304</td>
            <td>Not Modified</td>
            <td>
                <p>클라이언트에게 리소스가 수정되지 않았음을 알려줌</p>
                <p>클라이언트의 로컬 PC에 저장된 캐시를 재사용</p>
                <p>응답에 메시지 바디를 포함하면 안됨</p>
                <p>조건부 GET, HEAD 요청시 사용</p>
            </td>
        </tr>
        <tr>
            <td>307</td>
            <td>Temporary Redirect</td>
            <td>
                <p>리소스의 URI가 일시적으로 변경</p>
                <p>리다이렉트시 요청 메서드와 본문 유지</p>
            </td>
        </tr>
        <tr>
            <td>308</td>
            <td>Permanent Redirect</td>
            <td>
                <p>리소스의 URI가 영구적으로 이동</p>
                <p>리다이렉트시 요청 메서드와 본문 유지</p>
            </td>
        </tr>
    </tbody>
</table>

<br />

## 4xx (Client Error)

클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음

<p></p>

<table>
    <thead>
        <tr>
            <th>상태 코드</th>
            <th>상태 메시지</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>400</td>
            <td>Bad Request</td>
            <td><p>클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음</p></td>
        </tr>
        <tr>
            <td>401</td>
            <td>Unauthorized</td>
            <td>
                <p>클라이언트가 해당 리소스에 대한 인증이 필요함</p>
                <p>응답에 WWW-Authenticate 헤더와 함께 인증 방법을 설명</p>
                <p>참고</p>
                <p>인증 (Authentication): 본인이 누구인지 확인</p>
                <p>인가 (Authorization): 권한 부여</p>
                <p>오류 메시지가 Unauthorized 이지만 인증 되지 않음 (이름이 헷갈릴 수 있음)</p>
            </td>
        </tr>
        <tr>
            <td>403</td>
            <td>Forbidden</td>
            <td>
                <p>서버가 요청을 이해했지만 승인을 거부함</p>
                <p>주로 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우</p>
            </td>
        </tr>
        <tr>
            <td>404</td>
            <td>Not Found</td>
            <td><p>요청 리소스를 찾을 수 없음</p></td>
        </tr>
    </tbody>
</table>

<br />

## 5xx (Server Error)

서버 오류, 서버가 정상 요청을 처리하지 못함

<p></p>

<table>
    <thead>
        <tr>
            <th>상태 코드</th>
            <th>상태 메시지</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>500</td>
            <td>Internal Server Error</td>
            <td><p>서버 문제로 오류 발생</p></td>
        </tr>
        <tr>
            <td>503</td>
            <td>Service Unavailable</td>
            <td>
                <p>서비스 이용 불가</p>
                <p>서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음</p>
                <p>Retry-After 헤더 필드로 얼마 뒤에 복구되는지 보낼 수도 있음</p>
            </td>
        </tr>
    </tbody>
</table>

<br />
<br />
<br />

[출처: 김영한, 「모든 개발자를 위한 HTTP 웹 기본 지식」, 인프런](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

<br />
