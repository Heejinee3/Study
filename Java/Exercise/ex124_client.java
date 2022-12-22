// 인터넷 통신
// 1. TCP/IP(socket 통신): 게임, 채팅에 사용됨
//                      : 속도가 빠르다.
//                      : 연결 지향(한번 접속하면, 계속 연결이 지속됨)
//                      : 비공개 포트 방식(Port: 컴퓨터에서 응용프로그램마다 가지는 통신 창구)
//                      : 공식 포트 80 HTTP, 21 FTP, 443 HTTPS
// 2. HTTP 통신: 대부분의 웹앱에서 사용됨
//            : 80이나 443포트만 이용, 내부망에서 8080, 8090 포트들이 사용됨
//            : 웹브라우저 서비스 대응 용도에 사용됨

// 클라이언트 (서비스를 제공받으면 클라이언트) <--> 서버 (서비스를 제공하면 서버)

// 연습문제 64-1.
// 1. 2인1조로 소켓 통신하기
// 2. 한사람의 PC를 서버로 선택한다. ipconfig로 192.168.*.* IP 주소를 다른사람에게 알려준다.
// 3. 다른 한사람은 알려준 서버주소로 연결하고 메시지를 전송한다.
// 4. "클라이언트 홍길동입니다" 메시지를 수정하여 전송한다.
// 5. 전송 결과를 DM으로 제출하시오.

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ex124_client {
    public static void main(String[] args) {

        Socket socket = new Socket();

        // 127.0.0.1: 자기 컴퓨터의 주소를 말함. localhost와 같은 말
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", 5001));
            System.out.println("서버 접속 성공!");

            // 서버에 문자열형으로 데이터를 보내보자
            byte[] bytes = null;
            String message = null;

            OutputStream os = socket.getOutputStream();
            //message = "Hi, This is Client~";
            message = "클라이언트 정희진입니다.";

            // UTF-8: 문자 인토킹(부호화, 암호화) 타입
            // 문자 인코딩 타입: ASCII(영문), EUC-KR(완성형 한글), UTF-8(유니코드-전세계문자)
            //              : cp949(ms949) 윈도우즈 한글 인코딩
            bytes = message.getBytes("UTF-8");
            os.write(bytes);
            os.flush(); // 버퍼에 데이터를 다 내보낸다.
            System.out.println("데이터 보내기 성공!");

            //서버로부터 데이터 받기
            InputStream is = socket.getInputStream();
            bytes = new byte[1024];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount,"UTF-8");
            System.out.println("데이터받기 성공: " + message);

            os.close();
            is.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("서버 접속 오류!");
        }
    }
}
