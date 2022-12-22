public class ex048 {
    public static void main(String[] args) {

        // ***** i:0 j:01234
        // ***** i:1 j:01234
        // ***** i:2 j:01234
        // ***** i:3 j:01234
        // ***** i:4 j:01234
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 연습문제 27-1.
        // *     i:0 j:0
        // **    i:1 j:01
        // ***   i:2 j:012
        // ****  i:3 j:0123
        // ***** i:4 j:01234
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 연습문제 28-1.
        //     * i:0 j:0123 k:0
        //    ** i:1 j:012 k:01
        //   *** i:2 j:01 k:012
        //  **** i:3 j:0 k:0123
        // ***** i:4 j: k:01234
        for(int i=0; i<5; i++){
            for(int k=0; k<=4-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 연습문제 29-1.
        // *       i:0  j:0개 k:1
        //  *      i:1  j:1
        //   *     i:2  j:2
        //    *    i:3  j:3
        //     *   i:4  j:4
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }

        // 연습문제 30-1.
        // n의 자연수가 입력되고, n은 0보다 큰 홀수이다.
        // n == 1일때
        // *
        // n == 3일때
        //  *     i:2번
        // ***
        // n == 5일때
        // m = n/2+1(i루프 갯수)
        //   *    i :0      j:2 m-i   k:1  i*2+1
        //  ***     :1      j:1       k:3
        // *****    :2      j:0       k:5
        int n = 1;
        int m = n/2+1; //i루프 갯수
        for(int i=0; i<m; i++){
            for(int j=1; j<m-i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<i*2+1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
