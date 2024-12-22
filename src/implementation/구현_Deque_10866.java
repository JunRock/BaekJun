package implementation;
import java.util.*;
public class 구현_Deque_10866 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int x;
        Deque<Integer> deque=new LinkedList<>();
        int count=0;
        while(count!=num){
            String order=sc.next();
            if(order.equals("push_back")){
                x=sc.nextInt();
                deque.addLast(x);
            }
            else if(order.equals("push_front")){
                x=sc.nextInt();
                deque.addFirst(x);
            }
            else if(order.equals("front")){
                if(deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.peekFirst());
            }
            else if(order.equals("back")){
                if(deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.peekLast());
            }
            else if(order.equals("size")){
                System.out.println(deque.size());
            }
            else if(order.equals("empty")){
                if(!deque.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if(order.equals("pop_front")){
                if(deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.removeFirst());
            }
            else if(order.equals("pop_back")){
                if(deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.removeLast());
            }
            count++;
        }

    }
}
