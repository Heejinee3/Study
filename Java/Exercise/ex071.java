public class ex071 {
    // 연습문제 47-1.
    // 메소드(함수) 이름: calc
    // 매개변수 정수형 1개일 때는 그냥 변수값만 출력

    // 연습문제 47-2.
    // 매개변수 정수형 2개일 때는 두 변수의 합계를 출력

    // 연습문제 47-3.
    // 매개변수 정수형 3개일 때는 세 변수 중에서 최대값을 출력하시오.
    static void calc(int a){
        System.out.println(a);
    }
    static void calc(int a, int b){
        System.out.println(a + b);
    }
    static void calc(int a, int b, int c){
        int max = (a > b)? a : b;
        max = (max > c)? max: c;
        System.out.println(max);
    }

    //연습문제 48 - 함수의 선언/호출   (오버로딩 안씀)
    // 메소드 이름 : compute
    // 반환형은 double값
    // 1. 매개변수1 : int type  입력값( 0 )
    //    매개변수2 : int param1
    //    매개변수3 : int param2
    //    반환값 : 사각형의 넓이를 반환함. 직사각형 넓이=밑변×높이

    // 2. 매개변수1 : int type 입력값( 1 )
    //    매개변수2 : int param1
    //    매개변수3 : int param2
    //    반환값 : 사각형의 넓이를 반환함. 삼각형 넓이=1/2밑변높이

    // 3. 매개변수1 : int type 입력값( 2 )
    //   매개변수2 : int param1
    //   반환값 : 원의 넓이를 반환함.  원의 넓이 = PI * 반지름의 2승

    // 4. 매개변수1 : int type 입력값( 3 )
    //    매개변수2 : int param1
    //    반환값 : 원의 둘레를 반환함. 원의 둘레 = 2 * PI * 반지름
    static double compute(int type, int param1, int param2){
        double result = -1;
        if (type == 0){
            result = param1 * param2;
        }
        else if (type == 1){
            result = (double)(param1 * param2) / 2.0;
        }
        else if (type == 2){
            result = Math.PI * param1 * param1;
        }
        else if (type == 3){
            result = 2 * Math.PI * param1;
        }

        return result;
    }


    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        calc(a);
        calc(a, b);
        calc(a, b, c);

        System.out.println("직사각형의 넓이는 " + compute(0, 3,5));
        System.out.println("삼각형의 넓이는 " +compute(1, 3,5));
        System.out.println("원의 넓이는 " + compute(2, 3, 5)); // 5는 필요없는 매개변수
        System.out.println("원의 둘레는 " + compute(3, 3, 5)); // 5는 필요없는 매개변수
    }
}
