// final
// 1. 상수를 정의할 때 사용
// 2. 더이상 상속 불가한 마지막 클래스
class Bean{

}

final class CoffeeBean extends Bean{

}

// class JavaCoffeeBean extends CoffeeBeanBean  // final class는 상속 불가하기 때문에 사용 불가!

public class ex085 {
    public static void main(String[] args) {
        final Double PI = 3.141592;
    }
}
