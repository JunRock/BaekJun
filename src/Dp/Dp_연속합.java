package Dp;

import java.util.*;

public class Dp_연속합 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x];
        int[] dp = new int[x];
        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        int sum;
        dp[0] = arr[0];
        sum = dp[0];

        for (int i = 1; i < x; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            sum = Math.max(sum, dp[i]);
        }
        System.out.println(sum);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_연속합 dp_연속합 = new Dp_연속합();
        dp_연속합.run();
    }
}
