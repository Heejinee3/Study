public class ex103 {
    public static void main(String[] args) {
        // 예외를 처리하는 방법 2가지
        // 1. try catch문을 이용하여 자신이 직접 처리하는 방법
        // 2. throws문을 이용하여 자신을 호출한 함수에게 부탁하는(던지는) 방법
        try {
            myFunc();
        }catch (Exception e){}
    }

    static void myFunc() throws Exception{
        System.out.println("myFunc 함수 호출됨");

        // 1. 첫번째 방법
        try{
            throw new Exception();
        }catch(Exception e){
            e.printStackTrace();
        }

        // 2. 두번째 방법 - throws로 던진다.
        throw new Exception();

    }
}
