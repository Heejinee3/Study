<br />

## Type

```python
variable = 123
variable = 1.2
variable = "Hello World!"
variable = [1, 2, 3]
variable = (1, 2, 3)
variable = {'key1':'value1', 'key2':'value2'}
variable = {1, 2, 3}
variable = True
```

#### Integer/Float Method

```python
integer = integer1 + integer2  # 덧셈
integer = integer1 - integer2  # 뺄셈
integer = integer1 * integer2  # 곱셈
float   = integer1 / integer2  # 나눗셈
integer = integer1 ** integer2 # 제곱
integer = integer1 % integer2  # 나눗셈 나머지
integer = integer1 // integer2 # 나눗셈 몫
```

```python
# float도 integer과 동일
```

#### String Method

```python
string  = string1 + string2
string  = string * integer
string  = string[index1:index2]
string  = "Hello %s!" %string                      """
                                                   %s	문자열 (String)
                                                   %c	문자 1개( character)
                                                   %d	정수 (Integer)
                                                   %f	부동소수 (floating-point)
                                                   %o	8진수
                                                   %x	16진수
                                                   %%	Literal % (문자 % 자체)
                                                   """
string  = "{0}, {1}!".format(variable1, variable2)
string  = f"{variable1}, {variable2}!"
```

```python
integer = string1.count(string2)            # string1에 있는 string2 개수 반환
index   = string1.find(string2)             # 처음으로 나온 위치 반환, 없으면 -1
index   = string1.index(string2)            # 처음으로 나온 위치 반환, 없으면 error
string  = string1.join(string2)             # string2 각각의 문자 사이에 string1을 삽입
string  = string.upper()                    # 대문자로 바꿈
string  = string.lower()                    # 소문자로 바꿈
string  = string.lstrip()                   # 왼쪽 공백을 지움
string  = string.rstrip()                   # 오른쪽 공백을 지움
string  = string.strip()                    # 양쪽 공백을 지움
string  = string1.replace(string2, string3) # string1에 있는 string2를 string3로 모두 바꿈
list    = string1.split(string2)            # string1을 string2로 split
```

#### List Method

```python
list        = list[index1:index2]
list        = list1 + list2
list        = list * integer
list[index] = variable
del list[index1:index2]           # 해당 위치의 요소 삭제
```

```python
index    = list.index(variable)  # variable가 있는 index 반환, 없으면 error
variable = list.pop(index)       # index 자리에 있는 variable을 꺼냄, parameter가 없으면 오른쪽에 있는 요소를 꺼냄
integer  = list.count(variable)  # variable의 개수 반환
list.append(variable)            # list 오른쪽에 variable 추가
list.remove(variable)            # 첫번쨰로 나오는 variable 삭제, 없으면 error
list.sort()                      # 정렬
list.reverse()                   # list를 뒤집어줌
list.insert(index, variable)     # index 자리에 variable 추가
list1.extend(list2)              # list1의 오른쪽에 list2를 이어줌
```

#### Tuple Method

```python
tuple   = tuple[index1:index2]
tuple   = tuple1 + tuple2
tuple   = tuple * integer
```

#### Dictionary Method

```python
value           = dictionary[key]   # 해당 key의 value 반환, 없으면 error
dictionary[key] = value
del dictionary[key]                 # 해당 key의 요소 삭제
```

```python
dict_keys   = dictionary.keys()            # 모든 key 반환
dict_values = dictionary.values()          # 모든 value 반환
dict_items  = dictionary.items()           # 모든 key, value 반환
value       = dictionary.get(key, default) # 해당 key의 value 반환, 없으면 default, default를 안쓰면 None
dictionary1.update(dictionary2)            # 여러개 추가
dictionary.clear()                         # 모든 요소 삭제
```

#### Set Method

```python
set = set1 & set2 # 교집합
set = set1 | set2 # 합집합
set = set1 - set2 # 차집합
```

```python
set = set1.intersection(set2) # 교집합
set = set1.union(set2)        # 합집합
set = set1.difference(set2)   # 차집합
set.add(variable)             # 추가
set1.update(set2)             # 여러개 추가
set.remove(variable)          # 해당 요소 삭제, 없으면 error
```

#### Boolean Method

| 값        | 참 or 거짓 |
| --------- | ---------- |
| True      | 참         |
| False     | 거짓       |
| "python"  | 참         |
| ""        | 거짓       |
| [1, 2, 3] | 참         |
| []        | 거짓       |
| (1, 2, 3) | 참         |
| ()        | 거짓       |
| {'a': 1}  | 참         |
| {}        | 거짓       |
| {1, 2, 3} | 참         |
| set()     | 거짓       |
| 1         | 참         |
| 0         | 거짓       |
| None      | 거짓       |

