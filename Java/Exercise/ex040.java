public class ex040 {
    public static void main(String[] args) {

        // 연습문제 21 - for문 연습
        // 영희가 1부터 100까지 번호가 쓰인 징검다리 돌을 지나고 있다. 뒷자리가 2나 7로 된 돌은 밣지 않고 건너려고 한다.
        // 영희가 밣은 벽돌의 갯수와 밣지 않은 벽돌의 갯수를 출력하시오.

        int skipCount = 0;
        for(int i=1; i<101; i++){
            if(i%10==2 || i%10==7){
                skipCount++;
            }
        }

        System.out.println("영희가 밣은 벽돌의 갯수:"+(100-skipCount));
        System.out.println("밣지 않은 벽돌의 갯수:"+skipCount);


    }
}
