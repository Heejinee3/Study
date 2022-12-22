import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class Server {

    static int[][] map = new int[3][3]; // 비어있을 때는 0, Client1이 놓았을 때는 1, Client2가 놓았을 때는 2
    static String board = "- - -\n"     // 비어있을 때는 -, Client1이 놓았을 때는 O, Client2가 놓았을 때는 X
                        + "- - -\n"
                        + "- - -\n";

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket= new ServerSocket();
            serverSocket.bind(new InetSocketAddress("192.168.100.39", 5001));   // 자신의 아이피 넣기

            while(true){

                // Client1과 Client2를 연결함
                System.out.println("서버가 연결을 기다리는 중...");
                Socket socket1 = serverSocket.accept();
                InetSocketAddress isa1 = (InetSocketAddress)socket1.getRemoteSocketAddress();
                System.out.println("서버가 연결을 수락함: " + isa1.getHostName());
                Socket socket2 = serverSocket.accept();
                InetSocketAddress isa2 = (InetSocketAddress)socket2.getRemoteSocketAddress();
                System.out.println("서버가 연결을 수락함: " + isa2.getHostName());

                // static 변수 리셋하기
                map = new int[3][3];
                board =   "- - -\n"
                        + "- - -\n"
                        + "- - -\n";

                // 지역 변수 설정
                OutputStream os1 = socket1.getOutputStream();
                OutputStream os2 = socket2.getOutputStream();
                InputStream is1 = socket1.getInputStream();
                InputStream is2 = socket2.getInputStream();
                String msg1 = "";
                String msg2 = "";
                int win = -1; // 1이면 client1이 승, 2이면 client2가 숭, 0이면 draw, -1이면 아직 게임이 끝나지 않음

                // 게임 시작 신호 보내기
                sendStartSignal(os1, os2);

                // 준비 됐는지 신호 받기
                receiveReadySignal(is1, is2);

                int turn = 0;
                while (turn < 9) {

                    // Client1에게 바둑판 보내기
                    sendBoard(os1, os2, 1);

                    // Client1에게 input 받기
                    msg1 = receiveIndex(is1, is2, os1, 1);

                    // 바둑판 다시 세팅하기
                    resetBoard(msg1, 1);

                    // 바둑판 종료 조건 확인하기
                    win = checkWinner(turn);
                    if (win == 0 || win == 1 || win == 2)   // Draw(0), Client1 Win(1), Client2 Win(2)
                        break;

                    // 턴을 넘김
                    turn++;

                    // Client2에게 바둑판 보내기
                    sendBoard(os1, os2, 2);

                    // Client2에게 input 받기
                    msg2 = receiveIndex(is1, is2, os2, 2);

                    // 바둑판 다시 세팅하기
                    resetBoard(msg2, 2);

                    // 바둑판 종료 조건 확인하기
                    win = checkWinner(turn);
                    if (win == 0 || win == 1 || win == 2) // Draw(0), Client1 Win(1), Client2 Win(2)
                        break;

                    // 턴을 넘김
                    turn++;
                }

                // Winner가 누구인지 client에게 알려줌
                sendWinner(win, os1, os2);

                is1.close();
                is2.close();
                os1.close();
                os2.close();
                socket2.close();
                socket1.close();

            }
        } catch (Exception e) {
            System.out.println("통신 오류!");
        }

    } // main 함수

    static void sendBoard(OutputStream os1, OutputStream os2, int turn) throws Exception {

        String sendString1 = "";
        String sendString2 = "";

        if (turn == 1) { // Client1의 턴일 때
            sendString1 = board + "It's your turn\r\n" + "Input 'x,y' (x and y: 0,1,2)";
            sendString2 = board + "Waiting Client1...";
        }
        else{ // Client2의 턴일 때
            sendString1 = board + "Waiting Client2...";
            sendString2 = board + "It's your turn\r\n" + "Input 'x,y' (x and y: 0,1,2)";
        }

        sendMessage(sendString1, os1);
        sendMessage(sendString2, os2);

        System.out.println("Finished sending board to Client1");
        System.out.println("Finished sending board to Client2");
    }
    static String receiveIndex(InputStream is1, InputStream is2, OutputStream os, int turn) throws Exception {

        String adjustMsg = "";
        String stayMsg = "";
        InputStream adjustIs = null;
        InputStream stayIs = null;
        String pattern = "[0-2],[0-2]"; // client가 서버에게 보낸 index가 "x,y"의 형식일 때 (x,y는 0 ~ 2 사이의 정수)

        if (turn == 1) { // Client1의 턴일 때
            adjustIs = is1;
            stayIs = is2;
        }
        if (turn == 2) { // Client2의 턴일 때
            adjustIs = is2;
            stayIs = is1;
        }

        while(true){
            adjustMsg = receiveMessage(adjustIs);
            System.out.println("Client" + turn + " sends: " + adjustMsg);

            boolean match = Pattern.matches(pattern, adjustMsg);
            if (match == false ){ // client가 서버에게 보낸 index가 "x,y" (x,y는 0 ~ 2 사이의 정수) 형식이 아닐 경우
                sendMessage("Wrong Input. Send again", os);
                System.out.println("Finished sending board to Client" + turn + " again");

            }else{
                String[] splitString = adjustMsg.split(",");
                int x = Integer.parseInt(splitString[0]);
                int y = Integer.parseInt(splitString[1]);
                if (map[x][y] != 0){ // client가 서버에게 보낸 index가 형식이 맞지만 이미 보드에 놓았던 자리일 때
                    sendMessage("Wrong Input. Send again", os);
                    System.out.println("Finished sending board to Client" + turn + " again");
                }
                else{ // 정상적인 index가 보내질 경우
                    break;
                }
            }
        }

        turn = (turn == 1)? 2: 1;

        stayMsg = receiveMessage(stayIs);
        System.out.println("Client" + turn + " sends: " + stayMsg);

        return adjustMsg;
    }
    static void sendStartSignal(OutputStream os1, OutputStream os2) throws Exception {

        String sendString1 = "START! You are client1. Use 'O'\r\n" + "Are you ready?";
        String sendString2 = "START! You are client2. Use 'X'\r\n" + "Are you ready?";

        sendMessage(sendString1, os1);
        sendMessage(sendString2, os2);

        System.out.println("Send start signal Done");
    }
    static void receiveReadySignal(InputStream is1, InputStream is2) throws Exception {

        String receiveString1 = receiveMessage(is1);
        String receiveString2 = receiveMessage(is2);

        System.out.println("Client1: " + receiveString1);
        System.out.println("Client2: " + receiveString2);
    }

    static void sendWinner(int win, OutputStream os1, OutputStream os2) throws Exception {
        if (win == 0){ // 비겼을 때
            sendMessage(board + "Draw!", os1);
            sendMessage(board + "Draw!", os2);
        }
        else { // 승자가 나왔을 때
            sendMessage(board + "Client" + win + " Win!", os1);
            sendMessage(board + "Client" + win + " Win!", os2);
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

    static void resetBoard(String receiveString, int i) throws Exception {
        String[] splitString = receiveString.split(",");
        int x = Integer.parseInt(splitString[0]);
        int y = Integer.parseInt(splitString[1]);
        map[x][y] = i;

        StringBuilder sb = new StringBuilder(board);
        if (i == 1) // Client1의 턴일 때
            sb.setCharAt(6 * x + 2 * y, 'O');
        else // Client2의 턴일 때
            sb.setCharAt(6 * x + 2 * y, 'X');
        board = sb.toString();
    }

    static int checkWinner(int turn) throws Exception {

        int win = -1;

        // 1. 가로 행이 빙고일 때,
        for (int l = 0; l < 3; l++){
            if (map[l][0] == map[l][1] && map[l][1] == map[l][2] && map[l][0] != 0) {
                win = map[l][0];
                return win;
            }
        }
        // 2. 세로 열이 빙고일 때,
        for (int l = 0; l < 3; l++){
            if (map[0][l] == map[1][l] && map[1][l] == map[2][l] && map[0][l] != 0) {
                win = map[0][l];
                return win;
            }
        }
        // 3. 대각선이 빙고일 때,
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] != 0) {
            win = map[0][0];
            return win;
        }
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] != 0) {
            win = map[0][2];
            return win;
        }
        // 4. 모든 칸이 채워졌을 때,
        if (turn == 8){
            win = 0;
            return win;
        }

        return win;
    }
}