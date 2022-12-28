
# Type

    let undefined;             
    let number   = 10;            
    let string   = "string";        
    let boolean  = true;            
    let object   = [10, 20, 30];    
    let object   = {key: "value"}; 
    let function = function(param) {console.log(param);};
    let function = (param) => {console.log(param);};
    
# Variable/Constant

    var myVar     = value; // 변수(재선언 O, 호이스팅 O, 함수 scope)
    let myLet     = value; // 변수(재선언 X, 호이스팅 X, 블록 scope)
    const myConst = value; // 상수(재선언 X, 호이스팅 X, 블록 scope)

# If/Switch

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

# For/While/Do-while

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
    
# Function
  
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
       
# Array

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
    
# Destructuring Assignment

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
    
# Class

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
    
# Inheritance

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
  
# String

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

# Date

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

    let number = date.getFullYear();	                                   // 연도(0000-)
    
    let number = date.getMonth();	                                           // 월(0-11)
    
    let number = date.getDate();	                                           // 일(1-31)
    
    let number = date.getDay();	                                           // 요일(0-6)
    
    let number = date.getHours();	                                           // 시간(0-23)
    
    let number = date.getMinutes();	                                           // 분(0-59)
    
    let number = date.getSeconds();	                                           // 초(0-59)
    
    let number = date.getMilliseconds();	                                   // 밀리초(0-999)
    
    let number = date.getTime();	                                           // 1970년 1월 1일 이후로의 시간을 밀리초 단위로 얻음
    
    let number = date.setFullYear(number);	                               // 연도(0000-), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setMonth(number);	                                   // 월(0-11), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setDate(number);	                                   // 일(1-31), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setDay(number);	                                   // 요일(0-6), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setHours(number);	                                   // 시간(0-23), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setMinutes(number);	                                   // 분(0-59), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setSeconds(number);	                                   // 초(0-59), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setMilliseconds(number);	                           // 밀리초(0-999), 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
    
    let number = date.setTime(number);	                                   // 1970년 1월 1일 이후로의 시간을 밀리초 단위로 세팅, 업데이트된 날짜와 1970년 1월 1일 사이의 시간을 밀리초 단위로 반환
                                                                               
# 
         <img onmouseover="this.src='img/banana.png'" onmouseout="this.src='img/apple.png'"/>
        <a href="javascript:alert('클릭하셨어요?')"></a>
        <button onclick="Hello!"></button>

        var myVar = 10;
        let myLet = 20;
        const PI = 3.14;

        Number.Max_SAFE_INTEGER
        Number.Min_SAFE_INTEGER
        string.length
        list.length

        alert("Hello!")
        console.log("Hello!");
        document.write("Hello!");
        prompt("이름을 입력하세요.");
        confirm("파일을 전송할까요?");
        typeof(변수);
        Number(myStr);
        parseInt(myStr);
        parseFloat(myStr);
        String(myNum2);
        Math.floor(value / 3);
        
        Math.max();


      let timer = setTimeout(() => {
        console.log("3초후 호출됨!");
      }, 3000);

      clearTimeout(timer);
      
      let interval = setInterval(() => {
        console.log(Date());
        console.log(new Date().toTimeString().split(" ")[0]);
        console.log(new Date().toISOString().split("T")[0]);
      }, 1000);

        clearInterval(interval);

              var keyValue = {
        apple: 1000,
        banana: 2000,
        pear: 3000,
      };
      console.log(keyValue["apple"]);
      console.log(keyValue.apple);

            for (var key in toy) {
        console.log("key:" + key);
        console.log("value:" + toy[key]);
      }

      // for of문: key, value를 함께 받아옴
      for (const [key, value] of Object.entries(toy)) {
        console.log("key:" + key);
        console.log("value:" + value);
      }

      


    
    34부터
