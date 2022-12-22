import java.util.Random;

public class ex051 {
    public static void main(String[] args) {

        // 연습문제 31-1.
        // 철수가 주사위 1개를 계속해서(무한히) 던진다. 1~6사이의 랜덤값 발생!
        // 5가 나올때까지 계속해서 던지고, 주사위를 던진 시도횟수를 출력하시오.

        Random rand = new Random();
        int count = 0;
        for(;;){
            int dice = rand.nextInt(6) + 1;
            count++;
            System.out.print( dice+" " );
            if( dice == 5 ){
                System.out.println("stop!");
                System.out.println("던진 횟수는 "+count);
                break;
            }
        }

        // 연습문제 32-1.
        // 영희가 주사위 2개를 계속해서 던져서 두 주사위 숫자가 똑같을 때까지 던진다.
        // 영희는 몇번만에 성공할지 시도횟수를 출력하시오.

        count = 0;
        for(;;){
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            count++;
            System.out.print( dice1+":"+dice2+" " );
            if( dice1 == dice2 ){
                System.out.println("stop!");
                System.out.println("던진 횟수는 "+count);
                break;
            }
        }
    }
}