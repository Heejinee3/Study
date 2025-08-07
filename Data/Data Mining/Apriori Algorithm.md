<br />

## Apriori Algorithm

> 연관 규칙 (association rule) 학습에서 자주 사용하는 빈발 아이템셋(frequent itemsets)을 찾는 알고리즘

기본 아이디어는 다음과 같음

- 1-itemsets 중 지지도(support)를 만족하는 itemsets을 찾음
- k-itemsets을 만들기 위해 (k-1)-itemsets을 조합하며 지지도(support)를 만족하는 itemsets만 남김
- 더 이상 아이템셋이 없을 때까지 반복

<br />

## Association Rule

> 두 itemsets 간의 함께 등장하는 경향을 "if-then" 형태로 표현한 규칙

ex. {diaper} ⇒ {beer} → 기저귀를 산 고객은 맥주도 살 가능성이 높음

<br />

이 규칙을 평가하기 위해 다음과 같은 지표를 사용

### Support

정의: 아이템셋이 전체 거래에서 등장한 비율

수식: `support(X) = count(X)/N`

예: `support({milk}) = 3 / 5 = 0.6`

→ 5개의 거래 중 3개에 milk가 포함됨

<br />

### Confidence

정의: X가 등장할 때 Y도 등장하는 비율

수식: `confidence(X⇒Y) = support(X∪Y)/support(X)`

예: `confidence({diaper} ⇒ {beer}) = support({diaper, beer}) / support({diaper}) = 0.6 / 0.8 = 0.75`

→ 기저귀를 산 사람 중 75%가 맥주도 삼

<br />

### Lift

정의: X와 Y의 관계가 얼마나 유의미한지 나타냄

- lift = 1: X와 Y는 독립 (서로 관계 없음)
- lift > 1: X가 Y의 발생을 증가시킴 (양의 상관관계)
- lift < 1: X가 Y의 발생을 방해함 (음의 상관관계)

수식: `lift(X⇒Y) = support(X∪Y)/(support(X)*support(Y))`

<br />

### Interest

정의: X가 등장할 때 Y가 나올 확률(confidence(X⇒Y))이, 그냥 Y가 나올 확률(support(Y))보다 얼마나 더 높은지 측정

Y가 원래 자주 나오는 아이템이라면 {X ⇒ Y} 같은 규칙은 별로 유의미하지 않을 수도 있음기 때문에 이를 보정

수식: `interest(X⇒Y) = confidence(X⇒Y) - support(Y)`

<br />

## Implementation

### 코드

```python
from itertools import combinations

def apriori(transactions, min_support):
    # Total number of transactions
    num_transactions = len(transactions)

    # Generate candidate 1-itemsets
    items = set()
    for transaction in transactions:
        for item in transaction:
            items.add(frozenset([item]))

    # Function to filter frequent itemsets from candidates
    def get_frequent_itemsets(candidates):
        itemset_count = {}
        for candidate in candidates:
            for transaction in transactions:
                if candidate.issubset(transaction):
                    itemset_count[candidate] = itemset_count.get(candidate, 0) + 1

        # Return itemsets with support ≥ min_support
        return {
            itemset: count / num_transactions
            for itemset, count in itemset_count.items()
            if count / num_transactions >= min_support
        }

    frequent_itemsets = dict()

    # Step 1: Find frequent 1-itemsets
    current_frequent = get_frequent_itemsets(items)
    frequent_itemsets.update(current_frequent)

    k = 2
    while current_frequent:
        # Step 2: Generate candidate k-itemsets from (k-1)-frequent itemsets
        candidates = set()
        itemsets = list(current_frequent.keys())
        for i in range(len(itemsets)):
            for j in range(i + 1, len(itemsets)):
                union_set = itemsets[i].union(itemsets[j])
                if len(union_set) == k:
                    candidates.add(union_set)

        # Step 3: Filter frequent k-itemsets
        current_frequent = get_frequent_itemsets(candidates)
        frequent_itemsets.update(current_frequent)
        k += 1

    return frequent_itemsets

# Example usage
transactions = [
    {'bread', 'milk', 'diaper'},
    {'bread', 'diaper', 'beer', 'egg'},
    {'milk', 'diaper', 'beer', 'cola'},
    {'bread', 'milk', 'diaper', 'beer'},
    {'bread', 'milk', 'diaper', 'cola'},
]

min_support = 0.6
result = apriori(transactions, min_support)

# Print frequent itemsets and their supports
for itemset, support in result.items():
    print(f"Itemset: {set(itemset)}, Support: {support:.2f}")
```

