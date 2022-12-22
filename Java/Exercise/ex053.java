public class ex053 {
    public static void main(String[] args) {

        String str = "This is mom!";
        String strKor = "가나다라";

        //문자열 길이 얻기
        System.out.println("문자열의 길이:" + str.length());
        System.out.println("문자열의 길이:" + strKor.length());

        //문자열 비교( 값 비교 )
        String str2 = "This is papa!";
        System.out.println(str == str); // 주소를 비교하므로 안됨!
        System.out.println(str == str2); // 주소를 비교하므로 안됨!
        //다른 언어에서는 == 문자열 비교에 사용가능. C#, 파이썬, 코틀린, JS

        //자바에서는 반드시 문자열비교는 equals()함수를 사용함.
        System.out.println(str.equals(str));
        System.out.println(str.equals(str2));

        // 값 변수 vs 참조 변수
        // 값 변수(Value Variable) : 실제 값을 가지고 있음.
        //    기본형 8개-int long short byte char float double boolean
        // 참조 변수(Reference Variable) : 주소 값을 가지고 있음
        //    문자열형 객체 배열 열거형 맵 리스트 집합

        //문자열에서 문자 한자씩 가져오기
        for(int i=0; i<str.length(); i++){
            System.out.println(str.charAt(i));
        }

        //문자열 치환하기                        변경전          변경후
        String resultStr = str.replaceAll("mom", "hero");
        System.out.println(resultStr);

        //문자열 일부만 가져오기          시작인덱스 끝인덱스+1
        System.out.println(str.substring(8, 11));

        // 연습문제 34-1.
        // str3의 문자열의 길이를 출력하시오.
        String str3 = "java programming is good!";
        System.out.println(str3.length());

        // 연습문제 34-2.
        // good 문자열을 perfect로 치환하여 출력하시오.
        System.out.println(str3.replaceAll("good", "perfect"));

        // 연습문제 34-3.
        // "programming" 문자열만 가져와서 출력하시오.
        System.out.println( str3.substring(5, 16) );

        // 연습문제 34-4.
        // str3의 'i'문자가 몇개인지를 갯수를 출력하시오.
        int count = 0;
        for( int i=0; i<str3.length(); i++){
            if( str3.charAt(i) == 'i'){
                count++;
            }
        }
        System.out.println("i의 갯수는 " + count);

        str3 = "Java Programming is Good!";

        //특정문자열의 시작 인덱스 얻어오기
        System.out.println(str3.indexOf("Programming"));

        //대문자로 바꾸기
        System.out.println(str3.toUpperCase());
        //소문자로 바꾸기
        System.out.println(str3.toLowerCase());

        //문자열 연결
        // 1. 문자열 연결 연산자 +
        // 2. concat() 함수
        String str4 = "Spring is also Good!";
        System.out.println(str3.concat(str4));

        String str5 = " This is Trimed String~ ";

        //문자열의 시작과 끝의 공백만 제거(중간의 공백 제거 안함)
        System.out.println( str5.trim() );
        //문자열 중간의 공백도 모두 제거
        System.out.println( str5.replaceAll(" ", ""));

        //특정 문자열을 포함하고 있는지 true/false로 확인
        System.out.println( str4.contains("Spring") );

        //문자열 분리(토큰으로 분리 - Tokenizing)
        String[] arrString = str3.split(" ");
        for(int i=0; i<arrString.length; i++ ){
            System.out.println( arrString[i] );
        }

        String str6 = "Web Programming is funny~";
        String str7 = "  Test Trim String  ";

        // 연습문제 35-1.
        // "funny"의 시작 인덱스를 출력하시오.
        System.out.println(str6.indexOf("funny"));

        // 연습문제 35-2.
        // str6를 모두 대문자로 출력하시오.
        System.out.println(str6.toUpperCase());

        // 연습문제 35-3.
        // str6을 모두 소문자로 출력하시오.
        System.out.println(str6.toLowerCase());

        // 연습문제 35-4.
        // str5와 str6을 concat함수로 연결하여 출력하시오.
        System.out.println(str5.concat(str6));

        // 연습문제 35-5.
        // str7의 시작과 끝 공백만 제거하여 출력하시오.
        System.out.println(str7.trim());

        // 연습문제 35-6.
        // str7의 모든 공백을 *로 치환하여 출력하시오.
        System.out.println(str7.replaceAll(" ", "*"));

        // 연습문제 35-7.
        // str6이 "web" 문자열을 포함하고 있는지 출력하시오. (대소문자 안가림)
        System.out.println(str6.toLowerCase().contains("web"));

        // 연습문제 35-8.
        // str6을 문자열 배열로 만들고, "Web"와 "funny~"만 출력하시오.
        String[] str6Array = str6.split(" ");
        System.out.println(str6Array[0] + "," + str6Array[3] );

    }
}