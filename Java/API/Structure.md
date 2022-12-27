
# Type

    int myInt               = 10;
    long myLong             = 20L;
    short myShort           = 30;
    byte myByte             = 40;
    float myFloat           = 3.14f;
    double myDouble         = 6.24d;
    boolean myBoolean       = false;
    char myChar             = 'A';
    
    String myString         = "홍길동1234";
    Integer myInteger       = 10;
    Long myLong             = 20L;
    Short myShort           = 30;
    Byte myByte             = 40;
    Float myFloat           = 3.14f;
    Double myDouble         = 6.24d;
    Boolean myBoolean       = false;
    Character myCharacter   = 'A';
    Number myNumber         = 10;

    int                     = myInteger.intValue();
    long                    = myLong.doubleValue();
    short                   = myShort.shortValue();
    byte                    = myByte.ByteValue();
    float                   = myFloat.FloatValue();
    double                  = myDouble.DoubleValue();
    boolean                 = myBoolean.BooleanValue();
    Character               = myCharacter.CharacterValue();
    
# If/Switch

    if (조건문) {        // if문
        수행문;
    } else if (조건문) { 
        수행문;
    } else {
        수행문;
    }

    switch (변수) {      // switch문
      case 1:
        수행문;
        break;
      case 2:
        수행문;
        break;
      default:
        수행문;
        break;
    }
    
# For/While/Do-while

    for (초기화; 조건식; 증감문){ // for문
      수행문;
    }

    for (int value: array) {    // 간단한 for문
        수행문;
    }

    while(조건식){               // while문
      수행문;
    }

    do{                         // do-while문
      수행문;
    }while(조건식);
    
# Array

    int[] arr = new int[length];
    int[] arr = {value1, value2, ...};
    arr[index] = value;

    int[][] arr = new int[row-length][column-length];
    int[][] arr = {
        {value1, value2, value3},
        {value4, value5, value6}
    };
    arr[row-index][column-index] = value;
    
# Enum
    
    enum EnumName {
        enumtype1,
        enumtype2,
        enumtype3
    };
    
    EnumName myEnum = EnumName.enumtype; 
    EnumName.values();                   // enumtype list
    
# Class

    class ClassName{                                   // class 이름
    
        int value;                                     // instance variable
        
        static int staticValue;                        // static variable

        void function(int param){                      // instance function
        }
        
        static void staticFunction(int param){         // static function
        }
        
        public ClassName(int value){                   // constructor
            this.value = value;
        }

        public int getValue() {                        // instance variable get 함수
            return this.value;
        }

        public static int getStaticValue() {           // static variable get 함수
            return staticValue;
        }

        public void setValue(int value) {              // instance variable set 함수
            this.value = value;
        }

        public static void setStaticValue(int value) { // static variable set 함수
            staticValue = value;
        }
    }
    
    public class Main {
        public static void main(String[] args) {
        
            ClassName object = new ClassName(value); // 객체 생성

            object.value;                            // instance variable
            object.function(value);                  // instance function
            object.setValue(value);                  // instance variable set 함수
            object.getValue();                       // instance variable get 함수
            
            ClassName.staticValue;                   // static variable
            ClassName.staticFunction(value);         // static function
            ClassName.setStaticValue(value);         // static variable set 함수
            ClassName.getStaticValue();              // static variable get 함수
            
        }
    }
   
# Access Modifier

    /* public   : 모든 클래스(파일)에서 접근 가능
       protected: 같은 폴더(패키지) or 자식 클래스(하위)에서 부모 클래스(상위) 접근 가능
       default  : 같은 폴더(패키지)에서 접근 가능
       private  : 같은 클래스 안에서만 접근 가능                                      */
       
# Inheritance

    class ClassName1{
    
        int value;
        void function(int param) {
        }
        public ClassName1(int value){  
            this.value = value;
        }
    }
    
    class  ClassName2 extends ClassName1{
        public ClassName2(int value) {
            super(value);
        }
        @Override
        void function(int param) {
            System.out.println(param);
        }
    }

