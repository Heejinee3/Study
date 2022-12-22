public class ex007 {
    public static void main(String[] args) {

        /*
        숫자형 데이터 타입간의 형변환
        정수형 : long(8) > int(4) > short(2) > byte(1)
        실수형 : double(8) > float(4)

        형변환 공식 : 작은 정수형 -> 큰 정수형 (문제없음)
                    큰 정수형 -> 작은 정수형 (표현범위를 벗어나면 값 잘림)
                    실수형 -> 정수형( 값 잘림, 소숫점 날아감 3.14-> 3)
                    정수형 -> 실수형( 문제없음 3 -> 3.0 )

        자동(묵시적) 형변환 : 연산후에 자동 형변환이 됨.
        강제(명시적) 형변환 : 형변환 연산자 (타입)변수이름앞에 사용.

        자동 형변환 예시
        long * long = long
        long * int = long
        short * int = int
        float * int = float
        double * long = double
        long = int      long
        int = short     int
        float = int     float

        강제 형변환 예시
        작은 크기 타입 = (작은크기타입)큰크기타입
        short = (short)int
        int = (int)float
        */

        int intNum = 10;
        float floatNum = intNum;
        System.out.println(floatNum);

        System.out.println(floatNum * intNum);
        short shortNum = 5;
        System.out.println( shortNum * intNum );

        shortNum = 200;
        System.out.println(shortNum);
        byte byteNum = (byte)shortNum;
        System.out.println(byteNum); //-56 값 잘림 현상

        // 연습문제 3-1.
        // short형 변수 num1을 선언하고 10값을 넣어서 초기화 한다.
        // int형 변수 num2를 선언하고 20값을 넣어서 초기화 한다.
        // num1을 float형 변수 num3에 넣어서(대입) 자동형변환 시키자.

        short num1 = 10;
        int num2 = 20;
        float num3 = num1;
        System.out.println(num3);

        // 연습문제 3-2.
        // num2를 num1에 대입해서 강제 형변환 시킨 후 그 값을 출력하자.

        num1 = (short)num2;
        System.out.println( num1 );

        // 연습문제 3-3.
        // num3와 num2값을 곱하기 연산(*)한 후 자동 형변환 한 값을 출력하자.

        System.out.println( num3 * num2 );
        float num4 = num3 * num2;
        System.out.println( num4 );

    }
}
