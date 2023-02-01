package Dp;

import java.util.*;

public class Dp_다리놓기 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double[] dp = new double[x];

        for (int i = 0; i < x; i++) {
            double maxnum = 1;
            double div = 1;
            double west = sc.nextInt();
            double east = sc.nextInt();

            for (double j = east; j > east - west; j--) {
                maxnum *= j;
            }

            for (double k = west; k > 0; k--) {
                div *= k;
            }
            dp[i] = maxnum / div;
        }
        for (int i = 0; i < dp.length; i++)
            System.out.printf("%.0f\n", dp[i]);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_다리놓기 dp_다리놓기 = new Dp_다리놓기();
        dp_다리놓기.run();
    }
}
