// 기본 API 클래스들
// 패키지명은 java.lang.* java.util.*

// API: Application Programming Interface, 함수/클래스 호출의 접점
// SDI: Software Development Kit, 소프트웨어 개발 툴 모음
// 라이브러리: Library 도서관, 함수나 클래스들의 모임
// JDK: Java Development Kit. Java + SDK
// JAR: Java Archive, 자바 아카이브, class 파일과 리소스(이미지, 텍스트), 메타파일을 모아둔 것, 실행 가능한 압축 파일
// 프레임워크: Framework, 뼈대, 어떤 소프트웨어를 만드는데 사용하는 근간, 모듈
// 콜렉션: Collection. SW 모음
// DLL: 동적 링크 라이브러리(dynamic-link library), 함수 및 클래스 모임

// 프레임워크 > 라이브러리 > 콜렉션 > SDK > API

// java.lang.Object 클래스: 자바의 최상위 클래스
// 최상위 클래스 Object의 다형성을 이용하여, 모든 객체 타입의 주소를 담을 수 있다.
// 코틀린/스위프트: AnyObject 타입
public class ex093 {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1);
        System.out.println(object2);

        // 문자열은 참조변수
        // 1. 리터럴 데이터로 선언
        String str = "abc";
        // 2. 클래스 생성자로 선언
        String str2 = new String("abc");

        if (str == str2){
            System.out.println("문자열이 같음");
        }
        else{
            System.out.println("문자열이 같지않음");
        }

        if (str.equals(str2)){
            System.out.println("문자열이 같음");
        }
        else{
            System.out.println("문자열이 같지 않음");
        }

        // 해쉬코드(hash code)
        // int형 값으로 Object의 고유한 ID값
        // new를 통해 객체화 될 때, 자동적으로 부여됨
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
    }
}
