public class ex063 {
    public static void main(String[] args) {
        // 3. 삽입정렬
        // 인덱스 1(두번째)부터 정렬을 시작하고, 자기보다 왼쪽에 있는 값들과 비교하여, 더 작은 값이면 맞교환한다.
        // 인덱스를 가진 key값을 이용함
        int[] nums = {9, 8, 1, 3, 2};
        int key;
        for (int i = 1; i < nums.length; i++){
            key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }

        for (int num: nums){
            System.out.println(num);
        }
    }
}
