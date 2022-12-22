import java.util.Scanner;

// 연습문제 55-1.
// 혼자서 온도를 조절하는 보일러(Boiler)를 스레드로 설계해보자.
// Tread 클래스를 상속하여 만드시오.
// 실제 온도 변수 : int realTemp = 23; 초기값
// 설정 온도 변수 : int setTemp = 20; 초기값
// 설정 함수 : setSetTemp(int setTemp)
// 무한 루프를 돌면서: 실제 온도와 설정 온도를 출력하시오.
//                : 1초마다 내부 온도를 성정온도에 +/-1도씩 바꿀 수 있다.
// 출력값: 실제 온도: 23, 설정 온도: 20
//        실제 온도: 22, 설정 온도: 20
//        실제 온도: 21, 설정 온도: 20
//        실제 온도: 20, 설정 온도: 20
// setOutTemp(22);
//        실제 온도: 21, 설정 온도: 22
//        실제 온도: 22, 설정 온도: 22 빙고!

// 변수 이름 만드는 법
// 1. Camel Case: outTemp
// 2. UnderBar Case: out_temp OUT_TEMP(상수)
// 3. Dash Case: out-temp (변수이름에는 쓸 수 없고, 속성 이름이나 파일 이름)
class Boiler extends Thread{
    int realTemp = 23;
    int setTemp = 23;
    boolean isPowerOff = false;
    boolean showTemp = false;

    // 필드가 있는 생성자
    public Boiler(int realTemp){
        this.realTemp = realTemp;
        this.setTemp = realTemp;
    }

    // run() 메소드 오버라이드 - 재정의
    @Override
    public void run() {
        while(true){
            if (this.realTemp != this.setTemp)
                this.showTemp = true;

            if (this.showTemp == true){

                    System.out.println("실제 온도:" + this.realTemp + " 설정온도: " + this.setTemp);


                if (this.realTemp > this.setTemp) {
                    this.realTemp--;
                }
                else if (this.realTemp < this.setTemp) {
                    this.realTemp++;
                }
                else {
                    this.showTemp = false;
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }

            if (this.realTemp == this.setTemp && isPowerOff == true && this.showTemp == false)
                break;

        }
    }

    void setSetTemp(int setTemp){
        this.setTemp = setTemp;
    }

    void powerOff(){
        this.isPowerOff = true;
    }
}



public class ex100 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String manufact = "";
        int setTemp = 0;
        int realTemp = 23;



        while(true){
            System.out.println("Press 's' for setting temperature");
            System.out.println("Press 'o' for power off");
            manufact = scan.nextLine();

            if (manufact.equals("s")) {
                System.out.println("What temperature would you like to set it to?");
                setTemp = scan.nextInt();
                scan.nextLine();

                Boiler b = new Boiler(realTemp);
                b.start();
                b.setSetTemp(setTemp);
                b.powerOff();
                try {
                    b.join();
                }catch (Exception e){}
            }
            else if (manufact.equals("o")){
                System.out.println("Power Off...");
                break;
            }
            else{
                System.out.println("Please enter correct");
            }
        }



    }
}


