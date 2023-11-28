# Index

> [Basic Structure](#basic-structure)
>
> [Title](#title)
>
> [Paragraph](#paragraph)
>
> [Text](#text)
>
> [List](#list)
>
> [Table](#table)
>
> [Multimedia](#multimedia)
>
> [Link](#link)
>
> [Form](#form)
>
> [Meta Tag](#meta-tag)

# Basic Structure

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Title</title>
  </head>
  <body>
    <!-- 윗쪽 구역 -->
    <header>Header</header>

    <!-- 본문 -->
    <main>Main</main>

    <!-- 사이드바 -->
    <aside>Aside</aside>

    <!-- 아랫쪽 구역 -->
    <footer>Footer</footer>

    <!-- 개별적이고 독립적인 콘텐츠마다 사용 -->
    <article>Article</article>

    <!-- 관련있는 콘텐츠를 묶을 때 사용 -->
    <section>Section</section>

    <!-- 페이지를 block으로 나눌 때 사용 -->
    <div>Division</div>
  </body>
</html>
```

# Title

```html
<!-- 2 times -->
<h1>Title</h1>

<!-- 1.5 times -->
<h2>Title</h2>

<!-- 1.33 times -->
<h3>Title</h3>

<!-- 1.17 times -->
<h4>Title</h4>

<!-- 0.83 times -->
<h5>Title</h5>

<!-- 0.67 times -->
<h6>Title</h6>
```

# Paragraph

```html
<!-- 줄바꿈 -->
<br />

<!-- 단락 -->
<p>Paragraph</p>

<!-- 인용문 -->
<blockquote>Block Quote</blockquote>

<!-- 수평선 -->
<hr />

<!-- block -->
<div>Division</div>

<!-- inline -->
<span>Span</span>
```

# Text

```html
<!-- 굵은 글씨 -->
<b>Text</b>

<!-- 굵은 글씨(강조) -->
<strong>Text</strong>

<!-- 기울어진 글씨(관용구) -->
<i>Text</i>

<!-- 기울어진 글씨(강조) -->
<em>Text</em>

<!-- 기울어진 글씨(창작물의 제목) -->
<cite>Text</cite>

<!-- 작은 글씨 -->
<small>Text</small>

<!-- 아래쪽 글씨 -->
<sub>Text</sub>

<!-- 위쪽 글씨 -->
<sup>Text</sup>

<!-- 가운데줄 그어진 글씨(잘못됨) -->
<s>Text</s>

<!-- 가운데줄 그어진 글씨(삭제) -->
<del>Text</del>

<!-- 밑줄 그어진 글씨 -->
<u>Text</u>

<!-- 밑줄 그어진 글씨(추가) -->
<ins>Text</ins>

<!-- 축약된 글씨 -->
<abbr title="Original Text">Abbreviated Text</abbr>

<!-- 코드 글씨 -->
<code>Text</code>

<!-- 색깔, 크기, 모양 조절 글씨 -->
<font color="#000000" size="10px" face="돋움">Text</font>
```

# List

```html
<!-- 순서가 있는 목록 -->
<!-- type  = "1","a","A","i","I"
     start = "1" -->
<ol>
  <li>List</li>
  <li>List</li>
  <li>List</li>
</ol>
```

```html
<!-- 순서가 없는 목록 -->
<ul>
  <li>List</li>
  <li>List</li>
  <li>List</li>
</ul>
```

```html
<!-- 용어 목록 -->
<dl>
  <dt>Terms</dt>
  <dd>Explanation</dd>
  <dd>Explanation</dd>
</dl>
```

# Table

```html
<!-- border  = "1px"
     rowspan = "1"
     colspan = "1"
     align   = "center","left","right"
     bgcolor="#000000" -->
<table width="100px" height="100px">
  <!-- 제목 -->
  <caption>
    Title
  </caption>

  <!-- 열 -->
  <colgroup>
    <col />
    <col />
  </colgroup>

  <!-- 헤드 -->
  <thead>
    <tr>
      <th>Head</th>
      <th>Head</th>
    </tr>
  </thead>

  <!-- 본문 -->
  <tbody>
    <tr>
      <td>Cell</td>
      <td>Cell</td>
    </tr>
    <tr>
      <td>Cell</td>
      <td>Cell</td>
    </tr>
  </tbody>

  <!-- 요약 -->
  <tfoot>
    <tr>
      <td>Cell</td>
      <td>Cell</td>
    </tr>
  </tfoot>
</table>
```

# Multimedia

```html
<!-- 멀티미디어 -->
<object width="100px" data="data.pdf">Alternative</object>
<embed width="100px" src="data.pdf">Alternative</embed>

<!-- 이미지 -->
<!-- https://pixabay.com/ko/: 무료 이미지 다운로드 사이트
     https://www.canva.com/: 이미지 만들기 사이트 -->
<img src="data.jpg" alt="Alternative" width="100px">

<!-- 오디오/비디오 -->
<!-- autoplay
     loop
     muted
     preload = "auto","metadata","none"
     poster  = "data.jpg" -->
<audio src="data.mp3" width="100px" controls >Alternative</audio>
<video src="data.mp4" width="100px" controls >Alternative</video>
```

# Link

```html
<!-- 링크로 이동(텍스트) -->
<a href="http://www.naver.com" target="_blank">Move</a>

<!-- 링크로 이동(이미지) -->
<a href="http://www.naver.com" target="_blank">
  <img src="data.jpg" alt="Alternative" width="100" />
</a>

<!-- 해당 구역으로 이동 -->
<a href="#id">Move</a>

<!-- 다운로드 -->
<a href="#" download="data.jpg">Download</a>
```

# Form

```html
<!-- method       = "POST","GET"
     name         = "name"
     target       = "_blank","_self"
     autocomplete = "on","off" -->
<form action="http://myserver.com">
  <fieldset>
    <legend>Group</legend>
    <label for="id">Label</label>
    <input type="text" name="name" id="id" />
  </fieldset>
</form>
```

#### Text

```html
<label for="id">Label</label>
<!-- placeholder = "placeholder"
     value       = "value"
     size        = "10"
     minlength   = "0"
     maxlength   = "10"
     required -->
<input type="text" name="name" id="id" />
```

#### Password

```html
<label for="id">Label</label>
<!-- placeholder = "placeholder"
     size        = "10"
     minlength   = "0"
     maxlength   = "10"
     required -->
<input type="password" name="name" id="id" />
```

#### File

```html
<label for="id">Label</label>
<!-- placeholder = "placeholder"
     required -->
<input type="file" name="name" id="id" />
```

#### Checkbox

```html
<!-- checked
     required -->
<input type="checkbox" name="name" id="id1" value="value1" /><label for="id1"
  >Label</label
>
<input type="checkbox" name="name" id="id2" value="value2" /><label for="id2"
  >Label</label
>
```

#### Radio

```html
<!-- checked
     required -->
<input type="radio" name="name" id="id1" value="value1" /><label for="id1"
  >Label</label
>
<input type="radio" name="name" id="id2" value="value2" /><label for="id2"
  >Label</label
>
```

#### Number

```html
<label for="id">Label</label>
<!-- step        = "1"
     value       = "1"
     placeholder = "placeholder"
     required -->
<input type="number" name="name" id="id" value="1" min="1" max="10" />
```

#### Range

```html
<label for="id">Label</label>
<!-- step  = "1"
     value = "1" -->
<input type="range" name="name" id="id" min="1" max="10" step="1" />
```

#### Date

```html
<label for="id">Label</label>
<!-- min   = "2022-01-01"
     max   = "2022-12-31"
     step  = "1"
     value = "2022-01-01"
     required -->
<input type="date" name="name" id="id" />
```

#### Month

```html
<label for="id">Label</label>
<!-- min   = "2022-01"
     max   = "2022-12"
     step  = "1"
     value = "2022-01"
     required -->
<input type="month" name="name" id="id" />
```

#### Week

```html
<label for="id">Label</label>
<!-- min   = "2022-W01"
     max   = "2023-W01"
     step  = "1"
     value = "2022-W01"
     required -->
<input type="week" name="name" id="id" />
```

#### Time

```html
<label for="id">Label</label>
<!-- min   = "00:00"
     max   = "23:59"
     step  = "1"
     value = "00:00"
     required -->
<input type="time" name="name" id="id" />
```

#### Datetime

```html
<label for="id">Label</label>
<!-- min   = "2022-01-01T00:00"
     max   = "2022-12-23T23:59"
     step  = "1"
     value = "2022-01-01T00:00"
     required -->
<input type="datetime" name="name" id="id" />
```

#### Datetime Local

```html
<label for="id">Label</label>
<!-- min   = "2022-01-01T00:00"
     max   = "2022-12-23T23:59"
     step  = "1"
     value = "2022-01-01T00:00"
     required -->
<input type="datetime-local" name="name" id="id" />
```

#### Submit

```html
<label for="id">Label</label>
<!-- value      = "submit"
     formaction = "http://myserver.com" -->
<input type="submit" name="name" id="id" />
<button type="submit">submit</button>
```

#### Reset

```html
<label for="id">Label</label>
<!-- value = "reset" -->
<input type="reset" name="name" id="id" />
<button type="reset">reset</button>
```

#### Image Submit

```html
<label for="id">Label</label>
<!-- width      = "100px"
     formaction = "http://myserver.com" -->
<input type="image" name="name" id="id" src="data.jpg" alt="Alternative" />
<button type="submit">
  <img src="data.jpg" />
</button>
```

#### Email

```html
<label for="id">Label</label>
<!-- value       = "aaa@gmail.com"
     minlength   = "0"
     maxlength   = "10"
     placeholder = "placeholder"
     size        = "10"
     multiple
     pattern     = ".+@naver\.com"
     required -->
<input type="email" name="name" id="id" />
```

#### Search

```html
<label for="id">Label</label>
<!-- value       = "value"
     minlength   = "0"
     maxlength   = "10"
     placeholder = "placeholder"
     size        = "10"
     required -->
<input type="search" name="name" id="id" />
```

#### Url

```html
<label for="id">Label</label>
<!-- value       = "https://naver.com"
     minlength   = "0"
     maxlength   = "10"
     placeholder = "placeholder"
     size        = "10"
     pattern     = "https://.*"
     required -->
<input type="url" name="name" id="id" />
```

#### Tel

```html
<label for="id">Label</label>
<!-- value       = "010-0000-0000"
     minlength   = "0"
     maxlength   = "10"
     placeholder = "placeholder"
     size        = "10"
     pattern     = "[0-9]{3}-[0-9]{3}-[0-9]{4}"
     required -->
<input type="tel" name="name" id="id" />
```

#### Button

```html
<label for="id">Label</label>
<input type="button" name="name" id="id" value="button" onclick="function();" />
<button type="button" name="name" id="id" onclick="function();">button</button>
```

#### Hidden

```html
<label for="id">Label</label>
<input type="hidden" name="name" id="id" value="value" />
```

#### TextArea

```html
<label for="id">Label</label>
<!-- minlength   = "0"
     maxlength   = "10"
     placeholder = "placeholder"
     required -->
<textarea name="name" id="id" cols="30" rows="10">Text</textarea>
```

#### Select

```html
<label for="id">Label</label>
<!-- multiple
     size
     required
     selected(option) -->
<select name="name" id="id">
  <option value="1">option</option>
  <option value="2">option</option>
  <option value="3">option</option>
</select>
```

#### Datalist

```html
<label for="id">Label</label>
<input list="id" id="id" name="name" />
<datalist id="id" name="name">
  <option value="1">option</option>
  <option value="2">option</option>
  <option value="3">option</option>
</datalist>
```

#### Color

```html
<label for="id">Label</label>
<input type="color" name="name" id="id" value="#000000" />
```

# Meta Tag

```html
<!-- 문자인코딩 타입(UTF-8, EUC-KR) -->
<meta charset="UTF-8" />

<!-- viewport     : 뷰포트
     device-width : 웹페이지의 너비가 기기 너비와 동일
     initial-scale: 초기 확대 비율 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- IE브라우저에서 각 버전 중 가장 최신 표준 모드를 선택하는 문서 모드 -->
<meta http-equiv="X-UA-Compatible" content="ie=edge" />

<!-- content-type    : 콘텐츠의 형식을 알려줌 
     text/html       : text 기반의 html 콘텐츠
     text/xml        : text 기반의 xml 콘텐츠 
     application/json: AOS/IOS 앱 또는 REST API 서버와 통신할 때 콘텐츠 형식 -->
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!-- 검색 로봇에 의해 검색되는 단어를 지정 -->
<meta name="keyword" content="Web, html, 웹, 블로그" />

<!-- 검색 로봇에 의해 검색되는 문자열 -->
<meta name="description" content="저의 웹사이트입니다." />

<!-- noindex : 검색 로봇에 검색 안되게 함 
     nofollow: 검색 로봇이 페이지 링크를 따라가지 않도록 함 -->
<meta name="robots" content="noindex,nofollow" />

<!-- 제작자 표시 -->
<meta http-equiv="author" content="홍길동" />

<!-- 5초 간격으로 새로고침 -->
<meta http-equiv="refresh" content="5;url=http://www.naver.com" />
```
