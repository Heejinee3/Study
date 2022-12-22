public class ex050 {
    public static void main(String[] args) {

        //무한루프 만드는 방법
        //1. for(;;){  }
        //2. while(true){  }

        //1.for(;;) 사용
        int i=0;
        for(;;){
            System.out.println("무한루프1:"+(i++));
            if(i>100){
                break; //탈출!
            }
        }

        //2.while(true) 사용
        i = 0;
        while(true){
            System.out.println("무한루프2:"+(i++));
            if(i>100){
                break; //탈출!
            }
        }
    }
}
