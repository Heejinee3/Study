<br />

![alt text](https://github.com/Heejinee3/Study/blob/master/Basic/Algorithm/Figure/Figure1.png?raw=true)

<br />

## P (Polynomial time) Problem

> 결정 문제 중에서, 결과를 다항 시간(polynomial time) 안에 항상 계산할 수 있는 문제들의 집합

어떤 문제 L이 있고 입력 x (x∈L)에 대해 항상 다항식 시간 내에 "예/아니오"로 답할 수 있으면 그 문제는 P 클래스에 속함

<br />

## NP (Nondeterministic Polynomial time) Problem

> 결정 문제 중에서, 정답이 ‘있다’는 증거가 주어졌을 때, 그것이 맞는지 다항 시간 안에 검증 가능한 문제들의 집합

어떤 문제 L이 있고 입력 x에 대해, "예"라고 주장하는 증거 y가 주어지면 검증기 V(x,y) 가 다항 시간 안에 그걸 확인할 수 있으면 그 문제는 NP 클래스에 속함

<br />

## NP-hard Problem

> 모든 NP 문제를 다항 시간에 환원할 수 있을 만큼 어려운 문제 집합 (검증 가능성은 요구되지 않음)

어떤 문제 L에 대해서 모든 NP 문제가 다항 시간 안에 L로 환원(reduction) 가능하다면 그 문제는 NP-hard 클래스에 속함

| 구성 요소           | 설명                                                           |
| ------------------- | -------------------------------------------------------------- |
| 환원 가능성         | 모든 NP 문제를 다항 시간 안에 NP-hard 문제로 바꿀 수 있어야 함 |
| NP에 속할 필요 없음 | NP-hard 문제는 "답 검사가 빠르다"는 조건을 필요로 하지 않음    |

<br />

## NP-complete Problem

> NP에 속하면서, 모든 NP 문제를 다항 시간에 환원할 수 있는 가장 어려운 NP 문제들

어떤 문제 L이 NP-complete라는 것은, 다음 두 가지 조건을 모두 만족해야 함:

1. 문제의 답이 주어졌을 때 그 정답이 맞는지 다항 시간 안에 검증 가능해야 함 (NP에 속함)

2. 모든 NP 문제는 다항 시간 안에 L로 환원(reduction) 가능해야 함 (모든 NP 문제보다 L이 최소한 동일하거나 더 어려운 문제)

<br />
<br />
<br />
<br />
