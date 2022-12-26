
# Print

    System.out.print("");                   // 줄바꿈 없음
    System.out.println("");                 // 줄바꿈 있음
    System.out.printf("%d\n", 10);          // 10진수 정수
    System.out.printf("%o\n", 10);          // 8진수
    System.out.printf("%x\n", 10);          // 16진수
    System.out.printf("%e\n", 12345678f);   // 지수형
    System.out.printf("%c\n", 'A');         // 문자 한개
    System.out.printf("%s\n", "ABC");       // 문자열
    System.out.printf("%5d\n", 10);         // %[자릿수][타입]
    System.out.printf("%05d\n", 10);        // %[공백타입][자릿수][타입]
    System.out.printf("%f\n", 3.14f);       // 실수(float)
    System.out.printf("%.2f\n", 3.14f);     // %[소수점앞 자릿수].[소숫점뒤 자릿수][타입]
    System.out.printf("%f\n", 6.2489);      // 실수(double)

# Integer

    String  = Integer.toBinaryString(int);      // int를 2진수 표현의 String으로 바꿔줌
    String  = Integer.toOctalString(int);       // int를 8진수 표현의 String으로 바꿔줌
    String  = Integer.toHexString(int);         // int를 16진수 표현의 String으로 바꿔줌
    int     = Integer.parseInt(String);         // String을 int로 바꿔줌
    int     = Integer.MAX_VALUE;                // 2^31-1
    int     = Integer.MIN_VALUE;                // -2^31

# Random

    import java.util.Random;
    
    Random rand = new Random();
    int         = rand.nextInt(int);        // 0 <= 정수 난수 < 매개변수
    double      = rand.nextDouble(double);  // 0 <= 실수 난수 < 매개변수

# Scanner

    import java.util.Scanner;
    
    Scanner scan    = new Scanner(System.in);
    String          = scan.next();          // 공백까지 입력 String 얻기
    String          = scan.nextLine();      // Enter까지 입력 String 얻기
    int             = scan.nextInt();       // 공백까지 입력 int 얻기
    double          = scan.nextDouble();    // 공백까지 입력 double 얻기
    void            = scan.close();

# String

    int         = str.length();                                 // 길이 반환
    boolean     = str.equals(String);                           // 같은지 확인
    char        = str.charAt(int);                              // index 위치의 character 반환
    String      = str.replaceAll(beforeString, afterString);    // before을 모두 after로 바꿈, 정규식 사용
    String      = str.replace(beforeString, afterString)        // before을 모두 after로 바꿈, 정규식을 사용하지 않음
    String      = str.replaceFirst(beforeString, afterString)   // // before을 after로 바꿈, 반복은 안됨
    String      = str.substring(index1, index2);                // index1부터 index2-1까지 String 반환
    int         = str.indexOf(String);                          // String으로 시작하는 시작 index 반환
    String      = str.toUpperCase();                            // String을 대문자로 반환
    String      = str.toLowerCase();                            // String을 소문자로 반환
    String      = str.concat(str4);                             // 두개의 String을 연결
    String[]    = str.split(String);                            // String을 구분자로 나누어 배열로 반환
    String      = str.trim();                                   // 시작과 끝의 공백을 제거
    boolean     = str.contains(String);                         // String을 포함하고 있는지 확인
    String      = String.format("%d", int);                     // format에 맞는 String 생성

# StringBuffer

    StringBuffer str    = new StringBuffer(String);
    StringBuffer        = str.append(value);                    // 끝에 문자열 추가
    StringBuffer        = str.insert(index, value);             // 중간에 문자열 추가
    StringBuffer        = str.delete(start index, end index);   // 문자열 삭제
    void                = str.setCharAt(index, char);           // index에 있는 char을 변환
    String              = str.toString();                       // String으로 변환

# StringBuilder

    StringBuilder str   = new StringBuilder(String);
    StringBuilder       = str.append(value);                    // 끝에 문자열 추가
    StringBuilder       = str.insert(index, value);             // 중간에 문자열 추가
    StringBuilder       = str.delete(start index, end index);   // 문자열 삭제
    void                = str.setCharAt(index, char);           // index에 있는 char을 변환
    String              = str.toString();                       // String으로 변환

# Character 

    char[]  = str.toCharArray();            // String을 char array로 변환
    char    = Character.isUpperCase(char);  // character가 대문자인지 확인
    char    = Character.isLowerCase(char);  // character가 소문자인지 확인
    char    = Character.toUpperCase(char);  // character을 대문자로 바꿈
    char    = Character.toLowerCase(char);  // character을 소문자로 바꿈

