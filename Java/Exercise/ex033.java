import java.util.Scanner;

public class ex033 {
    public static void main(String[] args) {

        // 연습문제 14-1.
        // Scanner을 이용하여, 0~100까지 임의의 정수를 입력받고 입력받은 정수가 70 이상이면, "70이상입니다~"를 출력하고
        // 70 미만이면, "70 미만입니다~"라고 출력하시오.

        Scanner scan    = new Scanner(System.in);
        int i = scan.nextInt();

        if (i >= 70) System.out.println("70이상입니다~");
        else System.out.println("70미만입니다~");

        // 연습문제 15-1.
        // Scanner을 이용하여, 0~100까지 임의의 정수를 입력받고 입력받은 정수가
        // 90 이상이면, "90이상입니다."
        // 80 이상이면, "80 이상입니다."
        // 70 이상이면, "70이상입니다."
        // 그외의 수이면 "70미만의 수입니다." 라고 출력하시오.
        i = scan.nextInt();

        if (i >= 90) System.out.println("90이상입니다~");
        else if (i >= 80) System.out.println("80이상입니다~");
        else if (i >= 70) System.out.println("70이상입니다~");
        else System.out.println("70미만입니다~");

        scan.close();

    }
}
