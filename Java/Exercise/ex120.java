public class ex120 {
    public static void main(String[] args) {
        // 연습문제 63-1.
        // 클래스 생성자 함수, 객체 생성
        // 게임 개발자로서 좀비 게임을 만들어 보자.
        // 좀비 객체를 생성해서 데미지를 받을 때 Dead 상태로 만든다.
        // 클래스 이름: Zombie
        // 멤버 변수: name = "", health(체력) = 10
        // 생성자 함수를 통해, name과 health를 입력받아 초기화 한다.
        // onDamaged(int damage) 일반 함수를 통해 데미지를 받는다.
        // 여기서 체력이 0 이하가 되면, 좀비 이름 + Dead 문구를 출력한다.
        // 체력이 0 이하가 아니라면, 좀비 이름 + 체력값을 출력한다.
        // 좀비는 중간 보스 좀비, 체력 10으로 1개 생성한다
        //       보스 좀비, 체력 30으로 1개 생성한다
        // 모든 좀비가 체력이 0 이하가 될때까지 onDamaged(10)을 호출한다.

        Zombie midBossZombie = new Zombie("midBossZombie", 10);
        Zombie bossZombie = new Zombie("bossZombie", 30);

        while(midBossZombie.getHealth() > 0){
            midBossZombie.onDamaged(10);
        }
        while(bossZombie.getHealth() > 0){
            bossZombie.onDamaged(10);
        }

    }
}

class Zombie{
    String name = "";
    int health = 0;

    public Zombie(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    void onDamaged(int damage){
        this.health = this.health - damage;
        if (this.health <= 0){
            System.out.println(this.name + " Dead");
        }
        else{
            System.out.println(this.name + " " + this.health);
        }
    }
}
