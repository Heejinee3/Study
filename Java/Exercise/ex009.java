import java.util.Scanner;

public class ex009 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // scan.nextLine() : Enter을 치기 전까지의 입력값을 받고 string으로 반환
        System.out.println("문자열을 입력하세요:");
        String strInput = scan.nextLine();
        System.out.println("입력: " + strInput);

        // scan.close() : 메모리 할당 해제
        scan.close();
    }
}
