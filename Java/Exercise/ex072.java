// 클래스 class
// 객체지향프로그래밍(Object Oriented Programming)
// 모든 사물을 객체(물건)로 추상화(모델링)하여 프로그래밍하는 기법
// 속성(변수, 필드, 멤버변수)와 행동(메소드, 함수, 동작, 멤버함수)로 구분한다.
// class 이름: 첫글자는 영대문자로 쓴다.

class Car{
    int price = 1000;
    void run(){
        System.out.println("달린다.");
    }

}


public class ex072 {
    public static void main(String[] args) {
        Car objCar = new Car();
        System.out.println(objCar.price);
        objCar.run();

    }
}
