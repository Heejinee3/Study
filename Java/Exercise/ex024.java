public class ex024 {
    public static void main(String[] args) {
        // 논리 연산자 : && || !

        // AND 논리표
        // T && T => T
        // F && T => F
        // T && F => F
        // F && F => F

        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        // OR 논리표
        // T || T => T
        // F || T => T
        // T || F => T
        // F || F => F

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        // 논리 반전 연산자
        // !T => F
        // !F => T

        System.out.println(!true);
        System.out.println(!false);

        // XOR 논리표
        // 1 ^ 1 => 0
        // 0 ^ 1 => 1
        // 1 ^ 0 => 1
        // 0 ^ 0 => 0

        /*
        이진수 00000001
              00000010
        XOR   00000011
         */

        System.out.println(1 ^ 2);
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(1 ^ 2));

        String str = String.format("%032d", Integer.parseInt(Integer.toBinaryString( 1 ^ 2)));
        System.out.println(str);

    }
}
