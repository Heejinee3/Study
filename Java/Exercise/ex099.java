class Printer3 implements Runnable{
    int count = 0;
    String name = "노브랜드";

    public Printer3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this.name + (count++));
            if (count > 10)
                break;
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}

public class ex099 {
    public static void main(String[] args) {
        Printer3 p1 = new Printer3("우리집 프린터");
        Thread t1 = new Thread(p1);
        t1.start();

        Printer3 p2 = new Printer3("우리집 프린터");
        Thread t2 = new Thread(p2);
        t2.start();
    }
}
