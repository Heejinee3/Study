public class ex104 {
    public static void main(String[] args) {
        // try catch finally 문
        try{
            // 예외가 발생할 수 있는 수행문
        }catch(Exception e){
            // 예외가 발생하면 수행하는 수행문
        }
        finally {
            // 예외가 발생하든 안하든 무조건 수행하는 수행문
            // 용도: 자원(메로리, IO 포트) 닫아주는 역할

        }

        try{
            throw new Exception();
        }catch(Exception e){
            System.out.println("예외가 발생함!");
            e.printStackTrace();
        }
        finally {
            System.out.println("finally문: 정리중...");

        }


    }
}
