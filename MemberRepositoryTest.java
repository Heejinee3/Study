package com.study.springboot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest extends Ex14JpaH2DbTestApplicationTests{
    // Test에서는 생성자 주입이 안됨
    // 필드 주입으로 대체
    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll //해당 테이스 클래스를 초기화할때 딱 한번 수행되는 메소드이다.
    static void setup() {
        System.out.println("@BeforeAll - 클래스를 초기화시 한번 수행");
    }
    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - 메소드 호출시마다 한번 수행");
        save();
    }

    @Test
    @DisplayName("save 테스트")
    public void save(){
        memberRepository.save(
                new MemberEntity(Long.valueOf(1),"hong","1234","홍길동","ROLE_USER", LocalDate.now())
        );
        memberRepository.save(
                new MemberEntity(Long.valueOf(2),"tom","1234","톰아저씨","ROLE_USER", LocalDate.now())
        );
        memberRepository.save(
                new MemberEntity(Long.valueOf(3),"admin","1234","관리자","ROLE_ADMIN", LocalDate.now())
        );

        List<MemberEntity> list = memberRepository.findAll();

        for (MemberEntity m : list){
            System.out.println(m.getUserName());
        }
    }

    @Test
    @DisplayName("findById 테스트")
    public void findById(){
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresent(unwrappedMemberEntity -> {
            System.out.println(unwrappedMemberEntity.getUserName());
        });

    }

    @Test
    @DisplayName("count 테스트")
    public void count(){
        Long count = memberRepository.count();
        System.out.println("count:" + count);
    }

    @Test
    @DisplayName("query 테스트")
    public void query(){
        // find + By + 필드 이름 + And + 필드이름
        List<MemberEntity> list = memberRepository.findByUserId("hong");
        for (MemberEntity m : list){
            System.out.println(m.getUserName());
        }

        // Native SQL: 1. 특정 데이터베이스에 종속적인 기능 사용 가능
        //             예) MySQL: LIMIT 5, now()
        //                 Oracle: sysdate
        List<MemberEntity> list2 = memberRepository.findByUserId_nativeQuery("admin");
        for (MemberEntity m : list2){
            System.out.println(m.getUserName());
        }

        List<MemberEntity> list3 = memberRepository.findFirst5ByUserIdAndUserNameOrderByIdDesc("hong","홍길동");
        for (MemberEntity m : list3){
            System.out.println(m.getUserName());
        }

        Boolean isExist = memberRepository.existsByJoindateLessThanEqual(LocalDate.now());
        System.out.println("isExist: " + isExist);

        // JPQL: 1. 표준 SQL 문법을 지원
        //       2. 특정 데이터베이스에 종속적인 기능은 지원하지 않는다.
        //       3. from 뒤는 엔티티 명(소문자로 할시 에러)
        List<MemberEntity> list4 = memberRepository.findByUserId_JPQL_Query("tom");
        for (MemberEntity m : list4){
            System.out.println(m.getUserName());
        }
    }

    @Test
    @DisplayName("update 테스트")
    public void update(){
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresent(unwrapMember -> {
            unwrapMember.setUserId("Mr.Kim");
            unwrapMember.setUserName("김삿갓");
            memberRepository.save(unwrapMember); // 같은 id의 값이 있다면 update됨
            System.out.println("업데이트 성공!");
            findById();
        });
    }

    @Test
    @DisplayName("update2 테스트")
    public void update2(){
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresent(unwrapMember -> {
            int a = memberRepository.updateById_nativeQuery("Mr.Kim",(long)4);
            System.out.println("업데이트 성공!");
            System.out.println(a);
            findById();
        });
    }

    @Test
    @DisplayName("delete 테스트")
    public void delete(){
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresent(unwrapMember -> {
            memberRepository.delete(unwrapMember);
            System.out.println("삭제 성공!");
            findById();
        });
    }
}