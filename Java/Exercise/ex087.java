// 다형성 (Polymorphism: 폴리모피즘)
// 하나의 객체가 여러 자료형 타입을 가질 수 있는 것
// 부모 클래스의 타입이 자식 클래스의 타입을 가질 수 있다.

// 사용 이유:
// 하나의 객체 타입에서 여러 타입을 가질 수 있다
// 유연한 프로그램밍을 가능하게 해준다.
// 예: 자바의 모든 클래스는 Object를 상속한다.

class Parent{
    String name = "Parent";
    void parentMethod(){
        System.out.println("Parent 내 이름은 " + this.name);
    }
}
class Child extends Parent{
    String name = "Child";
    void childMethod(){
        System.out.println("Child 내 이름은 " + this.name);
    }
}
public class ex087 {
    public static void main(String[] args) {

        Child child = new Child();
        System.out.println(child.name);

        // 업캐스팅(자식 클래스의 객체가 부모 클래스의 타입을 가지는 것)
        // : 자식 클래스의 객체 주소를 부모 클래스 타입으로 전환
        // 1. new를 통해서
        Parent parent = new Child(); // Child + Parent
        System.out.println(parent.name);

        // 2. 형변환연산자를 통해서
        Parent parent2 = (Parent)child;
        System.out.println(parent2.name);

        // 다운캐스팅(부모 클래스의 타입을 자식 클래스의 타입으로 전환
        // : 부모 클래스의 객체 주소를 자식 클래스 타입으로 전환
        System.out.println(((Child)parent).name);

        // 4가지 형태
        Parent a = new Parent(); // 가능
        Child b = new Child(); // 가능
        Parent c = new Child(); // 가능 왜냐면 Child는 Parent를 상속
        // Child d = new Parent(); // 오류

    }
}
