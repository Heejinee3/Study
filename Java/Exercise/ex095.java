// Math 클래스
// java.lang.Math 패키지에 있으므로 import 안해도됨

public class ex095 {
    public static void main(String[] args) {

        // 소수점 첫째자리에서 반올림
        double num = 91.789D;
        System.out.println(Math.round(num)); // 92

        // 연습문제 54
        // 소수점 둘째자리에서 반올림
        System.out.println(Math.round(num * 10.0)/ 10.0); // 91.8
        //소숫점 셋째자리에서 반올림
        System.out.println(Math.round(num * 100.0)/ 100.0); // 91.79

        double num2 = 91.128D;
        // 올림
        System.out.println(Math.ceil(num2)); // 92
        // 버림
        System.out.println(Math.floor(num2)); // 91

        // 각도 계산 - sin, cos, tan
        // 단위 2가지
        // 1. 일상생활 - 360분위: 0도, 180도, 360도
        // 2. 수학(컴퓨터)적 표현 - 라디안: 각도를 실수 1개로 표현한 것
        // 1 (rad) = 180/PI = 약 57.32

        //피타고라스 정리로 변의 길이 구하기
        //c = 루트( a*a + b*b )
        //             /|
        //            / |
        //         c /  | b
        //          +---+
        //            a

        double a = 10;
        double b = 10;
        double aa = Math.pow(a, 2);
        double bb = Math.pow(b, 2);
        double c = Math.sqrt(aa + bb);
        System.out.println(c);

        // toRadians(): 각도(degree)를 라디안으로 변경
        // toDegrees(): 라디안을 각도로 변경
        double b2 = c * Math.sin(Math.toRadians(45));
        System.out.println(b2);

        double a2 = c * Math.cos(Math.toRadians(45));
        System.out.println(a2);

        // 절대값 구하기
        double abs = Math.abs(-123);
        System.out.println(abs);

        //더 큰 값 구하기
        double max = Math.max(10, 20);
        System.out.println(max);

        //더 작은 값 구하기
        double min = Math.min(10,20);
        System.out.println(min);

        //랜덤값 가져오기(0.0 ~ 0.999..)
        System.out.println(Math.random());

        // 10이상 20이하 사이의 랜덤 정수 가져오기
        System.out.println(10 + (int)(11 * Math.random()));

    }
}
