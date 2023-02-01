package Dp;

import java.util.*;

public class Dp_sum {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();

            for (int j = 4; j <= num; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[num]);
        }
    }

    public static void main(String[] args) {
        Dp_sum dp_sum = new Dp_sum();
        dp_sum.run();
    }
}
