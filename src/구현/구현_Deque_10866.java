package 구현;
import java.util.*;
public class 구현_Deque_10866 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int x;
        Deque<Integer> deque=new LinkedList<>();

        for(int i=0;i<num;i++){
            String order=sc.next();
            if(order.equals("push_back")){
                x=sc.nextInt();
                deque.addLast(x);
            }
            else if(order.equals("push_front")){
                x=sc.nextInt();
                deque.addLast(x);
            }
            else if(order.equals("front")){
                System.out.println(deque.peekFirst());
            }
            else if(order.equals("back")){
                System.out.println(deque.peekLast());
            }
            else if(order.equals("size")){
                System.out.println(deque.size());
            }
            else if(order.equals("empty")){
                System.out.println(deque.peekFirst());
            }
        }
    }
}
