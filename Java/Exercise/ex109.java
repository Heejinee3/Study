import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;

public class ex109 {
    public static void main(String[] args) {
        // 연습문제 56-1.
        // 두날짜 사이의 차이를 구하기(D-Day)
        // 12월25일에 크리스마스 이벤트를 시작한다.
        // 현재날짜 기준으로 D-Day를 출력하시오.
        // 출력예) "크리스마스까지 D-121일입니다"
        // 힌트) long 시간차_타임스탬프값 = 타임스탬프값1 - 타임스탬프값2
        //      타임스탬프값(밀리초)를 Day단위로 바꾸면 날짜가 나옴.
        //      현재시간 캘린더 객체 : startCal.setTime( new Date() );
        //      목표시간 캘린더 객체 : endCal.set(2022,12,25);

        Calendar startCal = new GregorianCalendar(Locale.KOREA);
        Calendar endCal = new GregorianCalendar(Locale.KOREA);

        startCal.setTime(new Date());
        endCal.set(2022,11,25);

        long D_day = endCal.getTimeInMillis() - startCal.getTimeInMillis();

        // 1s = 1000ms
        // 1m = 60s
        // 1h = 60m
        // 1d = 24h
        System.out.println("D-" + (int)(D_day/(1000.0*60.0*60.0*24.0))+ "일입니다");


    }

}
