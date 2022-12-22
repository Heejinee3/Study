//제너릭(Generic): 형(Type)에 따른 데이터 전송(타입 선언)을 편하게 하기 위해서
//              : 가변적인 타입의 선언을 위해서(상속과 상관없음)
//              : JDK 1.5버전부터 지원
// 주요 JDK 버전: 1.8(8버전) 11버전 17버전
// 기술면접: 제네릭의 기능은 무엇인가?

import java.awt.*;

class Keyboard1{
    // Object
    // : 모든 타입의 데이터를 담을 수 있음
    // : 단점이 다운 캐스팅을 꼭 이용해야 하위 클래스에 접근 가능

    private Object object;

    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
}

class Keyboard2<MyType>{
    // <MyType>은 가변타입으로 클래스타입 + 래퍼클래스타입이 다 들어감
    private  MyType object;

    public MyType getObject() {
        return object;
    }

    public void setObject(MyType object) {
        this.object = object;
    }
}

public class ex105 {
    public static void main(String[] args) {
        Keyboard1 k1 = new Keyboard1();

        k1.setObject("키보드1"); //String
        String str1 = (String)k1.getObject();
        System.out.println(str1);

        k1.setObject(10);
        Integer intObj = (Integer)k1.getObject();
        System.out.println(intObj);

        Keyboard2<String> k2 = new Keyboard2<String>();
        k2.setObject("키보드2");
        String str2 = k2.getObject();
        System.out.println(str2);

        Keyboard2<String> k3 = new Keyboard2<>();
        k3.setObject("키보드3");
        String str3 = k3.getObject();
        System.out.println(str3);

    }
}
