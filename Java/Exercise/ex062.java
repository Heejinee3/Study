public class ex062 {
    public static void main(String[] args) {

        // 2. 선택정렬
        // 인덱스변수 minIndex에 최소값 인덱스를 설정하고, minIndex를 이용해서 맞교환하는 방식

        int[] nums = {9, 8, 1, 3, 2};
        int minIndex;

        for (int i = 0; i < nums.length-1; i++){
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        for (int i : nums){
            System.out.println(i);
        }


    }
}
