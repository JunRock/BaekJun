package GREEDY;
import java.util.*;
public class Greedy_HappyPreschool_13164 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int answer=0;
        int[] arr=new int[x];
        int[]diff=new int[x-1];

        for(int i=0;i<x;i++)
            arr[i]=sc.nextInt();

        for(int i=0;i<x-1;i++){
            diff[i]=arr[i+1]-arr[i];
        }

        Arrays.sort(diff);
        for(int i=0;i<x-y;i++)
            answer+=diff[i];

        System.out.println(answer);
    }
}
