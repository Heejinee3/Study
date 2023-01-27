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

# MainController.java

```
@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberRepository memberRepository;

    @RequestMapping("/")
    public String function(Model model){
        memberRepository.save(
                new MemberEntity(Long.valueOf(1),"hong","1234", LocalDate.now())
        );

        List<MemberEntity> list = memberRepository.findAll();

        model.addAttribute("list", list);
        return "index";
    }
}
```

# MemberRepository.java

```
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    // 기본 함수에서 변형
    List<MemberEntity> findByUserId(String userid);

    // Native Query
    @Query(value = "SELECT * FROM member WHERE user_id = :userid", nativeQuery = true)
    List<MemberEntity> funciton(String userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE member SET user_id = :userid WHERE id = :id", nativeQuery = true)
    int funciton(String userid, Integer id); // Update, Insert, Delete문은 @Modifying, @Transactional을 추가해야됨

    // JPQL
    @Query(value = "SELECT m FROM MemberEntity m WHERE m.userId = :userid")
    List<MemberEntity> findByUserId_JPQL_Query(String userid);

    // 메소드 이름 추가
    List<MemberEntity> findFirst5ByUserIdAndUserNameOrderByIdDesc(String userid, String username);

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

### Query Function

| Keyword            | Sample                                                  | JPQL snippet                                                   |
| ------------------ | ------------------------------------------------------- | -------------------------------------------------------------- |
| Distinct           | findDistinctByLastnameAndFirstname                      | select distinct …​ where x.lastname = ?1 and x.firstname = ?2  |
| Firstn             | findFirst5                                              | …​ limit 5                                                     |
| Lastn              | findLast5                                               | …​ order by x.id limit 5                                       |
| Asc                | findByAgeOrderByIdAsc                                   | …​ order by x.id asc                                           |
| Desc               | findByAgeOrderByIdDesc                                  | …​ order by x.id desc                                          |
| And                | findByLastnameAndFirstname                              | … where x.lastname = ?1 and x.firstname = ?2                   |
| Or                 | findByLastnameOrFirstname                               | … where x.lastname = ?1 or x.firstname = ?2                    |
| Is, Equals         | findByFirstname,findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                                       |
| Between            | findByStartDateBetween                                  | … where x.startDate between ?1 and ?2                          |
| LessThan           | findByAgeLessThan                                       | … where x.age < ?1                                             |
| LessThanEqual      | findByAgeLessThanEqual                                  | … where x.age <= ?1                                            |
| GreaterThan        | findByAgeGreaterThan                                    | … where x.age > ?1                                             |
| GreaterThanEqual   | findByAgeGreaterThanEqual                               | … where x.age >= ?1                                            |
| After              | findByStartDateAfter                                    | … where x.startDate > ?1                                       |
| Before             | findByStartDateBefore                                   | … where x.startDate < ?1                                       |
| IsNull, Null       | findByAge(Is)Null                                       | … where x.age is null                                          |
| IsNotNull, NotNull | findByAge(Is)NotNull                                    | … where x.age not null                                         |
| Like               | findByFirstnameLike                                     | … where x.firstname like ?1                                    |
| NotLike            | findByFirstnameNotLike                                  | … where x.firstname not like ?1                                |
| StartingWith       | findByFirstnameStartingWith                             | … where x.firstname like ?1 (parameter bound with appended %)  |
| EndingWith         | findByFirstnameEndingWith                               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing         | findByFirstnameContaining                               | … where x.firstname like ?1 (parameter bound wrapped in %)     |
| OrderBy            | findByAgeOrderByLastnameDesc                            | … where x.age = ?1 order by x.lastname desc                    |
| Not                | findByLastnameNot                                       | … where x.lastname <> ?1                                       |
| In                 | findByAgeIn(Collection<Age> ages)                       | … where x.age in ?1                                            |
| NotIn              | findByAgeNotIn(Collection<Age> ages)                    | … where x.age not in ?1                                        |
| True               | findByActiveTrue()                                      | … where x.active = true                                        |
| False              | findByActiveFalse()                                     | … where x.active = false                                       |
| IgnoreCase         | findByFirstnameIgnoreCase                               | … where UPPER(x.firstname) = UPPER(?1)                         |

# Test

```
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
```

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
