import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {

        Socket socket = new Socket();
        try {
            // 게임 서버에 연결함
            socket.connect(new InetSocketAddress("192.168.100.39", 5001));
            System.out.println("서버 접속 성공!");

            // 사전 준비
            Scanner scan = new Scanner(System.in);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            byte[] msgBytes = null;
            int msgByteCount = 0;
            String msg = null;

            // 시작신호 받기
            msg = receiveMessage(is);
            System.out.println(msg);

            // 준비됐다고 말하기
            sendMessage("Ready!", os);
            System.out.println("Ready!");

            while (true) {
                // 바둑판 받기
                msg = receiveMessage(is);
                System.out.println(msg);

                // 게임 종료
                if (msg.contains("Client1 Win!") || msg.contains("Client2 Win!") || msg.contains("Draw!"))
                    break;

                if (msg.contains("Waiting Client")){ // 상대방 턴일 때,
                    msg = "I got board";
                    sendMessage(msg, os);
                }
                else { // 내 턴일 때,
                    msg = scan.nextLine();
                    sendMessage(msg, os);
                }

            }
            os.close();
            is.close();


        } catch (Exception e) {
            System.out.println("통신 오류!");
        }

    }

    static void sendMessage(String sendString, OutputStream os) throws Exception {
        byte[] sendBytes = sendString.getBytes("UTF-8");
        os.write(sendBytes);
        os.flush();
    }

    static String receiveMessage(InputStream is) throws Exception {
        byte[] receiveBytes = new byte[1024];
        int receiveByteCount = is.read(receiveBytes);
        String receiveString = new String(receiveBytes, 0, receiveByteCount, "UTF-8");

        return receiveString;
    }

}
