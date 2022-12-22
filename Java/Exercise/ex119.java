public class ex119 {
    public static void main(String[] args) {
        // 연습문제 59-1.
        // 재귀함수로 팩토리얼(Factorial)을 구현해보자.
        // 5! = 5*4*3*2*1
        // 형식: int result = factorial(n)
        int answer = factorial(5);
        System.out.println("factorial(5): " + answer);

        // 연습문제 60-1.
        // 1부터 N까지의 합계를 출력하시오.
        // int n = 5;
        // sum(n)을 호출하면, 5+4+3+2+1까지의 합이 반환된다.
        int answer2 = sum(5);
        System.out.println("sum(5): " + answer2);

        // 연습문제 61-1.
        // 십진정수를 2진수로 변환하여 출력하시오
        // printBin(int n)
        // printBin(10) 호출시, 1010으로 출력됨
        printBin(10);

        // 연습문제 62-1.
        // "abcde" => "edcba"
        System.out.println();
        reverseWord("abcde");

    }

    static void reverseWord(String str){
        if( str.length()==0 ){
            return;
        }
        else{
            reverseWord(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    static void printBin(int n){
        int s = n / 2;
        int r = n % 2;

        if (n == 1) {
            System.out.print(1);
        }
        else{
            printBin(s);
            System.out.print(r);
        }
    }
    static int factorial(int n){
        if (n == 1)
            return 1;
        else return n * factorial(n-1);
    }

    static int sum(int n){
        if (n == 1)
            return 1;
        else
            return n + sum(n-1);
    }
}
