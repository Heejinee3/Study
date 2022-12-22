// 클래스 객체 배열
class Snack{
    String name = "새우깡";

    public Snack(String name) {
        this.name = name;
    }
}

public class ex086 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        Snack[] snacks = new Snack[5];
        snacks[0] = new Snack("짱구");
        snacks[1] = new Snack("포카칩");
        snacks[2] = new Snack("허니버터칩");
        snacks[3] = new Snack("프링글스");
        snacks[4] = new Snack("엄마손쿠키");

        for(Snack snack: snacks){
            System.out.println(snack.name);
        }
    }
}
