
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

    var myVar     = value; // 변수(재선언 O)
    let myLet     = value; // 변수(재선언 X)
    const myConst = value; // 상수

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

    array.push(value);                               // 마지막 요소 추가
    array.unshift(value);                            // 처음 요소  추가
    array[index] = value;                            // index 자리에 value 넣기

    array.pop();                                     // 마지막 요소 삭제
    array.shift();                                   // 처음 요소 삭제
    delete array[index];                             // index 자리 value 삭제(empty로 남아있음)

    array.splice(index, count, value1, value2, ...); // index에 count만큼 삭제하고 value넣기
    array.splice(index, count);                      // index에 count만큼 삭제

    array = array1.concat(array2, array3, ...);      // array 병합 
    
# Destructuring Assignment

    // 여러개 변수에 값 할당
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

    let array1 = [value1, value2];
    let array2 = [value3, value2];
    let array3 = [...array1, ...array2];

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    arrayE.reverse();
    arrayE.sort();
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

      
      class Person3 {
        constructor(name, age) {
          console.log("생성자 함수 자동 호출됨");
          this.name = name;
          this.age = age;
        }
        get name() {
          console.log("name값을 읽으면 자동 호출됨");
          return this._name;
        }
        set name(newValue) {
          if (newValue) {
            console.log("name에 값을 대입하면 자동호출됨");
            this._name = newValue;
          }
        }
      }

      let person3 = new Person3("이몽룡", 30);
      console.log(person3.name);
      person3.name = "변사또";

      // 상속
      class Man {
        constructor() {}
        run() {
          console.log("남자가 달린다");
        }
      }
      class Superman extends Man {
        constructor() {
          super();
        }
        // 메소드 오버라이딩: 자식 클래스에서 부모 클래스의 메소드 재정의
        run() {
          console.log("수퍼맨이 달린다.");
        }
      }
      let superman = new Superman();
      superman.run();

      let string1 = "문자열";
      let string2 = new String("문자열");
      console.log(typeof string1);
      console.log(typeof string2);

      let string3 = "Abcdef";
      // 문자열길이
      console.log(string3.length);
      // 대문자로 변경
      console.log(string3.toUpperCase());
      console.log(string3.toLowerCase());
      let char = string3.charAt(0); // 첫번째 한자
      console.log(char);

      // 문자의 인덱스 찾기
      var string4 = "java_script_programming";
      console.log(string4.indexOf("script")); // 첫번째 발생 인덱스
      console.log(string4.lastIndexOf("i")); // 마지막 발생 인덱스

      // 문자열 치환
      var replaced = string4.replace("java", "ECMA");
      console.log(replaced);
      console.log(string4); // 원본 그대로

      // 문자열 일부 가져오기
      let substr1 = string4.substring(5, 11); // 시작인덱스, 종료 인덱스 + 1
      console.log(substr1);
      let substr2 = string4.substring(5, 6); // 시작인덱스, 개수
      console.log(substr2);

      // 문자열 분리 split = > 배열로 반환
      var string5 = "사과,배,딸기,바나나,포도";
      let array = string5.split(",");
      for (let fruit of array) {
        console.log(fruit);
      }

      // 문자열 연결 + concat() 함수
      let string6 = "ECMA";
      let string7 = "Script";
      var concated = string6.concat(string7);
      console.log(concated);

      // 공백 제거: 처음과 끝 공백만 제고(가운데 공백은 제거 안함)
      let string8 = "    This is java script    ";
      console.log(string8.trim());

      // 모든 공백을 제거하는 정규식
      let fullTrimStr = string8.replace(/(\s*)/g, "");
      console.log(fullTrimStr);
      console.log(string10.charCodeAt(i));
    
    34부터
