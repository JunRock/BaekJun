package Dp;
import java.util.*;
public class Dp_StandLine_2631 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int x=sc.nextInt();
        int[] arr=new int[x];
        int[] dp=new int[x];
        int m=0;
        Arrays.fill(dp,1);
        for(int i=0;i<x;i++)
            arr[i]=sc.nextInt();

        for(int i=0;i<x;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
                m=Math.max(m,dp[i]);
            }
        }
        System.out.println(x-m);
    }
}
