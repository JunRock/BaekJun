package 구현;
import java.util.*;
public class 구현_Card_2161 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        Vector<Integer> vector=new Vector<>();

        for(int i=1;i<=num;i++)
            queue.add(i);

        while(!queue.isEmpty()){
            vector.add(queue.remove());
            int x=queue.remove();
            queue.add(x);
        }
        for(int i=0;i< vector.size();i++)
            System.out.print(vector.get(i)+" ");
    }
}
