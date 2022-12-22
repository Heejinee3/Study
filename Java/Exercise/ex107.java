import java.text.SimpleDateFormat;
import java.util.Date;

public class ex107 {
    public static void main(String[] args) {
        // 날짜와 시간 관련된 클래스
        // Date , Calendar 클래스 사용

        // 인간이 살아가는 주배경
        // 1. 시간 - 년월일시분초밀리초, 정수값(timestamp 1970-1-1 0:0:0)
        //          2022년11월30일16시10분5초023초
        // 2. 장소 - 행정주소(서울시 마포구 신촌동), GPS 좌표(위도, 경도 double값)

        // 현재시간을 운영체제(OS - 윈도우즈10 home)에서 가져온다
        Date date = new Date();
        System.out.println(date);

        // 타임스탬프 정수값
        long timestamp = date.getTime();
        System.out.println("타입스탭프: " + timestamp);

        // 날짜 시간을 형식 포맷에 맞게 맞춰서 출력하기
        // SimpleDateFormat: 날짜시간 포맷을 정해주는 클래스
        // yyyy: year
        // MM: month
        // dd: day on month
        // HH: hour 24 hh: 12시간제
        // mm: minute
        // ss: second
        // SS: milli second
        // a: "AM" 또는 "PM"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        String dateFormat = sdf.format(new Date());
        System.out.println(dateFormat);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat2 = sdf2.format(new Date());
        System.out.println(dateFormat2);

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
        String dateFormat3 = sdf3.format(new Date());
        System.out.println(dateFormat3);




    }
}