# Abstract Class

    abstract class ClassName1{
        abstract void function1();
        void function2(){
        }
    }

    class ClassName2 extends ClassName1{
        @Override
        void function1() {
        }
    }

# Interface

    interface InterfaceName {
        abstract void function1();
        void function2();
    }
    
    class ClassName implements InterfaceName {
        @Override
        public void function1() {
        }
        
        @Override
        public void function2() {
        }
    }

# Thread

    class ClassName extends Thread{         // 1. Thread Class에 상속받기
        @Override
        public void run() {
        }
    }
    ClassName object = new ClassName();
    object.start();
  
    class ClassName implements Runnable{    // 2. Runnable Interface에 상속받기
        @Override
        public void run() {
        }
    }
    ClassName object = new ClassName();
    Thread thread = new Thread(object);
    thread.start();

# Exception 
    
    try{                                // 1. 직접 처리하기
        throw new Exception();
    }catch (Exception e){
    }

    void Function() throws Exception{   // 2. 호출한 곳으로 넘기기
    }
    
    throw new Exception();              // cf. Exception 발생
    
# Socket Client

    import java.io.InputStream;
    import java.io.OutputStream;
    import java.net.InetSocketAddress;
    import java.net.Socket;

    public class SocketClient {
        public static void main(String[] args) {

            try {
                Socket socket = new Socket();                                                 // Socket
                socket.connect(new InetSocketAddress("127.0.0.1", 5001));                     // Connect

                OutputStream os = socket.getOutputStream();                                   // Write / Read
                InputStream is = socket.getInputStream();

                String sendString = "message";
                sendMessage(sendString, os);
                String receiveString = receiveMessage(is);
                System.out.println(receiveString);

                os.close();                                                                   // Close
                is.close();
                socket.close();

            } catch (Exception e) {
                System.out.println("서버 접속 오류!");
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
    
# Socket Server

    import java.io.InputStream;
    import java.io.OutputStream;
    import java.net.InetSocketAddress;
    import java.net.ServerSocket;
    import java.net.Socket;

    public class SocketServer {
        public static void main(String[] args) {

            try {
                ServerSocket serverSocket= new ServerSocket();                                // Socket
                serverSocket.bind(new InetSocketAddress("127.0.0.1", 5001));                  // Bind

                while(true){
                    Socket socket = serverSocket.accept();                                    // Accept

                    InputStream is = socket.getInputStream();                                 // Read / Write
                    OutputStream os = socket.getOutputStream();

                    String receiveString = receiveMessage(is);
                    System.out.println(receiveString);
                    String sendString = "message";
                    sendMessage(sendString, os);

                    is.close();                                                               // Close
                    os.close();
                    socket.close();

                    if (receiveString.equals("exit")){
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("서버 초기화 에러!");
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
    
# Singleton

    class Singleton{

        private static Singleton singleton = new Singleton();

        static Singleton getInstance(){
            return singleton;
        }
    }

    Singleton singleton = Singleton.getInstance();

# Anonymous Object

    interface Anonymous{
        void function();
    }

    Anonymous ao = new Anonymous() {
        @Override
        public void function() {
        }
    };
    ao.function();

# Nested Class

    class Outer{
        String name = "outer";
        
        class Inner{
            String name = "inner";
        }
        
        static class InnerStatic{
            String name = "inner static";
        }
    }

    Outer outer = new Outer();
    System.out.println(outer.name);

    Outer.Inner inner = outer.new Inner();
    System.out.println(inner.name);

    Outer.InnerStatic is = new Outer.InnerStatic();
    System.out.println(is.name);

# Lambda Expression 

    @FunctionalInterface
    interface MyFunction{
        int function(int x, int y);
    }

    MyFunction f = (x, y) -> {return x + y;};
    f.function(10, 20);
