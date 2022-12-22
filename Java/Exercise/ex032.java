public class ex032 {
    public static void main(String[] args) {

        /*
        if (조건절) {
            (수행문)
        } else if (조건절){
            (수행문)
        } else {
            (수행문)
        }
        */

        int i = 10;

        if (i == 10){
            System.out.println("i는 10임");
        }

        if (i > 20) {
            System.out.println("i가 20보다 큼");
        } else{
            System.out.println("i가 20보다 같거나 작음");
        }

        if (i < 10){
            System.out.println("10보다 작음");
        } else if (i < 20){
            System.out.println("10보다 작지 않고 20보다 작음");
        } else{
            System.out.println("10보다 작지 않고 20보다 작지 않음");
        }

        if (i % 2 == 0){
            if (i % 5 == 0){
                System.out.println("2의 배수이고 5의 배수");
            }else{
                System.out.println("2의 배수이고 5의 배수는 아님");
            }
        }

    }
}
