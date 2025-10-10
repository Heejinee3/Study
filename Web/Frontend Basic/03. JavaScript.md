<br />

## Type

```javascript
let undefined;

let number = 10;

let string = "string";

let boolean = true;

let object = [10, 20, 30];

let object = {key: "value"};

let function = function(param) {console.log(param);};

let function = (param) => {console.log(param);};
```

<br />

## Type Function

```javascript
let type = typeof(variable);     // type 반환

let number = parseInt(string);   // string -> int 형태의 number

let number = parseFloat(string); // string -> float 형태의 number

let type = Type(value);          /* type 변환
                                    Number()
                                    String()
                                    Boolean() */
```

<br />

## Variable/Constant

```javascript
var myVar = value;     // 변수(재선언 O, 호이스팅 O, 함수 scope)

let myLet = value;     // 변수(재선언 X, 호이스팅 X, 블록 scope)

const myConst = value; // 상수(재선언 X, 호이스팅 X, 블록 scope)
```

<br />

## If/Switch

```javascript
if (조건문) {
    수행문;
} else if (조건문) {
    수행문;
} else {
    수행문;
}

switch (변수) {
  case 1:
    수행문;
    break;
  case 2:
    수행문;
    break;
  default:
    수행문;
    break;
}
```

<br />

## For/While/Do-while

```javascript
for (초기화; 조건식; 증감문){
  수행문;
}

for (let index in array) {        // array의 index을 얻을 수 있음
    수행문;
}

for (let value of array) {        // array의 value을 얻을 수 있음
    수행문;
}

array.forEach(function 타입 변수); // 각 array의 value마다 function을 수행

while(조건식){
  수행문;
}

do{
  수행문;
}while(조건식);
```

<br />

## Function

```javascript
function myFunc(param) {        // 함수 선언
  수행문
  return 반환값;
}

var myFunc = function (param) { // 함수형 변수 선언 1
  수행문
  return 반환값;
};

var myFunc = (param) => {       // 함수형 변수 선언 2
  수행문
  return 반환값;
};

myFunc(param);                  // 함수 호출
```

<br />

## Array

```javascript
let array = [];
let array = [value1, value2, ...];
let array = Array();
let array = Array(length);
let array = Array(value1, value2, ...);

array[index] = value;                                        // index 자리에 value 넣기

let length = array.length;                                   // 길이

let array = array1.concat(array2, array3, ...);              // 병합

let string = array.join("string");                           // array의 요소를 구분자로 구분해 병합하여 string으로 반환

let length = array.push(value1, value2, ...);                // 마지막에 요소 추가

let length = array.unshift(value1, value2, ...);             // 처음에 요소 추가

let element = array.pop();                                   // 마지막 요소 삭제

let element = array.shift();                                 // 처음 요소 삭제

let array = array.splice(index, count, value1, value2, ...); /* index에 count만큼 삭제하고 value넣기
                                                                count가 없으면 끝까지 삭제
                                                                value는 없어도 됨
                                                                기존 array가 바뀌고 삭제된 array 반환 */

let array = array.slice(index1, index2);                     // index1부터 index2 - 1까지 slice

let array = array.sort();                                    // 기존 array, 반환 array 모두 sort

let array = array.reverse();                                 // 기존 array, 반환 array 모두 역순으로 sort

let index= array.indexOf(value);                             // 주어진 값과 첫번째로 동일한 값의 index 반환

let index= array.lastIndexOf(value);                         // 주어진 값과 마지막으로 동일한 값의 index 반환

let string = array.toString();                               // array의 요소값을 ,로 연결시켜 string으로 반환

delete array[index];                                         // index 자리 value 삭제(empty로 남아있음)

let undefined = array.forEach(function);                     // 각 element(param)에 대하여 실행문을 실행

let array = array.map(function);                             // 각 element(param)에 대하여 실행문을 실행해 반환

let array = array.filter(function);                          // 각 element(param)에 대하여 실행문을 실행해 true인 것만 반환

let var = array.reduce(function);                            // left부터 right로 reduce 함수 실행

let var = array.reduceRight(function);                       // right부터 left로 reduce 함수 실행

let boolean = array.every(function);                         // 각 element가 실행문을 실행해 모두 true이면 true 반환

let boolean = array.some(function);                          // 각 element가 실행문을 실행해 true인게 하나라도 있으면 true 반환

let value = array.find(function);                            // 실행문을 실행해 true가 나오는 첫번째 value

let index = array.findIndex(function);                       // 실행문을 실행해 true가 나오는 첫번째 value의 index

let boolean = array.includes(value);                         // array의 element 중 value가 있는지 확인

let array = array.entries();                                 // [index, value]의 key-value 형태로 array 생성
```

