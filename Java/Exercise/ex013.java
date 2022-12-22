import java.util.Scanner;

public class ex013 {
    public static void main(String[] args) {

        // 연습문제 7-1.
        // 콘솔로부터 10과 20을 입력받고, 두 수의 합산과 평균값을 출력하시오.

        Scanner scan = new Scanner(System.in);
        System.out.println("두 수를 입력하세요.");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int sum = num1 + num2;
        int avg = sum / 2;

        System.out.println("합산: " + sum);
        System.out.println("평균: " + avg);

        // 연습문제 7-2.
        // 콘솔로부터 3.14를 입력받고 소숫점을 제거한 3을 출력하시오.

        System.out.println("3.14를 입력하세요.");
        int num = (int)scan.nextDouble();
        System.out.println("출력: " + num);

        scan.close();

    }
}
