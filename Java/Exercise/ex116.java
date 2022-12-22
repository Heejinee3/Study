import java.util.*;

public class ex116 {
    public static void main(String[] args) {
        // 맵(Map): 키와 값으로 된 데이터 구조
        //        : Key(문자열형) - Value(객체, 기본 데이터형)
        //        : JSON, XML 데이터와 연결
        //        : 인덱스나 순서 없음
        // Hash: 해쉬 테이블을 이용한 Map 데이터 구조를 구현한 구현 클래스
        // Hash Table: 데이터를 빨리 검색하기 위한 데이터 구조
        Map<String, String> map = new HashMap<>();
        map.put("username", "hong"); // 아이디
        map.put("password", "1234"); // 비밀번호
        System.out.println(map);

        ArrayList<String> al = new ArrayList<>();
        al.add("a");
        al.add("b");
        al.add("c");
        System.out.println(al);

        System.out.println(map.get("username"));
        System.out.println(map.get("password"));

        // 전체 순환
        // 향상된 for문
        Set<String> keys = map.keySet();
        for (String key: keys){
            System.out.println(map.get(key));
        }

        //이터레이터를 이용
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(map.get(key));
        }

        // 연습문제 58-1.
        // 철수라는 학생이 데이타를 맵으로 설정해 보자.
        // map의 이름은 student라 하고
        // 키값 age : 값 20
        // 키값 height : 값 170
        // 키값 name : "배철수" 로 데이타를 설정후
        // 모든 Key Value를 출력하시오.
        // 향상 for문 사용
        Map<String, String> student = new HashMap<>();
        student.put("age", "20");
        student.put("height", "170");
        student.put("name", "배철수");

        System.out.println("*********** forloop ************");
        Set<String> keys2 = student.keySet();
        for (String key: keys2){
            System.out.print("key: " + key);
            System.out.println(" value: " + student.get(key));
        }

        // 연습문제 58-2.
        // 이터레이터를 이용
        System.out.println("*********** iterator ************");
        Iterator<String> it2 = keys2.iterator();
        while(it2.hasNext()){
            String key = it2.next();
            System.out.print("key: " + key);
            System.out.println(" value: " + student.get(key));
        }

        System.out.println("*********** Object ************");
        Map<String, Object> student2 = new HashMap<>();
        student2.put("age", 20);
        student2.put("height", 170);
        student2.put("name", "배철수");

        Integer age = (Integer)student2.get("age");
        Integer height = (Integer)student2.get("height");
        String name = (String)student2.get("name");


        Set<String> keys3 = student.keySet();
        for (String key: keys3){
            System.out.print("key: " + key);
            System.out.println(" value: " + student2.get(key));
        }





    }
}
