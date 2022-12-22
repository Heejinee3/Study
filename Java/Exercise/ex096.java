public class ex096 {
    public static void main(String[] args) {
        // 래퍼클래스(Wrapper Class)
        // 1. 기본 자료형 8개를 클래스로 감싸서 기능 추가
        // 2. 기본 자료형을 클래스(객체)로 만들어서 하나의 타입(Object)로 전달 가능

        // 기본 자료형 8개: int, long, short, byte, char, float, double, boolean
        // 래퍼 클래스: Integer, Long, Short, Byte, Character, Float, Double, Boolean
        // 숫자형 클래스 Number <= int, long, short, byte, float, double

        Integer intValue1 = new Integer(10);

        System.out.println(intValue1);
        System.out.println(intValue1.intValue());
        System.out.println(intValue1.doubleValue());

        // Deprecated: 이전 버전에서는 사용되었으나, 현재 버전에서는 사용되지 않는 함수나 클래스를 의미
        //              새로운 버전을 사용하도록 권고한다는 의미

        Integer intValue2 = 10;
        System.out.println(intValue2);

        //
        Number num1 = 30;
        Number num2 = 3.14D;
        System.out.println(num1.doubleValue());
        System.out.println(num2.intValue());
    }
}
