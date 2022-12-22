import java.util.Random;
public class ex054 {
    // 열거형 enumerate
    // 선언은 함수 밖 + 클래스 안에서 해야함
    //            0         1       2
    enum Hero {Ironman, Superman, Batman}
    enum SRP {Sissors, Rock, Paper}


    enum Ball {Strike, Ball}

    public static void main(String[] args) {
        // 예시 if (ball == Ball.Strike)
        System.out.println(Hero.Ironman);
        System.out.println(Hero.Superman);
        System.out.println(Hero.Batman);

        System.out.println(Hero.Ironman.ordinal());
        System.out.println(Hero.Superman.ordinal());
        System.out.println(Hero.Batman.ordinal());

        Hero myHero = Hero.Ironman;
        if (myHero == Hero.Ironman){
            System.out.println("아이언맨입니다.");
        }

        switch (myHero){
            case Ironman:
                System.out.println("아이언맨!");
                break;
            case Superman:
                System.out.println("수퍼맨!");
                break;
            case Batman:
                System.out.println("베트맨!");
                break;
            default:
                System.out.println("그외의 값!");
                break;
        }

        // 연습문제 36-1.
        // 랜덤값 0, 1, 2를 발생시켜 0이면 가위, 1이면 바위, 2이면 보로 열거형변수를 설정한다.
        // switch 문장으로 가위, 바위, 보를 출력하시오.

        Random rand = new Random();
        int randomInt= rand.nextInt(3);

        SRP srp;

        if (randomInt == 0){
            srp = SRP.Sissors;
        }
        else if (randomInt == 1){
            srp = SRP.Rock;
        }
        else{
            srp = SRP.Paper;
        }

        switch (srp){
            case Sissors:
                System.out.println("가위!");
                break;
            case Rock:
                System.out.println("바위!");
                break;
            case Paper:
                System.out.println("보!");
                break;
        }



    }
}
