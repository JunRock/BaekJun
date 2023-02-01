package Dp;

import java.util.*;

public class Dp_타일링2 {
    public void run() {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[1001];
        int num = sc.nextInt();
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        System.out.println(dp[num]);
        sc.close();
    }

    public static void main(String[] args) {
        Dp_타일링2 dp_타일링2 = new Dp_타일링2();
        dp_타일링2.run();
    }
}