# Arrays 

    import java.util.Arrays;
    import java.util.Collections;
    
    Arrays.sort(array);                                                     // array를 오름차순으로 정렬
    Arrays.sort(array, Collections.reverseOrder());                         // array를 내림차순으로 정렬
    System.arraycopy(src array, src index, dest array, dest index, length); // source array를 dest array에 copy (index부터 length길이까지)
    array   = Arrays.copyOf(array, length);                                 // array를 length만큼 copy
    array   = array.clone();                                                // array 복사
    int     = array.length                                                  // array의 길이 반환

# Math 

    long    = Math.round(double);           // 반올림
    double  = Math.ceil(double);            // 올림
    double  = Math.floor(double);           // 내림
    double  = Math.pow(double, double);     // a^b
    double  = Math.sqrt(double);            // a^(1/2)
    double  = Math.random();                // 0.0 ~ 0.999... 난수 생성
    double  = Math.toRadians(double);       // degree에서 radian으로 바꿈
    double  = Math.toDegrees(double);       // radian에서 degree로 바꿈
    double  = Math.sin(double);             // sine 함수
    double  = Math.cos(double);             // cosine 함수
    double  = Math.tan(double);             // tangent 함수
    number  = Math.abs(number);             // 절대값
    number  = Math.max(number1, number2);   // 더 큰 값 반환
    number  = Math.min(number1, number2);   // 더 작은 값 반환

# Date 

    import java.text.SimpleDateFormat;
    import java.util.Date;
    
    Date               date = new Date();                       // Date 반환
    long                    = date.getTime();                   // timestamp 반환
    SimpleDateFormat    sdf = new SimpleDateFormat(String);     // yyyy: year   // MM: month    // dd: day  // a: "AM", "PM"
                                                                // HH: hour 24  // hh: hour 12  // mm: minute
                                                                // mm: minute   // ss: second   // SS: milli second
    String                  = sdf.format(Date);                 // 원하는 형식으로 날짜 반환

# Calendar

    import java.util.Calendar;
    import java.util.GregorianCalendar;
    import java.util.Locale;
    
    Calendar    cal = new GregorianCalendar(Locale.KOREA);
    Date            = cal.getTime();                                        // Date 반환
    long            = cal.getTimeInMillis();                                // timestamp 반환
    void            = cal.add(Calendar.HOUR, int);                          // calendar에 저장된 날짜에 int값을 계산한 날짜 넣기

    int             = cal.get(Calendar.YEAR);                               // 연도
    int             = cal.get(Calendar.MONTH);                              // 월 (1월은 0, 2월은 1...)
    int             = cal.get(Calendar.DAY_OF_MONTH);                       // 일
    int             = cal.get(Calendar.DAY_OF_WEEK);                        // 요일 (일요일은 1, 월요일은 2...)
    int             = cal.get(Calendar.WEEK_OF_YEAR);                       // 올해의 몇주차인지 반환
    int             = cal.get(Calendar.WEEK_OF_MONTH);                      // 이달의 몇주차인지 반환
    int             = cal.get(Calendar.HOUR);                               // 시 (12시간제)
    int             = cal.get(Calendar.HOUR_OF_DAY);                        // 시 (24시간제)
    int             = cal.get(Calendar.MINUTE);                             // 분
    int             = cal.get(Calendar.SECOND);                             // 초
    int             = cal.get(Calendar.MILLISECOND);                        // 밀리초

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");     // 원하는 날짜를 calendar에 넣기
    String           str = "year-month-date hour:minute:second";
    Date            date = sdf.parse(str);
    void                 = cal.setTime(date);

    void                 = cal.set(year, month(0~11), date);                // calendar 날짜 세팅하기
    void                 = cal.set(year, month(0~11), date, hour(24), minute, second);
    void                 = cal.set(Calendar.YEAR, year);

