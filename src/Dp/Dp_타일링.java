package Dp;

import java.util.*;

public class Dp_타일링 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        int num = sc.nextInt();

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[num]);
        sc.close();
    }

    public static void main(String[] args) {
        Dp_타일링 dp_타일링 = new Dp_타일링();
        dp_타일링.run();
    }
}
