public class ex042 {
    public static void main(String[] args) {

        for( int i=0; i<5; i++ ){
            System.out.println(i);
        }

        /*
        초기화
        while(조건) {
          수행문
          마지막에 증감문
        }
        */

        int i=0;
        while( i<5 ){
            System.out.println(i);
            i++;
        }

        // 연습문제 22-1.
        // j값이 10부터 20까지 출력되도록 하시오.
        int j = 10;
        while (j<21){
            System.out.println(j);
            j++;
        }

        // 연습문제 22-2.
        // j값이 10부터 -10까지 출력되도록 하시오.
        j = 10;
        while (j>-11){
            System.out.println(j);
            j--;
        }

        // 연습문제 22-3.
        // j값이 1부터 100까지 3의 배수만 출력되도록 하시오.
        j = 1;
        while (j<101){
            if (j%3 ==0)
                System.out.println(j);
            j++;
        }

        // 연습문제 22-4.
        // 100을 1부터 100까지 나누어 약수의 갯수를 구하시오.
        j=1;
        int count = 0;

        while(j<101){
            if (100%j == 0) {
                count++;
            }
            j++;
        }
        System.out.println(count);

    }
}
