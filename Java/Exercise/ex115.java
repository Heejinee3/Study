import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex115 {
    public static void main(String[] args) {
        // 스택과 큐
        // 스택(Stack): LIFO(Last In First Out)
        //           : 함수 호출시 주로 사용하는 구조
        // 큐(Queue): FIFO(First In First Out)
        //          : 버퍼(Buffer) 입력속도와 출력속도가 다른 경우에 완충역할을 함

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.contains(10));
        System.out.println(stack.empty());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.offer(40);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.size());

    }
}
