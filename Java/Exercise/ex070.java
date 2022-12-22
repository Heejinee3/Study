public class ex070 {

    // 메소드 오버로딩(Overloading): 메소드 확장
    // : 매개변수를 다르게 함으로 함수의 기능을 확장하는 것
    // 장점: 함수 이름을 계속 만들지 않고 같은 함수를 매개변수를 달리함으로 계속 사용 가능

    // 면접 질문
    // 1. Overloading vs. Overriding
    // 2. 추상화 클래스 vs. 인터페이스의 차이점


    public static void main(String[] args) {
        echo();
        echo(10);
        echo("홍길동");
        echo(10, "홍길동");
    }

    static void echo(){
        System.out.println("echo");
    }

    static void echo(int param){
        System.out.println("echo: " + param);
    }

    static void echo(String param){
        System.out.println("echo: " + param);
    }

    static void echo(int param1, String param2){
        System.out.println("echo: " + param1 + ", " + param2);
    }


}
