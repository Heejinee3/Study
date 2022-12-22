// 접근제한자 4가지
// 접근제한자는 클래스, 함수, 변수 앞에 위치하여 접근하는 권한을 제어할 때 사용함
// public: 모든 클래스(파일)에서 접근 가능
// protected: 같은 폴더(패키지) or 상속관계의 클래스는 접근 가능
//            자식 클래스(하위)에서 부모 클래스(상위) 접근 가능
// default: 같은 폴더(패키지)에서 접근 가능
// private: 같은 클래스 안에서만 접근 가능, 캡슐화(은닉)에 적합

// public > protected > default > private

// 패키지(package) : 폴더와 거의 같은 의미
//                : 폴더의 경로로 클래스를 구분하는 용도로 사용
// src\Member.java Member 클래스: 패키지명은 src.Member
// src\Member.java Member 클래스는 동일하므로 생성할 수 없음
// src\member\Member.java Member 클래스는 생성 가능: src.member.Member
// 용도: 폴더 경로로 클래스 이름이 동일한 클래스를 구분하기 위해서

class Hong{
    String name = "홍길동";        // default  : 같은 폴더 + 자기 클래스
    public int age = 30;          // public   : 모든 폴더 + 상속 관계 + 같은 폴더 + 자기 클래스
    protected int korScore = 80;  // protected: 상속 관계 + 같은 폴더 + 자기 클래스
    private int engScore = 70;    // private  : 자기 클래스

    public int getEngScore() {
        return engScore;
    }
    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }
}



public class ex075 {
    public static void main(String[] args) {
        Hong obj = new Hong();
        System.out.println(obj.getEngScore());
        obj.setEngScore(90);
        System.out.println(obj.getEngScore());

    }
}
