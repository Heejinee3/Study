import java.util.Random;

public class ex034 {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomInt = rand.nextInt(10); // 0~9 사이의 정수
        System.out.println(randomInt);

        System.out.println(Math.random()); // 0.0 ~ 0.9999....사이의 실수
        int randomInt2 = (int)(Math.random() * 10);
        System.out.println(randomInt2);

        // 연습문제 16-1.
        // Random 클래스를 이용하여, 로또번호 6개를 발생시켜 보자. 로또번호 1~45까지의 숫자 6개임.
        int lotto;
        for (int i = 0; i < 6; i++) {
            lotto = rand.nextInt(45) + 1;
            System.out.print(lotto + " ");
        }
        System.out.println();

        // 연습문제 16-2.
        // Math.random() 함수를 이용하여, 주사위 값 하나를 발생시키자. 주사위 1~6까지의 값임.
        int dice = (int)(Math.random() * 6) + 1;
        System.out.println(dice);

        // 연습문제 16-3.
        // 철수와 영희가 주사위 놀이를 하고 있다. 주사위 2개를 던져서, 두개 다 짝수가 나오면 철수 승! 두개 다 홀수가 나오면, 영희 승! 그외의 경우는 무승부!이다.
        // 게임의 결과를 출력하시오.
        int cheolsu = (int)(Math.random() * 6) + 1;
        int younghee = (int)(Math.random() * 6) + 1;
        System.out.println("철수: " + cheolsu);
        System.out.println("영희: " + younghee);

        if (cheolsu % 2 == 0 && younghee % 2 == 0)
            System.out.println("철수 승!");
        else if (cheolsu % 2 != 0 && younghee % 2 != 0)
            System.out.println("영희 승!");
        else
            System.out.println("무승부!");




    }
}
