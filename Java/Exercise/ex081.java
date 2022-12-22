// 클래스에서 중요한 개념들
// 1. 상속: 모듈화/계층화, 중복 제거
// 2. 생성자 함수: 객체 생성시 자동으로 호출되는 함수
// 3. 다형성: 상속 관계에서 하나의 객체가 여러 타입을 가질 수 있다.
// 4. 추상화 클래스: 일반 클래스(일반 함수) + 가상함수
// 5. 인터페이스: 인터페이스 타입에 가상함수만 있는 것

// 생성자 함수(Constructor): 객체 생성시(new) 자동으로 호출되는 함수
// 용도: 값을 초기화할 때 사용
class Book{
    int price = 1000;
    void read(){
        System.out.println("책을 읽는다.");
    }
    // 생성자 함수 형식
    // public 반환형표시없음 클래스이름()
    public Book(){
        System.out.println("생성자 함수 호출됨");
        this.price = 2000;
    }
}
public class ex081 {
    public static void main(String[] args) {
        Book objBook = new Book();
        System.out.println(objBook.price);
    }
}
