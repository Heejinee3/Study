public class ex060 {
    public static void main(String[] args) {

        int[] nums = {3, 25, 12, 45, 37};

        // 최소값/최대값 찾기
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 연습문제 40-1.
        // 최솟값 구하는 순서
        // 1. int min = 최대값으로 초기화
        // 2. 배열을 전체 순환하면서, min값보다 더 작은 값을 발견하면, 그 값을 min값으로 설정
        // 3. 순환이 종료되고 min 값을 출력한다.

        // 연습문제 41-1.
        // 최댓값을 출력하시오.

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // nums가 비어있는지 확인
        if (nums == null || nums.length == 0) {
            System.out.println("배열이 비어있음");
        }
        else{ // 최대값, 최소값 구하기
            for (int i : nums){
                if (min > i){
                    min = i;
                }
            }
            System.out.println("min: " + min);

            for (int i : nums){
                if (max < i){
                    max = i;
                }
            }
            System.out.println("max: "+ max);
        }

    }
}
