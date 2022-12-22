import java.util.LinkedList;

public class ex114 {
    public static void main(String[] args) {
        // LinkedList
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        System.out.println(nums);
        nums.add(0,40);
        System.out.println(nums);

        // 차별화된 함수들
        System.out.println(nums.getFirst());
        System.out.println(nums.getLast());

        // 자료구조(알고리즘)에서 사용하는 함수들
        System.out.println(nums.peek());
        System.out.println(nums);

        System.out.println(nums.poll()); // 왼쪽 요소 반환 후 삭제
        System.out.println(nums);

        nums.push(50); // 왼쪽 요소 추가
        System.out.println(nums);

        System.out.println(nums.pop()); // 왼쪽 요소 반환 후 삭제
        System.out.println(nums);
    }
}