```python
boolean = boolean1 or boolean2
boolean = boolean1 and boolean2
boolean = not boolean
boolean = variable in iterable
boolean = variable not in iterable
```

#### Deque Method

```python
from collections import deque
variable = deque(list)
```

```python
variable     = deque[index]
deque        = deque1 + deque2
deque        = deque * integer
deque[index] = variable
del deque[index]               # 해당 위치의 요소 삭제
```

```python
index    = deque.index(variable) # variable가 있는 index 반환, 없으면 error
variable = deque.pop()           # 오른쪽에서 값을 뺌
variable = deque.popleft()       # 왼쪽에서 값을 뺌
integer  = deque.count(variable) # variable의 개수 반환
deque.reverse()                  # deque를 뒤집어줌
deque.insert(index, variable)    # index 자리에 variable 추가
deque.append(variable)           # 오른쪽에 값을 넣음
deque.appendleft(variable)       # 왼쪽에 값을 넣음
deque1.extend(deque2)            # 오른쪽에 deque2를 넣음
deque1.extendleft(deque2)        # 왼쪽에 deque2를 넣음
deque.remove(variable)           # 첫번쨰로 나오는 variable 삭제, 없으면 error
```

<br />

## Control Statement

#### If/Elif/Else Condition

```python
if <condition1>:
    <statement1>
elif <condition2>:
    <statement2>
else:
    <statement3>
```

#### While Loop

```python
while <condition>:
    <statement>
```

#### For Loop

```python
for <variable> in <iterable>:
    <statement>
```

```python
list = [<statement> for <variable1> in <iterable1> if <condition1>
                    for <variable2> in <iterable2> if <condition2>]
```

#### Loop Operation

| Operation | Explanation        |
| --------- | ------------------ |
| break     | loop를 빠져나감    |
| continue  | 다음 loop로 넘어감 |

<br />

## Function

```python
def function(parameter1, parameter2): # initial value 지정 가능 ex. parameter = value
                                      # 하지만 뒤쪽에 설정해야함
    <statement>
    return result                     # 여러개 return 가능 ex. variable1, variable2
                                      # 그러면 tuple 형태로 return

variable = function(parameter1 = variable1, parameter2 = variable2)
```

```python
def function(*parameters): # *를 사용할 경우 여러개의 파라미터를 받을 수 있음
                           # type은 tuple
    <statement>
    return result

tuple = function(variable1, variable2)
```

```python
def function(**parameters): # **를 사용할 경우 여러개의 파라미터를 받을 수 있음
                            # type은 dictionary
    <statement>
    return parameters

dictionary = function(parameter1 = variable1, parameter2 = variable2)
```

```python
# 간단할 경우 lambda 사용
variable = lambda parameter1, parameter2: parameter1 + parameter2
```

<br />

## Class

```python
class Class(Parent):

    variable = value

    def __init__(self, parameter):
        self.variable = parameter

    def __str__(self):
        return string

    def __call__(self, parameter):
        <statement>
        return result

    def function(self, parameter):
        <statement>
        return result

class    = Class(value)
variable = class.variable
```

<br />

## File Input/Output

```python
path = "C:/chunja/file.txt" # "C:\\chunja\\file.txt" or r"C:/chunja/file.txt"
mode = "w"                  # r : 읽기, w: 쓰기, a: 추가
file = open(path, mode)
file.close()

with open(path, mode) as file:
    <statement>
```

```python
file.write(string)       # 파일에 쓰기
string = file.readline() # 파일에서 한줄 읽기, 더 이상 없으면 ""
list = file.readlines()  # 파일에서 여러줄 읽기, string list로 반환
string = file.read()     # 파일 모두 읽기
```

<br />

## Module/Package

#### Import Module

```python
from package.module import <function | variable | class> # 모듈 불러오기
                                                         # module은 파일 이름
                                                         # package는 폴더 이름
                                                         # .. : 부모 디렉터리
                                                         # .  : 현재 디렉터리
```

#### \_\_name\_\_ == \_\_main\_\_

```python
if __name__ == "__main__": # 현재 실행되고 있는 파일일떄, __name__ = __main__
    <statement>
```

#### Import System Path

```python
import sys
sys.path.append(path) # module이 안불려질 때 path 넣기
```

```python
set PYTHONPATH = path  # module이 안불려질 때 path 넣기
```

#### \_\_init.py\_\_

```python
from package.module import <function | variable | class> # 기본 모듈 추가

variable = value                                         # 기본 변수 추가

def function():                                          # 기본 함수 추가
    <statemet>

class Class:                                             # 기본 클래스 추가
    <initialize>

__all__ = ['module']                                     # 'from package import *' 을 했을 때 추가될 모듈 선언
                                                         # 'from package.module import *'일 경우 자동으로 모두 추가됨
```

<br />

## Exception

#### Exception Handling

