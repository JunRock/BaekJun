package Dp;

import java.util.*;

public class Dp_긴증가부분수열 {
    public void run() {
        Scanner sc = new Scanner(System.in);

        int maxnum = 0;
        int x = sc.nextInt();
        int[] arr = new int[x + 1];
        int[] dp = new int[x + 1];

        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        for (int i = 0; i < x; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //핵심!
                }
            }
        }

        for (int i = 0; i < x; i++)
            maxnum = Math.max(maxnum, dp[i]);

        System.out.println(maxnum);
        sc.close();
    }

    public static void main(String[] args) {
        Dp_긴증가부분수열 dp_수열 = new Dp_긴증가부분수열();
        dp_수열.run();
    }
}
