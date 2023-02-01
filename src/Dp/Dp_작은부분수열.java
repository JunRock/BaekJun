package Dp;

import java.util.*;

public class Dp_작은부분수열 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int minnum = 0;
        int[] arr = new int[x + 1];
        int[] dp = new int[x + 1];
        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        for (int i = 0; i < x; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < x; i++)
            minnum = Math.max(minnum, dp[i]);
        System.out.println(minnum);
        sc.close();
    }

    public static void main(String[] args) {
        Dp_작은부분수열 dp_작은부분수열 = new Dp_작은부분수열();
        dp_작은부분수열.run();
    }
}
