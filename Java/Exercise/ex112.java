import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ex112 {
    public static void main(String[] args) {
        // 데이터를 담는 그릇 - 데이터구조
        // 1. 변수
        // 2. 배열
        // 3. 리스트
        // 4. 맵
        // 5. 세트

        // 콜렉션 프레임워크: List, Map, Set
        // 1. 리스트(List)
        // List 인터페이스를 구현해서 ArrayList(일반), LinkedList(알고리즘기반) 클래스 사용
        // ArrayList: 순차적으로 데이터가 나열되어 있음
        // LinkedList: 다음 요소의 주소값을 이전 요소가 가지고 있음
        // 2. 맵(Map)
        // Map 인터페이스를 구현해서 HashMap 클래스 사용
        // 3. 집합(Set)
        // Set 인터페이스를 구현해서 HashSet 클래스 사용

        // 해쉬(HashCode): 내부 데이터간의 연결을 위한 유일한 키(정수)

        // ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println(fruits);
        fruits.add("수박");
        System.out.println(fruits);
        fruits.add("망고");
        System.out.println(fruits);
        fruits.add("딸기");
        System.out.println(fruits);

        // 인덱스 추가
        fruits.add(0, "레몬");
        System.out.println(fruits);
        fruits.add(1, "사과");
        System.out.println(fruits);

        // 삭제
        fruits.remove(1);
        System.out.println(fruits);

        // 오름차순 정렬
        Collections.sort(fruits);
        System.out.println(fruits);

        // 내림차순 정렬
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println(fruits);

        // 리스트 길이
        System.out.println(fruits.size());

        // 데이터 변경/치환
        fruits.set(1, "복숭아");
        System.out.println(fruits);

        // 전체 지우기
        fruits.clear();
        System.out.println(fruits);

        // 연습문제 57-1.
        // names라는 arrayList를 만들고
        ArrayList<String> names = new ArrayList<>();
        System.out.println("리스트 생성: " + names);

        // 연습문제 57-2.
        // "홍길동", "사임당", "이순신", "변사또" 추가하고,
        names.add("홍길동");
        names.add("사임당");
        names.add("이순신");
        names.add("변사또");
        System.out.println("4명 추가: " + names);

        // 연습문제 57-3.
        // 맨앞에 "춘향이" 추가하고
        names.add(0, "춘향이");
        System.out.println("춘향이 추가: " + names);

        // 연습문제 57-4.
        // "사임당"삭제하고
        names.remove("사임당");
        System.out.println("사임당 삭제: " + names);

        // 연습문제 57-5.
        // arrayList 갯수 size()함수를 이용하여 출력하고
        System.out.println("리스트 크기: " + names.size());

        // 연습문제 57-6.
        // "홍길동"을 "제임스"로 변경하시오. set함수
        names.set(1, "제임스");
        System.out.println("제임스로 변경: " + names);

        // 연습문제 57-7.
        // 오름차순 정렬하시오.
        Collections.sort(names);
        System.out.println("오름차순 정렬: " + names);

        // 연습문제 57-8.
        // 내림차순 정렬하시오.
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("내림차순 정렬: " + names);
    }
}
