import java.util.Scanner;

public class ex020 {
    public static void main(String[] args) {

        // 연습문제 8-1.
        // 콘솔로부터 3.141592를 입력받고 소숫점 첫째자리에서 반올림하시오.

        Scanner scan = new Scanner(System.in);
        System.out.println("3.141592를 입력하세요.");
        double doubleInput = scan.nextDouble();
        System.out.println("첫째자리에서 반올림: " + Math.round(doubleInput));

        // 연습문제 8-2.
        // 콘솔로부터 3.141592를 입력받고 소숫점 첫째자리에서 올림하시오.

        System.out.println("첫째자리에서 올림: " + (int)Math.ceil(doubleInput));

        // 연습문제 8-3.
        // 콘솔로부터 3.141592를 입력받고 소숫점 첫째자리에서 버림하시오.

        System.out.println("첫째자리에서 버림: " + (int)Math.floor(doubleInput));

        // 연습문제 8-4.
        // 콘솔로부터 3.561를 입력받고 소숫점 둘째자리에서 반올림하시오.

        System.out.println("3.561를 입력하세요.");
        doubleInput = scan.nextDouble();
        System.out.println("둘째자리에서 반올림: " + Math.round(doubleInput * 10.0)/10.0);

        // 연습문제 8-5.
        // 콘솔로부터 3.561를 입력받고 소숫점 둘째자리에서 올림하시오.
        System.out.println("둘째자리에서 올림: " + Math.ceil(doubleInput * 10.0)/10.0);

        // 연습문제 8-6.
        // 콘솔로부터 3.561를 입력받고 소숫점 둘째자리에서 버림하시오.
        System.out.println("둘째자리에서 버림: " + Math.floor(doubleInput * 10.0)/10.0);

        scan.close();

    }
}
