import java.util.Arrays;
import java.util.Random;

public class ex058 {
    public static void main(String[] args) {

        // 배열의 선언
        // 1. 값 초기화 하면서 선언
        int[] nums = {10, 30, 20, 40, 50};

        // 2. 배열의 길이만 선언
        int[] nums2 = new int[5];
        nums2[0] = 10;
        nums2[0] = 30;
        nums2[0] = 20;
        nums2[0] = 40;
        nums2[0] = 50;

        // 로또 번호 6개를 추첨해서 배열에 넣어보자.
        int[] lotto = new int[6];
        Random rand = new Random();
        for (int i=0; i<lotto.length; i++){
            lotto[i] = rand.nextInt(45) + 1;
        }

        // 연습문제 30-1.
        // lotto 배열을 오름차순 정렬하여 출력하시오.
        Arrays.sort(lotto);
        for (int num  : lotto){
            System.out.print(num + " ");
        }
        System.out.println();

        // 연습문제 30-2.
        // 로또번호 중 가장 작은 수와 가장 큰 수를 출력하시오.
        System.out.println("가장 작은 수: " + lotto[0]);
        System.out.println("가장 큰 수: " + lotto[lotto.length-1]);

        // 연습문제 30-3.
        // 로또 번호 중복된 수가 추첨되었을 때 재추첨하시오.
        int randInt;
        loop1: for (int i=0; i<lotto.length; i++){ // 재추첨
             randInt = rand.nextInt(45) + 1;
            for (int j=0 ; j<i; j++){
                if (randInt == lotto[j]) {
                    i--;
                    continue loop1;
                }
            }
            lotto[i] = randInt;
        }

        for (int num  : lotto){ // 로또 번호 출력
            System.out.print(num + " ");
        }
        System.out.println();

    }

}
