import java.util.Random;

public class ex055 {
    enum SRP {Sissors, Rock, Paper}

    public static void main(String[] args) {

        //연습문제 37-1.
        // 철수가 AI로봇과 가위바위보 게임을 한다.
        // 철수가 가위를 낼 확률은 1/10이고, 바위를 낼 확률은 5/10, 보를 낼 확률은 4/10이다.
        // AI로봇은 동일한 확률로 가위바위보를 낸다.
        // 철수가 이길 때까지 가위바위보 게임을 한다고 할때 과정과 결과를 출력하시오.

        Random rand = new Random();
        boolean infinLoop = true;

        while(true) {
            int cheolsuInt = rand.nextInt(10);
            int robotInt = rand.nextInt(10);
            SRP cheolsuSRP = SRP.Sissors;
            SRP robotSRP = SRP.Sissors;

            if (cheolsuInt == 0) {
                cheolsuSRP = SRP.Sissors;
                System.out.println("철수: 가위");
            } else if (cheolsuInt > 0 && cheolsuInt < 6) {
                cheolsuSRP = SRP.Rock;
                System.out.println("철수: 바위");
            } else if (cheolsuInt > 5 && cheolsuInt < 10) {
                cheolsuSRP = SRP.Paper;
                System.out.println("철수: 보");
            } else {
                System.out.println("오류발생");
                infinLoop = false;
            }

            if (robotInt == 0) {
                robotSRP = SRP.Sissors;
                System.out.println("로봇: 가위");
            } else if (robotInt > 0 && robotInt < 6) {
                robotSRP = SRP.Rock;
                System.out.println("로봇: 바위");
            } else if (robotInt > 5 && robotInt < 10) {
                robotSRP = SRP.Paper;
                System.out.println("로봇: 보");
            } else {
                System.out.println("오류발생");
                infinLoop = false;
            }

            switch (cheolsuSRP) {
                case Sissors:
                    switch (robotSRP) {
                        case Sissors:
                            System.out.println("무승부!");
                            break;
                        case Rock:
                            System.out.println("로봇 승!");
                            break;
                        case Paper:
                            System.out.println("철수 승!");
                            infinLoop = false;
                            break;
                        default:
                            System.out.println("오류발생");
                            infinLoop = false;
                            break;
                    }
                    break;
                case Rock:
                    switch (robotSRP) {
                        case Sissors:
                            System.out.println("철수 승!");
                            infinLoop = false;
                            break;
                        case Rock:
                            System.out.println("무승부!");
                            break;
                        case Paper:
                            System.out.println("로봇 승!");
                            break;
                        default:
                            System.out.println("오류발생");
                            infinLoop = false;
                            break;
                    }
                    break;
                case Paper:
                    switch (robotSRP) {
                        case Sissors:
                            System.out.println("로봇 승!");
                            break;
                        case Rock:
                            System.out.println("철수 승!");
                            infinLoop = false;
                            break;
                        case Paper:
                            System.out.println("무승부!");
                            break;
                        default:
                            System.out.println("오류발생");
                            infinLoop = false;
                            break;
                    }
                    break;
                default:
                    System.out.println("오류발생");
                    infinLoop = false;
                    break;
            }
            if (infinLoop == false) { // loop 빠져나오기
                break;
            }
        }


    }
}
