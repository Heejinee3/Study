# Index

> [Type](#type)
>
> [If/Switch](#if-switch)
>
> [For/While/Do-while](#for-while-do-while)
>
> [Array](#array)
>
> [Enum](#enum)
>
> [Class](#class)
>
> [Access Modifier](#access-modifier)
>
> [Inheritance](#inheritance)
>
> [Abstract Class](#abstract-class)
>
> [Interface](#interface)
>
> [Thread](#thread)
>
> [Exception](#exception)
>
> [Singleton](#singleton)
>
> [Anonymous Object](#anonymous-object)
>
> [Nested Class](#nested-class)
>
> [Lambda Expression](#lambda-expression)
>
> [Collection](#collection)
>
> [Function](#function)
>
> [Socket](#socket)
>
> [MariaDB](#mariadb)

# Type

```java
int myInt               = 10;
long myLong             = 20L;
short myShort           = 30;
byte myByte             = 40;
float myFloat           = 3.14f;
double myDouble         = 6.24d;
boolean myBoolean       = false;
char myChar             = 'A';

String myString         = "홍길동1234";
Integer myInteger       = 10;
Long myLong             = 20L;
Short myShort           = 30;
Byte myByte             = 40;
Float myFloat           = 3.14f;
Double myDouble         = 6.24d;
Boolean myBoolean       = false;
Character myCharacter   = 'A';
Number myNumber         = 10;

int                     = myInteger.intValue();
long                    = myLong.doubleValue();
short                   = myShort.shortValue();
byte                    = myByte.byteValue();
float                   = myFloat.floatValue();
double                  = myDouble.doubleValue();
boolean                 = myBoolean.booleanValue();
char                    = myCharacter.charValue();
```

# If/Switch

```java
if (조건문) {        // if문
    수행문;
} else if (조건문) {
    수행문;
} else {
    수행문;
}

switch (변수) {      // switch문
    case 1:
    수행문;
    break;
    case 2:
    수행문;
    break;
    default:
    수행문;
    break;
}
```

# For/While/Do-while

```java
for (초기화; 조건식; 증감문){ // for문
    수행문;
}

for (int value: array) {    // 간단한 for문
    수행문;
}

while(조건식){               // while문
    수행문;
}

do{                         // do-while문
    수행문;
}while(조건식);
```

# Array

```java
int[] arr = new int[length];
int[] arr = {value1, value2, ...};
arr[index] = value;

int[][] arr = new int[row-length][column-length];
int[][] arr = {
    {value1, value2, value3},
    {value4, value5, value6}
};
arr[row-index][column-index] = value;
```

# Enum

```java
enum EnumName {
    enumtype1,
    enumtype2,
    enumtype3
};

EnumName myEnum = EnumName.enumtype;
EnumName.values();                   // enumtype list
```

# Class

```java
class ClassName{                                   // class 이름

    int value;                                     // instance variable

    static int staticValue;                        // static variable

    void function(int param){                      // instance function
    }

    static void staticFunction(int param){         // static function
    }

    public ClassName(int value){                   // constructor
        this.value = value;
    }

    public int getValue() {                        // instance variable get 함수
        return this.value;
    }

    public static int getStaticValue() {           // static variable get 함수
        return staticValue;
    }

    public void setValue(int value) {              // instance variable set 함수
        this.value = value;
    }

    public static void setStaticValue(int value) { // static variable set 함수
        staticValue = value;
    }
}

public class Main {
    public static void main(String[] args) {

        ClassName object = new ClassName(value); // 객체 생성

        object.value;                            // instance variable
        object.function(value);                  // instance function
        object.setValue(value);                  // instance variable set 함수
        object.getValue();                       // instance variable get 함수

        ClassName.staticValue;                   // static variable
        ClassName.staticFunction(value);         // static function
        ClassName.setStaticValue(value);         // static variable set 함수
        ClassName.getStaticValue();              // static variable get 함수

    }
}
```

# Access Modifier

```java
/* public   : 모든 클래스(파일)에서 접근 가능
    protected: 같은 폴더(패키지) or 자식 클래스(하위)에서 부모 클래스(상위) 접근 가능
    default  : 같은 폴더(패키지)에서 접근 가능
    private  : 같은 클래스 안에서만 접근 가능                                      */
```

# Inheritance

```java
class ClassName1{

    int value;
    void function(int param) {
    }
    public ClassName1(int value){
        this.value = value;
    }
}

class  ClassName2 extends ClassName1{
    public ClassName2(int value) {
        super(value);
    }
    @Override
    void function(int param) {
        System.out.println(param);
    }
}
```

# Abstract Class

```java
abstract class ClassName1{
    abstract void function1();
    void function2(){
    }
}

class ClassName2 extends ClassName1{
    @Override
    void function1() {
    }
}
```

# Interface

```java
interface InterfaceName {
    abstract void function1();
    void function2();
}

class ClassName implements InterfaceName {
    @Override
    public void function1() {
    }

    @Override
    public void function2() {
    }
}
```

# Thread

```java
class ClassName extends Thread{         // 1. Thread Class에 상속받기
    @Override
    public void run() {
    }
}
ClassName object = new ClassName();
object.start();

class ClassName implements Runnable{    // 2. Runnable Interface에 상속받기
    @Override
    public void run() {
    }
}
ClassName object = new ClassName();
Thread thread = new Thread(object);
thread.start();
```

# Exception

```java
try{                                // 1. 직접 처리하기
    throw new Exception();
}catch (Exception e){
}

void Function() throws Exception{   // 2. 호출한 곳으로 넘기기
}

throw new Exception();              // cf. Exception 발생
```

# Singleton

```java
class Singleton{

    private static Singleton singleton = new Singleton();

    static Singleton getInstance(){
        return singleton;
    }
}

Singleton singleton = Singleton.getInstance();
```

# Anonymous Object

```java
interface Anonymous{
    void function();
}

Anonymous ao = new Anonymous() {
    @Override
    public void function() {
    }
};
ao.function();
```

# Nested Class

```java
class Outer{
    String name = "outer";

    class Inner{
        String name = "inner";
    }

    static class InnerStatic{
        String name = "inner static";
    }
}

Outer outer = new Outer();
System.out.println(outer.name);

Outer.Inner inner = outer.new Inner();
System.out.println(inner.name);

Outer.InnerStatic is = new Outer.InnerStatic();
System.out.println(is.name);
```

# Lambda Expression

```java
@FunctionalInterface
interface MyFunction{
    int function(int x, int y);
}

MyFunction f = (x, y) -> {return x + y;};
f.function(10, 20);
```

# Collection

#### HashMap

```java
HashMap<Key, Value> map = new HashMap<>();          // 초기값 지정하지 않고 생성
HashMap<Key, Value> map = new HashMap<>(){{
put(Key, Value);
put(Key, Value);
}};                                                 // 초기값 지정하여 생성
value       = map.put(key, value);                  // (key, value) 넣기, key가 이미 있으면 갱신, 이전 value 반환, 이전 value가 없으면 null 반환
void        = map.clear();                          // 모든 값 삭제
value       = map.get(key);                         // value 얻기, 없으면 null 반환
boolean     = map.containsKey(key);                 // key가 있는지 확인
boolean     = map.containsValue(value);             // value가 있는지 확인
value       = map.remove(key);                      // (key, value) 제거, value 반환, 없으면 null 반환
int         = map.size();                           // 크기 반환
boolean     = map.isEmpty()                         // map이 크기가 0인지 확인
Set         = map.keySet();                         // 모든 key 반환
Collection  = map.values();                         // 모든 value 반환
for (Map.Entry entry : map.entrySet()) {            // map 순회
key         = entry.getKey();
value       = entry.getValue();}
```

#### LinkedHashMap

```java
LinkedHashMap<Key, Value> map = new LinkedHashMap<>();
LinkedHashMap<Key, Value> map = new LinkedHashMap<>(){{
put(key, value);
put(key, value);
}};

// HashMap과 동일
// 입력된 순서대로 데이터 저장
```

#### TreeMap

```java
TreeMap<Key, Value> map = new TreeMap<>();
TreeMap<Key, Value> map = new TreeMap<>(Collections.reverseOrder());
TreeMap<Key, Value> map = new TreeMap<>(){{
put(key, value);
put(key, value);
}};

// HashMap과 동일
// 오름차순 순서대로 데이터 저장
```

#### HashSet

```java
HashSet<Element> set = new HashSet<>(Arrays.asList(element1, element2));    // 초기값 지정하여 생성
HashSet<Element> set = new HashSet<>();                                     // 초기값 지정하지 않고 생성
boolean             = set1.retainAll(set2);                                 // 교집합, set1이 바뀌었으면 true, 아니면 false
boolean             = set1.addAll(set2);                                    // 합집합, set1이 바뀌었으면 true, 아니면 false
boolean             = set1.removeAll(set2);                                 // 차집합, set1 - set2, set1이 바뀌었으면 true, 아니면 false
boolean             = set1.containsAll(set2);                               // set1이 set2를 포함하면 true, 아니면 false
boolean             = set.add(element);                                     // element를 set에 넣기, 넣어지면 true, 이미 있었으면 false
void                = set.clear();                                          // element 전부 삭제
boolean             = set.remove(element);                                  // elemenet 삭제, 삭제됬는지 반환
int                 = set.size();                                           // 크기 반환
boolean             = set.isEmpty();                                        // set이 비어있는지 확인
boolean             = set.contains(element);                                // element가 있는지 확인
Iterator iterator   = set.iterator();                                       // set 순회
while(iterator.hasNext()){
element             = iterator.next();}
int[]               = set.stream().mapToInt(i -> i).toArray();              // HashSet<Integer> -> int[]로 바꾸기
```

#### TreeSet

```java
TreeSet<Element> set = new TreeSet<>(Arrays.asList(element1, element2));
TreeSet<Element> set = new TreeSet<>();
TreeSet<Element> set = new TreeSet<>(Collections.reverseOrder());
int[]                = set.stream().mapToInt(i -> i).toArray();             // TreeSet<Integer> -> int[]로 바꾸기

// HashSet과 동일
// 오름차순 순서대로 데이터 저장
```

#### LinkedHashSet

```java
LinkedHashSet<Element> set = new LinkedHashSet<>(Arrays.asList(element1, element2));
LinkedHashSet<Element> set = new LinkedHashSet<>();
int[]                      = set.stream().mapToInt(i -> i).toArray();   // LinkedHashSet<Integer> -> int[]로 바꾸기

// HashSet과 동일
// 입력된 순서대로 데이터 저장
```

#### Stack

```java
Stack<Element> stack = new Stack<>();
element             = stack.push(element);                          // element stack에 넣기
element             = stack.pop();                                  // element stack에서 빼기, stack이 비어있으면 Exception
element             = stack.peek();                                 // stack에 가장 나중에 들어간 element 반환, 존재하지않으면 Exception
void                = stack.clear();                                // stack에 있는 모든 element 지우기
int                 = stack.size();                                 // stack의 크기 반환
boolean             = stack.empty();                                // stack이 비어있는지 확인
boolean             = stack.contains(element);                      // element가 있는지 확인
Iterator iterator   = stack.iterator();                             // stack 순회(stack에서 나오는 순서가 아니라 들어간 순서)
while(iterator.hasNext()){
element             = iterator.next();}
int[]               = stack.stream().mapToInt(i -> i).toArray();    // Stack<Integer> -> int[]로 바꾸기
```

#### ArrayList

```java
ArrayList<Element> list = new ArrayList<>();
ArrayList<Element> list = new ArrayList<>(Arrays.asList(element1, element2));
preelement          = list.set(index, element);                     // index에 value 바꾸기
boolean             = list.add(element);                            // value 추가, list가 바뀌면 true
void                = list.add(index, element);                     // index에 value 추가, index를 벗어나면 Exception
element             = list.remove(index);                           // index에 있는 값 제거, 제거된 값 반환, index를 벗어나면 Exception
boolean             = list.remove(element);                         // 첫번째로 발생한 value 제거, value가 list에 있었다면 true 반환
void                = list.clear();                                 // list 초기화
int                 = list.size();                                  // list의 크기 반환
boolean             = list.isEmpty();                               // list가 비어있는지 확인, 비었으면 true 아니면 false
element             = list.get(index);                              // index에 있는 값 반환, index를 벗어나면 Exception
int                 = list.indexOf(element);                        // value가 있는 index 반환, 없으면 -1
boolean             = list.contains(element);                       // value가 있는지 검색, 있으면 true 없으면 false
Iterator iterator   = list.iterator();                              // list 순회
while(iterator.hasNext()){
element             = iterator.next();}
int[]               = list.stream().mapToInt(i -> i).toArray();     // ArrayList<Integer> -> int[]로 바꾸기
void                = list.sort(Comparator.naturalOrder());         // 오름차순 정렬
void                = list.sort(Comparator.reverseOrder());         // 내림차순 정렬
```

#### LinkedList

```java
LinkedList<Element> list = new LinkedList<>();
LinkedList<Element> list = new LinkedList<>(Arrays.asList(element1, element2));
void        = list.addFirst(element);                       // 가장 앞에 element 추가
void        = list.addLast(element);                        // 가장 뒤에 element 추가
element     = list.removeFirst();                           // 가장 앞의 값 제거, 비어있으면 Exception
element     = list.removeLast();                            // 가장 뒤의 값 제거, 비어있으면 Exception
element     = list.getFist();                               // 가장 앞의 값 반환, 비어있으면 Exception
element     = list.getLast();                               // 가장 뒤의 값 제거, 비어있으면 Exception
int[]       = list.stream().mapToInt(i -> i).toArray();     // LinkedList<Integer> -> int[]로 바꾸기

// Array List와 동일
// 요소 접근은 느리지만 요소 삽입, 삭제는 쉬움
```

#### Queue

```java
Queue<Element> queue = new LinkedList<>();
Queue<Element> queue = new LinkedList<>(Arrays.asList(element1, element2));
boolean                     = queue.add(element);                           // queue에 값 넣기, 실패시 exception
boolean                     = queue.offer(element);                         // queue에 값 넣기, 실패시 false 반환
element                     = queue.poll();                                 // queue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
element                     = queue.remove();                               // queue에 첫번째 값을 반환하고 제거, 비어있다면 exception
void                        = queue.clear();                                // queue 초기화
int                         = queue.size();                                 // queue의 크기 반환
boolean                     = queue.isEmpty();                              // queue가 비어있는지 확인, 비었으면 true 아니면 false
element                     = queue.peek();                                 // queue의 첫번째 값 반환, 비었으면 null 반환
boolean                     = queue.contains(element);                      // queue에 element가 포함됐는지 확인
element                     = queue.element();                              // queue의 첫번째 값 반환, 비었으면 exception
Iterator<Element> iterator  = queue.iterator();                             // queue 순회
while(iterator.hasNext()){
element                     = iterator.next();}
int[]                       = queue.stream().mapToInt(i -> i).toArray();    // LinkedList<Integer> -> int[]로 바꾸기
```

#### PriorityQueue

```java
PriorityQueue<Element> queue = new PriorityQueue<>();                                   // 낮은 숫자가 우선순위가 높음
PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 높은 숫자가 우선순위가 높음
PriorityQueue<Element> queue = new PriorityQueue<>(Arrays.asList(element1, element2));
boolean                     = queue.add(element);                                       // queue에 값 넣기, 실패시 exception
boolean                     = queue.offer(element);                                     // queue에 값 넣기, 실패시 false 반환
element                     = queue.poll();                                             // queue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
element                     = queue.remove();                                           // queue에 첫번째 값을 반환하고 제거, 비어있다면 exception
void                        = queue.clear();                                            // queue 초기화
int                         = queue.size();                                             // queue의 크기 반환
boolean                     = queue.isEmpty()                                           // queue가 비어있는지 확인, 비었으면 true 아니면 false
element                     = queue.peek();                                             // queue의 첫번째 값 반환, 비었으면 null 반환
element                     = queue.element();                                          // queue의 첫번째 값 반환, 비었으면 exception
boolean                     = queue.contains(element);                                  // queue에 element가 포함됐는지 확인
Iterator<Element> iterator  = queue.iterator();                                         // queue 순회
while(iterator.hasNext())
element                     = iterator.next();
int[]                       = queue.stream().mapToInt(i -> i).toArray();                // LinkedList<Integer> -> int[]로 바꾸기
```

# Function

#### Print

```java
System.out.print("");                   // 줄바꿈 없음
System.out.println("");                 // 줄바꿈 있음
System.out.printf("%d\n", 10);          // 10진수 정수
System.out.printf("%o\n", 10);          // 8진수
System.out.printf("%x\n", 10);          // 16진수
System.out.printf("%e\n", 12345678f);   // 지수형
System.out.printf("%c\n", 'A');         // 문자 한개
System.out.printf("%s\n", "ABC");       // 문자열
System.out.printf("%5d\n", 10);         // %[자릿수][타입]
System.out.printf("%05d\n", 10);        // %[공백타입][자릿수][타입]
System.out.printf("%f\n", 3.14f);       // 실수(float)
System.out.printf("%.2f\n", 3.14f);     // %[소수점앞 자릿수].[소숫점뒤 자릿수][타입]
System.out.printf("%f\n", 6.2489);      // 실수(double)
```

#### Integer

```java
String  = Integer.toBinaryString(int);      // int를 2진수 표현의 String으로 바꿔줌
String  = Integer.toOctalString(int);       // int를 8진수 표현의 String으로 바꿔줌
String  = Integer.toHexString(int);         // int를 16진수 표현의 String으로 바꿔줌
int     = Integer.parseInt(String);         // String을 int로 바꿔줌
int     = Integer.MAX_VALUE;                // 2^31-1
int     = Integer.MIN_VALUE;                // -2^31
```

#### Random

```java
import java.util.Random;

Random rand = new Random();
int         = rand.nextInt(int);        // 0 <= 정수 난수 < 매개변수
double      = rand.nextDouble(double);  // 0 <= 실수 난수 < 매개변수
```

#### Scanner

```java
import java.util.Scanner;

Scanner scan    = new Scanner(System.in);
String          = scan.next();          // 공백까지 입력 String 얻기
String          = scan.nextLine();      // Enter까지 입력 String 얻기
int             = scan.nextInt();       // 공백까지 입력 int 얻기
double          = scan.nextDouble();    // 공백까지 입력 double 얻기
void            = scan.close();
```

#### String

```java
int         = str.length();                                 // 길이 반환
boolean     = str.equals(String);                           // 같은지 확인
char        = str.charAt(int);                              // index 위치의 character 반환
String      = str.replaceAll(beforeString, afterString);    // before을 모두 after로 바꿈, 정규식 사용
String      = str.replace(beforeString, afterString)        // before을 모두 after로 바꿈, 정규식을 사용하지 않음
String      = str.replaceFirst(beforeString, afterString)   // // before을 after로 바꿈, 반복은 안됨
String      = str.substring(index1, index2);                // index1부터 index2-1까지 String 반환
int         = str.indexOf(String);                          // String으로 시작하는 시작 index 반환
String      = str.toUpperCase();                            // String을 대문자로 반환
String      = str.toLowerCase();                            // String을 소문자로 반환
String      = str.concat(str4);                             // 두개의 String을 연결
String[]    = str.split(String);                            // String을 구분자로 나누어 배열로 반환
String      = str.trim();                                   // 시작과 끝의 공백을 제거
boolean     = str.contains(String);                         // String을 포함하고 있는지 확인
String      = String.format("%d", int);                     // format에 맞는 String 생성
```

#### StringBuffer

```java
StringBuffer str    = new StringBuffer(String);
StringBuffer        = str.append(value);                    // 끝에 문자열 추가
StringBuffer        = str.insert(index, value);             // 중간에 문자열 추가
StringBuffer        = str.delete(start index, end index);   // 문자열 삭제
void                = str.setCharAt(index, char);           // index에 있는 char을 변환
String              = str.toString();                       // String으로 변환
```

#### StringBuilder

```java
StringBuilder str   = new StringBuilder(String);
StringBuilder       = str.append(value);                    // 끝에 문자열 추가
StringBuilder       = str.insert(index, value);             // 중간에 문자열 추가
StringBuilder       = str.delete(start index, end index);   // 문자열 삭제
void                = str.setCharAt(index, char);           // index에 있는 char을 변환
String              = str.toString();                       // String으로 변환
```

#### Character

```java
char[]  = str.toCharArray();            // String을 char array로 변환
char    = Character.isUpperCase(char);  // character가 대문자인지 확인
char    = Character.isLowerCase(char);  // character가 소문자인지 확인
char    = Character.toUpperCase(char);  // character을 대문자로 바꿈
char    = Character.toLowerCase(char);  // character을 소문자로 바꿈
```

#### Arrays

```java
import java.util.Arrays;
import java.util.Collections;

Arrays.sort(array);                                                     // array를 오름차순으로 정렬
Arrays.sort(array, Collections.reverseOrder());                         // array를 내림차순으로 정렬
System.arraycopy(src array, src index, dest array, dest index, length); // source array를 dest array에 copy (index부터 length길이까지)
array   = Arrays.copyOf(array, length);                                 // array를 length만큼 copy
array   = array.clone();                                                // array 복사
int     = array.length                                                  // array의 길이 반환
```

#### Math

```java
long    = Math.round(double);           // 반올림
double  = Math.ceil(double);            // 올림
double  = Math.floor(double);           // 내림
double  = Math.pow(double, double);     // a^b
double  = Math.sqrt(double);            // a^(1/2)
double  = Math.random();                // 0.0 ~ 0.999... 난수 생성
double  = Math.toRadians(double);       // degree에서 radian으로 바꿈
double  = Math.toDegrees(double);       // radian에서 degree로 바꿈
double  = Math.sin(double);             // sine 함수
double  = Math.cos(double);             // cosine 함수
double  = Math.tan(double);             // tangent 함수
number  = Math.abs(number);             // 절대값
number  = Math.max(number1, number2);   // 더 큰 값 반환
number  = Math.min(number1, number2);   // 더 작은 값 반환
```

#### Date

```java
import java.text.SimpleDateFormat;
import java.util.Date;

Date               date = new Date();                       // Date 반환
long                    = date.getTime();                   // timestamp 반환
SimpleDateFormat    sdf = new SimpleDateFormat(String);     // yyyy: year   // MM: month    // dd: day  // a: "AM", "PM"
                                                            // HH: hour 24  // hh: hour 12  // mm: minute
                                                            // mm: minute   // ss: second   // SS: milli second
String                  = sdf.format(Date);                 // 원하는 형식으로 날짜 반환
```

#### Calendar

```java
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

Calendar    cal = new GregorianCalendar(Locale.KOREA);
Date            = cal.getTime();                                        // Date 반환
long            = cal.getTimeInMillis();                                // timestamp 반환
void            = cal.add(Calendar.HOUR, int);                          // calendar에 저장된 날짜에 int값을 계산한 날짜 넣기

int             = cal.get(Calendar.YEAR);                               // 연도
int             = cal.get(Calendar.MONTH);                              // 월 (1월은 0, 2월은 1...)
int             = cal.get(Calendar.DAY_OF_MONTH);                       // 일
int             = cal.get(Calendar.DAY_OF_WEEK);                        // 요일 (일요일은 1, 월요일은 2...)
int             = cal.get(Calendar.WEEK_OF_YEAR);                       // 올해의 몇주차인지 반환
int             = cal.get(Calendar.WEEK_OF_MONTH);                      // 이달의 몇주차인지 반환
int             = cal.get(Calendar.HOUR);                               // 시 (12시간제)
int             = cal.get(Calendar.HOUR_OF_DAY);                        // 시 (24시간제)
int             = cal.get(Calendar.MINUTE);                             // 분
int             = cal.get(Calendar.SECOND);                             // 초
int             = cal.get(Calendar.MILLISECOND);                        // 밀리초

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");     // 원하는 날짜를 calendar에 넣기
String           str = "year-month-date hour:minute:second";
Date            date = sdf.parse(str);
void                 = cal.setTime(date);

void                 = cal.set(year, month(0~11), date);                // calendar 날짜 세팅하기
void                 = cal.set(year, month(0~11), date, hour(24), minute, second);
void                 = cal.set(Calendar.YEAR, year);
```

#### LocalDateTime

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Year;

LocalDateTime   = LocalDateTime.now();                                                          // 현재 시간으로 초기화
LocalDateTime   = LocalDateTime.now(ZoneId.of("Europe/Paris"));                                 // 영국 시간으로 초기화
LocalDateTime   = LocalDateTime.of(year, month, date, hour(24), minute, second, milisecond);    // 해당 시간으로 초기화
LocalDateTime   = LocalDateTime.parse("year-month-dateThour(24):minute:second.milisecond");
LocalDateTime   = Year.of(year).atMonth(month).atDay(date).atTime(hour(24), minute, second);

int             = localdatetime.getYear();                                                      // 연도 반환
Month           = localdatetime.getMonth();                                                     // 월 반환 (String과 유사)
int             = localdatetime.getMonthValue();                                                // 월 반환 (int)
int             = localdatetime.getDayOfMonth();                                                // 일 반환
int             = localdatetime.getHour();                                                      // 시 반환 (0~23)
int             = localdatetime.getMinute();                                                    // 분 반환
int             = localdatetime.getSecond();                                                    // 초 반환

LocalTime       = localdatetime.plusYears(int);
LocalTime       = localdatetime.plusMonths(int);
LocalTime       = localdatetime.plusDays(int);
LocalTime       = localdatetime.plusWeeks(int);
LocalTime       = localdatetime.plusHours(int);
LocalTime       = localdatetime.plusMinutes(int);
LocalTime       = localdatetime.plusSeconds(int);

LocalTime       = localdatetime.minusYears(int);
LocalTime       = localdatetime.minusMonths(int);
LocalTime       = localdatetime.minusDays(int);
LocalTime       = localdatetime.minusWeeks(int);
LocalTime       = localdatetime.minusHours(int);
LocalTime       = localdatetime.minusMinutes(int);
LocalTime       = localdatetime.minusSeconds(int);

// LocalDate과 LocalTime도 같음
```

#### Optional

```java
import java.util.Optional;

Optional opt    = Optional.ofNullable(value);               // null이면 Optional.empty를, 아니면 Optional[value]를 반환
Optional opt    = Optional.of(value);                       // Optional[value]를 반환, value가 null이 아니라고 확신할 때 사용
boolean         = opt.isPresent();                          // Optional[value]면 true, 아니면 false 반환
boolean         = opt.isEmpty();                            // Optional.empty면 true, 아니면 false 반환
value           = opt.get();                                // Optional[value]면 그 value를 반환, 아니면 Exception
T               = opt.orElse(replacement value);            // Optional.empty면 replacement value를, 아니면 value를 반환
Optional        = opt.filter((parameter) -> statement);     // Optional.empty면 Optional.empty로, Optional[value]이고 statement가 true이면 Optional[value]로,
                                                            // Optional[value]이고 statement가 false면 Optional.empty로 반환
Optional        = opt.map((parameter) -> statement);        // Optional.empty면 Optional.empty로, Optional[value]면 Optional[mapped value]로 변환
```

#### FileOutputStream / FileInputStream

```java
import java.io.FileOutputStream;
import java.io.FileInputStream;

FileOutputStream fos =  new FileOutputStream("./out.txt");  // 바이트 단위로 쓰기
String data = "문자열 쓰기\r\n";
fos.write(data.getBytes());
fos.close();

FileInputStream fis = new FileInputStream("./in.txt");      // 바이트 단위로 읽기
int data = 0;
do {
    data = fis.read();
    if (data != -1) {
        System.out.print((char)data);
    }
} while(data != -1);
fis.close();
```

#### FileWriter / FileReader

```java
import java.io.FileWriter;
import java.io.FileReader;

FileWriter fw = new FileWriter("./out.txt");    // 문자열 단위로 쓰기
fw.write("문자열 쓰기\r\n");
fw.close();

FileReader fis = new FileReader("./in.txt");    // 문자열 단위로 읽기
int data = 0;
do {
    data = fis.read();
    if (data != -1) {
        System.out.print((char)data);
    }
} while(data != -1);
fis.close();
```

#### BufferedWriter / BufferedWriter

```java
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

FileWriter fw = new FileWriter("./out.txt");    // 대용량 쓰기
BufferedWriter bw = new BufferedWriter(fw);
bw.write("문자열 쓰기\r\n");
bw.newLine();
bw.close();

FileReader fr = new FileReader("./in.txt");     // 대용량 읽기
BufferedReader br = new BufferedReader(fr);
String data = "";
do {
    data = br.readLine();
    if (data != null) {
        System.out.println(data);
    }
} while(data != null)
br.close();
```

# Socket

#### Socket Client

```java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket();                                                 // Socket
            socket.connect(new InetSocketAddress("127.0.0.1", 5001));                     // Connect

            OutputStream os = socket.getOutputStream();                                   // Write / Read
            InputStream is = socket.getInputStream();

            String sendString = "message";
            sendMessage(sendString, os);
            String receiveString = receiveMessage(is);
            System.out.println(receiveString);

            os.close();                                                                   // Close
            is.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("서버 접속 오류!");
        }
    }

    static void sendMessage(String sendString, OutputStream os) throws Exception {
        byte[] sendBytes = sendString.getBytes("UTF-8");
        os.write(sendBytes);
        os.flush();
    }

    static String receiveMessage(InputStream is) throws Exception {
        byte[] receiveBytes = new byte[1024];
        int receiveByteCount = is.read(receiveBytes);
        String receiveString = new String(receiveBytes, 0, receiveByteCount, "UTF-8");
        return receiveString;
    }
}
```

#### Socket Server

```java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket= new ServerSocket();                                // Socket
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 5001));                  // Bind

            while(true){
                Socket socket = serverSocket.accept();                                    // Accept

                InputStream is = socket.getInputStream();                                 // Read / Write
                OutputStream os = socket.getOutputStream();

                String receiveString = receiveMessage(is);
                System.out.println(receiveString);
                String sendString = "message";
                sendMessage(sendString, os);

                is.close();                                                               // Close
                os.close();
                socket.close();

                if (receiveString.equals("exit")){
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("서버 초기화 에러!");
        }
    }

    static void sendMessage(String sendString, OutputStream os) throws Exception {
        byte[] sendBytes = sendString.getBytes("UTF-8");
        os.write(sendBytes);
        os.flush();
    }

    static String receiveMessage(InputStream is) throws Exception {
        byte[] receiveBytes = new byte[1024];
        int receiveByteCount = is.read(receiveBytes);
        String receiveString = new String(receiveBytes, 0, receiveByteCount, "UTF-8");
        return receiveString;
    }
}
```

# MariaDB

#### MemberVO

```java
package MariaDB;

public class MemberVO {

    private int memberno;                       // 회원번호
    private String id;                          // 아이디
    private String name;                        // 이름

    public int getMemberno() {                  // memberno
        return memberno;
    }
    public void setMemberno(int memberno) {
        this.memberno = memberno;
    }

    public String getId() {                     // id
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {                   // name
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
```

#### MemberDAO

```java
package MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    Connection conn = null; // 데이터베이스 접속 객체
    Statement stmt = null;  // SQL 쿼리를 구현한 객체
    ResultSet rs = null;    // 쿼리에 대한 응답 레코드셋을 가져오는 객체

    // 생성
    public MemberDAO(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");       // MariaDB 드라이버 로드
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/mydb",   // Host
                    "root",                                 // 사용자
                    "1234"                                  // 암호
            );                                              // 데이터베이스 접속
        }catch (Exception e){
            e.printStackTrace();
            try {
                conn.close();
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        if( conn != null) {
            System.out.println("데이터베이스 접속 성공!!");
        }
    }

    // 회원 정보 추가
    public int insert(MemberVO vo){
        int result = 0;
        try{
            String sql = "INSERT INTO member (memberno, id, name) VALUES (" + vo.getMemberno() + ", '" + vo.getId() + "', '" + vo.getName() + "')"; // 세미콜론은 안넣음
            stmt = conn.createStatement();      // statement 만들기
            result = stmt.executeUpdate(sql);   // 쿼리 수행
        }catch(Exception e){ e.printStackTrace(); }
        return result;                          // 정상적이면 1 반환
    }

    // 회원 정보 수정
    public int update(MemberVO vo){
        int result = 0;
        try {
            String sql = "UPDATE member SET id = '" + vo.getId() + "', name = '" + vo.getName() + "' WHERE memberno = " + vo.getMemberno();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }

    // 회원 정보 삭제
    public int delete(int memberno){
        int result = 0;
        try{
            String sql = "DELETE FROM member WHERE memberno = " + memberno;
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }

    // 회원 정보 전체 조회
    public List<MemberVO> list(){
        List<MemberVO> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM member";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                MemberVO vo = new MemberVO();
                vo.setMemberno(rs.getInt("memberno"));
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
                list.add(vo);
            }
        }
        catch (Exception e){ e.printStackTrace(); }
        return list;
    }

    // 회원 정보 조회
    public MemberVO selectOne(int memberno){
        MemberVO vo = new MemberVO();
        try{
            String sql = "SELECT * FROM member WHERE memberno = " + memberno;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                vo.setMemberno(rs.getInt("memberno"));
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
            }
        }catch(Exception e){ e.printStackTrace(); }
        return vo;
    }

    // 자원 해제
    public void close(){
        if(conn != null ){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
```

#### Main

```java
package MariaDB;

import java.util.List;

public class MemberMain {
    public static void main(String[] args) {

        MemberVO vo = null;
        MemberDAO dao = null;
        int r = 0;

        // 회원 정보 추가
        vo = new MemberVO();
        vo.setMemberno(0);
        vo.setId("gang");
        vo.setName("이강인");

        dao = new MemberDAO();
        r = dao.insert( vo );
        if( r > 0 ){ System.out.println("회원 정보 등록 성공!"); }

        // 회원 정보 조회
        vo = dao.selectOne(2);
        System.out.println("회원 정보 출력");
        System.out.println("회원번호 : " + vo.getMemberno());
        System.out.println("아이디 : " + vo.getId());
        System.out.println("이름 : " + vo.getName());

        // 회원 정보 수정
        vo.setMemberno(0);
        vo.setId("ho");
        vo.setName("호날두형");
        r = dao.update(vo);
        if( r > 0 ){ System.out.println("회원정보 수정 성공!"); }

        // 회원 정보 전체 조회
        System.out.println("회원 목록 조회");
        List<MemberVO> list = dao.list();
        for(int i=0; i<list.size(); i++){
            System.out.println("회원번호 : " + list.get(i).getMemberno());
            System.out.println("아이디 : " + list.get(i).getId());
            System.out.println("이름 : " + list.get(i).getName());
        }

        // 회원 정보 삭제
        r = dao.delete( 2 );
        if( r > 0 ){ System.out.println("회원 삭제 성공!"); }

        // 자원 해제
        dao.close();
    }
}
```