<br />

## Key-value

```javascript
let map = {                                     // map 초기화
  key1: value1,
  key2: value2,
  ...
};

let value = map["apple"];                       // value
let value = map.apple;

for (let key in map) {                          // key 순회
}

for (let [key, value] of Object.entries(map)) { // key, value 순회
}
```

<br />

## Destructuring Assignment

```javascript
let [var1, var2, var3] = [value1, value2, value3]; // 여러개 변수에 값 할당

let [var, ...rest] = [value1, value2, value3];     /* 여러개 변수에 값 할당
                                                      ...: 전개(spread) 연산자 */

let var1, var2;                                    // 여러개 변수에 값 할당
[(var1 = value1), (var2 = value2)];
(var1 = value1), (var2 = value2);

let object = {key1: value1, key2: value2};         /* key 이름의 변수 생성
let {key1, key2} = object;                            key 이름과 같아야 함 */

let object = {key1: value1, key2: value2};         /* 여러개 변수에 값 할당
let {key1: var1, key2: var2} = object;                var1= value1, var2= value2 */

let object1 = {key1: value1, key2: value2};        // key, value 객체 병합
let object2 = {key3: value3, key4: value4};
let object3 = {...var1, ...var2};

let array1 = [value1, value2];                     // 배열 병합
let array2 = [value3, value2];
let array3 = [...array1, ...array2];
```

<br />

## Class

```javascript
class Class {                  // class 선언
  constructor(value) {         // constructor
    this.var = value;
  }
  get var() {                  // get variable
    return this._var;
  }
  set var(value) {             // set variable
    if (value) {
      this._var = value;
    }
  }
}

let object = new Class(value); // object 생성
object.var;                    // get variable
object.var = value;            // set variable
```

<br />

## Inheritance

```javascript
class Class1 {                // 부모 클래스
  constructor() {}
  function() {
  }
}

class Class2 extends Class1 { // 자식 클래스
  constructor() {
      super();
  }
  run() {                     // 오버라이딩
  }
}
```

<br />

## String

