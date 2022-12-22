public class ex047 {
    public static void main(String[] args) {

        // for문 안의 for문에서 레이블을 이용하여 상위 반복문을 제어(break,continue)함.
        loop1: for(int i=0; i<5; i++){
            System.out.println("i:"+i);
            loop2: for (int j=0; j<5; j++){
                System.out.println("j:"+j);
                break loop1;
            }
            System.out.println();
        }

        System.out.println("----------");

        loop1: for(int i=0; i<5; i++){
            System.out.println("i:"+i);
            loop2: for (int j=0; j<5; j++){
                System.out.println("j:"+j);
                continue loop1;
            }
            System.out.println();
        }

    }
}

