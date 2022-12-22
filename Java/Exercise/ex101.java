public class ex101 {
    public static void main(String[] args) {
        // 예외 Exception: 에러, 버그(bug), 오류와 비슷한 단어
        // 예외 처리(Exception Handling) : 예측 가능한 오류를 최대한 처리하는 것
        // try catch문 (finally문)

        // 형식
        // try{
        //  예외가 발생할 수 있는 실행문 예) 통신, 파일 읽기/쓰기, 스레드
        // }
        // catch(예외클래스 객체){
        // 예외 발생시 처리하는 실행문 - 에러내용 출력 또는 메모리 정리(close)
        //}
        String name = null; // 값이 존재하지 않음, 연산 불가
        String name2 = ""; // 값이 비어있음
        // System.out.println(name.equals(("Hong"))); // NullPointException

        try{
            System.out.println(name.equals("Hong"));
            System.out.println("아랫쪽 코드...");
        }catch (Exception e){
            System.out.println("널포인트 에러 발생!!!");
            e.printStackTrace();
        }
    }
}
