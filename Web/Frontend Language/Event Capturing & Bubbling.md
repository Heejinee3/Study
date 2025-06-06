<br />

## Capturing Phase

- 이벤트가 가장 바깥쪽 요소(루트)에서 시작해서 → 타깃 요소까지 내려옴
- 예: `document → html → body → div → button`

<p></p>

## Bubbling Phase

- 이벤트가 타깃 요소에서 시작해서 → 다시 바깥쪽으로 올라감
- 예: `button → div → body → html → document`

<p></p>

```html
<div id="outer">
  <button id="inner">클릭</button>
</div>
```

```js
document.getElementById("outer").addEventListener(
  "click",
  () => {
    console.log("Outer clicked");
  },
  true
); // true면 캡처링 단계에서 실행됨

document.getElementById("inner").addEventListener("click", () => {
  console.log("Inner clicked");
});
```

```
Outer clicked ← 캡처링 단계
Inner clicked ← 버블링 단계
```

<br />

## stopPropagation()

- 이벤트가 부모 요소로 올라가는 것(버블링) 또는 내려가는 것(캡처링)을 막음

```html
<div id="outer">
  <button id="inner">Click</button>
</div>

<script>
  document.getElementById("outer").addEventListener("click", () => {
    console.log("Outer clicked");
  });

  document.getElementById("inner").addEventListener("click", (e) => {
    e.stopPropagation();
    console.log("Inner clicked");
  });
</script>
```

```
Inner clicked
```

<br />
<br />
<br />

[출처: 짐코딩, 「이벤트 버블링&캡쳐링 | 이벤트 전파 | stopPropagation() | preventDefault() | 웹개발 입문」, 유튜브](https://www.youtube.com/watch?v=0jtalJxrxhs)

<br />
