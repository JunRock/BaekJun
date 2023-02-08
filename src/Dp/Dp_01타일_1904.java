package Dp;
import java.util.*;
public class Dp_01타일_1904 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []dp=new int[n+2];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(2);
            return;
        }

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%15746;
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args){
        Dp_01타일_1904 dp_01타일_1904=new Dp_01타일_1904();
        dp_01타일_1904.run();
    }
}
