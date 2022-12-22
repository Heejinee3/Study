public class ex041 {
    public static void main(String[] args) {

        for(int i=1; i<6; i++){
            System.out.println( "i:" + i );
            for(int j=1; j<6; j++){
                System.out.println( "j:" + j);
            }
        }

        for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                System.out.println( i + "*" + j + "=" + i*j );
            }
        }

    }
}
