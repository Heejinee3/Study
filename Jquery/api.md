<script src="jquery-3.6.0.js"></script>
<script src="jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>

# window.onload()

    $(document).ready(() => {
    });

    $(() => {
    });

# document.querySelectorAll()

    $("query")
    element.first();               // 가장 앞에 있는 element
    element.last();                // 가장 마지막에 있는 element
    element.add("query");          // query까지 합한 element
    element.slice(index1, index2); // index1부터 index2 - 1까지 slice한 elements
    element.not("query");          // query를 제외한 element
    element.find("query");         // query를 만족하는 자식 element
    element.eq(index);             // index 순서에 있는 element

# Query Select Loop

    element.each(function (index, item) {
        index과 item을 시용한 실행문;
    });

# element.innerText

    element.text("string"); // set
    element.text();         // get

# element.innerHTML

    element.html("string"); // set
    element.html();         // get

# element.onEvent

    element.on("Event", function); // set

# element.classList

    element.addClass("class");             // add(한개)
    element.addClass("class1 class2 ..."); // add(여러개)
    element.removeClass("class");          // remove
    element.hasClass( "class" );           // contain

# element.style.attribute

    element.css("attribute", "value"); // set
    element.css({                      // multiple set
        attribute1: value1,
        attribute2: value2,
        ...
        });
    element.css("attribute");          // get

# element.getAttribute/setAttribute

    element.attr("attribute");          // get
    element.attr("attribute", "value"); // set
    element.removeAttr("attribute");    // remove

# Get JSON File

    fetch("url")                   // fetch 이용
    .then((response) => {
        return response.json();
    })
    .then((json) => {
        for (const obj of json) {
            obj.key 이용
        }
    })
    .catch((error) => {
        console.log(error);
    });

    $.ajax({                      // ajax 이용
    dataType: "json",
    url: "url",
    mimeType: "application/json",
    success: function (json) {
        for (const obj of json) {
            obj.key 이용
        }
    },
    });

    let string = JSON.stringfy(object); // json object를 string으로 변환
    let object = JSON.parse(string);    // string을 json object로 변환
