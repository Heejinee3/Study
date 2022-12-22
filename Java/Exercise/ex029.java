public class ex029 {
    public static void main(String[] args) {

        // 삼항연산자 (조건절)? (A깂) : (B값)
        // 조건절이 true면 A값, false면 B값

        int n = true ? 10 : 20;
        System.out.println(n);

        int m = false? 10 : 20;
        System.out.println(m);

        int k = (10 < 20) ? (20 < 30 ? 20 : 30) : 20;
        System.out.println(k);

        if (false) m = 10;
        else m = 20;
        System.out.println(m);

    }
}
