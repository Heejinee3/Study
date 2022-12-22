import java.util.Random;

public class ex036 {
    public static void main(String[] args) {
        /*
        switch문
        switch(정수형 변수){
            case 정수값1:
                수행문1;
            break;
            case 정수값2:
                수행문2;
            default:
                수행문3;
            break;
        }
        */

        int i = 10;
        switch (i){
            case 10:
                System.out.println("10입니다.");
                break;
            case 20:
                System.out.println("i값은 20입니다.");
                break;
            default:
                System.out.println("그 외의 값입니다.");
                break;
        }

        // 연습문제 19-1.
        // 달을 나타내는 랜덤수 1~12까지의 정수를 발생시켜, 3, 4, 5이면 봄, 6, 7, 8이면 여름, 9, 10, 11이면 가을, 12, 1, 2이면 겨울이라고 출력하시오.
        Random rand = new Random();
        int month = rand.nextInt(12) + 1;
        switch (month){
            case 3: case 4: case 5: // case 3, 4, 5: <-- java 14버전부터 가능
                System.out.println("봄");
                break;
            case 6: case 7: case 8:
                System.out.println("여름");
                break;
            case 9: case 10: case 11:
                System.out.println("가을");
                break;
            case 12: case 1: case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("오류 발생");
                break;
        }

    }
}
