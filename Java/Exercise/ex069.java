public class ex069 {

    // 연습문제 46-1.
    // 함수이름: sum
    // 매개변수: int형 2개 (int a, int b)
    // 반환값: 두 매개변수의 합
    // 입력 예) 10, 20
    // 출력 예) 30
    static int sum(int a, int b){
        return a + b;
    }

    // 연습문제 46-2.
    // 함수이름: avr
    // 매개변수: int형 3개 (int a, int b)
    // 반환값: 세 매개변수의 평균값
    // 입력 예) 10, 20, 30
    // 출력 예) 20
    static double avr(int a, int b, int c){
        return (a + b + c) / 3.0;
    }

    // 연습문제 46-3.
    // 함수이름: vendingMachine
    // 매개변수: 금액 정수값 예) 1000
    // 반환값: 상품이름 예 ) "포카리스웨트"
    // 입력: 1000, 2000, 3000
    // 출력: 포카리스웨트, 콜라, 에너지드링크
    static String vendingMachine(int price){
        String item = "";

        if (price == 1000)
            item = "포카리스웨트";
        else if (price == 2000)
            item = "콜라";
        else if (price == 3000)
            item = "에너지드링크";
        else
            item = "정확한 금액을 입력하시오";

        return item;

    }



    public static void main(String[] args) {

        System.out.println(sum(10, 20));
        System.out.println(avr(10, 20, 30));

        System.out.println(vendingMachine(1000));
        System.out.println(vendingMachine(2000));
        System.out.println(vendingMachine(3000));

    }
}