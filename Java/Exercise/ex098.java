// 스레드를 여러개 만들고, 비동기적으로 실행해보자
class Printer2 extends Thread{
    int count = 0;
    String name = "노브랜드";

    // 필드가 있는 생성자
    public Printer2(String name){
        this.name = name;
    }
    // run() 메소드 오버라이드 - 재정의

    @Override
    public void run() {
        while(true){
            System.out.println(this.name + (count++));
            if (count > 10){
                break;
            }
            try{
                if (this.name.equals("우리집 프린터") == true){
                    Thread.sleep(1000);
                }
                else {
                    Thread.sleep(500);
                }
            }catch (Exception e){}

        }
    }
}



public class ex098 {
    public static void main(String[] args) {

        Printer2 p1 =  new Printer2("우리집 프린터");
        p1.start();
        Printer2 p2 =  new Printer2("우리학원 프린터");
        p2.start();

    }
}
