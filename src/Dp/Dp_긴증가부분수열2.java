package Dp;

import java.util.*;

public class Dp_긴증가부분수열2 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = 0;
        int[] arr = new int[x + 1];
        int[] dp = new int[x + 1];
        int[] dp1 = new int[x];

        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        for (int i = 0; i < x; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < x; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);


        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_긴증가부분수열2 dp_긴증가부분수열2 = new Dp_긴증가부분수열2();
        dp_긴증가부분수열2.run();
    }
}
