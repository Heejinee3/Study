// StringBuffer: 문자열을 좀더 유연하게 처리하는 클래스
//               추가(append), 삽입(insert), 삭제(delete)
// StringBuilder: StringBuffer를 좀더 빠르게 하려고 만든 것
//              : 대량의 데이터(1Mbyte)를 다루지 않는한 큰차이 없음
public class ex094 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb);

        sb.append("def"); // 끝에 문자열 추가
        System.out.println(sb);

        //        시작 인덱스
        sb.insert(3, "123"); // 중간에 문자열 추가
        System.out.println(sb);

        //        시작 인덱스, 끝 인덱스
        sb.delete(2, 4);
        System.out.println(sb);

        StringBuilder builder = new StringBuilder("123");
        // append, insert, delete 동일하게 사용

    }
}
