public class ex026 {
    public static void main(String[] args) {

        // 쉬프트 연산자: << >> >>>
        // << : 왼쪽으로 n 비트 이동, *2의 효과가 있음
        // >> : 오른쪽으로 n 비트 이동, /2의 효과가 있음, 0 또는 1로 채움
        // >>>: 오른쪽으로 n 비트 이동, 0으로 채움

        int i = 1;
        System.out.println(i << 1);
        System.out.println(i << 2);

        i = 8;
        System.out.println(i >> 1);
        System.out.println(i >> 2);

        i = -1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i << 1);

        i = -8;
        System.out.println(i >> 1);
        System.out.println(i >> 2);

        i = -1;
        System.out.println(i >>> 1);

    }
}
