public class ex046 {
    public static void main(String[] args) {

        for(int i=1; i<=10; i++){
            if(i%2 == 1){
                continue;
            }
            System.out.println(i);
        }

        // 연습문제 26-1.
        // 1부터 100까지 홀수만 출력하되, 3의 배수는 출력하지 마시오. (continue문 이용)
        for(int i=1; i<=100; i++){
            if(i%2 == 1) {
                if( i%3==0 ){
                    continue;
                }
                System.out.println(i);
            }
        }

    }
}

