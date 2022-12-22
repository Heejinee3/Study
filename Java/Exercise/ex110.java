import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Year;

public class ex110 {
    public static void main(String[] args) {
        // LocalDate, LocalTime, LocalDateTime
        // JDK 1.8부터 지원, 타임존 개념이 없는 단순 날짜/시간 정보 출력
        // 오픈소스인 JodaTime 클래스를 본따서 만듦
        // 최신 트렌드는 Date보다는 LocalDate, LocalDateTime을 사용한다

        // Date.Calender의 단점
        // 1. get/set 함수로 인해서 값이 중간에 변경될 수 있다
        // 2. 1월을 0으로 표현하는 문제
        // 3. 년/월/일 계산은 Date로만 안되고 Calendar를 사용해야 됨

        // LocalDate
        LocalDate now = LocalDate.now(); // 현재시간 반환
        System.out.println(now);

        // 날짜 설정하기
        LocalDate birthDay = LocalDate.of(2000,12,1);
        System.out.println(birthDay);

        // 문자열로부터 날짜 설정하기
        LocalDate xmas = LocalDate.parse("2022-12-05");
        System.out.println(xmas);

        // LocalTime
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);

        // 세계시간 - 프랑스 파리
        LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(parisTime);

        // 시간 설정하기
        LocalTime sleepTime = LocalTime.of(23,30,0);
        System.out.println(sleepTime);

        // 시간 더하기/빼기
        LocalTime getUpTime = sleepTime.plusHours(8);
        System.out.println(getUpTime);
        LocalTime InHouseTime = sleepTime.minusHours(5);
        System.out.println(InHouseTime);

        // LocalDateTime
        LocalDateTime dateTime = LocalDateTime.now(); // 현재시간 반환
        System.out.println(dateTime);
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());

        // 날짜시간 설정하기
        LocalDateTime y2k = LocalDateTime.of(1999, 12, 31, 23, 59,29,999);
        System.out.println(y2k);

        // 문자열에서 날짜시간 가져오기
        LocalDateTime now2 = LocalDateTime.parse("2022-12-01T12:06:06.391847500");
        System.out.println(now2);
        now2 = LocalDateTime.parse("2022-12-01T12:06");
        System.out.println(now2);

        // 함수 연결하여 날짜시간 설정하기
        LocalDateTime now3 = Year.of(2022).atMonth(12).atDay(1).atTime(12, 01,05);
        System.out.println(now3);

        // 클래스 필드                오라클 DB 필드  MySQL(MariaDB)
        // String                   varchar2      varchar
        // int, lo                  number        INT
        // float, double            float         FLOAT
        // Date                     date          DATETIME
        // LocalDate, LocalTime     date          DATETIME
    }
}