# LocalDateTime

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import java.time.ZoneId;
    import java.time.Year;
    
    LocalDateTime   = LocalDateTime.now();                                                          // 현재 시간으로 초기화
    LocalDateTime   = LocalDateTime.now(ZoneId.of("Europe/Paris"));                                 // 영국 시간으로 초기화
    LocalDateTime   = LocalDateTime.of(year, month, date, hour(24), minute, second, milisecond);    // 해당 시간으로 초기화
    LocalDateTime   = LocalDateTime.parse("year-month-dateThour(24):minute:second.milisecond");
    LocalDateTime   = Year.of(year).atMonth(month).atDay(date).atTime(hour(24), minute, second);

    int             = localdatetime.getYear();                                                      // 연도 반환
    Month           = localdatetime.getMonth();                                                     // 월 반환 (String과 유사)
    int             = localdatetime.getMonthValue();                                                // 월 반환 (int)
    int             = localdatetime.getDayOfMonth();                                                // 일 반환
    int             = localdatetime.getHour();                                                      // 시 반환 (0~23)
    int             = localdatetime.getMinute();                                                    // 분 반환
    int             = localdatetime.getSecond();                                                    // 초 반환

    LocalTime       = localdatetime.plusYears(int);
    LocalTime       = localdatetime.plusMonths(int);
    LocalTime       = localdatetime.plusDays(int);
    LocalTime       = localdatetime.plusWeeks(int);
    LocalTime       = localdatetime.plusHours(int);
    LocalTime       = localdatetime.plusMinutes(int);
    LocalTime       = localdatetime.plusSeconds(int);

    LocalTime       = localdatetime.minusYears(int);
    LocalTime       = localdatetime.minusMonths(int);
    LocalTime       = localdatetime.minusDays(int);
    LocalTime       = localdatetime.minusWeeks(int);
    LocalTime       = localdatetime.minusHours(int);
    LocalTime       = localdatetime.minusMinutes(int);
    LocalTime       = localdatetime.minusSeconds(int);

    // LocalDate과 LocalTime도 같음
    
# Optional 

    import java.util.Optional;
    
    Optional opt    = Optional.ofNullable(value);               // null이면 Optional.empty를, 아니면 Optional[value]를 반환
    Optional opt    = Optional.of(value);                       // Optional[value]를 반환, value가 null이 아니라고 확신할 때 사용
    boolean         = opt.isPresent();                          // Optional[value]면 true, 아니면 false 반환
    boolean         = opt.isEmpty();                            // Optional.empty면 true, 아니면 false 반환
    value           = opt.get();                                // Optional[value]면 그 value를 반환, 아니면 Exception
    T               = opt.orElse(replacement value);            // Optional.empty면 replacement value를, 아니면 value를 반환
    Optional        = opt.filter((parameter) -> statement);     // Optional.empty면 Optional.empty로, Optional[value]이고 statement가 true이면 Optional[value]로,
                                                                // Optional[value]이고 statement가 false면 Optional.empty로 반환
    Optional        = opt.map((parameter) -> statement);        // Optional.empty면 Optional.empty로, Optional[value]면 Optional[mapped value]로 변환

# FileOutputStream / FileInputStream

        import java.io.FileOutputStream;
        import java.io.FileInputStream;

        FileOutputStream fos =  new FileOutputStream("./out.txt");  // 바이트 단위로 쓰기
        String data = "문자열 쓰기\r\n";
        fos.write(data.getBytes());
        fos.close();

        FileInputStream fis = new FileInputStream("./in.txt");      // 바이트 단위로 읽기
        int data = 0;
        do {
            data = fis.read();
            if (data != -1) {
                System.out.print((char)data);
            }
        } while(data != -1);
        fis.close();
        
# FileWriter / FileReader

        import java.io.FileWriter;
        import java.io.FileReader;
        
        FileWriter fw = new FileWriter("./out.txt");    // 문자열 단위로 쓰기
        fw.write("문자열 쓰기\r\n");
        fw.close();

        FileReader fis = new FileReader("./in.txt");    // 문자열 단위로 읽기
        int data = 0;
        do {
            data = fis.read();
            if (data != -1) {
                System.out.print((char)data);
            }
        } while(data != -1);
        fis.close();



# BufferedWriter / BufferedWriter

        import java.io.BufferedWriter;
        import java.io.BufferedReader;
        import java.io.FileWriter;
        import java.io.FileReader;
        
        FileWriter fw = new FileWriter("./out.txt");    // 대용량 쓰기
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("문자열 쓰기\r\n");
        bw.newLine();
        bw.close();

        FileReader fr = new FileReader("./in.txt");     // 대용량 읽기
        BufferedReader br = new BufferedReader(fr);
        String data = "";
        do {
            data = br.readLine();
            if (data != null) {
                System.out.println(data);
            }
        } while(data != null)
        br.close();
