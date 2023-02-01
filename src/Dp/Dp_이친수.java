package Dp;

import java.util.*;

public class Dp_이친수 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        long[] dp = new long[x + 2];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        for (int i = 3; i <= x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[x]);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_이친수 dp_이친수 = new Dp_이친수();
        dp_이친수.run();
    }
}
