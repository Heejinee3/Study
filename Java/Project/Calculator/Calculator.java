import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

// 자바에서 GUI 기반 앱 만들기
// Graphic User Interface
// AWT, SWING 클래스 사용(JAVA FX은 사용안함)
// AWT: 저수준의 UI 지원, Frame, Panel
// SWING: 고수준의  UI 지원, JFrame, JPanel
// Frame: 윈도우창 뼈대
// Panel: 컨트롤을 감싸놓은 것(컨테이너)
// Layout: 배치하는 방법
//      1. BorderLayout: 기본 레이아웃, 상하좌우중앙에 배치
//      2. FlowLayout: 흘러가는대로 배치
//      3. GridLayout: 바둑판 모양 배치
//      등등...


public class Calculator extends JFrame{

    static JTextField textField = null;
    static String text = "";

    double calculate(){
        String[] numericTermString = text.split("\\+|-|\\*|/");
        LinkedList<Double> numericTerm = new LinkedList<>();        // 숫자 list
        LinkedList<Character> operatorTerm = new LinkedList<>();    // 연산자 list

        System.out.println(text);

        for (String t: numericTermString){          // text에서 숫자를 뽑아 넣기
            numericTerm.add(Double.parseDouble(t));
        }
        for (int i = 0; i < text.length(); i++){    // text에서 연산자를 뽑아 넣기
            char c = text.charAt(i);
            if (c == '+' | c == '-' | c == '/' | c == '*')
                operatorTerm.add(text.charAt(i));
        }

        // *, / 먼저 계산하기
        Iterator<Character> it = operatorTerm.iterator();
        int idx = 0;
        while (it.hasNext()) {
            char c = it.next();
            if (c == '/' || c == '*'){                  // 나눗셈과 곱셈 연산자일 때,
                it.remove();                            // 연산자를 list에서 제거
                double a = numericTerm.remove(idx);     // 좌측 숫자를 list에서 제거
                double b = numericTerm.remove(idx);     // 우측 숫자를 list에서 제거

                if (c == '/'){
                    numericTerm.add(idx, a/b);  // 나눗셈 결과값 list에 넣기
                }
                else{
                    numericTerm.add(idx, a*b);  // 곱셈 결과값 list에 넣기
                }
            }
            else {
                idx++;
            }
        }

        // +, - 계산하기
        it = operatorTerm.iterator();
        idx = 0;
        while (it.hasNext()) {
            char c = it.next();
            it.remove();                            // 연산자를 list에서 제거
            double a = numericTerm.remove(idx);     // 좌측 숫자를 list에서 제거
            double b = numericTerm.remove(idx);     // 우측 숫자를 list에서 제거

            if (c == '+'){
                numericTerm.add(idx, a+b);  // 덧셈 결과값 list에 넣기
            }
            else{
                numericTerm.add(idx, a-b);  // 뺄셈 결과값 list에 넣기
            }
        }

        System.out.println("result: " + numericTerm.get(0));
        return numericTerm.get(0);
    }
    public Calculator(String title){
        super(title);

        // 프레임 설정
        setSize(500,500);               // 프레임 크기 조절
        setLocationRelativeTo(null);                // 프레임 화면 위치 가운데로 옮기기
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 프로그램 종료버튼 활성화
        setLayout(new BorderLayout());              // 보더레이아웃으로 설정

        // 윗쪽 UI 만들기
        textField = new JTextField();                                       // 문자 입력창
        textField.setFont(new Font("D2Coding", Font.PLAIN, 40)); // 글자꼴, 크기 설정
        textField.setForeground(new Color(100, 100, 255));         // 글자 색 설정
        add(textField, BorderLayout.NORTH);

        // 가운데 UI 만들기
        JPanel panel = new JPanel(new GridLayout(4,4)); // 컨트롤을 감싸놓은 것
        String[] buttons = {"7","8","9","+",
                            "4","5","6","-",
                            "1","2","3","*",
                            "0","Clear","=","/"};

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼이 눌렸을 때, 눌린 버튼 객체를 가져오기
                JButton btn = (JButton)e.getSource();
                String btnText = btn.getText();

                if (btnText.equals("=")){                                                               // =이 눌렸을 때
                    if (text.length() == 0){                                                            // 비어있을 때 =을 누르면 0을 출력한다
                        text = "0";
                        textField.setText(text);
                    }else {
                        char lastChar = text.charAt(text.length() - 1);
                        if (lastChar == '*' || lastChar == '+' || lastChar == '-' || lastChar == '/') { // 연산자가 있을 때 =을 누르면 그대로 출력한다.
                            textField.setText(text);
                        }
                        else{                                                                           // 숫자가 있을 때 =을 누르면 계산을 한다.
                            double result = calculate();
                            textField.setText(String.valueOf(result));
                            text = String.valueOf(result);
                        }
                    }
                }
                else if (btnText.equals("Clear")){ // Clear가 눌렸을 때 비운다
                    text = "";
                    textField.setText(text);
                }
                else if (btnText.equals("*") || btnText.equals("/") || btnText.equals("+") || btnText.equals("-")){ // +,-,*,/(연산자)가 눌렸을 때
                    if (text.length() == 0){                                                                        // 비어있을 때 연산자를 누르면 앞에 0을 넣어준다
                                                                                                                    // ex) 비어있는 상태에서 '+'가 눌리면 0+로 바꿔준다
                        text = "0" + btnText;
                        textField.setText(text);
                    }else {
                        char lastChar = text.charAt(text.length() - 1);
                        if (lastChar == '*' || lastChar == '+' || lastChar == '-' || lastChar == '/') {             // 연산자가 있을때 또 연산자를 누르면 해당 연산자로 바꿔준다
                                                                                                                    // ex) '5+'가 입력된 상태에서 '-'가 입력되면 '5-'로 바꿔준다
                            text = text.substring(0, text.length() - 1);
                        }
                        text = text + btnText;                                                                      // 숫자가 있을 때 연산자를 누르면 그냥 넣어준다
                        textField.setText(text);
                    }
                }
                else {                          // 숫자가 입력되었을 때 그냥 넣어준다
                    text = text + btnText;
                    textField.setText(text);
                }

                // 문자열 가져오기
                //System.out.println(textField.getText());

            }
        };

        for(String button: buttons){
            JButton btn = new JButton(button);
            btn.setFont(new Font("D2Coding", Font.PLAIN, 30)); // 글자꼴, 크기 설정
            // 각 버튼에 이벤트(마우스 클릭)처리 코드를 추가한다.
            // 이벤트 대응 코드를 리스너(Listener)라고 한다.
            // ActionListener 인터페이스의 구현 객체를 넣어준다
            btn.addActionListener(al); // this는 Calculator 클래스를 의미

            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {

        Calculator calc = new Calculator("계산기");
        calc.setVisible(true);
    }
}
