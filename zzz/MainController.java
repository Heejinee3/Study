
@Controller
@RequiredArgsConstructor
public class MainController {

    // 생성자 주입
    private final MemberRepository memberRepository;

    @RequestMapping("/")
    public String main(Model model){
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
        model.addAttribute("list", list);
        return "index";
    }
}
