public class ex056 {
    public static void main(String[] args) {

        int i = 10;
        int[] arrayNum1 = {10, 20, 30};
        System.out.println(arrayNum1[0]);
        System.out.println(arrayNum1[1]);
        System.out.println(arrayNum1[2]);

        for (i = 0; i < 3; i++){
            System.out.println(arrayNum1[i]);
        }

        System.out.println(arrayNum1.length);

        // 연습문제 38-1.
        // 배열의 모든 요소값을 출력하시오.
        int[] nums = {10, 30, 20, 50, 40};
        int sum = 0;

        for (i = 0; i < nums.length; i++){
            System.out.println((i+1) + "번째 요소: " + nums[i]);
        }

        // 연습문제 38-2.
        // 배열의 값 갯수를 출력하시오.
        System.out.println("배열의 요소는 총 " + nums.length + "개 입니다.");

        // 연습문제 38-3.
        // 배열의 모든 값의 합계를 출력하시오.
        for (i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        System.out.println("합계는 " + sum + "입니다.");

        // 연습문제 38-4.
        // 배열에서 20은 몇번째에 위치하는지 출력하시오.
        for (i = 0; i < nums.length; i++){
            if (nums[i] == 20)
                System.out.println("20은 " + (i + 1) + "번째에 있습니다.");
        }

        // 향상된 for문
        for (int item: nums){
            System.out.println(item);
        }
    }
}
