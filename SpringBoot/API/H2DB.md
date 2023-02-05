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
