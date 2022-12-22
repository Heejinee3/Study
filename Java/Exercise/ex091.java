// 익명 객체(이름없는 객체 - Anonymous Object)
// : 일회성 메소드 재정의시 사용한다.
// : 한번 쓰고 버릴 코드는 굳이 이름을 붙여서 사용할 필요가 없다.

// 인터페이스 객체 생성
// 인터페이스이름 객체이름(참조변수) = new 인터페이스이름();
/*
인터페이스이름 객체 = new 인터페이스이름(){
    가상함수 메소드 재정의
}
*/
interface NormalCar{
    void run();
}

// 여러번 사용할거면, 클래스를 정의해서 사용
class SuperCar implements NormalCar{
    @Override
    public void run() {
        System.out.println("수퍼카가 달린다");
    }
}


public class ex091 {
    public static void main(String[] args) {
        SuperCar sc = new SuperCar();
        sc.run();

        // 일회성 익명(이름없는) 인터페이스 구현 객체 선언
        NormalCar nc = new NormalCar() {
            @Override
            public void run() {
                System.out.println("수퍼카가 한번 달린다");
            }
        };
        nc.run();


    }
}
