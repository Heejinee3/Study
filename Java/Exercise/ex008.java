public class ex008 {
    public static void main(String[] args) {

        char myChar = 'A';
        System.out.println(myChar);

        int k = (int)myChar;
        System.out.println( k );

        char myChar2 = (char)42;
        System.out.println( myChar2 );

        // 연습문제 4-1.
        // 대문자 'X'를 정수형 값으로 출력하시오.
        char X = 'X';
        System.out.println((int)X);

        // 연습문제 4-2.
        // 97 값을 가진 정수형 변수를 이용하여, 소문자 'a'를 출력하시오.
        int n = 97;
        System.out.println((char)n);

        // 연습문제 4-3.
        // 71 79 79 68 정수값을 이용하여, "GOOD"를 출력하시오.
        System.out.print((char)71);
        System.out.print((char)79);
        System.out.print((char)79);
        System.out.print((char)68);
        System.out.println();

        String str = "java programming is funny!";
        System.out.println(str);

        // str.charAt(index): string의 index번째에 있는 character을 반환
        char c = str.charAt(0);
        System.out.println(c);
        c = str.charAt(1);
        System.out.println(c);

        String strB = "Happy Days~";
        String strA = new String("Happy Days~");
        System.out.println( strA );

    }
}
