public class ex021 {
    public static void main(String[] args) {

        // 연습문제 9-1.
        // 12345의 만의 자릿수를 출력하시오.
        int i = 12345;
        int a = i/10000;
        System.out.println("만의 자릿수: " + a);

        // 연습문제 9-2.
        // 12345의 천의 자릿수를 출력하시오.
        int b = i / 1000 % 10;
        System.out.println("천의 자릿수: " + b);

        // 연습문제 9-3.
        // 12345의 백의 자릿수를 출력하시오.
        int c = i / 100 % 10;
        System.out.println("백의 자릿수: " + c);

        // 연습문제 9-4.
        // 12345의 십의 자릿수를 출력하시오.
        int d = i / 10 % 10;
        System.out.println("십의 자릿수: " + d);

        // 연습문제 9-5.
        // 12345의 일의 자릿수를 출력하시오.
        int e = i % 10;
        System.out.println("일의 자릿수: " + e);

        // 연습문제 9-6.
        // 각 자릿수를 이용하여 "1만2천3백4십5"로 출력하시오.
        System.out.println(a + "만" + b + "천" + c + "백" + d + "십" + e);

    }
}
