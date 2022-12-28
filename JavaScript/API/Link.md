
# Event

    /* Mouse Event
       click    : 사용자가 HTML 요소를 클릭할 때 이벤트 발생
       dblclick : 사용자가 HTML 요소를 더블클릭할 때 이벤트 발생
       mousedown: 사용자가 요소 위에서 마우스 버튼을 눌렀을 때 이벤트 발생
       mousemove: 사용자가 요소 위에서 포인터를 움직일 때 이벤트 발생
       mouseover: 마우스 포인터가 요소 위로 옮겨질 때 이벤트 발생
       mouseout : 마우스 포인터가 요소를 벗어날 때 이벤트 발생
       mouseup  : 사용자가 요소 위에 높인 마우스 버튼에서 손을 뗄 때 이벤트 발생 */

    /* Keyboard Event
       keydown : 사용자가 키를 누르는 동안 이벤트 발생
       keypress: 사용자가 키를 눌렀을 때 이벤트 발생
       keyup   : 사용자가 키에서 손을 뗄 때 이벤트 발생 */
       
    /* Document Loading Event
       abort : 문서가 완전히 로딩되기 전에 불러오기를 멈췄을 때 이벤트 발생
       error : 문서가 정확히 로딩되지 않았을 때 이벤트 발생
       load  : 문서 로딩이 끝나면 이벤트 발생
       resize: 문서 화면 크기가 바뀌었을 때 이벤트 발생
       scroll: 문서 화면이 스크롤되었을 때 이벤트 발생
       unload: 문서에서 벗어날 때 이벤트 발생                             */
       
    /* Form Event
       blur  : 폼 요소에 포커스를 잃었을 때 이벤트 발생
       change: 목록이나 체크 상태 등이 변경되면 이벤트 발생
             : input, select, textarea 태그에서 사용
       focus : 폼 요소에 포커스가 놓였을 때 이벤트 발생
             : label, select, textarea, button
       reset : 폼이 리셋되었을 때 이벤트 발생
       submit: submit 버튼을 클릭했을 때 이벤트 발생       */
       
    // Event Handler
    document.querySelector(selector).onEvent = (parameter) => {
      statement;
    }; 
       
alert("string")
confirm("string")
prompt("string","value")
document.write("eee")
console.log("eee")
       
       
  

 
       
# Window(Useful)
       
    let window = open("www.naver.com", "name", "width=100, height=400, left=100, top=100, scrollbars=yes"); /* 새로운 창 열기
                                                                                                               return값이 null이면 팝업이 차단된 경우 */
                                                                                                               
    let undefined = window.close();	                                                                        // 현재 열려 있는 창 닫기 
    
    let undefined = window.onload(function);                                                                // window 로딩이 끝나면 function 발생(이벤트)
    
# Window(Etc)

    let return = document;	                      // 브라우저 창에 표시된 웹 문서에 접근할 수 있음
    
    let return = frameElement;	                  // 현재 창이 다른 요소 안에 포함되어 있으면 그 요소를 반환, 포함되어 있지 않으면 null
    
    let return = innerHeight;	                  // 내용 영역의 높이
    
    let return = innerWidth;	                  // 내용 영역의 너비
    
    let return = localStorage;	                  // 웹 브라우저에서 데이터를 저장하는 로컬 스토리지
    
    let return = location;	                      // Window 객체의 위치 / 현재 URL
    
    let return = name;	                          // 브라우저 창의 이름을 가져오거나 수정
    
    let return = outerHeight;	                  // 브라우저 창의 바깥 높이
    
    let return = outerWidth;	                  // 브라우저 창의 바깥 너비
    
    let return = parent;	                      // 현재 창이나 서브 프레임의 부모 프레임
    
    let return = screenX;	                      // 브라우저 창의 왼쪽 테두리가 모니터 왼쪽 테두리에서 떨어져 있는 거리
    
    let return = screenY;	                      // 브라우저 창의 위쪽 테두리가 모니터 위쪽 테두리에서 떨어져 있는 거리
    
    let return = scrollX;	                      // 스크롤했을 때 수평으로 이동하는 픽셀 수
    
    let return = scrollY;	                      // 스크롤했을 때 수직으로 이동하는 픽셀 수
    
    let return = sessionStorage;	              // 웹 브라우저에서 데이터를 저장하는 세션 스토리지
    
    let undefined = blur();  	                  // 창에서 포커스를 제거
    
    let undefined = focus();	                  // 현재 창에 포커스를 부여
    
    let undefined = moveBy(x, y);	              // 현재 창을 지정한 크키만큼 이동
    
    let undefined = moveTo(x, y);	              // 현재 창을 지정한 좌표로 이동
    
    let undefined = postMessage(message, target); // 다른 창으로 메시지를 전달
    
    let undefined = print();	                  // 현재 문서를 인쇄
    
    let undefined = resizeBy(width, height);	  // 지정한 크기만큼 현재 창 크기를 조절
    
    let undefined = resizeTo(width, height);	  // 동적으로 브라우저 창의 크기를 조절
    
    let undefined = scroll(x, y);	              // 문서에서 특정 위치로 스크롤
    
    let undefined = scrollBy(x, y);	              // 지정한 크기만큼씩 스크롤
    
    let undefined = scrollTo(x, y);	              // 지정한 위치까지 스크롤
    
    let undefined = setCursor(cursor);	          // 현재 창의 커서를 변
    
    let return = showModalDialog(url);	          // 모달 창을 표시
    
    let undefined = sizeToContent();	          // 내용에 맞체 창 크기를 맞춤
    
    let undefined = stop();                       // 로딩 중지

