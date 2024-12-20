
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
       
# Event Method/Property

    element.onEvent = function(event) {     // event method, property 불러오는 법
    }

    let return = event.altKey;              // 이벤트가 발생할때 ALT를 눌렀는지 여부를 boolean 값으로 반환
    
    let return = event.button;              // 마우스에서 누른 버튼의 키값을 반환
    
    let return = event.charCode;            // keypress 이벤트가 발생할 때 어떤 키를 눌렀는지 유니코드 값으로 반환
    
    let return = event.keypress;            // 이벤트가 발생할 때 어떤 키를 눌렀는지 유니코드 값으로 반환
    
    let return = event.clientX;             // 이벤트가 발생한 가로 위치 반환
    
    let return = event.clientY;             // 이벤트가 발생한 세로 위치 반환
    
    let return = event.ctrlKey;             // 이벤트가 발생할 때 Ctrl를 눌렀는지 여부를 boolean 값으로 반환
    
    let return = event.pageX;               // 현재 문서 기준으로 이벤트가 발생한 가로 위치를 반환
    
    let return = event.pageY;               // 현재 문서 기준으로 이벤트가 발생한 세로위치 반환
    
    let return = event.screenX;             // 현재 화면 기준으로 이벤트가 발생한 가로길이 반환
    
    let return = event.screenY;             // 현재 화면 기준으로 이벤트가 발생한 세로길이 반환
    
    let return = event.shiftKey;            // 이벤트가 발생할 때 Shift를 눌렀는지 여부를 boolean 값으로 반환
    
    let return = event.target;              // 이벤트가 최초로 발생한 대상을 반환
    
    let return = event.timeStamp;           // 이벤트가 발생한 시간을 반환
    
    let return = event.type;                // 발생한 이벤트 이름을 반환
    
    let return = event.which;               // 키보드와 관련된 이벤트가 발생할 때 키의 유니코드 값을 반환
    
    let undefined = event.preventDefault(); // 이벤트를 취소할 수 있는 경우에 취소
 
# Print

    let undefined = alert(string);            // 알림
    
    let return = confirm(string);             // 확인, 취소
    
    let return = prompt(string, value);       // input 넣기
    
    let undefined = document.write(string);   // document에 쓰기
    
    let undefined = document.writeln(string); // document에 쓰기
    
    let undefined = console.log(string);      // console에 쓰기
            
# Window(Useful)
       
    let window = open("www.naver.com", "name", "width=100, height=400, left=100, top=100, scrollbars=yes"); /* 새로운 창 열기
                                                                                                               return값이 null이면 팝업이 차단된 경우 */
                                                                                                               
    let undefined = window.close();	                                                                        // 현재 열려 있는 창 닫기 
    
    let undefined = window.onload(function);                                                                // window 로딩이 끝나면 function 발생(이벤트)
    
# Window(Etc)

    let return = document;	                      // 브라우저 창에 표시된 웹 문서에 접근할 수 있음
    
    let return = frameElement;                    // 현재 창이 다른 요소 안에 포함되어 있으면 그 요소를 반환, 포함되어 있지 않으면 null
    
    let return = innerHeight;                     // 내용 영역의 높이
    
    let return = innerWidth;                      // 내용 영역의 너비
    
    let return = localStorage;                    // 웹 브라우저에서 데이터를 저장하는 로컬 스토리지
    
    let return = location;	                      // Window 객체의 위치 / 현재 URL
    
    let return = name;                            // 브라우저 창의 이름을 가져오거나 수정
    
    let return = outerHeight;                     // 브라우저 창의 바깥 높이
    
    let return = outerWidth;                      // 브라우저 창의 바깥 너비
    
    let return = parent;	                      // 현재 창이나 서브 프레임의 부모 프레임
    
    let return = opener;	                      // 창을 오픈한 창
    
    let return = screenX;	                      // 브라우저 창의 왼쪽 테두리가 모니터 왼쪽 테두리에서 떨어져 있는 거리
    
    let return = screenY;	                      // 브라우저 창의 위쪽 테두리가 모니터 위쪽 테두리에서 떨어져 있는 거리
    
    let return = scrollX;	                      // 스크롤했을 때 수평으로 이동하는 픽셀 수
    
    let return = scrollY;	                      // 스크롤했을 때 수직으로 이동하는 픽셀 수
    
    let return = sessionStorage;	              // 웹 브라우저에서 데이터를 저장하는 세션 스토리지
    
    let undefined = blur();                       // 창에서 포커스를 제거
    
    let undefined = focus();                      // 현재 창에 포커스를 부여
    
    let undefined = moveBy(x, y);	              // 현재 창을 지정한 크키만큼 이동
    
    let undefined = moveTo(x, y);	              // 현재 창을 지정한 좌표로 이동
    
    let undefined = postMessage(message, target); // 다른 창으로 메시지를 전달
    
    let undefined = print();                      // 현재 문서를 인쇄
    
    let undefined = resizeBy(width, height);      // 지정한 크기만큼 현재 창 크기를 조절
    
    let undefined = resizeTo(width, height);      // 동적으로 브라우저 창의 크기를 조절
    
    let undefined = scroll(x, y);	              // 문서에서 특정 위치로 스크롤
    
    let undefined = scrollBy(x, y);	              // 지정한 크기만큼씩 스크롤
    
    let undefined = scrollTo(x, y);	              // 지정한 위치까지 스크롤
    
    let undefined = setCursor(cursor);            // 현재 창의 커서를 변경
    
    let return = showModalDialog(url);            // 모달 창을 표시
    
    let undefined = sizeToContent();              // 내용에 맞체 창 크기를 맞춤
    
    let undefined = stop();                       // 로딩 중지

