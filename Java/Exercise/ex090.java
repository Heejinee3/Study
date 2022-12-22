// 인터페이스( interface ) : 추상화클래스와 유사하게 가상함수가 있음.

//          추상화 클래스   인터페이스
// 1.가상함수  있음           있음
// 2.일반함수  있음           없음(가상함수만 있음)
// 3.예약어    absract class interface
//            extends       implements
// 4.다중상속  불가능         가능

interface Drawing {
    //일반함수 선언 안됨.
    //void sale(){ }

    //가상함수 선언
    abstract void draw();
    void sketch(); //abstract 예약어 생략 가능
}
interface Sketch{
    void paint();
}
class Painter implements Drawing, Sketch {
    @Override
    public void draw() {
        System.out.println("드로윙");
    }
    @Override
    public void sketch() {
        System.out.println("스케치");
    }
    @Override
    public void paint() {
        System.out.println("페인트");
    }
}

public class ex090 {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.draw();
        p.sketch();
        p.paint();
    }
}
