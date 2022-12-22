public class ex064 {
    public static void main(String[] args) {
        // 2차원 정수배열    1열 2열
        int[][] nums = { {10, 20},      // 1행
                         {30, 40} };    // 2행

        //                      행 열
        System.out.println(nums[0][0]);
        System.out.println(nums[0][1]);
        System.out.println(nums[1][0]);
        System.out.println(nums[1][1]);

        int[][] nums2 = new int[2][2];
        nums2[0][0] = 10;
        nums2[0][1] = 20;
        nums2[1][0] = 30;
        nums2[1][1] = 40;

        // 행 길이: 배열이름.length
        // 열 길이: 배열이름[행인덱스].length
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                System.out.println(nums[i][j]);
            }
        }

        // 향상된 for문으로 2차배열 순환
        for(int[] arrNum: nums) {
            for (int num: arrNum){
                System.out.println(num);
            }
        }

    }
}
