public class ex028 {
    public static void main(String[] args) {
        // 비트 단위 논리 연산자 : & | ^
        // AND : &
        // OR  : |
        // XOR : ^

        int i = 1;      // 001
        int j = 2;      // 010

        int k = i & j;  // 000
        int m = i | j;  // 011
        int n = i ^ j;  // 011

        System.out.println(k);
        System.out.println(m);
        System.out.println(n);
    }
}
