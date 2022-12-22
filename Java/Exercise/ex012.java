import java.util.Scanner;

public class ex012 {
    public static void main(String[] args) {
        // scan.nextInt(): 문자열을 입력받아 정수(int)로 반환
        // scan.nextFloat(): 문자열을 입력받아 실수(float)로 반환
        // scan.nextDouble(): 문자열을 입력받아 실수(double)로 반환
        Scanner scan = new Scanner(System.in);
        System.out.println("nextLine()으로 입력");
        String msg1 = scan.nextLine();
        System.out.println(msg1);

        // 버퍼메모리 공간이 clear 되지 않음
        // nextLine()을 한번 수행해 주면 해결
        System.out.println("next()으로 입력");
        String msg2 = scan.next();
        System.out.println(msg2);
        scan.nextLine();

        System.out.println("nextInt()으로 입력");
        int num1 = scan.nextInt();
        System.out.println(num1 * 2);

        System.out.println("nextDouble()으로 입력");
        double num2 = scan.nextDouble();
        System.out.println(num2 * 2);

        scan.close();

    }
}
