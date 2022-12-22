public class ex003 {
    public static void main(String[] args) {

        // System.out.println() : 문자열 출력하고 줄바꿈을 함
        // println() 단축키 : sout + Enter
        // 한줄 선택 : Shift + End
        System.out.println("Java Programming~");
        System.out.println("Java Programming~");

        // System.out.print() : 줄바꿈 없이 출력
        System.out.print("줄바꿈이 없어요~");
        System.out.print("줄바꿈이 없어요~");

        System.out.println();
        System.out.println("줄바꿈이 되었어요~");

        // + 연산자 : 문자열 연결, 산술연산
        System.out.println("Java" + "Coding");
        System.out.println("Java" + 10);
        System.out.println(20 + "Java");
        System.out.println( 10 + 20 );
        System.out.println();

        // System.out.printf(): 형식화된 출력문
        System.out.printf("%d\n", 10);          // 10진수 정수
        System.out.printf("%o\n", 10);          // 8진수
        System.out.printf("%x\n", 10);          // 16진수
        System.out.printf("%e\n", 12345678f);   // 지수형
        System.out.printf("%c\n", 'A');         // 문자 한개
        System.out.printf("%s\n", "ABC");       // 문자열
        System.out.printf("%5d\n", 10);         // %[자릿수][타입]
        System.out.printf("%05d\n", 10);        // %[공백타입][자릿수][타입]
        System.out.printf("%f\n", 3.14f);       // 실수(float)
        System.out.printf("%.2f\n", 3.14f);     // %[소수점앞 자릿수].[소숫점뒤 자릿수][타입]
        System.out.printf("%f\n", 6.2489);      // 실수(double)

        // 연습문제 1-1.
        // "Coding is Good!"을 출력하세요.

        System.out.println("Coding is Good!");

        // 연습문제 1-2.
        // "Java"문자와 "Programming"문자를 + 연결연산자로 연결해서 출력하시오.

        System.out.println("Java"+"Programming");

        // 연습문제 1-3.
        // 십진 정수 123을 printf를 이용하여 출력하시오.

        System.out.printf("%d\n",123);

        // 연습문제 1-4.
        // 십진 정수 123을 printf를 이용하여 "00123"으로 출력하시오.

        System.out.printf("%05d\n", 123);

        // 연습문제 1-5.
        // 실수형 123.45를 printf를 이용하여 "123.45"로 출력하시오.

        System.out.printf("%.2f\n", 123.45);

    }
}
