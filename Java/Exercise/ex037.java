import java.util.Random;

public class ex037 {
    public static void main(String[] args) {
        // 연습문제 20-1.
        // 애완용 똘이를 기쁘게 해줄 애완용 로봇을 프로그램해보자.
        // 코드 0: 음악을 틀어준다.
        // 코드 1: 간식을 준다.
        // 코드 2: 주인의 영상을 틀어준다.
        // 코드 3: 산책을 시켜준다.
        // 그외의 코드: 잘못된 코드입니다.
        // 랜덤수를 0 ~ 3까지 발생시켜, 코드에 맞는 출력문을 작성하시오.

        Random rand = new Random();
        int code = rand.nextInt(6);
        switch (code){
            case 0:
                System.out.println("음악을 틀어준다.");
                break;
            case 1:
                System.out.println("간식을 준다.");
                break;
            case 2:
                System.out.println("주인의 영상을 틀어준다.");
                break;
            case 3:
                System.out.println("산책을 시켜준다.");
                break;
            default:
                System.out.println("잘못된 코드입니다.");
                break;
        }

    }
}
