public class ex015 {
    public static void main(String[] args) {

        // (우선순위 높음) 단항연산자 - 이항연산자 - 삼항연산자 - 대입연산자 (우선순위 낮음)
        int i = 3 * 2 + 10 / 5;
        i = (3 * 2) + (10 / 5);

        /*
        (우선순위 높음) 단항 - 산술 - 비교 - 논리 - 삼항 - 대입 (우선순위 낮음)
        단항 : ++ -- ! (타입) ~
        산술 : + - * / % << >> >>>
        비교 : < > <= >= == !=
        논리 : && || & | ^
        삼항 : ? :
        대입 : = += -= *= /=
        */

        int k = 10;
        k++;
        System.out.println(k);

        k--;
        System.out.println(k);

        boolean myBool = true;
        System.out.println(!myBool);
        System.out.println(!!myBool);

    }
}
