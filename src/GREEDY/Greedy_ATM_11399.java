package GREEDY;
import java.util.*;
public class Greedy_ATM_11399 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int waitTime=0;
        int sum=0;
        int[] arr=new int[size];

        for(int i=0;i<size;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);

        for(int i=0;i<size;i++){
            waitTime=arr[i]+waitTime;
            sum+=waitTime;
        }

        System.out.println(sum);
    }
}
