// 싱글톤 만들기
// 싱글톤(Singleton) : 프로그램 안의 유일한 객체를 의미

class FishBun{ // 일반 붕어빵
    int bunNo = 10;
}
class UniqueFishBun{ // 절대 붕어빵: 싱글톤
    int bunNo = 20;
    private static UniqueFishBun singleton = new UniqueFishBun();
    static UniqueFishBun getInstance(){
        return singleton;
    }
}

public class ex077 {
    public static void main(String[] args) {

        // 일반 붕어빵
        // Heap 영역 메모리 사용
        // 생성: new
        // 소멸: 블록(영역)을 벗어날 때, 또는 null 값을 줄 때
        //    : GC(Garbage Collector)가 자동으로 처리해줌
        FishBun bun1 = new FishBun();
        FishBun bun2 = new FishBun();
        FishBun bun3 = new FishBun();

        System.out.println(bun1); // 0x4eec7777
        System.out.println(bun2); // 0x3b07d329
        System.out.println(bun3); // 0x41629346

        bun1.bunNo = 100;
        System.out.println(bun2.bunNo);

        // 절대 붕어빵
        UniqueFishBun uBun1 = UniqueFishBun.getInstance();
        UniqueFishBun uBun2 = UniqueFishBun.getInstance();
        UniqueFishBun uBun3 = UniqueFishBun.getInstance();

        System.out.println(uBun1); // 0x6d311334
        System.out.println(uBun2); // 0x6d311334
        System.out.println(uBun3); // 0x6d311334

        uBun1.bunNo = 200;
        System.out.println(uBun2.bunNo);

    }
}
