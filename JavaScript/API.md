
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
    
    
