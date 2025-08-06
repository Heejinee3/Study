<br />

## Multihash Algorithm

데이터 마이닝에서 빈번한 아이템 쌍(Frequent Item Pairs) 을 찾을 때 사용하는 해시 기반 알고리즘

PCY와 비슷하게 해시를 사용하지만, 한 번이 아니라 여러 개의 서로 다른 해시 함수를 사용

![alt text](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2FR1hQD%2FbtsPGFrJmOT%2FAAAAAAAAAAAAAAAAAAAAAFMODlH3ZcIJjU3hN_ovktw7OFt9GVqQdYGRa_BN2L6t%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1756652399%26allow_ip%3D%26allow_referer%3D%26signature%3DsDOKrartrohRtaIN1rL6PYrdvoA%253D)

<br />

## Implementation

### Code

```python
from collections import defaultdict
from itertools import combinations

def hash_pair(pair, num_buckets, seed):
    return (hash(pair[0] + str(seed)) ^ hash(pair[1] + str(seed))) % num_buckets

def multihash(transactions, min_support_ratio, num_buckets=10, num_hashes=3):
    num_transactions = len(transactions)
    min_support = min_support_ratio * num_transactions

    # Step 1: Count individual item frequencies
    item_counts = defaultdict(int)
    for transaction in transactions:
        for item in transaction:
            item_counts[item] += 1
    frequent_items = {item: count for item, count in item_counts.items() if count >= min_support}

    # Step 2: Count hash bucket frequencies for candidate pairs using multiple hash functions
    buckets = [defaultdict(int) for _ in range(num_hashes)]
    for transaction in transactions:
        filtered_items = [item for item in transaction if item in frequent_items]
        for pair in combinations(sorted(filtered_items), 2):
            for i in range(num_hashes):
                bucket_index = hash_pair(pair, num_buckets, seed=i)
                buckets[i][bucket_index] += 1

    # Step 3: Create bitmaps to mark buckets with counts above the minimum support
    bitmaps = []
    for i in range(num_hashes):
        bitmap = [False] * num_buckets
        for b in range(num_buckets):
            if buckets[i][b] >= min_support:
                bitmap[b] = True
        bitmaps.append(bitmap)

    # Step 4: Filter candidate pairs that appear in all hash function bitmaps
    candidate_pairs = set()
    for transaction in transactions:
        filtered_items = [item for item in transaction if item in frequent_items]
        for pair in combinations(sorted(filtered_items), 2):
            pass_all = True
            for i in range(num_hashes):
                bucket_index = hash_pair(pair, num_buckets, seed=i)
                if not bitmaps[i][bucket_index]:
                    pass_all = False
                    break
            if pass_all:
                candidate_pairs.add(pair)

    # Step 5: Count support of candidate pairs in transactions
    pair_counts = defaultdict(int)
    for transaction in transactions:
        for pair in candidate_pairs:
            if pair[0] in transaction and pair[1] in transaction:
                pair_counts[pair] += 1

    frequent_pairs = {pair: count for pair, count in pair_counts.items() if count >= min_support}

    return frequent_pairs, frequent_items

# Sample transactions
transactions = [
    {'bread', 'milk'},
    {'bread', 'diaper', 'beer', 'egg'},
    {'milk', 'diaper', 'beer', 'cola'},
    {'bread', 'milk', 'diaper', 'beer'},
    {'bread', 'milk', 'diaper', 'cola'}
]

min_support = 0.6
frequent_pairs, frequent_items = multihash(transactions, min_support)

# Pretty print results
print("Frequent Items:")
for item, count in sorted(frequent_items.items(), key=lambda x: -x[1]):
    print(f"  {item}: {count}")

print("\nFrequent Pairs:")
for pair, count in sorted(frequent_pairs.items(), key=lambda x: -x[1]):
    print(f"  {pair}: {count}")
```

<br />

---

### Example data

```python
transactions = [
    {'bread', 'milk'},
    {'bread', 'diaper', 'beer', 'egg'},
    {'milk', 'diaper', 'beer', 'cola'},
    {'bread', 'milk', 'diaper', 'beer'},
    {'bread', 'milk', 'diaper', 'cola'}
]

min_support = 0.6
```

👉 전체 트랜잭션 수: 5

👉 지지도 기준: 3

<br />

---

### Step 1. Count individual items

각 아이템이 얼마나 자주 등장하는지 세고, `3번 이상` 등장한 것만 남김

| Item   | Count |
| ------ | ----- |
| bread  | 4 ✅  |
| milk   | 4 ✅  |
| diaper | 4 ✅  |
| beer   | 3 ✅  |
| egg    | 1 ❌  |
| cola   | 2 ❌  |

→ frequent 1-itemsets:

`{bread}, {milk}, {diaper}, {beer}`

<br />

---

### Step 2. Count with hash buckets

1. 각 트랜잭션에서 frequent item만 남긴 후, 가능한 모든 2-itemset 조합을 생성

예: `{bread, milk, diaper, cola}` → `{bread, milk, diaper}` → `{bread, milk}, {bread, diaper}, {milk, diaper}`

<p></p>

2. 생성된 모든 2-itemset 후보쌍을 각 해시 함수에 적용하여 해당하는 bucket의 카운트를 증가

```python
for i in range(num_hashes):
    bucket_index = hash_pair(pair, num_buckets, seed=i)
    buckets[i][bucket_index] += 1
```

<br />

---

### Step 3. Create bitmaps

각 해시 함수에 대해, bucket count가 최소 지지도(support) 이상인 경우 해당 위치를 True로 표시한 bitmap을 생성

```python
# 예시
bitmaps[0] = [False, True, False, ..., True]
bitmaps[1] = ...
bitmaps[2] = ...
```

<br />

---

### Step 4. Filter pairs by bitmaps

1. 각 트랜잭션에서 frequent item만 남긴 뒤, 가능한 모든 2-itemset 조합을 생성

예: `{bread, milk, diaper, cola}` → `{bread, milk, diaper}` → `{bread, milk}, {bread, diaper}, {milk, diaper}`

<p></p>

2. 각 2-itemset에 대해 모든 해시 함수의 해시 값을 계산하고, 해당 bucket 위치의 bitmap 값이 모두 True인지 확인

예:

`{bread, milk}`: hash 0~2 모두 bitmap이 True → Pass

`{diaper, milk}`: hash 중 하나 이상이 False → Fail

<br />

---

### Step 5. Count support of candidate pairs

각 후보쌍이 실제 트랜잭션에서 몇 번 등장하는지 계산

<br />

---

### Step 6. Filter frequent 2-itemsets

pair count가 3(support threshold) 이상인 것만 최종 frequent pair로 남김

→ frequent 2-itemsets:

`{bread, milk}, {bread, diaper}, {bread, beer}, {milk, diaper}`

<br />

---

### Result

```python
Frequent Items:
  bread: 4
  milk: 4
  diaper: 4
  beer: 3

Frequent Pairs:
  ('bread', 'milk'): 3
  ('beer', 'diaper'): 3
  ('bread', 'diaper'): 3
  ('diaper', 'milk'): 3
```

<br />
<br />
<br />
<br />
