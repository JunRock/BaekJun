package Dp;

import java.util.*;

public class Dp_포도주 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x + 2];
        int[] dp = new int[x + 2];

        for (int i = 1; i <= x; i++) {
            arr[i] = sc.nextInt();
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= x; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[x]);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_포도주 dp_포도주 = new Dp_포도주();
        dp_포도주.run();
    }
}
