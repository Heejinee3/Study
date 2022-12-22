// static 클래스 안에서의 변수/함수에 대해서
// static 예약어 : 정적 변수/함수를 지정할 때 사용
// static 의미: 프로그램 구동시에 고정된 메모리 번지에 들어감(Load).
//             프로그램 종료시까지 번지값이 바뀌지 않고, 소멸되지 않음.
// 장점 1. new 안해도 바로 사용 가능
//     2. 데이터를 안정적으로 저장하거나 사용할 수 있음
//     3. 자주 사용하는 유틸성 클래스(예. Math)에 사용함


class BallFactory{
    int ballCount = 100;
    void make() {
        this.ballCount++;
        System.out.println("축구공 만들기");
    }
}

class FoodFactory{
    static int foodCount = 200;
    static void make(){
        foodCount++;
        System.out.println("도시락 만들기");
    }
}

public class ex074 {
    public static void main(String[] args) {
        BallFactory objBall = new BallFactory();
        System.out.println(objBall.ballCount);
        objBall.make();

        // static 변수/함수는 new를 통해 객체를 생성하지 않더라도 프로그램 구동시에 이미 고정된 번지수에 객체 할당(적재)이 되어있음.
        System.out.println(FoodFactory.foodCount);
        FoodFactory.make();

    }
}
