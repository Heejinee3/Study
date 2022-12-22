import java.util.Random;

public class ex052 {
    public static void main(String[] args) {
        // 일정시간동안 프로세스(앱)을 멈추는 명령어
        // Thread.sleep() 함수
        // System.out.println(new Date()); //현재시간출력
        // try {
        //     Thread.sleep(3000);//3초
        // }catch(Exception e){ }

        //파일에서 찾기 (CTRL+SHIFT+F)
        //예제에서 필요한 내용찾기 예)++연산자

        // 연습문제 33-1.
        // 문자 야구게임을 만들어 보자. 4번타자가 타석에 들어섰다. 투수가 공을 던질때, 랜덤하게 던진다.
        // 스트라이크을 던지면 숫자 0, 볼을 던지면 숫자 1로 처리한다.
        // 볼 카운트와 스트라이크 카운트를 세서 볼카운트가 4개가 되면, "1루 진루!"라고 표시하고, 게임이 종료된다.
        // 스트라이크가 3개가 되면, "삼진 아웃!"라고 표시하고, 게임이 종료된다.
        // 공을 던지는 간격은 1초이다. Thread.sleep() 함수이용

        Random rand = new Random();
        int countBall = 0;
        int countStrike = 0;
        for(;;){
            int ball = rand.nextInt(2);
            if( ball == 0 ) { //스트라이크
                countStrike++;
                System.out.println("스트라이크");
            }else{ //볼
                countBall++;
                System.out.println("볼");
            }
            if(countStrike >= 3){
                System.out.println("삼진아웃!");
                break;
            }
            if(countBall >= 4 ){
                System.out.println("1루 진루!");
                break;
            }

            try {
                Thread.sleep(1000);//3초
            }catch(Exception e){ }

        }

    }
}