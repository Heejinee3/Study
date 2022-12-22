// 연습문제 51-1.
// 책상(Desk)을 클래스로 설계해보자.
// 속성: price 가격은 1000으로 초기화한다.(접근권한: private)
// 행동: Getter/Setter 함수를 만들어보자.
// 출력값: price를 2000으로 바꾸고 가격을 출력하시오.
// Getter/Setter 자동 생성: 우클릭 -> 생성 -> Getter/Setter

class Desk{
    private int price = 1000;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        // this: 자기클래스를 의미
        // super: 부모 클래스를 의미
        this.price = price;
    }
}


public class ex076 {
    public static void main(String[] args) {
        Desk desk = new Desk();
        System.out.println("처음 가격: " + desk.getPrice());
        desk.setPrice(2000);
        System.out.println("바뀐 가격: " + desk.getPrice());
    }
}