```javascript
let string = "string";                              // 문자열 선언
let string = new String("string");

let lengh = string.length;                          // 길이

let string = string.toUpperCase();                  // 대문자로 바꾸기

let string = string.toLowerCase();                  // 소문자로 바꾸기

let char = string.charAt(index);                    // index에 있는 character 반환

let num = string.charCodeAt(index);                 // index에 있는 character의 아스키코드 반환

let index = string1.indexOf(string2, index);        /* index부터 첫번째 string2 발생 인덱스 반환
                                                        선택적 두번째 인자
                                                        regular expressions 불가능               */

let index = string1.lastIndexOf(string2, index);    /* index부터 마지막 string2 발생 인덱스 반환
                                                        선택적 두번째 인자
                                                        regular expressions 불가능               */

let index = string1.search(string2);                /* 첫번째 string2 발생 인덱스 반환
                                                        regular expressions 가능       */

let string = string1.replace(string2, string3);     // 처음 한개 치환

let string = string1.replaceAll(string2, string3);  /* 모두 치환
let string = string1.replace(/string2/gi, string3);    replace 함수 이용 */

let string = string.substring(index1, index2);      // 일부 반환(index1부터 index2 - 1까지)

let string = string.substring(index, length);       // 일부 반환(index부터 length만큼)

let array = string1.split(string2);                 // 분리

let string = string1.concat(string2);               // 연결

let string = string.trim();                         // 처음, 끝 공백 제거

let string = string.trimStart();                    // 처음 공백 제거

let string = string.trimEnd();                      // 끝 공백 제거

let string = string1.padStart(1ength, string2);     // 반환된 string이 length가 될때까지 앞쪽 pad

let string = string1.padEnd(1ength, string2);       // 반환된 string이 length가 될때까지 뒤쪽 pad

let string = string.replace(/ /g, "");              // 모든 공백 제거

let boolean = string1.startsWith(string2);          // string1이 string2로 시작하는지 확인

let boolean = string1.endsWith(string2);            // string1이 string2로 끝나는지 확인

let boolean = string1.includes(string2);            // string1이 string2를 포함하는지 확인

let array = string1.match(string2);                 // string1에서 첫번째로 string2와 매치되는 substring array 반환

let array = string1.matchAll(string2);              // string1에서 string2와 매치되는 substring array 모두 반환
```

<br />

## Date

```javascript
let date = new Date();                                                     // 현재 시간
let date = new Date("2022");                                               // YYYY
let date = new Date("2022-12");                                            // YYYY,MM
let date = new Date("2022-12-28");                                         // YYYY,MM,DD
let date = new Date("2022-12-28T10");                                      // YYYY,MM,DD,HH
let date = new Date("2022-12-28T10:36");                                   // YYYY,MM,DD,HH,MM
let date = new Date("2022-12-28T10:36:23");                                // YYYY,MM,DD,HH,MM,SS
let date = new Date("2022-12-28T10:36:23Z");                               // YYYY,MM,DD,HH,MM,SS(국제 표준시)
let date = new Date(2022,12,28,10,36,23,897);                              // YYYY,MM,DD,HH,MM,SS,SSS
let date = new Date("Wed Dec 28 2022 10:36:23 GMT+0900 (대한민국 표준시)"); // 이름 사용

let number = date.getFullYear();                                           // 연도(0000-)

let number = date.getMonth();                                              // 월(0-11)

let number = date.getDate();                                               // 일(1-31)

let number = date.getDay();                                                // 요일(0-6)

let number = date.getHours();                                              // 시간(0-23)

let number = date.getMinutes();                                            // 분(0-59)

let number = date.getSeconds();                                            // 초(0-59)

let number = date.getMilliseconds();                                       // 밀리초(0-999)

let number = date.getTime();                                               // 1970년 1월 1일 이후로의 시간을 밀리초 단위로 얻음

let number = date.setFullYear(number);                                     // 연도(0000-), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setMonth(number);                                        // 월(0-11), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setDate(number);                                         // 일(1-31), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setDay(number);                                          // 요일(0-6), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setHours(number);                                        // 시간(0-23), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setMinutes(number);                                      // 분(0-59), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setSeconds(number);                                      // 초(0-59), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setMilliseconds(number);                                 // 밀리초(0-999), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let number = date.setTime(number);                                         // 1970년 1월 1일 이후로의 시간을 밀리초 단위로 세팅, 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환

let string = date.toString();                                              // date을 string으로 변환

let string = date.toLocaleString("ko-KR", { timeZone: "UTC" });            // 지역 date을 string으로 변환
```

<br />

## Math

