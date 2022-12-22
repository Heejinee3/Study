public class ex027 {
    public static void main(String[] args) {
        // 연습문제 12-1.
        // 쉬프트 연산자를 이용하여, i*2의 값을 구하시오.
        int i = 1;
        System.out.println(i << 1);

        // 연습문제 12-2.
        // i*8의 값을 구하시오.
        System.out.println(i << 3);

        // 연습문제 12-3.
        // 쉬프트 연산자를 이용하여, j/4의 값을 구하시오.
        int j = 16;
        System.out.println(j >> 2);

        // 연습문제 12-4.
        // 쉬프트 연산자를 이용하여, j/8의 값을 구하시오.
        System.out.println(j >> 3);

        // 연습문제 13-1.
        // 13을 계속 2로 나누어서 몫과 나머지를 구하고, 이를 이용하여 이진수 문자열로 출력하시오.

        i = 13;
        String ans = "";
        int quotient = i;
        int remainder;

        while(quotient > 1){
            quotient = quotient >> 1;
            remainder = i - quotient * 2;
            System.out.println("몫: " + quotient);
            System.out.println("나머지: " + remainder);
            ans = remainder + ans;
            i = quotient;
        }

        ans = quotient + ans;
        System.out.println(ans);

        int k = 13;
        int a = k % 2; //1
        int b = k / 2; //
        int c = b % 2; //0
        int d = b / 2; //
        int e = d % 2; //1
        int f = d / 2; //
        int g = f % 2; //1
        int h = f / 2; //
        System.out.println(g+""+e+""+c+""+a);


    }
}
