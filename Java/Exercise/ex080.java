// 오버로딩 vs. 오버라이드
// 오버로딩: 매개변수를 다르게 함으로 메소드의 기능을 확장
//          같은 이름의 함수를 계속 사용할 수 있다
// 오버라이드: 부모클래스의 메소드를 자식클래스에서 재정의한다
class Machine{
    String name = "일반기계";
    public void work(){
        System.out.println("기계가 일한다");
    }

}
class CoffeeMachine extends Machine{
    String name = "커피기계";
    // @Override : 오버라이드 메소드임을 컴파일러에게 알려주는 지시어
    // 어노테이션(Annotation): 컴파일러 지시어, 실행시에는 사라짐
    @Override
    public void work(){
        System.out.println("커피기계가 일한다");
    }
}


public class ex080 {
    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        System.out.println(cm.name);
        cm.work();
    }
}
