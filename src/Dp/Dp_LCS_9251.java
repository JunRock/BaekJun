package Dp;
import java.util.*;
public class Dp_LCS_9251 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        int max=0;
        int[][]dp=new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                    max=Math.max(dp[i+1][j+1],max);
                }
                else{
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
