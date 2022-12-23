
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

    var myVar     = 10; // 변수
    let myLet     = 10; // 변수
    const myConst = 10; // 상수

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
    
    
    
    
         <img onmouseover="this.src='img/banana.png'" onmouseout="this.src='img/apple.png'"/>
        <a href="javascript:alert('클릭하셨어요?')"></a>
        <button onclick="Hello!"></button>

        var myVar = 10;
        let myLet = 20;
        const PI = 3.14;

        Number.Max_SAFE_INTEGER
        Number.Min_SAFE_INTEGER
        string.length

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
    
    
