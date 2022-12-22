public class ex045 {
    public static void main(String[] args) {
        // break: 반복문을 종료(탈출)
        // continue: 현재 회차(루프)에서 증감문으로 이동

        for(int i=1; i<=10; i++){
            if(i > 5) {
                break;
            }
            System.out.println( i );
        }

        // 연습문제 25-1.
        // 1부터 10까지 출력하되, 2의 배수이면 출력하고(if문 사용), 8이상이면 출력을 중단하시오.(break문 사용)

        for(int i=1; i<=10; i++){
            if(i >= 8){ //모든 i값에 대한 비교
                break;
            }
            if(i%2 == 0) { //짝수 i값에 대한 조건
                System.out.println(i);
            }
        }
    }
}