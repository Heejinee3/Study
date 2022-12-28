
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
