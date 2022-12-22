import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ex117 {
    public static void main(String[] args) {
        // 콜렉션: 리스트, 맵, 셋
        // 리스트: 순차적으로 나열된 데이터, 인덱스 있음, 추가/삭제 쉽다
        // 맵: 키(Key)와 값(Value)로 구성된 데이터, 순서 없음, 통신에 사용
        // 집합(세트): 중복된 데이터를 허용안함, 순서 없음, 집합 데이터 처리에 사용

        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("사임당");
        set.add("변사또");
        System.out.println(set);

        // 중복 허용을 하지 않기에 같은 데이터를 넣으면 추가 안됨
        boolean isAdded = set.add("홍길동");
        System.out.println(isAdded);
        System.out.println(set);

        // 전체 순환
        for (String name: set){
            System.out.println(name);
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // 집합 연산 - 교집합, 합집합, 차집합
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();
        setA.add(10);
        setA.add(20);
        setA.add(30);
        setB.add(30);
        setB.add(40);
        setB.add(50);

        // 교집합
        setC.addAll(setA);
        setA.retainAll(setB); // setA가 교집합으로 값 변경
        System.out.println(setA);
        setA.addAll(setC);

        // 합집합
        setA.addAll(setB);
        System.out.println(setA);
        setA.addAll(setC);

        // 차집합 (A-B)
        setA.removeAll(setB);
        System.out.println(setA);
        setA.addAll(setC);

        // 집합A가 집합B를 포함하고 있는가
        System.out.println(setA.containsAll(setB));





    }
}