<br />

### 예시 데이터

```python
transactions = [
    {'bread', 'milk', 'diaper'},
    {'bread', 'diaper', 'beer', 'egg'},
    {'milk', 'diaper', 'beer', 'cola'},
    {'bread', 'milk', 'diaper', 'beer'},
    {'bread', 'milk', 'diaper', 'cola'},
]
```

<br />

### 목표

지지도(support) ≥ 0.6인 빈발 아이템셋(frequent itemsets)을 찾는 것

---

### 1단계

모든 단일 아이템을 뽑아서 각 아이템의 지지도(support)를 계산

| 아이템 | 등장 횟수 | Support (=횟수/5) |
| ------ | --------- | ----------------- |
| bread  | 4         | 0.80 ✅           |
| milk   | 4         | 0.80 ✅           |
| diaper | 5         | 1.00 ✅           |
| beer   | 3         | 0.60 ✅           |
| egg    | 1         | 0.20 ❌           |
| cola   | 2         | 0.40 ❌           |

<p></p>

→ frequent 1-itemsets:

`{bread}, {milk}, {diaper}, {beer}`

---

### 2단계

이전 단계에서 살아남은 아이템셋을 2개씩 조합해서 2-itemset candidates 생성

`{bread, milk}`
`{bread, diaper}`
`{bread, beer}`
`{milk, diaper}`
`{milk, beer}`
`{diaper, beer}`

<p></p>

→ 각 조합의 지지도(support) 계산

| Itemset         | Count | Support |
| --------------- | ----- | ------- |
| {bread, milk}   | 3     | 0.60 ✅ |
| {bread, diaper} | 4     | 0.80 ✅ |
| {bread, beer}   | 2     | 0.40 ❌ |
| {milk, diaper}  | 4     | 0.80 ✅ |
| {milk, beer}    | 2     | 0.40 ❌ |
| {diaper, beer}  | 3     | 0.60 ✅ |

<p></p>

→ frequent 2-itemsets:

`{bread, milk}, {bread, diaper}, {milk, diaper}, {diaper, beer}`

---

### 3단계

frequent 2-itemsets끼리 조합해서 3-itemset candidates 생성

(단, 교집합 2개 이상 → 합집합이 정확히 3개일 때만 후보로 유지)

`{bread, milk, diaper}`
`{bread, diaper, beer}`
`{milk, diaper, beer}`

<p></p>

→ 각 조합의 지지도(support) 계산

| 아이템셋              | 등장 횟수 | Support |
| --------------------- | --------- | ------- |
| {bread, milk, diaper} | 3         | 0.60 ✅ |
| {bread, diaper, beer} | 2         | 0.40 ✅ |
| {milk, diaper, beer}  | 2         | 0.40 ❌ |

<p></p>

→ frequent 3-itemsets:

`{bread, milk, diaper}`

---

### 4단계

frequent 3-itemsets은 1개뿐이므로 더 이상 조합 불가 → 종료

---

### 최종 결과

빈발 아이템셋(frequent itemsets) + 지지도(support)

```yaml
Itemset: {'milk'}                   , Support: 0.80
Itemset: {'bread'}                  , Support: 0.80
Itemset: {'diaper'}                 , Support: 1.00
Itemset: {'beer'}                   , Support: 0.60
Itemset: {'bread', 'milk'}          , Support: 0.60
Itemset: {'bread', 'diaper'}        , Support: 0.80
Itemset: {'milk', 'diaper'}         , Support: 0.80
Itemset: {'diaper', 'beer'}         , Support: 0.60
Itemset: {'bread', 'milk', 'diaper'}, Support: 0.60
```

<br />
<br />
<br />
<br />
