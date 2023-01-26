# MemberEntity.java

```
@Entity
@Table(name="MEMBER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    // SQUENCE: Oracle, PostgreSQL
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @SequenceGenerator(sequenceName = "member_seq", allocationSize = 1, name = "member_seq_gen")
    private Long id;

    // IDENTITY: MySQL, MariaDB, PostgreSQL, H2DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id") // 변수 이름과 DB 열의 이름이 다를 때 매칭
    private String userId; // 언더바 생략 가능, 대소문자 구분 안함

    private String userPw;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 자바 클래스와 DB/Form Data와 매핑시 형식을 정해줌
    private LocalDate joindate;
}
```

# MemberRepository.java

```
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    // 기본 함수에서 변형
    List<MemberEntity> findByUserId(String userid);

    // 네이티브 쿼리
    @Query(value = "SELECT * FROM member WHERE user_id = :userid", nativeQuery = true)
    List<MemberEntity> funciton(String userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userid WHERE id = :id", nativeQuery = true)
    int funciton(String userid, Integer id); // Update, Insert, Delete문은 @Modifying, @Transactional을 추가해야됨

    // And, Or를 메소드 이름에 추가할 수 있다.
    // OrderBy 필드이름 Desc, Asc
    // First5, Last5
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userid, String username);

    // JPQL
    @Query(value = "SELECT m FROM MemberEntity m WHERE m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL_Query(String userid);

    Boolean existsByJoindateLessThanEqual(LocalDate date);
}
```

### Basic Function

| Function                                            | Return                   | Explanation                                                        |
| --------------------------------------------------- | ------------------------ | ------------------------------------------------------------------ |
| count()                                             | long                     | returns the number of entities available                           |
| delete(MemberEntity member)                         | void                     | deletes an entity                                                  |
| deleteAll()                                         | void                     | deletes all the entities                                           |
| deleteAll(Iterable< extends MemberEntity > members) | void                     | deletes the entities passed as argument                            |
| deleteAll(Iterable< extends Integer > ids)          | void                     | deletes the entities identified using their ids passed as argument |
| existsById(Integer id)                              | boolean                  | checks if an entity exists using its id                            |
| findAll()                                           | Iterable< MemberEntity > | returns all the entities                                           |
| findAllByIds(Iterable< Integer > ids)               | Iterable< MemberEntity > | returns all the entities identified using ids passed as argument   |
| findById(Integer id)                                | Optional< Employee >     | returns an entity identified using id                              |
| save(MemberEntity member)                           | MemberEntity             | saves an entity and return the updated one                         |
| saveAll(Iterable< Employee> entities)               | Iterable< Employee>      | saves all entities passed and return the updated entities          |

# Test

class MemberRepositoryTest extends AppNameApplicationTests{

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        save();
    }

    @Test
    @DisplayName("테스트 이름")
    public void save(){
        memberRepository.save(new MemberEntity(Long.valueOf(1), "hong", "1234", LocalDate.now()));
    }

}

# build.gradle

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // JPA
	  runtimeOnly 'com.h2database:h2'                                        // H2DB
}
```

# application.properties

### H2 Database

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

```
# in-memory DB
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
```

```
# file DB
spring.datasource.url=jdbc:h2:~/testdb
spring.datasource.driverClassName=org.h2.Driver
```

### JPA

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create                                    # 상용 DB에서는 none이나 validate
```

### Log

```
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type.descriptor.sql=trace
```
