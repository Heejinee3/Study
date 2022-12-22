public class ex005 {
    public static void main(String[] args) {

        /*
        기본타입 8가지
        정수형 : int(4)  long(8) short(2) byte(1) char(2)
        실수형 : double(8) float(4)
        논리형 : boolean(1)

        문자형 : char 문자한개를 담는 공간 (단따옴표)
        문자열형 : String 문자열을 담는 공간 (쌍따옴표)
        함수형 : 익명함수(람다식) 코드를 담는 공간
        객체형 : 클래스객체 코드를 담는 공간

        값 타입 변수   : 기본형 8개 - 고정된 크기의 값을 담는다.
        참조 타입 변수 : 문자열형, 함수형, 객체형 - 주소값을 담는다.
        */

        int myInt = 10;
        System.out.println(myInt);

        long myLong = 20L;
        System.out.println(myLong);

        short myShort = 30;
        System.out.println(myShort);

        byte myByte = 40; // 표현범위: -128 ~ 127
        System.out.println(myByte);

        char myChar = 'A';  //아스키코드표 A는 65이다.
        System.out.println( myChar );
        System.out.println( (int)myChar );
        char myHan = '가';
        System.out.println( myHan );
        System.out.println((int)myHan);
        System.out.printf("%x\n", (int)myHan);

        double myDouble = 6.24d; // d는 생략가능.
        System.out.println(myDouble);

        float myFloat = 3.14f;
        System.out.println(myFloat);

        boolean myBoolean = false;
        System.out.println(myBoolean);

        String myString = "홍길동1234";
        System.out.println( myString );

    }
}
