import java.io.*;

public class ex122 {
    public static void main(String[] args) throws Exception {
        // 파일 읽기
        // 1. 바이트(Byte) 단위 파일 읽기
        // 2. 문자(Character) 단위 파일 일기
        // 3. 대용량의 파일 읽기 - 속도 개선
        readFile1();
        //readFile2();
        //readFile3();
    }
    static void readFile1() throws Exception {

        // FileInputStream 클래스
        String filePath = "./src/ex121.java";
        FileInputStream fis = new FileInputStream(filePath);

        int data = 0; // 읽은 바이트 데이터를 저장하는 용도
        do {
            data = fis.read();
            if (data != -1) {
                System.out.print((char)data);
            }
        } while(data != -1); // 파일의 끝(eof)은 -1
        fis.close();

    }
    static void readFile2() throws Exception {

        // FileReader 클래스
        String filePath = "./src/ex121.java";
        FileReader fr = new FileReader(filePath);
        int data = 0;
        do {
            data = fr.read();
            if (data != -1) {
                System.out.print((char)data);
            }
        } while (data != -1);

    }
    static void readFile3() throws Exception {
        String filePath = "./src/ex121.java";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String text = "";
        while(text != null){
            // readLine(): 한줄의 데이터를 읽어옴.(\r\n문자로 구분)
            //           : 파일의 끝(EOF)면 null 반환.
            text = br.readLine();
            System.out.println(text);
        }
        br.close();
    }
}
