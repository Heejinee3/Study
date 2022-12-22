
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
