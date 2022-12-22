import java.util.Random;
public class ex043 {
    public static void main(String[] args) {

        // 연습문제 23-1.
        // 어떤 터널이 낮아서 최대로 들어갈 수 있는 차량의 높이는 5미터 이하이다. 1~10(미터단위)까지 차량이 임의로 10대 들어올 때,
        // 차량이 들어갈 수 있으면, 통과! 못들어가면 후퇴!를 출력하시오.
        int height;
        int i = 10;
        Random rand = new Random();

        while(i > 0){
            height = rand.nextInt(10) + 1;
            if (height < 6 && height > -1)
                System.out.println("통과!");
            else if (height < 11 && height > -1)
                System.out.println("후퇴!");
            else
                System.out.println("에러발생");
            i--;
        }

        // 연습문제 24-1
        // 1부터 100사이의 소수를 찾아서 출력하시오. 소수만 약수가 1 또는 자기 자신인 수를 의미함.
        int count;

        for (i = 1; i < 101; i++){
            count = 0;

            if (i == 1)
                continue;

            for (int j = 1; j < 101; j++){
                if (i%j == 0)
                    count++;
                if (count > 2)
                    break;

            }

            if (count == 2)
                System.out.println(i);
        }

    }
}
