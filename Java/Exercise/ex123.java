import java.net.InetAddress;
import java.net.UnknownHostException;

public class ex123 {
    public static void main(String[] args) throws Exception {
        // 통신: IP 주소 알아오기
        // IP Address: Internet Protocol Address의 약자
        //           : 인터넷 상의 컴퓨터의 주소
        // IP v4: 오늘날의 일반적인 IP 주소, 32bit
        //      : 0.0.0.0 ~ 255.255.255.255까지 약 43억개의 주소 체계.
        // IP v6: 모든 단말에 주소를 부여하기에는 v4로는 부족함.
        //      : 128bit, 6자리 주소 체계. 아직은 도입되는 시기
        // 내 IP 주소 확인하는 방법
        // 1. 네이버 - 아이피 확인 검색(14.39.239.118)
        // 2. 명령 프롬프트(파워셀) - 윈도우즈 검색 cmd, powershell
        //                       - ipconfig: 192.168.100.39
        // Ctrl + Insert: 복사, Shift + Insert: 붙여넣기

        // IP 주소 2종류
        // 1. 공인 IP: 14.39.239.118
        //    1) 고정 IP: 비용이 비싸다.
        //    2) 유동 IP: 비용이 저렴하다. 재접속(리셋)시에는 IP 바뀜
        // 2. 사설(가상) IP: 192.168.100.39
        //    유무선공유기(허브, 라우터)에서 IP 가상으로 할당하여 내부적으로만 사용한다
        //    192.168.0.1 ~ 255

        // 통신의 흐름
        // 255개의 내부 단말(유동IP) <-> 공유기(중간IP) <-> 허브, 라우터(고정IP) <-> 인터넷
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터 IP 주소: " + localhost.getHostAddress());
        System.out.println("내 컴퓨터 호스트 이름: " + localhost.getHostName());
        InetAddress[] iaArray = InetAddress.getAllByName("www.daum.net");
        for (InetAddress remote: iaArray){
            System.out.println("daum ip: " + remote.getHostAddress());
            System.out.println("name: " + remote.getHostName());
        }

        // 도메인 네임 서버: Domain Name Server
        // : IP를 숫자로 기억하기 어렵기 때문에 글자로 접속하기 위해서 사용하는 서버
        // : daum.net <-> 211.249.220.24
        // DNS 무료(유료) 제공 서버가 있다
        // 도메인 네임은 구매해야 됨: 가비아, 후이즈, AWS, 카페24 등
        //                        .xyz .io 1년에 2500원
        // 가비아 도메인 관리자 페이지에서 Forward 서비스를 신청하면 됨
        // 예) www.hboard.xyz => 43.200.251.42
        // AWS EC2 => 1년 무료후 유료전환(한달 2만 5천원)
        //         => 스케일링 가능(메모리, CPU, 네트워크 등)
        //     Lightsail => 3개월 무료후 유료전환(한달 5천원)
        //               => 가상서버이고, 스케일링 2G 메모리로 선정
        //

    }
}