# Navigator
   
    let return = navigator.appCodeName;    // 브라우저 이름(코드 이름)을 문자열로 반환
    
    let return = navigator.appName;	       // 브라우저 공식 이름을 문자열로 반환
    
    let return = navigator.appVersion;     // 브라우저 버전을 문자열로 반환
    
    let return = navigator.battery;	       // 배터리 충전 상태를 알려 주는 정보가 담긴 객체를 반환
    
    let return = navigator.connection;     // 브라우저 장치의 네트워크 정보가 담긴 객체를 반환
    
    let return = navigator.cookieEnabled;  // 쿠기 정보를 무시한다면 false, 그렇지 않다면 true를 반환
    
    let return = navigator.geolocation;    // 모바일 기기를 사용한 위치 정보가 담긴 객체를 반환
    
    let return = navigator.maxTouchPoints; // 장치에서 동시에 터치 가능한 포인트가 몇 개인지 반환
    
    let return = navigator.platform;       // 브라우저 플랫폼 정보를 가지고 있는 문자열을 반환
    
    let return = navigator.userAgent;      // 현재 브라우저 정보가 있는 사용자 에이전트 문자열을 반환
    
    let return = navigator.oscpu;	       // 현재 운영체제 정보를 반환
    
    let return = navigator.language;       // 브라우저 UI의 언어 정보를 반환
    
# History
  
    let undefined = history.length;     // 현재 브라우저 창의 History 목록에 있는 항목의 개수, 즉 방문한 사이트 개수를 반환
    
    let undefined = history.back();     // History 목록에서 이전 페이지를 현재 화면에 불러옴
    
    let undefined = history.forward();  // History 목록에서 다음 페이지를 현재 화면에 불러옴
    
    let undefined = history.go(number); // History 목록에서 현재 페이지를 기준으로 상대 위치에 있는 페이지를 현재 화면에 불러옴

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
    
# Screen

    let return = screen.availHeight;                  // 화면에서 윈도우의 작업 표시줄이나 맥의 메뉴/독 같은 UI 영역을 제외한 부분의 높이
    
    let return = screen.availWidthUI;                 // 영역을 제외한 부분의 너비
    
    let return = screen.colorDepth;                   // 화면상에서 픽셀을 렌더링할 때 사용하는 색상 수
    
    let return = screen.heightUI;                     // 영역을 포함한 화면의 높이
    
    let return = screen.orientation;                  // 화면의 현재 방향
    
    let return = screen.pixelDepth;                   // 화면상에서 픽셀을 랜더링할 때 사용하는 비트 수
    
    let return = screen.widthUI;                      // 영역을 포함한 화면의 너비
    
    let return = screen.lockOrientation(orientation); // 화면 방향을 잠금
    
    let return = screen.unlockOrientation();          // 화면 방향 잠금을 해제
  
# DOM
                
    let undefined = document.writeln(string);                                         // document에 쓰기
    
    let undefined = document.write(string);                                           // document에 쓰기(줄바꿈까지)
    
    let element = document.getElementById(id);                                        // id로 객체 선택
    
    let array = document.getElementsByClassName(class);                               // class로 객체 선택
    
    let array = document.getElementsByTagName(tag);                                   // tag로 객체 선택
    
    let element = document.querySelector(selector);                                   // css로 객체 선택(한개)
    
    let array = document.querySelectorAll(selector);                                  // css로 객체 선택(여러개)
    
    let string = element.innerHTML;                                                   // 안의 텍스트 선택(HTML로)
    
    let string = element.innerText;                                                   // 안의 텍스트 선택(Text로)
    
    let value = element.getAttribute(name);                                           // attrubute 얻기(element.name 이용 가능)
    
    let undefined = element.setAttribute(name, value);                                // attrubute 세팅하기 (element.name 이용 가능)
    
    let value = element.style.attribute;                                              // 스타일 속성
    
    let boolean = element.classList.contains(class);                                  // class가 포함되어있는지 확인
    
    let undefined = element.classList.remove(class);                                  // class 삭제
    
    let undefined = element.classList.add(class);                                     // class 등록
    
    element.onEvent = function;                                                       // event handler 정의
    
    element.addEventListener("Event", function);                                      // event handler 정의
    
    let node = document.createElement(tag);                                           // element node 만들기
    
    let node = document.createTextNode(string);                                       // text node 만들기
    
    let node = document.createAttribute(attribute);                                   // attribute node 만들기
    
    node.value = attribute;                                                           // attibute node에 속성 지정하기
    
    let undefined = parentNode.appendChild(childNode);                                // parent node의 child node 중 가장 마지막에 child node 넣기
    
    let undefined = parentNode.insertBefore(childNode, parentNode.childNodes[index]); // parent node의 child node 중 index 앞쪽에 새로운 child node 넣기

    let undefined = parentNode.setAttributeNode(childNode);                           // parent node에 attribute node 넣기
    
    let undefined = node.parentNode.removeChild(node);                                // node 제거
