//연습문제 53-1.
// 클래스이름 : VendingMachine
// 속성: itemCount  0개
// 행동: popup() "상품 출고 + 재고 5개" 출력하고 itemCount를 하나 뺀다.
// 생성자 함수: 매개변수를 통해 itemCount를 5개로 넣어준다.
// 출력: 상품 출고 + 재고 4개
//       상품 출고 + 재고 3개
//       상품 출고 + 재고 2개
//       상품 출고 + 재고 1개
//       상품 출고 + 재고 0개
//       상품 재고가 없습니다!

class VendingMachine{
    int itemCount = 0;

    public VendingMachine(int itemCount){
        this.itemCount = itemCount;
    }

    void popup() {
        if (itemCount <= 0) {
            System.out.println("상품 재고가 없습니다!");
        } else {
            itemCount--;
            System.out.println("상품 출고 + 재고 " + itemCount + "개");
        }
    }
}
public class ex083 {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(5);
        for (int i = 0; i < 6; i++){
            machine.popup();
        }
    }
}
