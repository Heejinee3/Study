// 연습문제 49-1.
// 카페라는 객체를 클래스로 설계해보자
// 클래스 이름: Cafe
// 속성: menuCount    메뉴 갯수는 10개
// 행동: sale         출력값은 "커피를 판다"
// 클래스를 설계하고 객체를 생성해서 속성값을 출력하고 행동을 실행시켜보자.

class Cafe{
    int menuCount = 10;
    void sale(){
        System.out.println("커피를 판다.");
    }

}

// 연습문제 50-1.
// 당긍농장을 클래스로 설계해보자
// 클래스 이름: Farm
// 속성: carrot 당근의 개수 초기값은 0
// 행동: plant() 호출시마다 당근을 하나씩 생산하고, 속성 carrot++를 해준다.
//              호출시 "당근을 1개 생산했습니다."를 출력한다.
// 당근을 plant() 함수를 이용하여 5개를 생산한 후 당근 갯수를 출력하시오.

class Farm{
    int carrot = 0;
    void plant(){
        this.carrot++; // or carrot++;
        System.out.println("당근을 1개 생산했습니다.");
    }
}

public class ex073 {
    public static void main(String[] args) {

        Farm farm = new Farm();
        System.out.println("당근의 초깃값은 " + farm.carrot + "개 입니다.");

        for (int i = 0; i < 5; i++) {
            farm.plant();
        }

        System.out.println("당근의 총 생산량은 " + farm.carrot + "개 입니다.");

        for (int i = 0; i < 5; i++) {
            farm.carrot++;
        }

        System.out.println("당근의 총 생산량은 " + farm.carrot + "개 입니다.");

    }
}
