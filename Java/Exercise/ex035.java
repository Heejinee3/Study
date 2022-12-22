import java.util.Random;

public class ex035 {
    public static void main(String[] args) {

        // 연습문제 17-1.
        // 오늘 날씨 예측에 따른 출력문을 작성해 봅시다.
        // 랜덤수를 0~4까지 발생시켜 0이면 "맑음", 1이면 "흐림", 2이면 "비가 옴", 3이면 "눈이 옴", 4이면 "안개가 낌"이라고 출력하시오.
        Random rand = new Random();
        int i = rand.nextInt(5);
        if (i == 0)
            System.out.println("맑음");
        else if (i == 1)
            System.out.println("흐림");
        else if (i == 2)
            System.out.println("비가 옴");
        else if (i == 3)
            System.out.println("눈이 옴");
        else if (i == 4)
            System.out.println("안개가 낌");
        else
            System.out.println("그 외의 날씨입니다");

        // 연습문제 18-1.
        // 철수와 영희가 주사위 게임을 하고 있다. 주사위 2개를 철수가 한번 던지고, 영희가 또 한번 던진다.
        // 첫번째 주사위는 십의 자릿수로하고, 두번째 주사위는 일의 자릿수로 해서 더 높은 점수를 가진 사람이 승리한다.
        // 출력값: 철수 주사위1 수: 1
        //        철수 주사위2 수: 3
        //        철수의 점수는 13
        //        영희 주사위1 수: 3
        //        영희 주사위2 수: 4
        //        영희의 점수는 34
        //        영희 승!

        int cheolDice1 = rand.nextInt(6) + 1;
        int cheolDice2 = rand.nextInt(6) + 1;
        int youngDice1 = rand.nextInt(6) + 1;
        int youngDice2 = rand.nextInt(6) + 1;

        int cheolScore = cheolDice1 * 10 + cheolDice2;
        int youngScore = youngDice1 * 10 + youngDice2;

        System.out.println("철수 주사위1 수 " + cheolDice1);
        System.out.println("철수 주사위2 수 " + cheolDice2);
        System.out.println("철수의 점수는 " + cheolScore);
        System.out.println("영희 주사위1 수 " + youngDice1);
        System.out.println("영희 주사위2 수 " + youngDice2);
        System.out.println("영희의 점수는 " + youngScore);

        if (cheolScore > youngScore){
            System.out.println("철수 승!");
        }
        else if (cheolScore < youngScore){
            System.out.println("영희 승!");
        }
        else{
            System.out.println("무승부!");
        }

    }
}
