package GREEDY;
import java.util.*;
public class Greedy_CardSort_1715 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        Vector<Integer> v=new Vector<>();
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();

        int arr_sum=0;
        int count=0,sum=0;
        for(int i=0;i<x;i++){
            int num=sc.nextInt();
            priorityQueue.add(num);
        }
        if(x==1){
            System.out.println(0);
            return;
        }
        while(count!=x-1){
            sum=0;
            sum+=priorityQueue.remove()+priorityQueue.remove();
            arr_sum+=sum;
            priorityQueue.add(sum);
            count++;
        }
        System.out.println(arr_sum);

    }
}
