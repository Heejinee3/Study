// 중첩클래스: 클래스 안에 클래스가 들어감
// 외부클래스(Outer): 클래스 밖에 클래스가 있음
// 내부 클래스(Inter): 클래스 안에 클래스가 있음

class Outer{
    String name = "outer";
    class Inner{
        String name = "inner";
    }
    static class InnerStatic{
        String name = "inner static";
    }
}

public class ex092 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.name);
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.name);
        Outer.InnerStatic is = new Outer.InnerStatic();
        System.out.println(is.name);
    }
}
