import java.util.Scanner;

public class ex011 {
    public static void main(String[] args) {

        // Integer.parseInt(string) : string 타입을 int 타입으로 바꿈
        // String.valueOf(num) : int 타입을 string 타입으로 바꿈
        // ctrl + / : 한줄 주석 입력/해제
        Scanner scan = new Scanner(System.in);
        String strInput = scan.nextLine();
        int intInput = Integer.parseInt(strInput);

        System.out.println(intInput * 2);

        // 연습문제 6-1.
        // 콘솔로부터 "20"을 입력받고 정수형 변수 num1으로 변환한 후에 정수형 변수 num2에 5을 초기화한 후에 num1과 num2를 사칙연산한 결과를 출력하시오.
        // 입력값 : "20"
        // 출력값 : 덧셈 25
        //         뺄셈 15
        //         곱셈 100
        //         나눗셈 4

        System.out.println("20을 입력하세요.");
        strInput = scan.nextLine();
        int num1 = Integer.parseInt(strInput);
        int num2 = 5;

        System.out.println("덧셈: " + (num1 + num2));
        System.out.println("뺄셈: " + (num1 - num2));
        System.out.println("곱셈: " + (num1 * num2));
        System.out.println("나눗셈: " + (num1 / num2));

        scan.close();

    }
}
