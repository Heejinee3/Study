import java.util.LinkedList;
import java.util.Queue;

public class ex102 {
    public static void main(String[] args) {
        // 다양한 종류의 예외 처리
        try{
            Thread.sleep(1000);
            // System.out.println(10/0);
            int[] array = new int[3];
            array[3] = 30;
        }
        catch (InterruptedException e){ //인터럽트 예외발생시
            // 인터럽트: CPU의 제어를 가로채는 행위
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e){ // 배열 인덱스 예외발생시
            e.printStackTrace();
        }
        catch (ArithmeticException e){ // 산술처리 예외발생시
            e.printStackTrace();
        }
        catch (Exception e){ // 모든 경우의 예외 처리 (다형성)
            e.printStackTrace();
        }
    }
}
