import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ex113 {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> nums3 = new ArrayList<>(10);
        ArrayList<Integer> nums4 = new ArrayList<>(nums1);
        ArrayList<Integer> nums5 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(nums5);

        for(int i = 0; i < nums5.size(); i++){
            System.out.println(nums5.get(i));
        }
        for (Integer num: nums5){
            System.out.println(num);
        }

        // 이터레이터(Iterator): 열거자
        // 콜렉션(리스트, 맵, 셋)의 순차적인 처리를 도와주는 클래스
        // hasNext(): 다음 요소를 가지고 있는지 true/false로 반환
        // next(): 다음 요소값을 반환함
        Iterator<Integer> it = nums5.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // 값을 포함하는지 확인
        if (nums5.contains(30)){
            System.out.println("30을 포함함");
        }

        // 특정 요소의 인덱스 알아오기
        System.out.println(nums5.indexOf(40));



    }
}
