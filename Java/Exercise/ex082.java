

class Robot{
    String color = "빨강";
    // 기본 생성자 함수(매개변수 없음)
    public Robot() {
        System.out.println("기본 생성자 함수");
    }

    // 매개변수가 있는 생성자 함수
    public Robot(String color){
        this.color = color;
        System.out.println("매개변수가 있는 생성자 함수");
    }
}

public class ex082 {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Robot robot2 = new Robot("흰색");
        System.out.println(robot2.color);
    }
}
