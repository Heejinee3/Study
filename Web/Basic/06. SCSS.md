<br />

## Sass vs. SCSS

### Sass

들여쓰기 기반

```
$main-color: #333

body
  color: $main-color
  font-size: 16px

nav
  ul
    margin: 0
    padding: 0
  li
    list-style: none
```

<br />

### SCSS

CSS와 유사 (중괄호 `{}` + 세미콜론 `;`)

```scss
$main-color: #333;

body {
  color: $main-color;
  font-size: 16px;
}

nav {
  ul {
    margin: 0;
    padding: 0;
  }

  li {
    list-style: none;
  }
}
```

<br />

## Data Types

| 타입     | 예시                                    | 설명                           |
| -------- | --------------------------------------- | ------------------------------ |
| Number   | 100px, 1.5                              | 숫자, 단위 가능                |
| String   | "Hello", 'World'                        | 문자열                         |
| Color    | #fff, rgb(0,0,0), hsl(0,0%,0%)          | 색상값                         |
| Boolean  | true, false                             | 참/거짓                        |
| Null     | null                                    | 값 없음                        |
| List     | red, green, blue                        | 배열 형태, 쉼표/공백 구분 가능 |
| Map      | (key: value, key2: value2)              | 객체 형태, 키-값 쌍            |
| Function | @function double($n) { @return $n\*2; } | 함수                           |
| Mixin    | @mixin flex { display: flex; }          | 재사용 스타일 블록             |

<br />

## Nesting

선택자를 계층 구조로 작성할 수 있는 기능

```scss
/* SCSS */
nav {
  ul {
    margin: 0;
    padding: 0;
  }

  li {
    list-style: none;
  }

  a {
    color: blue;
  }
}
```

```css
/* CSS */
nav ul {
  margin: 0;
  padding: 0;
}

nav li {
  list-style: none;
}

nav a {
  color: blue;
}
```

<br />

`&` 기호를 사용하여 부모 선택자를 그대로 가져올 수 있음

```scss
/* SCSS */
.button {
  color: white;
  background: blue;

  &:hover {
    background: darkblue;
  }

  &.active {
    background: green;
  }
}
```

```css
/* CSS */
.button {
  color: white;
  background: blue;
}

.button:hover {
  background: darkblue;
}

.button.active {
  background: green;
}
```

<br />

## Variable

`$` 기호를 사용해서 선언

```scss
$primary-color: #3498db;
$font-size-large: 20px;
$spacing: 16px;

.button {
  background-color: $primary-color;
  font-size: $font-size-large;
  margin: $spacing;
}
```

<br />

## Operations

### Arithmetic Operations

숫자, 단위, 길이 값에 대해 `+`, `-`, `*`, `/`, `%` 연산이 가능

`/` 는 연산자로 쓰일 때만 계산되고, 단순 값일 경우는 CSS로 그대로 출력됨

```scss
$base: 16px;

.box {
  width: $base * 2; // 32px
  height: $base + 4; // 20px
  margin: $base / 2; // 8px
}
```

<br />

### Color Operations

RGB 색상끼리 더하거나 뺄 수 있음

보통은 `lighten()`, `darken()`, `mix()` 같은 SCSS 내장 함수가 더 직관적이고 많이 사용됨

```scss
$red: #ff0000;
$blue: #0000ff;

.mix {
  color: $red + $blue; // #ff00ff (magenta)
}
```

<br />

### String Operations

문자열을 `+` 연산자로 이어붙일 수 있음

```scss
$font: "Roboto";
$weight: "-Bold";

.title {
  font-family: $font + $weight; // "Roboto-Bold"
}
```

<br />

### Comparison/Logical Operations

조건문(`@if`, `@else`)에서 사용 가능

`==`, `!=`, `<`, `>`, `<=`, `>=`, `and`, `or`, `not` 지원

```scss
$size: 12px;
$color: blue;

@if ($size > 10px) and ($color == blue) {
  .box {
    border: 2px solid blue;
  }
} @else {
  .box {
    border: 2px solid gray;
  }
}
```

<br />

### List Operations

여러 값들을 리스트처럼 다룰 수 있고, 연산이나 함수에 활용 가능

```scss
$list: 10px 20px 30px;

.item {
  margin: nth($list, 2); // 20px
  padding: length($list) * 5px; // 15px (3 * 5px)
}
```

<br />

### Map Operations

Key-Value 쌍으로 저장된 자료형을 가져와 연산 가능

```scss
$colors: (
  primary: #3498db,
  danger: #e74c3c,
);

.alert {
  color: map-get($colors, danger); // #e74c3c
}
```

<br />

### Interpolation Operations

`#{}` : 보간(interpolation) 문법으로 문자열, 셀렉터, 속성명, 값 어디든 삽입 가능

```scss
$side: top;

.box {
  margin-#{$side}: 20px; // margin-top: 20px
}
```

<br />

## Minin

재사용 가능한 스타일 블록을 정의하는 기능

일종의 함수처럼 사용할 수 있어서, 중복되는 CSS를 줄이고 유지보수를 쉽게 해줌

```scss
// mixin 정의
@mixin box-style($padding, $margin) {
  padding: $padding;
  margin: $margin;
  border: 1px solid #333;
  border-radius: 8px;
}

// mixin 사용 (include)
.card {
  @include box-style(20px, 10px);
}
```

<br />

## Function

값을 반환하여 CSS 속성 값으로 바로 사용 가능

매개변수 사용 가능

Mixin과 달리 스타일 블록을 출력하지 않음

```scss
@function double($number) {
  @return $number * 2;
}

.box {
  width: double(10px); // 20px
  height: double(5px); // 10px
}
```

<br />

## Conditional Statement

`@if`, `@else if`, `@else` 을 사용하여 스타일을 동적으로 제어

```scss
$size: 15px;

.button {
  @if $size > 20px {
    font-size: 22px;
  } @else if $size > 10px {
    font-size: 18px;
  } @else {
    font-size: 14px;
  }
}
```

<br />

## Loop Statement

`@for`, `@each`, `@while` 를 사용하여 반복적으로 스타일을 생성

`@for` – 숫자 범위 반복

```scss
@for $i from 1 through 3 {
  .item-#{$i} {
    width: 20px * $i;
  }
}
```

<br />

`@each` – 리스트 반복

```scss
$colors: red, green, blue;

@each $color in $colors {
  .text-#{$color} {
    color: $color;
  }
}
```

<br />

`@while` – 조건 반복

```scss
$i: 1;

@while $i <= 3 {
  .box-#{$i} {
    height: 10px * $i;
  }
  $i: $i + 1;
}
```

<br />

## Built-in Function

이미 SCSS에 내장되어 있어서 바로 사용할 수 있는 함수

```scss
$color: #ff0000;
$size: 10px;
$colors: red, green, blue;
$str: "hello";

.button {
  // 색상 함수
  background-color: lighten($color, 20%); // 빨강 밝게
  border-color: darken($color, 10%); // 빨강 어둡게

  // 숫자 함수
  width: $size * 2; // 20px
  height: round(3.6) * 5px; // 20px

  // 문자열 함수
  content: unquote($str); // hello

  // 리스트 함수
  color: nth($colors, 2); // green

  // 타입/단위 함수
  font-size: 2 * 1px; // 단위 px 확인 가능
  type: type-of($colors); // list
}
```

<br />
<br />
<br />
<br />
