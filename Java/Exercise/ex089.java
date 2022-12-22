// 기술 면접: 자바, 통신, DB, JSP, 스프링, 프레임워크, 포폴(팀작업, 본인역할, 프론트, 백엔드, 통신, DB, 배포)
// 자바
// 1. 메소드 오버로딩 vs. 오버라이딩
// 2. 상속
// 3. 생성자함수
// 4. 다형성
// 5. 추상화 클래스 vs. 인터페이스

// 추상화 클래스(abstract class)
// : 일반 클래스 + 가상 함수(메소드)
// 가상함수 : 선언만 있고 코드 본체는 없는 함수
//         : 본체는 하위 클래스에서 재정의해서 사용

// 가상 함수(추상화 메소드)를 사용하는 이유
// 1. 설계와 구현 관점에서 생각하면 됨
// 설계: 건축에서 설계 사무소의 역할, 단시간에 전체 구조와 기능 명세를 설계
// 구현: 건축에서 시공사의 역할, 실질적인 기능은 코더가 구현한다.
// 2. 기능을 정의하고 실제 구현은 나중에 한다.
//
// 그림을 그린다 -> 동양화를 그린다
//             -> 서양화를 그린다
// paint() 정의 -> paint(){ 동양화 or 서양화 }

// 추상화 클래스
abstract class Picture{
    // 가상 함수 (추상화 메소드)
    abstract void draw(); // 선언만 있고 코드 본체가 없다.
    // 일반 함수
    public void sale(){
        System.out.println("그림을 판다");
    }
}

// 일반 클래스와 추상화 클래스는 다중 상속 불가
// 다중 상속: 한번에 여러 클래스를 상속받는 것 C와 B -> A
// 다단계 상속: 여러번 걸쳐 상속받는 것 C -> B, B -> A
class Picasso extends Picture{
    @Override // 메소드 재정의
    void draw() {
        System.out.println("피카소 그림을 그린다");
    }
}

// 다단계 상속
class A{

}
class B extends A{

}
class C extends B{

}
// 다중 상속: 일반 + 추상화 클래스에서는 불가하지만, 인터페이스는 가능
/*
class D extends A, B, C{
}
*/
public class ex089 {
    public static void main(String[] args) {
        Picasso p = new Picasso();
        p.draw();
    }

}
