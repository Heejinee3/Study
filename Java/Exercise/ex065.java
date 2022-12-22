import java.util.Random;

public class ex065 {
    public static void main(String[] args) {
        // 연습문제 44-1.
        // 2차원 정수배열 nums를 행 3개, 열 3개로 만들고, 모든 행열에 값을 넣되,
        // 랜덤값 정수 1~100 사이의 값을 넣고, 전체를 순환하여 출력하시오.

        int [][] nums = new int[3][3];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = rand.nextInt(100) + 1;
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        // 연습문제 44-2.
        // 최소값과 최대값을 출력하시오.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;;

        for (int[] arrNum: nums){
            for (int num: arrNum) {
                if (min > num){
                    min = num;
                }
                if (max < num){
                    max = num;
                }
            }
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);

        // 연습문제 45-1.
        // 순돌이네 인쇄소
        // 3x3 2차원 정수배열에 아래와 같은 숫자가 들어있다면,
        // 0 1 0      공백 * 공백
        // 1 2 0   =>  *  +  공백
        // 1 0 0       *  공백 공백
        // 이렇게 출력이 된다.
        // 0 1 2
        // 1 2 0
        // 2 1 0 이렇게 들어가 있을때 출력결과를 표시하시오.

        int[][] nums2 = {{0, 1, 2},
                         {1, 2, 0},
                         {2, 1, 0}};

        for (int[] arrNum: nums2){
            for (int num: arrNum) {
                if (num == 0){
                    System.out.print("  ");
                }
                else if (num == 1){
                    System.out.print("* ");
                }
                else if (num == 2){
                    System.out.print("+ ");
                }
                else{
                    System.out.print("? ");
                }
            }
            System.out.println();
        }

    }
}
