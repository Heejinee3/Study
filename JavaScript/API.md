
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

    let string = "string";                        // 문자열 선언
    let string = new String("string");
 
    let lengh = string3.length;                   // 길이

    let string = string.toUpperCase();            // 대문자로 바꾸기
    
    let string = string.toLowerCase();            // 소문자로 바꾸기
    
    let char = string.charAt(index);              // index에 있는 character 반환

    let index = string.indexOf("find");           // 첫번째 발생 인덱스 반환
    
    let index = string.lastIndexOf("find");       // 마지막 발생 인덱스 반환

    let string = string.replace("from", "to");    // 치환

    let string = string.substring(start, end);    // 일부 반환(start index부터 end index- 1까지)
   
    let string = string.substring(start, length); // 일부 반환(start index부터 length만큼)

    let array = string.split("split");            // 분리

    let string = string1.concat(string2);         // 연결

    let string = string.trim();                   // 처음, 끝 공백 제거

    let string = string.replace(/(\s*)/g, "");    // 모든 공백 제거








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

      


    
    34부터
