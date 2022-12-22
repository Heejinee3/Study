public class ex030 {
    public static void main(String[] args) {
        // 대입연산자 =
        int i = 10;
        int j = 20;
        int k = 30;
        i = j = k = 40;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        // 복합대입연산자 += -= *= /= %= <<= >>=
        i = 0;
        i += 10;
        System.out.println(i);

        i -= 5;
        System.out.println(i);

        i *= 2;
        System.out.println(i);

        i /= 2;
        System.out.println(i);

    }
}
