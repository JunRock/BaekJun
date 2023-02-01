package Dp;

import java.util.*;

public class Dp_RGB {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[1001][3];

        int house = sc.nextInt();

        for (int i = 0; i < house; i++) {
            for (int j = 0; j < 3; j++) {
                int price = sc.nextInt();
                dp[i][j] = price;
            }
        }

        for (int i = 1; i < house; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[house - 1][0], Math.min(dp[house - 1][1], dp[house - 1][2])));
        sc.close();
    }

    public static void main(String[] args) {
        Dp_RGB dp_rgb = new Dp_RGB();
        dp_rgb.run();
    }
}
