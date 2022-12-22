
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class ex121 {
    public static void main(String[] args) {
        // 파일을 읽고 쓰기
        // Input Output: IO
        // 파일 쓰기
        // 1. 바이트(Byte) 단위 파일 쓰기
        // 2. 문자(Character) 단위 파일 쓰기
        // 3. 대용량의 파일 쓰기 - 속도 개선
        writeFile1();
        writeFile2();
        writeFile3();
    }

    static void writeFile1(){
        // FileOutputStream 클래스 사용
        String filePath = "./out1.txt";
        try {
            FileOutputStream fos =  new FileOutputStream(filePath);

            // \r: 커서(입출력위치) 맨 첫열로 이동
            // \n: 커서 줄바꿈
            String data = "파일에 문자열 쓰기 1\r\n";

            // getBytes(): 문자열을 byte 단위 정수로 바꿔서 반환
            fos.write(data.getBytes());

            data = "파일에 문자열 쓰기 2\r\n";
            fos.write(data.getBytes());

            fos.close(); // 버퍼메모리 정리

        } catch (Exception e) {
            System.out.println("파일 입출력 에러!");
            e.printStackTrace(); // 에러 내용 보기
        }


    }
    static void writeFile2(){
        // FileWriter 클래스
        FileWriter fw = null;
        String filePath = "./out2.txt";
        try {
            fw = new FileWriter(filePath);
            fw.write("홍길동\r\n");
            fw.write("사임당\r\n");
            fw.write("제임스\r\n");
            fw.write("손흥민\r\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("파일 입출력 에러2!");
            e.printStackTrace();
        }

    }
    static void writeFile3(){
        // BufferedWriter 클래스: 대용량 파일을 쓸 때
        // Buffer: 입출력 속도에 따른 여유 메로리 공간을 의미
        String filePath = "./out3.txt";
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("춘향이\r\n");
            bw.newLine(); // 빈줄 추가
            bw.write("홍길동\r\n");
            bw.write("춘향이\r\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("파일 입출력 에러 3!");
            e.printStackTrace();
        }
    }

}