```javascript
let number = Math.E;                   // Euler's number

let number = Math.PI;                  // PI

let number = Math.SQRT2;               // square root of 2

let number = Math.SQRT1_2;             // square root of 1/2

let number = Math.LN2;                 // natural logarithm of 2

let number = Math.LN10;                // natural logarithm of 10

let number = Math.LOG2E;               // base 2 logarithm of E

let number = Math.LOG10E;              // base 10 logarithm of E

let number = abs(value);

let number = acos(value);

let number = acosh(value);

let number = asin(value);

let number = asinh(value);

let number = atan(value);

let number = atan2(y, x);

let number = atanh(value);

let number = cos(value);

let number = cosh(value);

let number = sin(value);

let number = sinh(value);

let number = tan(value);

let number = tanh(value);

let number = ceil(value);

let number = floor(value);

let number = round(value);

let number = max(value1, value2, ...);

let number = min(value1, value2, ...);

let number = exp(value);

let number = log(value);

let number = pow(value1, value2);

let number = sqrt(value);

let number = sign(number);

let number = random();	               // 랜덤수(0 ~ 0.999)
```

<br />

## Timer

```javascript
let timer = setTimeout(function, time);     // time(ms) 후에 울리는 타이머 설정(한번)

let undefined = clearTimeout(timer);        // 타이머 제거

let interval = setInterval(function, time); // time(ms) 후에 울리는 타이머 설정(반복)

let undefined = clearInterval(interval);    // 타이머 제거
```

<br />

## Event

```javascript
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
```

<br />
    
## Event Method/Property

```javascript
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
```
 
<br />

## Print

```javascript
let undefined = alert(string);            // 알림

let return = confirm(string);             // 확인, 취소

let return = prompt(string, value);       // input 넣기

let undefined = document.write(string);   // document에 쓰기

let undefined = document.writeln(string); // document에 쓰기

let undefined = console.log(string);      // console에 쓰기
```

<br />  

## Window
      
```javascript
let window = open("www.naver.com", "name", "width=100, height=400, left=100, top=100, scrollbars=yes"); /* 새로운 창 열기
                                                                                                            return값이 null이면 팝업이 차단된 경우 */
                                                                                                            
let undefined = window.close();	                                                                        // 현재 열려 있는 창 닫기 

let undefined = window.onload(function);                                                                // window 로딩이 끝나면 function 발생(이벤트)
```

```javascript
let return = document;                        // 브라우저 창에 표시된 웹 문서에 접근할 수 있음

let return = frameElement;                    // 현재 창이 다른 요소 안에 포함되어 있으면 그 요소를 반환, 포함되어 있지 않으면 null

let return = innerHeight;                     // 내용 영역의 높이

let return = innerWidth;                      // 내용 영역의 너비

let return = localStorage;                    // 웹 브라우저에서 데이터를 저장하는 로컬 스토리지

let return = location;                        // Window 객체의 위치 / 현재 URL

let return = name;                            // 브라우저 창의 이름을 가져오거나 수정

let return = outerHeight;                     // 브라우저 창의 바깥 높이

let return = outerWidth;                      // 브라우저 창의 바깥 너비

let return = parent;                          // 현재 창이나 서브 프레임의 부모 프레임

let return = opener;                          // 창을 오픈한 창

let return = screenX;                         // 브라우저 창의 왼쪽 테두리가 모니터 왼쪽 테두리에서 떨어져 있는 거리

let return = screenY;                         // 브라우저 창의 위쪽 테두리가 모니터 위쪽 테두리에서 떨어져 있는 거리

let return = scrollX;                         // 스크롤했을 때 수평으로 이동하는 픽셀 수

let return = scrollY;                         // 스크롤했을 때 수직으로 이동하는 픽셀 수

let return = sessionStorage;                  // 웹 브라우저에서 데이터를 저장하는 세션 스토리지

let undefined = blur();                       // 창에서 포커스를 제거

let undefined = focus();                      // 현재 창에 포커스를 부여

let undefined = moveBy(x, y);                 // 현재 창을 지정한 크키만큼 이동

let undefined = moveTo(x, y);                 // 현재 창을 지정한 좌표로 이동

let undefined = postMessage(message, target); // 다른 창으로 메시지를 전달

let undefined = print();                      // 현재 문서를 인쇄

let undefined = resizeBy(width, height);      // 지정한 크기만큼 현재 창 크기를 조절

let undefined = resizeTo(width, height);      // 동적으로 브라우저 창의 크기를 조절

let undefined = scroll(x, y);                 // 문서에서 특정 위치로 스크롤

let undefined = scrollBy(x, y);               // 지정한 크기만큼씩 스크롤

let undefined = scrollTo(x, y);               // 지정한 위치까지 스크롤

let undefined = setCursor(cursor);            // 현재 창의 커서를 변경

let return = showModalDialog(url);            // 모달 창을 표시

let undefined = sizeToContent();              // 내용에 맞체 창 크기를 맞춤

let undefined = stop();                       // 로딩 중지
```