```python
try:
    <statement1>
except (Error1, Error2) as e:
    <statement2>
else:
    <statement3>
finally:
    <statement4>
```

#### Force Exception

```python
raise Error
```

#### Make Exception

```python
class Error(Exception):
    pass

raise Error()
```

<br />

## Built-in Function

```python
number    = abs(number)                      # 절댓값 반환
boolean   = all(iterable)                    # 요소가 모두 참이면 True, 아니면 False
boolean   = any(iterable)                    # 요소 중 하나라도 참이면 True, 아니면 False
boolea    = bool(variable)                   # type을 bool로 바꿔줌
string    = chr(integer)                     # 유니코드 숫자값을 입력받고 해당 문자 반환
list      = dir(variable)                    # 해당 객체의 변수와 함수를 보여줌
tuple     = divmod(number1, number2)         # (number1//number2, number1%number2) 반환
enumerate = enumerate(iterable)              # (index, iterable의 요소)로 구성된 enumerate 반환, 순서가 있는 iterable을 널어야 함
value     = eval(string)                     # string의 실행 결과값을 반환
filter    = filter(function, iterable)       # 결과값이 True로 나오는 요소만 골라 filter로 반환
string    = hex(number)                      # 16진수 문자열 반환
integer   = id(variable)                     # 고유 주소 반환
string    = input(string)                    # 사용자 입력
integer   = int(variable, integer)           # type을 int로 바꿔줌, 2번째 인자는 radix, 없으면 10진수 형태
boolean   = isinstance(variable, class)      # variable이 class type인지 확인
integer   = len(iterable)                    # 길이 반환
list      = list(iterable)                   # type을 list로 바꿔줌
map       = map(function, iterable)          # iterable의 요소를 각각 function의 인자로 넣어 반환값들을 map으로 반환
value     = max(iterable)                    # 각 요소의 최댓값 반환
value     = min(iterable)                    # 각 요소의 최솟값 반환
string    = oct(number)                      # 8진수 문자열 반환
integer   = ord(string)                      # 문자의 유니코드 숫자값 반환
number    = pow(number1, number2)            # number1의 number2 제곱한 결과값 반환
void      = print(variable, end = string)    # 콘솔 출력
range     = range(number1, number2, number3) # number1(start)에서 number2(end)까지 number3(step) 이동한 range 반환, number2는 포함되지 않음
number    = round(number, integer)           # number를 소수 integer 자리까지만 반올림, 2번째 인자는 없어도 됨
set       = set(iterable)                    # type을 set으로 바꿔줌
list      = sorted(iterable)                 # 정렬하여 list로 반환
string    = str(variable)                    # type을 string으로 바꿔줌
number    = sum(iterable)                    # 각 요소를 더한 값 반환
tuple     = tuple(iterable)                  # type을 tuple로 바꿔줌
type      = type(variable)                   # type 반환
zip       = zip(*iterable)                   # 동일한 개수로 이루어진 데이터들을 묶어서 반환
```

<br />

## Library

#### Standard Library

[Standard Library](https://wikidocs.net/33)

#### External Library

[External Library](https://wikidocs.net/180538)

<br />

## Encoding/Decoding

```python
encoded = string.encode('utf-8')
decoded = encoded.decode('utf-8')
```

<br />

## Closure

```python
def closure(function):
    def wrapper():
        result = function()
        return result
    return wrapper

def function():
    <statement>

wrapper = closure(function)
wrapper()
```

<br />

## Decorator

```python
def decorator(function):
    def wrapper(*args, **kwargs):
        result = function(*args, **kwargs)
        return result
    return wrapper

@decorator
def function(parameter):
    <statement>

function(variable)
```

<br />

## Iterator

```python
iterator = iter(iterable) # next(iterator) 함수로 하나씩 접근 가능
```

```python
class Itertor:
    def __init__(self, data):
        self.data = data
        self.position = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.position >= len(self.data):
            raise StopIteration
        result = self.data[self.position]
        self.position += 1
        return result

iterator = Itertor(list)
for item in iterator:                       # for loop은 한번밖에 사용 못함
    <statement>
```

<br />

## Generator

```python
def generator():
    for i in range(1, 1000):
        result = i
        yield result
```

```python
generator = (i for i in range(1, 1000))
```

```python
class Generator:
    def __init__(self):
        self.data = 1

    def __iter__(self):
        return self

    def __next__(self):
        result = self.data
        self.data += 1
        if self.data >= 1000:
            raise StopIteration
        return result
```

<br />

## Type Annotation

```python
variable: type = value

def function(parameter1: type, parameter2: type) -> type:
    <statement>
    return result
```

<br />

## Regular Expression

[Regular Expression1](https://wikidocs.net/4308)

[Regular Expression2](https://wikidocs.net/4309)

<br />
