public class ex068 {

    static void func1(){
        System.out.println("func1 호출됨");
        return; // 생략가능
        // System.out.println(""); 도달 불가 에러!
    }

    static void func2(int param){
        System.out.println("func2 호출됨");
        System.out.println("매개변수 param: " + param);
        return;
    }

    static int func3(){
        System.out.println("func3 호출됨");
        return 40;
    }

    static int func4(int param){
        System.out.println("func4 호출됨");
        return param * 2;
    }

    public static void main(String[] args) {

        func1();

        int param = 10;
        func2(param);

        int result = func3();
        System.out.println("반환값: " + result);
        System.out.println("반환값: " + func3());

        result = func4(param);
        System.out.println("반환값: " + result);
        System.out.println("반환값: " + func4(param));

    }

}
