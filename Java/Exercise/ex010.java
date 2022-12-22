import java.util.Scanner;

public class ex010 {
    public static void main(String[] args) {

        // 연습문제 5-1.
        // Scanner 클래스를 이용하여, 사용자로부터 "java coding!" 이라는 문구를 입력받고 출력하시오.
        // 입력값 : "java coding!"
        // 출력값 : "java coding!"

        Scanner scan = new Scanner(System.in);

        System.out.println("java coding!을 입력하세요:");
        String strInput = scan.nextLine();
        System.out.println("입력: " + strInput);

        // 연습문제 5-2.
        // 사용자로부터 "대한" 문자열과 "민국"문자열을 2번 입력받고 "대한민국"이라고 출력하시오. (문자열 연결은 +)
        // 입력값1 : "대한"
        // 입력값2 : "민국"
        // 출력값 : "대한민국"

        System.out.println("대한민국을 입력하세요:");

        scan = new Scanner(System.in);
        strInput = scan.nextLine();
        strInput = strInput + scan.nextLine();

        System.out.println("입력: " + strInput);

        scan.close();

    }
}
