// 람다식(Lambda Expression)
// JDK 1.8부터 지원하기 시작
// 일반 변수는 값을 담는다. 값변수: 실제값, 참조변수: 주소값
// 함수형 변수: 코드를 담는다, 함수: 코드의 선언/호출
// 3세대 언어인 JS, 코틀린, 스위프트, GO 언어들에서는 함수형 변수를 지원
// 자바에서 코드를 변수형태로 담아서 전달(매개변수)하기 위해 새롭게 설계
// 억지로 인터페이스 문법을 차용하여 사용한다
// 자바는 클래스와 객체에 변수+함수코드를 담고있지 때문에 객체를 전달하면 코드 전달을 할 수 있기에 람다식은 그다지 유용하지 않다.

// 람다식 선언: 함수형 인터페이스 형태로 선언
// 구현: -> 화살표 연산자를 이용

//@FunctionalInterface: 람다식 선언시에만 사용하는 어노테이션(컴파일 지시어)
@FunctionalInterface
interface MyFunc1{
    int calc(int x, int y);
}

@FunctionalInterface
interface MyFunc2{
    int calc(int x);
}

@FunctionalInterface
interface MyFunc3{
    void calc();
}


interface  MyInterface{
    void paint();
}

public class ex106 {
    public static void main(String[] args) {

        MyInterface i1 = new MyInterface() {
            @Override
            public void paint() {
                {
                    System.out.println("그림 그린다.");
                }
            }
        };

        MyFunc1 f1 = (x, y) -> {return x + y;};
        System.out.println(f1.calc(10, 20));

        execFunc(f1);

        MyFunc2 f2 = (x) -> {return x + x;};
        System.out.println(f2.calc(3));

        MyFunc3 f3 = () -> {System.out.println("Hello");};
        f3.calc();
    }
    static void execFunc(MyFunc1 f1){
        System.out.println(f1.calc(30, 40));
    }
}
