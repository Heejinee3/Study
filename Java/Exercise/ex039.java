public class ex039 {
    public static void main(String[] args) {
        // 연습문제 20-1.
        // 반복 변수 i값을 5부터 10까지 출력하시오.
        for (int i=5; i<11 ; i++){
            System.out.println("i값은 " + i);
        }

        // 연습문제 20-2.
        // 반복변수 i값을 1부터 100까지 출력하되 3씩 증가하여 출력하시오.
        for (int i=1; i<101 ; i=i+3){
            System.out.println("i값은 " + i);
        }

        // 연습문제 20-3.
        // 반복변수 i값을 -20부터 10까지 증가하며 출력하시오.
        for (int i=-20; i<11 ; i++){
            System.out.println("i값은 " + i);
        }

        // 연습문제 20-4.
        // 반복변수 i값을 1부터 100까지 5의 배수만 출력하시오.
        for (int i=1; i<101 ; i++){
            if (i%5 == 0)
                System.out.println("i값은 " + i);
        }

        // 연습문제 20-5.
        // 반복변수 i값을 10부터 -10까지 감소하여 출력하시오.
        for (int i=10; i>-11 ; i--){
            System.out.println("i값은 " + i);
        }

        // 연습문제 20-6.
        // 1부터 10까지의 합을 출력하시오.
        int sum = 0;

        for (int i=1; i<11 ; i++){
            sum += i;
        }

        System.out.println("총합은 " + sum);

        // 연습문제 20-7.
        // 1부터 100까지 끝자리가 3으로 끝나는 수의 갯수를 출력하시오.
        int count = 0;
        for (int i=1; i<101 ; i++){
            if (i%10 == 3)
                count++;
        }
        System.out.println("갯수는 " + count);

        // 연습문제 20-8.
        // 1부터 100까지 끝자리가 3으로 끝나는 수의 갯수를 출력하시오. 십의 자릿수도 3이면 카운트에 추가하시오.
        count = 0;
        for(int i=1; i<101; i++) {
            if (i % 10 == 3 || i / 10 == 3) {
                count++;
            }
        }
        System.out.println("갯수는 " + count);






    }
}
