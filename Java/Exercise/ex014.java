public class ex014 {
    public static void main(String[] args) {

        /*
        십진수: 0 1 2 3 ... 9 10 ... 99 100 ...
        2진수: 0 1 10 11 100 ...
        8진수: 0 1 2 3 ... 7 10 ...
        16진수: 0 1 2 3 ... 9 a b c d e f 10 ...
        */

        // Integer.toBinaryString(num): 정수를 2진수 표현의 string으로 나타낸다.
        int i = 10;
        String binaryString = Integer.toBinaryString(i);
        System.out.println(binaryString);

        // Integer.toOctalString(num): 정수를 8진수 표현의 string으로 나타낸다.
        String octalString = Integer.toOctalString(i);
        System.out.println(octalString);

        // Integer.toHexString(num): 정수를 16진수 표현의 string으로 나타낸다.
        String hexString = Integer.toHexString(i);
        System.out.println(hexString);

    }
}
