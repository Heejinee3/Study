<br />

## Useful Site

| 분류        | 도구/가이드                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| ----------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Design Tool | [Sketch](https://www.sketch.com/), [Figma](https://www.figma.com/), [Adobe XD](https://helpx.adobe.com/support/xd.html)                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| Design Idea | [iOS Design Guide](https://developer.apple.com/design/human-interface-guidelines/platforms/designing-for-ios/), [Android Design Guide](https://m3.material.io/), [Mobile Patterns](https://www.simform.com/mobile-patterns/), [pttrns](https://www.pttrns.com/), [dribbble](https://dribbble.com/)                                                                                                                                                                                                                                                                            |
| Color       | [Material Design Palette](https://www.materialpalette.com/), [Color Hunt](https://colorhunt.co/), [Coolors](https://coolors.co/palettes/trending), [Gradient Editor](https://www.colorzilla.com/gradient-editor/)                                                                                                                                                                                                                                                                                                                                                             |
| Font        | [Apple Font](https://developer.apple.com/fonts/), [Google Font](https://fonts.google.com/)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| Icon        | [Icons8](https://icons8.com/), [Vecteezy](https://www.vecteezy.com/), [Iconduck](https://iconduck.com/), [Flat Icon](https://www.flaticon.com/), [Feather](https://developer.apple.com/design/human-interface-guidelines/foundations/sf-symbols), [Canva](https://developer.apple.com/design/human-interface-guidelines/foundations/sf-symbols), [Apple SF Symbols](https://developer.apple.com/design/human-interface-guidelines/foundations/sf-symbols), [Material Icons](https://fonts.google.com/icons?selected=Material+Icons), [Font Awesome](https://fontawesome.com/) |
| Test        | [Can I Use](https://caniuse.com/), [Device Resolution](yesviz.com/devices.php), [Mobile Test](http://www.responsinator.com/)                                                                                                                                                                                                                                                                                                                                                                                                                                                  |

<br />

## CSS Apply

```html
<!-- head 사이 -->
<style>
  h {
    color: red;
  }
</style>
```

```html
<!-- body 사이 -->
<h style="color: red;"></h>
```

```html
<!-- head 사이 -->
<link rel="stylesheet" href="mycss.css" />
```

<br />

## Selector

#### Unary Operator

```
*                /* universal */
tag              /* tag */
.class           /* class */
#id              /* id */
:pseudo          /* pseudo-class */
::pseudo-element /* pseudo-element */
```

#### Property

```
[property]          /* 해당 속성이 있는 요소 */
[property="value"]  /* 지정한 속성값이 있는 요소 */
[property~="value"] /* 지정한 속성값이 포함된 요소(단어별) */
[property|="value"] /* 지정한 속성값이 포함된 요소(하이픈 포함, 단어별) */
[property^="value"] /* 지정한 속성값으로 시작하는 요소 */
[property$="value"] /* 지정한 속성값으로 끝나는 요소 */
[property*="value"] /* 지정한 속성값의 일부가 일치하는 요소 */
```

#### Binary Operator

```
A     /* A의 모든 후손들에게 영향 */
A,B   /* A의 후손들, B의 후손들에게 영향 */
A B   /* A의 후손들 중 B 조건을 만족하는 사람과 그의 후손들에게 영향 */
A > B /* A의 직계들 중 B 조건을 만족하는 사람과 그의 후손들에게 영향 */
A + B /* A의 형제들 중 A 다음으로 첫번째로 B 조건을 만족하는 사람과 그의 후손들에게 영향 */
A ~ B /* A의 형제들 중 A 다음으로 B 조건을 만족하는 사람과 그의 후손들에게 영향 */
```

<br />

## Pseudo Class/Pseudo Element

#### Pseudo Class

```
:link     /* 방문하지 않은 상태 */
:visited  /* 방문한 상태 */
:hover    /* 마우스가 올려진 상태 */
:active   /* text가 마우스로 눌려진 상태 */
:enabled  /* 활성화 된 상태 */
:disabled /* 비활성화 된 상태 */
:checked  /* checkbox에서 체크된 상태 */
:focus    /* input에서 눌려진 상태 */
:target   /* a로 연결된 부분이 눌린 */
:not()    /* 부정 */
```

```
:only-child        /* 자식 요소 선택(형제가 없을 때) */
:nth-child(n)      /* 자식 요소 선택(형제 관계인 태그들 중 n번째) */
:nth-last-child(n) /* 자식 요소 선택(형제 관계인 태그들 중 마지막에서 n번째) */
:first-child       /* 자식 요소 선택(형제 관계인 태그들 중 첫번째) */
:last-child        /* 자식 요소 선택(형제 관계인 태그들 중 마지막) */
```

```
:only-of-type        /* 자식 요소 선택(형제가 없을 때) */
:nth-of-type(n)      /* 자식 요소 선택(형제 관계인 같은 태그들 중 n번째) */
:nth-last-of-type(n) /* 자식 요소 선택(형제 관계인 같은 태그들 중 마지막에서 n번째) */
:first-of-type       /* 자식 요소 선택(형제 관계인 같은 태그들 중 첫번째) */
:last-of-type        /* 자식 요소 선택(형제 관계인 같은 태그들 중 마지막) */
```

> nth-child(n), nth-last-child(n), nth-of-type(n), nth-last-of-type(n)에서
>
> 짝수번째를 선택할 때는 2n, even 사용
>
> 홀수번째를 선택할 때는 2n+1, odd 사용

#### Pseudo Element

```
::first-line   /* 첫 번째 줄을 선택 */
::first-letter /* 첫 번째 글자를 선택 */
::before       /* 특정 요소의 앞에 내용이나 스타일 추가 */
::after        /* 특정 요소의 뒤에 내용이나 스타일 추가 */
```

<br />

## Font

```css
font-size: 10px; /* Font 사이즈 */

/* em  : 부모 요소에서 지정한 글꼴의 대문자 M의 너비를 기준(1em)으로 한 후 비율값을 지정
   rem : 문서 시작 부분(root)에서 지정한 크기를 기준(1rem)으로 한 후 비율값을 지정
   ex  : 해당 글꼴의 소문자 x의 높이를 기준(1ex)으로 한 후 비율값을 지정
   px  : 모니터의 1픽셀을 기준(1px)으로 한 후 비율값을 지정
   pt  : 포인트라고 하며, 일반 문서에서 많이 사용
   %   : 부모 요소의 글자 크기를 기준으로 계산하여 지정
   vh  : 화면 높이에 비례(화면 높이가 100px일때, 1vh=1px
   vw  : 화면 너비에 비례(화면 너비가 100px일때, 1vw=1px
   vmax: 화면 너비나 높이 중 큰 값을 선택
   vmin: 화면 너비나 높이 중 작은 값을 선택 */
```

```css
font-style: normal; /* Font 스타일
                       normal : 기본
                       italic : 이탤릭체
                       oblique: 이탤릭체 */
```

```css
font-weight: normal; /* Font 굵기
                        normal : 기본
                        bold   : 굵게
                        bolder : 원래보다 더 굵게
                        lighter: 원래보다 더 가늘게
                        100~900: 가장 가늘게(100)~가장 굵게(900) */
```

```css
color: #000000; /* Text 색상
                   #000000 ~ #FFFFFF                            : 레드, 그린, 블루
                   hsl(0, 0%, 0%) ~ hsl(360, 100%, 100%)        : 색상, 채도, 명도
                   hsla(0, 0%, 0%, 0) ~ hsla(360, 100%, 100%, 1): 색상, 채도, 명도, 불투명도
                   rgb(0, 0, 0) ~ rgb(255, 255, 255)            : 레드, 그린, 블루
                   rgba(0, 0, 0, 0) ~ rgba(255, 255, 255, 1)    : 레드, 그린, 블루, 불투명도 */
```

#### Apply

```html
<style>
  @font-face {
    font-family: "Ostrich";
    src: local("Ostrich Sans"),
      url("fonts/ostrich-sans-bold.woff") format("woff"), url("fonts/ostrich-sans-bold.ttf")
        format("truetype"), url("fonts/ostrich-sans-bold.svg") format("svg");
  }
  h {
    font-family: "Ostrich", sans-serif;
  }
</style>
```

<br />

## Text

```css
text-align: start; /* Text 정렬
                      start       : 줄 시작 위치에 맞춰 정렬
                      end         : 줄 끝 위치에 맞춰 정렬
                      left        : 왼쪽에 맞춰 정렬
                      right       : 오른쪽에 맞춰 정렬
                      center      : 가운데에 맞춰 정렬
                      justify     : 양쪽에 맞춰 정렬
                      match-parent: 부모 요소를 따라 정렬 */
```

```css
vertical-align: middle; /* Text를 세로 중앙으로 보내기 */
```

```css
line-height: 10px; /* Line 높이 */
```

```css
text-decoration: none; /* Text 데코
                          none        : 아무것도 없음
                          underline   : 밑줄
                          overline    : 윗줄
                          line-through: 가운데줄 */
```

```css
text-shadow: 10px 10px 10px #ffffff; /* Text에 그림자 넣기
                                        가로, 세로, 번짐, 색상 */
```

```css
text-transform: capitalize; /* Text 대소문자 변환
                               capitalize: 첫번째 글자를 대문자로 변환
                               uppercase : 대문자로 변환
                               lowercase : 소문자로 변환
                               full-width: 전각문자(가로,세로 비율이 같은 글자)로 변환 */
```

```css
letter-spacing: 0.1em; /* 글자와 글자 사이 간격 조절 */
```

```css
word-spacing: 0.1em; /* 단어와 단어 사이 간격 조절 */
```

<br />

## List

```css
list-style-type: none; /* List 요소 앞 모양 지정
                          none                    : 없음
                          disc                    : ●
                          circle                  : ○
                          square                  : ■
                          decimal                 : 1, 2, 3, ...
                          decimal-leading-zero    : 01, 02, 03, ...
                          lower-roman             : i, ii, iii, ...
                          upper-roman             : I, II, III, ...
                          lower-alpha(lower-latin): a, b, c, ...
                          upper-alpha(upper-latin): A, B, C, ... */
```

```css
list-style-image: url("image.jpg"); /* List 요소 앞 모양 이미지 넣기 */
```

```css
list-style-position: inside; /* List 요소 앞 모양을 들여쓸 지 결정
                                inside : 안으로 들여씀
                                outside: 밖에 있음 */
```

```css
list-style: none inside; /* List type, position */
```

<br />

## Table

```css
caption-side: top; /* caption의 위치 결정
                      top   : 표 위
                      bottom: 표 아래 */
```

```css
border: 1px solid black; /* 테두리 굵기,  선 모양, 색상 */
```

```css
border-spacing: 1px 1px; /* 테두리 여백 수평 거리, 수직 거리 */
```

```css
border-collapse: separate; /* 테두리 두 줄로 둘 것인지, 아닌지 결정
                              separate: 두 줄
                              collapse: 한 줄 */
```

<br />

## Box

```css
width: 100px; /* 너비 */
```

```css
min-width: 100px; /* 최소 너비 */
```

```css
max-width: 100px; /* 최대 너비 */
```

```css
height: 100px; /* 높이 */
```

```css
min-height: 100px; /* 최소 높이 */
```

```css
max-height: 100px; /* 최대 높이 */
```

```css
box-sizing: content-box; /* Box의 너비와 높이를 어떻게 맞출건지 결정
                            content-box: content
                            border-box :content+padding+border */
```

```css
box-shadow: 10px 10px 10px 10px #ffffff inset; /* 박스에 그림자 넣기
                                                  수평 거리, 수직 거리, 흐림, 번짐, 색상, 안쪽 or 바깥쪽 결정 */
```

<br />

## Border/Padding/Margin

```css
border-style: none; /* Border 선 종류
                       none  : 없음
                       hidden: 감춤
                       solid : 실선
                       dotted: 점선
                       dashed: 줄선
                       double: 이중선
                       groove: groove 방식
                       inset : inset 방식
                       outset: outset 방식
                       ridge : ridge 방식 */
```

```css
border-width: 10px; /* Border 크기
                       10px  : 크기 지정
                       thin  : 얇음
                       medium: 보통
                       thick : 두꺼움 */
```

```css
border-color: #000000; /* Border 색상 */
```

```css
border: 1px solid red; /* Border 크기, 선 종류, 색상 */
```

```css
border-radius: 10px 10px 10px 10px; /* Border 모서리 둥글게 만들기
                                       타원 모양일 때는 '가로 반지름/세로 반지름' 넣기 */
```

```css
padding: 10px 10px 10px 10px; /* Padding 크기(위, 오른쪽, 아래, 왼쪽) */
```

```css
margin: 10px 10px 10px 10px; /* Margin 크기(위, 오른쪽, 아래, 왼쪽)
                                세로 Margin은 더 큰쪽으로 합쳐짐 */
```

<br />

## Display

```css
visibility: hidden; /* 공간이 남아있지만 안보이게 만듦 */
```

```css
overflow: hidden; /* overflow가 된 부분은 안보여지게 함 */
```

```css
display: none; /* 공간이 사라짐 */
```

```css
display: inline-block; /* inline이면서 자기 공간을 확보 */
```

```css
display: inline; /* inline이고, 자기 공간을 확보하지 못함 */
```

```css
display: block; /* blcok */
```

<br />

## Float

```css
float: none; /* float 상태로 만들기
                none : 없음
                right: 오른쪽으로 보내기
                left : 왼쪽으로 보내기 */
```

```css
clear: both; /* float 영향을 받지 않기
                right: 오른쪽
                left : 왼쪽
                both : 둘 다 */
```

<br />

## Position

```css
position: static; /* Postition 정하기
                     static  : 기본값
                     relative: 현재 요소를 기준으로 위치를 배치치
                     absolute: relative, absolute, fixed, sticky인 상위 요소를 기준으로 위치를 배치
                     fixed   : 뷰포트를 기준으로 위치를 배치 (화면 고정)
                     sticky  : 뷰포트를 기준으로 위치를 배치 (스크롤 시 고정) */
```

```css
left: 10px; /* 기준의 왼쪽을 기준으로 오른쪽으로 이동 */
```

```css
right: 10px; /* 기준의 오른쪽을 기준으로 왼쪽으로 이동 */
```

```css
top: 10px; /* 기준의 위쪽을 기준으로 아래쪽으로 이동 */
```

```css
bottom: 10px; /* 기준의 아래쪽을 기준으로 위쪽으로 이동 */
```

```css
z-index: 10; /* z index 조정 */
```

<br />

## Background

```css
background-color: #000000; /* 배경 색상 */
```

```css
background-clip: border-box; /* 배경 적용 범위 지정
                                border-box : 테두리까지 적용
                                padding-box: 패딩까지 적용
                                content-box: 콘텐츠까지 적용 */
```

```css
background-image: url("img.jpg"); /* 뒷 배경을 이미지로 채우기 */
```

```css
background-repeat: no-repeat; /* 뒷 배경의 반복 유무 정하기
                                 repeat   : 가로, 세로 반복
                                 repeat-x : 가로 반복
                                 repeat-y : 세로 반복
                                 no-repeat: 반복하지 않음 */
```

```css
background-position: 10px 10px; /* 수평 위치, 수직 위치 지정
                                   10px  : 단위
                                   10%   : 백분율

                                   첫번째 인자(가로)
                                   left  : 왼쪽
                                   center: 가운데
                                   right : 오른쪽

                                   두번째 인자(세로)
                                   center: 가운데
                                   top   : 위쪽
                                   bottom: 아래쪽 */
```

```css
background-origin: content-box; /* 이미지 적용 범위 지정
                                   content-box: 콘텐츠까지
                                   padding-box: 패딩까지
                                   border-box : 테두리까지 */
```

```css
background-attachment: fixed; /* 스크롤을 내릴때 이미지 고정 여부
                                 fixed : 고정
                                 scroll: 스크롤 */
```

```css
background: url("img.jpg") no-repeat center center scroll; /* image, repeat, position, attachment */
```

```css
background-size: 100px 100px; /* 배경의 크기 조정
                                 contain: 비율을 맞추면서 공백(여백)이 생김
                                 cover  : 비율을 맞추면서 이미지가 잘림
                                 100px  : 단위
                                 100%   : 원래 크기의 백분율
                                 auto   : 원래 이미지 크기 */
```

```css
opacity: 0.5; /* 투명도 변경 */
```

<br />

## Gradation

```css
background: linear-gradient(to right bottom, #000000, #ffffff);

/* 선형 그라데이션

   첫번째 인자(방향)
   to left      : 왼쪽으로
   to right     : 오른쪽으로
   to top       : 위쪽으로
   to bottom    : 아래쪽으로
   to right top : 오른쪽 위로
   0deg ~ 360deg: 시계 방향으로 각도만큼

   두번째 인자 ~ 마지막 인자(색상, 위치)
   #000000 20%: 색상, 위치 */
```

```css
background: repeating-linear-gradient(to right bottom, #000000, #ffffff);

/* 선형 그라데이션(반복)

   첫번째 인자(방향)
   to left      : 왼쪽으로
   to right     : 오른쪽으로
   to top       : 위쪽으로
   to bottom    : 아래쪽으로
   to right top : 오른쪽 위로
   0deg ~ 360deg: 시계 방향으로 각도만큼

   두번째 인자 ~ 마지막 인자(색상, 위치)
   #000000 20%: 색상, 위치 */
```

```css
background: radial-gradient(
  circle farthest-corner at 50% 50%,
  #000000,
  #ffffff
);

/* 원형 그라데이션

   첫번째 인자(모양)
   circle : 원형
   ellipse: 타원형

   두번째 인자(크기)
   closest-side   : 그라데이션 가장자리가 가장 가까운 요소의 측면에 닿을 때까지
   closest-corner : 그라데이션 가장자리가 가장 가까운 요소의 코너에 닿을 때까지
   farthest-side  : 그라데이션 가장자리가 가장 먼 요소의 측면에 닿을 때까지
   farthest-corner: 그라데이션 가장자리가 가장 먼 요소의 코너에 닿을 때까지

   세번째 인자(가로 위치)
   50%   : 백분율
   left  : 왼쪽
   center: 가운데
   right : 오른쪽

   네번째 인자(세로 위치)
   50%   : 백분율
   top   : 위쪽
   center: 가운데
   bottom: 아래쪽

   다섯번째 인자 ~ 마지막 인자(색상, 위치)
   #000000 20%: 색상, 위치 */
```

```css
background: repeating-radial-gradient(
  circle farthest-corner at 50% 50%,
  #000000,
  #ffffff
);

/* 원형 그라데이션(반복)

   첫번째 인자(모양)
   circle : 원형
   ellipse: 타원형

   두번째 인자(크기)
   closest-side   : 그라데이션 가장자리가 가장 가까운 요소의 측면에 닿을 때까지
   closest-corner : 그라데이션 가장자리가 가장 가까운 요소의 코너에 닿을 때까지
   farthest-side  : 그라데이션 가장자리가 가장 먼 요소의 측면에 닿을 때까지
   farthest-corner: 그라데이션 가장자리가 가장 먼 요소의 코너에 닿을 때까지

   세번째 인자(가로 위치)
   50%   : 백분율
   left  : 왼쪽
   center: 가운데
   right : 오른쪽

   네번째 인자(세로 위치)
   50%   : 백분율
   top   : 위쪽
   center: 가운데
   bottom: 아래쪽

   다섯번째 인자 ~ 마지막 인자(색상, 위치)
   #000000 20%: 색상, 위치 */
```

<br />

## Transform

```css
transform: translate(10px, 10px); /* x, y축 이동 */
```

```css
transform: translate3d(10px, 10px, 10px); /* x, y, z축 이동 */
```

```css
transform: translateX(10px); /* x축 이동 */
```

```css
transform: translateY(10px); /* y축 이동 */
```

```css
transform: translateZ(10px); /* z축 이동 */
```

```css
transform: scale(1, 1); /* x, y축 확대, 축소 */
```

```css
transform: scale3d(1, 1); /* x, y, z축 확대, 축소 */
```

```css
transform: scaleX(1); /* x축 확대, 축소 */
```

```css
transform: scaleY(1); /* y축 확대, 축소 */
```

```css
transform: scaleZ(1); /* z축 확대, 축소 */
```

```css
transform: rotate(10deg, 10deg); /* x, y축 회전 */
```

```css
transform: rotate3d(1, 1, 1, 10deg); /* x, y, z축 회전 */
```

```css
transform: rotateX(10deg); /* x축 회전 */
```

```css
transform: rotateY(10deg); /* y축 회전 */
```

```css
transform: rotateZ(10deg); /* z축 회전 */
```

```css
transform: skew(10deg, 10deg); /* x, y축 비틀기 */
```

```css
transform: skewX(10deg); /* x축 비틀기 */
```

```css
transform: skewY(10deg); /* y축 비틀기 */
```

```css
transform-origin: 10% 10%; /* pivot

                              첫번째 인자(가로 위치)
                              10%   : 백분율
                              left  : 왼쪽
                              center: 가운데
                              right : 오른쪽

                              네번째 인자(세로 위치)
                              10%   : 백분율
                              top   : 위쪽
                              center: 가운데
                              bottom: 아래쪽 */
```

```css
perspective(100px); /* 입체적으로 보일 수 있게 깊이 조정 */
```

<table>
  <tr>
    <th>축</th>
    <th>부호</th>
    <th>방향</th>
  </tr>
  <tr>
    <td rowspan="2">X</td>
    <td>+</td>
    <td>왼쪽</td>
  </tr>
  <tr>
    <td>-</td>
    <td>오른쪽</td>
  </tr>
  <tr>
    <td rowspan="2">Y</td>
    <td>+</td>
    <td>아래쪽</td>
  </tr>
  <tr>
    <td>-</td>
    <td>위쪽</td>
  </tr>
  <tr>
    <td rowspan="2">Z</td>
    <td>+</td>
    <td>화면 앞쪽</td>
  </tr>
  <tr>
    <td>-</td>
    <td>화면 뒤쪽</td>
  </tr>
</table>

<br />

## Transition

```css
transition-property: all; /* 대상 지정
                             all  : 모든 속성
                             none : 없음
                             width: 속성 이름 */
```

```css
transition-duration: 1s; /* 진행 시간
                            1s : 초
                            1ms: 밀리초 */
```

```css
transition-delay: 1s; /* 지연 시간
                         1s : 초
                         1ms: 밀리초 */
```

```css
transition-timing-function: linear; /* 속도 곡선 지정
                                       linear                  : linear
                                       ease                    : ease
                                       ease-in                 : ease-in
                                       ease-out                : ease-out
                                       ease-in-out             : ease-in-out
                                       cubic-bezier(0, 0, 0, 0): cubic-bezier.com 이용 */
```

```css
transition: all 1s 1s linear; /* property, duration, delay, timing-function */
```

<br />

## Animation

```css
animation-name: name; /* Animation name */
```

```css
animation-duration: 1s; /* 지속 시간
                           1s : 초
                           1ms: 밀리초 */
```

```css
animation-delay: 1s; /* 지연 시간
                        1s : 초
                        1ms: 밀리초 */
```

```css
animation-direction: normal; /* 진행 방향
                                normal: from에서 to로 진행
                                reverse: to에서 from으로 진행
                                alternate: 홀수번째는 normal, 짝수번째는 reverse
                                alternate-reverse: 홀수번째는 reverse, 짝수번째는 normal */
```

```css
animation-iteration-count: 1; /* 반복 횟수
                                 1: 반복 획수
                                 infinite: 무힌 반복 */
```

```css
animation-timing-function: linear; /* 속도 곡선 지정
                                      linear                  : linear
                                      ease                    : ease
                                      ease-in                 : ease-in
                                      ease-out                : ease-out
                                      ease-in-out             : ease-in-out
                                      cubic-bezier(0, 0, 0, 0): cubic-bezier.com 이용 */
```

```css
animation: name 1s linear 1s 1 normal; /* name, duration, timing-function, delay, iteration-count, direction */
```

#### Declaration

```css
@keyframes name {
  /* Animation 선언
     0%  : 백분율
     from: 처음
     to  : 끝 */
  0% {
  }
  50% {
  }
  100% {
  }
}
```

<br />

## Media Query

#### Import

```html
<!-- 외부 css 파일 연결(추천, head 사이) -->
<link rel="stylesheet" media="screen" href="mycss.css" />
```

```html
<!-- 외부 css 파일 연결(비추천, head 사이) -->
<style>
  @import url("mycss.css") only screen and (min-width: 768px) and
    (max-width: 1024px);
</style>
```

```html
<!-- 내부 직접 정의(head 사이) -->
<style media="only screen and (min-width:768px) and (max-width:1024px)"></>
```

```html
<!-- 내부 직접 정의(head 사이) -->
<style>
  @media only screen and (min-width: 768px) and (max-width: 1024px) {
  }
</style>
```

#### Apply

```css
@media [only|not] 미디어유형 [and 조건] [and 조건] ...;
```

 <table>
  <tr>
    <td>only</td> 
    <td>미디어 쿼리를 지원하지 않는 웹 브라우저에서는 미디어 쿼리를 무기하고 실행하지 않음</td> 
  </tr>
  <tr>
    <td>not</td>
    <td>not 다음에 지정하는 미디어 유형을 제외</td>   
  </tr>    
  <tr>                                
    <td>and</td>
    <td>조건을 여러개 연결해서 추가</td> 
 </tr>
</table>

| 미디어 유형 | 설명                               |
| ----------- | ---------------------------------- |
| all         | 모든 유형                          |
| print       | 인쇄 장치                          |
| screen      | 컴퓨터, 스마트폰 스크린            |
| tv          | TV                                 |
| aural       | 화면을 읽어 소리로 출력해주는 장치 |
| braille     | 점자 표시 장치                     |
| handheld    | 손에 들고 다니는 장치              |
| projection  | 프로젝터                           |
| tty         | 디스플레이 기능이 제한된 장치      |
| embossed    | 점자 프린터                        |

| 웹 문서의 너비 높이 | 설명      |
| ------------------- | --------- |
| width               | 너비      |
| height              | 높이      |
| min-width           | 최소 너비 |
| min-height          | 최소 높이 |
| max-width           | 최대 너비 |
| max-height          | 최대 높이 |

| 단말기의 너비 높이 | 설명      |
| ------------------ | --------- |
| device-width       | 너비      |
| device-height      | 높이      |
| min-device-width   | 최소 너비 |
| min-device-height  | 최소 높이 |
| max-device-width   | 최대 너비 |
| max-device-height  | 최대 높이 |

| 화면 회전   | 방향      | 설명      |
| ----------- | --------- | --------- |
| orientation | portrait  | 세로 모드 |
| orientation | landscape | 가로 모드 |

<br />

## Object Fit

```css
object-fit: none; /* 가로세로 크기 유지가 되고 가운데가 보여짐 */
```

```css
object-fit: contain; /* 가로세로 비율 유지가 되지만 여백이 생김 */
```

```css
object-fit: cover; /* 가로세로 비율 유지가 되지만 이미지가 잘림 */
```

```css
object-fit: fill; /* 가로세로 비율 유지가 안됨 */
```

```css
object-fit: scale-down; /* none 또는 contain 중에 더 적절한 방향으로 사이즈를 조절 */
```

<br />

## Flex

```css
display: flex; /* container 지정
                  flex       : flex
                  inline-flex: inline-flex */
```

```css
flex-direction: row; /* 주축 설정
                        row           : 오른 방향
                        row-reverse   : 왼 방향
                        column        : 아래 방향
                        column-reverse: 위 방향 */
```

```css
flex-wrap: nowrap; /* 보조축 설정
                      nowrap      : 컨테이너를 넘어가도 박스는 안넘어감
                      wrap        : 보조축이 아래 또는 오른 방향
                      wrap-reverse: 보조축이 위 또는 왼 방향 */
```

```css
flex-flow: row nowrap; /* direction, flex-wrap */
```

```css
justify-content: flex-start; /* 주축 이동
                                flex-start   : 주축의 원점으로 이동
                                flex-end     : 주축의 화살표로 이동
                                center       : 주축의 가운데로 이동
                                space-between: between 방식으로 주축을 고르게 이동
                                space-around : around 방식으로 주축을 고르게 이동
                                space-evenly : evenly 방식으로 주축을 고르게 이동 */
```

```css
align-items: flex-start; /* 한줄 보조축 이동
                            flex-start: 보조축의 원점으로 이동
                            flex-end  : 보조축의 화살표로 이동
                            center    : 보조축의 가운데로 이동
                            stretch   : 보조축 방향에 따라 길게 늘림
                            baseline  : 보조축 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
align-content: flex-start; /* 여러줄 보조축 이동
                              flex-start   : 보조축의 원점으로 이동
                              flex-end     : 보조축의 화살표로 이동
                              center       : 보조축의 가운데로 이동
                              space-between: between 방식으로 보조축을 고르게 이동
                              space-around : around 방식으로 보조축을 고르게 이동
                              stretch      : 보조축 방향에 따라 길게 늘림 */
```

```css
align-self: flex-start; /* 각 box 보조축 이동
                           flex-start: 보조축의 원점으로 이동
                           flex-end  : 보조축의 화살표로 이동
                           center    : 보조축의 가운데로 이동
                           stretch   : 보조축 방향에 따라 길게 늘림
                           baseline  : 보조축 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
flex-basis: 100px; /* content 크기
                      주축이 row일때는 width
                      column일때는 height를 바꿈
                      basis값보다 content가 크면 더 크게 바꿈 */
```

```css
flex-grow: 1; /* 늘어나는 공백 비율을 따질 수 있음
                 0: 안늘어남
                 1: 길게 늘어남 */
```

```css
flex-shrink: 1; /* 줄어드는 공백 비율을 따질 수 있음
                   0: 안늘어남
                   1: 길게 늘어남 */
```

```css
flex: 1 1 auto; /* grow shrink basis */
```

```css
order: 1; /* content의 순서 변경 */
```

```css
gap: 10px; /* content 사이의 gap 크기 */
```

<br />

## Grid

```css
display: grid; /* 그리드 지정
                  grid       : grid
                  inline-grid: inline-grid */
```

```css
grid-template-columns: 100px 100px ...; /* 열의 크기와 개수 지정
                                           100px                                : 크기
                                           1fr                                  : 상대적 크기
                                           repeat(3, 1fr)                       : 반복(n번, 길이)
                                           minmax(100px, 1fr)                   : 최소, 최대
                                           repeat(auto-fit, minmax(100px, 1fr)) : 남는 공간 없음
                                           repeat(auto-fill, minmax(100px, 1fr)): 남는 공간 있음 */
```

```css
grid-template-rows: 100px 100px ...; /* 줄의 크기와 개수 지정
                                        100px 100px ...         : 크기
                                        1fr 1fr ...             : 상대적 크기
                                        repeat(3, 1fr)          : 반복(n번, 길이)
                                        minmax(100px, 1fr)      : 최소, 최대
                                        repeat(auto-fit, 100px) : 남는 공간 없음
                                        repeat(auto-fill, 100px): 남는 공간 있음 */
```

```css
grid-column-gap: 10px; /* 열 간격 지정 */
```

```css
grid-row-gap: 10px; /* 행 간격 지정 */
```

```css
grid-gap: 10px 10px; /* 행, 열 간격 지정 */
```

```css
align-items: start; /* 한줄 row 이동
                       start   : row의 원점으로 이동
                       end     : row의 화살표로 이동
                       center  : row의 가운데로 이동
                       stretch : row 방향에 따라 길게 늘림
                       baseline: row 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
align-content: start; /* 여러줄 row 이동
                         start        : row의 원점으로 이동
                         end          : row의 화살표로 이동
                         center       : row의 가운데로 이동
                         space-between: between 방식으로 row을 고르게 이동
                         space-around : around 방식으로 row을 고르게 이동
                         stretch      : row 방향에 따라 길게 늘림 */
```

```css
align-self: start; /* 각 box row 이동
                      start   : row의 원점으로 이동
                      end     : row의 화살표로 이동
                      center  : row의 가운데로 이동
                      stretch : row 방향에 따라 길게 늘림
                      baseline: row 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
justify-items: start; /* 한줄 column 이동
                         start   : column의 원점으로 이동
                         end     : column의 화살표로 이동
                         center  : column의 가운데로 이동
                         stretch : column 방향에 따라 길게 늘림
                         baseline: column 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
justify-content: start; /* 여러줄 column 이동
                           start        : column의 원점으로 이동
                           end          : column의 화살표로 이동
                           center       : column의 가운데로 이동
                           space-between: between 방식으로 column을 고르게 이동
                           space-around : around 방식으로 column을 고르게 이동
                           stretch      : column 방향에 따라 길게 늘림 */
```

```css
justify-self: start; /* 각 box column 이동
                        start   : column의 원점으로 이동
                        end     : column의 화살표로 이동
                        center  : column의 가운데로 이동
                        stretch : column 방향에 따라 길게 늘림
                        baseline: column 방향의 텍스트 베이스라인 기준으로 정렬 */
```

```css
grid-column-start: 1; /* 열 시작 라인 번호 지정 */
```

```css
grid-column-end: 1; /* 열 끝 라인 번호 지정 */
```

```css
grid-column: 1/1; /* 열 시작/끝 라인 번호 지정 */
```

```css
grid-row-start: 1; /* 줄 시작 라인 번호 지정 */
```

```css
grid-row-end: 1; /* 줄 끝 라인 번호 지정 */
```

```css
grid-row: 1/1; /* 줄 시작/끝 라인 번호 지정 */
```

```css
grid-template-areas: "box1 box1"; /* 영역 배치 */
grid-template-areas: "box2 .";
```

```css
grid-area: box1; /* 영역 이름 */
```

<br />

## Word Break

```css
word-wrap: normal;
word-break: normal;
```

| 함수       | 설명                                                    |
| ---------- | ------------------------------------------------------- |
| word-break | 단어의 분리를 어떻게 할 것인지 결정                     |
| word-wrap  | 자기영역을 벗어난 단어의 줄바꿈을 어떻게 할 것인지 결정 |

| 언어    | 설명                 |
| ------- | -------------------- |
| CJK     | 중국어, 일본어, 한글 |
| non-CJK | 숫자, 영어, 베트남어 |

| word-break | normal(기본값) | break-all | keep-all             |
| ---------- | -------------- | --------- | -------------------- |
| non-CJK:   | 공백,하이픈(-) | 음절      | 공백,하이픈          |
| CJK :      | 음절           | 음절      | 공백,하이픈,그외기호 |

| word-wrap | normal(기본값) | break-word |
| --------- | -------------- | ---------- |
| non-CJK   | 단어넘침 O     | 단어넘침 X |
| CJK       | 단어넘침 X     | 단어넘침 X |

<br />

## Vendor Prefix

```css
background: red; /* gradient 속성을 지원하지 않는 모든 브라우저를 위한 코드 */
```

```css
background: -webkit-linear-gradient(
  red,
  yellow
); /* 크롬과 사파리 4.0 이상을 위한 코드 */
```

```css
background: -moz-linear-gradient(
  red,
  yellow
); /* 파이어폭스 3.6 이상을 위한 코드 */
```

```css
background: -ms-linear-gradient(
  red,
  yellow
); /* 익스플로러 10.0 이상을 위한 코드 */
```

```css
background: -o-linear-gradient(red, yellow); /* 오페라 10.0 이상을 위한 코드 */
```

```css
background: linear-gradient(red, yellow); /* CSS 표준 문법 코드 */
```

<br />
<br />
<br />

[출처: 고경희, 「Do it! HTML+CSS+자바스크립트 웹 표준의 정석」, 이지스퍼블리싱](http://www.easyspub.co.kr/20_Menu/BookView/421/PUB)

<br />
