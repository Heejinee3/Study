public class ex059 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int temp = 0;
        temp = a;
        a = b;
        b = temp;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        int[] nums = {10, 30, 20, 50, 40};
        temp = nums[2];
        nums[2] = nums[1];
        nums[1] = temp;

    }
}
