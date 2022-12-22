public class ex067 {

    // 함수안에서 함수 선언은 안됨!
    // static 메소드에서는 static 함수만 호출 가능!
    // static 정적: 프로그램 시작시 고정된 번지에 주소값을 설정하고, 프로그램 종료시까지 변경되지 않는 변수, 함수, 객체에 사용.
    // 용도: main 함수 호출시
    //    : 안정된 데이타를 유지하기 위해서
    // 동적데이터 - new/소멸이 자주 일어남

    static void printString(){
        System.out.println("하이~");
        return;
    }

    public static void main(String[] args) {
        System.out.println("main start~");
        printString();
        System.out.println("main end~");
    }
}
