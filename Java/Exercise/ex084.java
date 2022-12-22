// 상속 관계에서 생성자가 호출되는 순서
class Energy{
    int price = 1000;

    public Energy() {
        System.out.println("Energy 기본생성자");
    }

    public Energy(int price) {
        this.price = price;
        System.out.println("Energy 매개변수생성자");
    }
}
class WindEnergy extends Energy{
    int price = 2000;

    public WindEnergy() {
        System.out.println("WindEnergy 기본생성자");
    }

    public WindEnergy(int price) {
        super(price);
        this.price = price;
        System.out.println("WindEnergy 매개변수생성자");
    }

}
// this 뒤에 점을 찍으면 자기 클래스의 변수, 메소드에 접근
// this() 함수를 호풀하면, 자기 클래스의 생성자 함수 호출
// super 뒤에 점을 찍으면, 부모 클래스의 변수, 메소드에 접근
// super() 함수를 호출하면, 부모 클래스의 생성자 함수 호출

public class ex084 {
    public static void main(String[] args) {
        // 부모 기본 생성자 -> 자식 기본 생성자 호출
        WindEnergy we = new WindEnergy();

        // 부모 기본 생성자 -> 자식 매개변수 생성자 호출
        WindEnergy we2 = new WindEnergy(3000);
    }
}
