package Dp;

import java.util.*;

public class Dp_퇴사 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int[] workday = new int[day + 15];
        int[] salary = new int[day + 15];
        int[] dp = new int[day + 6]; //최대 급여를 저장하는 배열
        int maxnum = 0;

        for (int i = 0; i < day; i++) {
            workday[i] = sc.nextInt();
            salary[i] = sc.nextInt();
        }

        for (int i = 0; i <= day; i++) {
            dp[i] = Math.max(maxnum, dp[i]);
            dp[workday[i] + i] = Math.max(dp[workday[i] + i], dp[i] + salary[i]);
            maxnum = Math.max(dp[i], maxnum);
        }

        System.out.println(maxnum);
        sc.close();
        return;

    }

    public static void main(String[] args) {
        Dp_퇴사 dp_퇴사 = new Dp_퇴사();
        dp_퇴사.run();
    }
}