# Navigator
   
    let return = navigator.appCodeName;	   // 브라우저 이름(코드 이름)을 문자열로 반환
    
    let return = navigator.appName;	       // 브라우저 공식 이름을 문자열로 반환
    
    let return = navigator.appVersion;	   // 브라우저 버전을 문자열로 반환
    
    let return = navigator.battery;	       // 배터리 충전 상태를 알려 주는 정보가 담긴 객체를 반환
    
    let return = navigator.connection;	   // 브라우저 장치의 네트워크 정보가 담긴 객체를 반환
    
    let return = navigator.cookieEnabled;  // 쿠기 정보를 무시한다면 false, 그렇지 않다면 true를 반환
    
    let return = navigator.geolocation;	   // 모바일 기기를 사용한 위치 정보가 담긴 객체를 반환
    
    let return = navigator.maxTouchPoints; // 장치에서 동시에 터치 가능한 포인트가 몇 개인지 반환
    
    let return = navigator.platform;	   // 브라우저 플랫폼 정보를 가지고 있는 문자열을 반환
    
    let return = navigator.userAgent;	   // 현재 브라우저 정보가 있는 사용자 에이전트 문자열을 반환
    
    let return = navigator.oscpu;	       // 현재 운영체제 정보를 반환
    
    let return = navigator.language;       // 브라우저 UI의 언어 정보를 반환
    
# History
  
    let undefined = history.length;	    // 현재 브라우저 창의 History 목록에 있는 항목의 개수, 즉 방문한 사이트 개수를 반환
    
    let undefined = history.back();	    // History 목록에서 이전 페이지를 현재 화면에 불러옴
    
    let undefined = history.forward();	// History 목록에서 다음 페이지를 현재 화면에 불러옴
    
    let undefined = history.go(number);	// History 목록에서 현재 페이지를 기준으로 상대 위치에 있는 페이지를 현재 화면에 불러옵니다.

# Location

    let return = location.hash;            // URL 중 #로 시작하는 해시 부분
    let return = location.host;            // URL의 호스트 이름과 포트 번호
    let return = location.hostname;        // URL의 호스트 이름
    let return = location.href;            // 전체 URL
    let return = location.pathname;        // URL 경로
    let return = location.port;            // URL 포트 번호
    let return = location.protocol;        // http://나 ftp:// 같은 URL의 프로토콜
    let return = location.password;        // 도메인 이름 앞에 username과 password를 함께 입력해서 접속하는 URL일 경우 password 정보를 저장
    let return = location.search;          // URL 중 ?(물음표)로 시작하는 검색 내용 부분
    let return = location.username;        // 도메인 이름 앞에 username을 함께 입력해서 접속하는 사이트 URL일 경우 username 정보를 저장
    let undefined = location.assign(url);  // 현재 문서에 새 문서 주소를 할당해 새 문서를 가져옴
    let undefined = location.reload();     // 현재 문서를 다시 불러옴, 브라우저의 [새로 고침]
    let undefined = location.replace(url); // 현재 문서의 URL을 지우고 다른 URL의 문서로 교체
    let return = location.toString();      // 현재 문서의 URL을 문자열로 반환

    
# DOM
    
    document.writeln("<tr>");
    document.write("<tr>");
    
    let element = document.getElementById(id);
    let array = document.getElementsByClassName(class);
    let array = document.getElementsByTagName(tag);
    let element = document.querySelector(selector);
    let array = document.querySelectorAll(selector);
    
    let string = element.innerHTML;
    let string = element.innerText;
    let value = element.getAttribute(name); // element.name
    let undefinded = element.setAttribute(name, value);  // element.name
    let array = element.classList;
    
    let value = element.style.display;
    
    element.onEvent = function;
    element.addEventListener("Event", function);
