public class ex019 {
    public static void main(String[] args) {

        // 버림: 형변환 연산자 or Math.floor()
        // Math.floor(num): num의 버립값 반환
        double doubleFloor = 3.14;
        int intFloor1 = (int)doubleFloor;
        System.out.println(intFloor1);

        double intFloor2 = Math.floor(doubleFloor);
        System.out.println(intFloor2);

        // 반올림: (0.5+형변환 연산자) or Math.round()
        // Math.round(num): num의 반올림값 반환
        double doubleRound = 3.14;
        int intRound1 = (int)(doubleRound + 0.5);
        System.out.println(intRound1);

        double intRound2 = Math.round(doubleRound);
        System.out.println(intRound2);

        // 올림: (1.0+형변환 연산자) or Math.ceil()
        // Math.ceil(num): num의 올림값 반환
        double doubleCeil = 3.14;
        int intCeil1 = (int)(doubleCeil + 1.0);
        System.out.println(intCeil1);

        double intCeil2 = Math.ceil(doubleCeil);
        System.out.println(intCeil2);
    }
}
