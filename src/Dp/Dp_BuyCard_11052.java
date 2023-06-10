package Dp;
import java.util.*;
public class Dp_BuyCard_11052 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] dp=new int[num+1]; //최대 금액을 담는 dp배열
        int[] arr=new int[num+1]; //카드값을 저장하고 있는 배열

        for(int i=1;i<=num;i++)
            arr[i]=sc.nextInt();

        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }

        System.out.println(dp[num]);
    }

    public static void main(String[] args) {
        Dp_BuyCard_11052 dp_buyCard_11052=new Dp_BuyCard_11052();
        dp_buyCard_11052.run();
    }
}
