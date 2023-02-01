package Dp;

import java.util.*;

public class Dp_SetOne {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[1000001];
        dp[1] = 0; //초기값 설정

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                if ((dp[i / 3] + 1) < dp[i])
                    dp[i] = dp[i / 3] + 1;
            }

            if (i % 2 == 0) {
                if ((dp[i / 2] + 1) < dp[i])
                    dp[i] = dp[i / 2] + 1;
            }
        }
        System.out.println(dp[num]);
    }

    public static void main(String[] args) {
        Dp_SetOne setOne = new Dp_SetOne();
        setOne.run();
    }
}
