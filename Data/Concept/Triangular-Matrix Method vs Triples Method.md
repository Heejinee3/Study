<br />

## Triangular-Matrix Method

- 삼각형 형태의 1차원 배열을 사용하여 카운트를 저장

- 전체 행렬을 저장하는 것보다 절반 이하

- 인덱스 계산이 필요하지만, 특정 노드 쌍의 카운트에 빠르게 접근 가능

- 각 pair 당 4byte 차지

- pair가 $(0,1), (1,2), \dots, (1,n), (2,3), \dots, (n-1,n)$순으로 나열될 때,

  $\text{index}(i,j) = i \cdot n - \frac{i(i-1)}{2} + (j-i-1)$

<br />

## Triples Method

- 해시 테이블을 사용해서 모든 삼중 항(triple) 정보를 저장

- 하지만 해시 테이블의 추가 오버헤드가 있음

- 각 pair 당 12byte 차지

- 각 triple은 $[i, j, c]$형태이며, 여기서 c는 pair $(i, j)$의 개수를 나타냄

<br />
<br />

![alt text](https://github.com/Heejinee3/Study/blob/master/Data/Concept/Figure/Figure2.png?raw=true)

<br />
<br />
<br />
<br />
