// 다형성 사용 예
// 다형성이란? 하나의 객체가 여러 타입을 가질 수 있다.
// 부모 클래스의 객체 타입으로 자식 클래스의 타입(다운 캐스팅) 또는 부모 클래스의 타입(업캐스팅)을 가질 수 있다.
// Parent p는 Parent 객체를 가리킬수도, Child 객체를 가리킬 수도 있다.
// C는 B를 상속, B는 A를 상속했다. C = C + B + A

// 메소드 오버로딩: 매개변수를 다르게 함으로 메소드의 기능을 확장
// 메소드 오버라이딩: 재정의. 상속관계에서 부모 클래스의 메소드를 자식 클래스에서 재정의한다.

class People{
    void think(){
        System.out.println("생각한다.");
    }
}
class Man extends People{
    @Override
    void think() {
        System.out.println("남자가 생각한다.");
    }
    void soccer() {
        System.out.println("축구한다.");
    }
}
class Woman extends People{
    @Override
    void think() {
        System.out.println("여자가 생각한다.");
    }
    void makeUp() {
        System.out.println("화장한다.");
    }
}

public class ex088 {
    public static void main(String[] args) {
        // 1. 업캐스팅
        //    자식 클래스의 객체 주소를 부모 클래스 타입으로 변환
        People people = new Man();
        people.think(); //"남자가 생각한다" <-메소드 오버라이딩

        // 2. 다운캐스팅
        // 부모 클래스의 객체 주소를 자식 클래스 타입으로 변환
        ((Man)people).soccer();

        myFunc(new Man());
    }

    static void myFunc(People p) {
        // p는 Man인가? Woman인가? People인가?
        // 객체 타입을 확인하는 연산자: instance of 연산자
        // 맞으면 true, 틀리면 false

        if (p instanceof Man){
            System.out.println("Man 클래스입니다.");
            ((Man)p).soccer();
        }
        if (p instanceof Woman){
            System.out.println("Woman 클래스입니다.");
            ((Woman)p).makeUp();
        }
        if (p instanceof People){
            System.out.println("People 클래스입니다.");
            p.think();
        }

    }
}
