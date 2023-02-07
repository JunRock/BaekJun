package Dp;
import java.util.*;
public class Dp_평범한배낭_12865 {
    public void run(){
        int []weight;
        int []value;
        int [][]dp;
        int num, k;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        k=sc.nextInt();
        weight=new int[num+1];
        value=new int[num+1];
        dp=new int[num+1][k+1];

        for(int i=1;i<=num;i++){
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }

        for(int i=1;i<=num;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j];
                if(j-weight[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[num][k]);
    }

    public static void main(String[] args){
        Dp_평범한배낭_12865 dp_평범한배낭_12865=new Dp_평범한배낭_12865();
        dp_평범한배낭_12865.run();
    }
}