<br />

## Navigator
   
```javascript
let return = navigator.appCodeName;    // 브라우저 이름(코드 이름)을 문자열로 반환

let return = navigator.appName;        // 브라우저 공식 이름을 문자열로 반환

let return = navigator.appVersion;     // 브라우저 버전을 문자열로 반환

let return = navigator.battery;        // 배터리 충전 상태를 알려 주는 정보가 담긴 객체를 반환

let return = navigator.connection;     // 브라우저 장치의 네트워크 정보가 담긴 객체를 반환

let return = navigator.cookieEnabled;  // 쿠기 정보를 무시한다면 false, 그렇지 않다면 true를 반환

let return = navigator.geolocation;    // 모바일 기기를 사용한 위치 정보가 담긴 객체를 반환

let return = navigator.maxTouchPoints; // 장치에서 동시에 터치 가능한 포인트가 몇 개인지 반환

let return = navigator.platform;       // 브라우저 플랫폼 정보를 가지고 있는 문자열을 반환

let return = navigator.userAgent;      // 현재 브라우저 정보가 있는 사용자 에이전트 문자열을 반환

let return = navigator.oscpu;          // 현재 운영체제 정보를 반환

let return = navigator.language;       // 브라우저 UI의 언어 정보를 반환
```

<br />

## History
  
```javascript
let undefined = history.length;     // 현재 브라우저 창의 History 목록에 있는 항목의 개수, 즉 방문한 사이트 개수를 반환

let undefined = history.back();     // History 목록에서 이전 페이지를 현재 화면에 불러옴

let undefined = history.forward();  // History 목록에서 다음 페이지를 현재 화면에 불러옴

let undefined = history.go(number); // History 목록에서 현재 페이지를 기준으로 상대 위치에 있는 페이지를 현재 화면에 불러옴
```

<br />

## Location

```javascript
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
```

<br />  

## Screen

```javascript
let return = screen.availHeight;                  // 화면에서 윈도우의 작업 표시줄이나 맥의 메뉴/독 같은 UI 영역을 제외한 부분의 높이

let return = screen.availWidthUI;                 // 영역을 제외한 부분의 너비

let return = screen.colorDepth;                   // 화면상에서 픽셀을 렌더링할 때 사용하는 색상 수

let return = screen.heightUI;                     // 영역을 포함한 화면의 높이

let return = screen.orientation;                  // 화면의 현재 방향

let return = screen.pixelDepth;                   // 화면상에서 픽셀을 랜더링할 때 사용하는 비트 수

let return = screen.widthUI;                      // 영역을 포함한 화면의 너비

let return = screen.lockOrientation(orientation); // 화면 방향을 잠금

let return = screen.unlockOrientation();          // 화면 방향 잠금을 해제
```
  
<br />

## DOM

```javascript
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
```

<br />
<br />
<br />

[출처: 고경희, 「Do it! HTML+CSS+자바스크립트 웹 표준의 정석」, 이지스퍼블리싱](http://www.easyspub.co.kr/20_Menu/BookView/421/PUB)

<br />
