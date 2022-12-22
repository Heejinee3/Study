// 클래스의 상속 : 부모 클래스의 자산(함수/변수)를 자녀 클래스가 물려받는다
// 상속을 사용하는 이유

// 1. 코드 중복을 피할 수 있음
// 2. 계층적인 구조의 코드 작성을 할 수 있다.

// 예) 강아지: 동물 속성/행동 + 강아지 고유의 속성/행동
//     고양이: 동물 속성/행동 + 고양이 고유의 속성/행동
//            공통된 속성/행동 - 코드를 한개만 설계해서 각각 상속받으면 된다

class Animal{
    int age = 10;
    void eat(){
        System.out.println("먹는다");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("짖는다");
    }
}
class Cat extends Animal{
    void grooming(){
        System.out.println("손질한다");
    }
}



public class ex078 {
    public static void main(String[] args) {
        Dog objDog = new Dog();
        System.out.println(objDog.age);
        objDog.eat();
        objDog.bark();

        Cat objCat = new Cat();
        System.out.println(objCat.age);
        objCat.eat();
        objCat.grooming();
    }
}
