package com.study.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.List;

// DAO 클래스: Database Access Object - DB에 직접 접근하는 클래스
// DTO/VO/Entity: 데이터의 전달 또는 DB 열에 매칭하는 클래스

// @Repository: JPA DAO클래스에 적용하고, @Component가 적용됨
// @Service: 서비스 로직 클래스에 적용하고, @Component가 적용됨
// @Controller: 컨트롤(HTTP 요청 처리) 클래스에 적용, @Component가 적용됨

// JpaRepository: 스프링 JPA 라이브러리에서 Entity에 대한 기복적인 조회, 삽입, 수정, 삭제가 가능하도록 만든 인터페이스이다.
// 제네릭 타입1: 엔티티 클래스
// 제네릭 타입2: PK 타입

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // JpaRepository의 기본함수
    // 1. findAll(): SQL(Select * from Table)문을 실행한다.
    // 2. findBy열이름(): SQL(Select 열이름 from Table)문을 실행한다.
    //                  예) findById((long)2): Select * from member where id=2;
    //                  예) findByUser_id(): Select user_id from member where user_id="hong"와 동일하다
    // 3. save(): SQL insert문과 update문을 실행한다.
    //            id값을 보고, 없으면 추가, 있으면 수정
    // 4. delete(): SQL delete문을 수행한다.

    // private String userId -> (findBy)UserId;
    // SELECT * FROM member WHERE user_id = "userid"
    List<MemberEntity> findByUserId(String userid);

    // 네이티브 쿼리
    // 1. Update, Insert, Delete문은 @Modifying, @Transactional을 추가해야됨
    @Query(value = "SELECT * FROM member WHERE user_id = :userid", nativeQuery = true)
    List<MemberEntity> findByUserId_nativeQuery(String userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userid WHERE id = :id", nativeQuery = true)
    int updateById_nativeQuery(String userid, Long id);

    // And, Or를 메소드 이름에 추가할 수 있다.
    // OrderBy 필드이름 Desc, Asc
    // First5, Last5
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userid, String username);

    // JPQL
    @Query(value = "SELECT m FROM MemberEntity m WHERE m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL_Query(String userid);

    Boolean existsByJoindateLessThanEqual(LocalDate date);
}