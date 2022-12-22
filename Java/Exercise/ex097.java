// 스레드(Thread): 실, 실타레를 의미함
//              : 프로그램 안의 작은 프로그램을 의미함
//              : 메인 스레드 안에서 별도의 스레드를 생성하여 실행하는 것
// 예) 웹브라우저에서 네이버 화면을 보면서 다운로드도 함께 실행
//     백그라운드(UI가 없는 프로그램)로 돌면서 서비스를 수행

// 자바로 스레드를 구현하는 방법 2가지
// 1. 추상화 클래스를 상속하는 방법 - Thread
// 2. 인터페이스를 구현하는 방법 - Runnable

class Printer extends Thread{
    int count = 0;

    @Override
    public void run() {
        // super.run(); 지워준다
        // run() 함수는 1회만 호출되고 종료되므로 무한 루프를 만들어서 계속 실행되도록 한다
        while(true){
            System.out.println("Printer:" + count++);

            // 탈출조건
            if (count > 10){
                break;
            }
        }
    }
}


public class ex097 {
    public static void main(String[] args) {
        Printer p = new Printer();
        // Thread 클래스 안의 start 함수 실행: 스레드를 시작하는 함수
        p.start();
        System.out.println("메인 함수 종료");
    }
}
