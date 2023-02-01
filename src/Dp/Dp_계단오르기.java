package Dp;

import java.util.*;

public class Dp_계단오르기 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] stair = new int[301];
        int[] maxnum = new int[10000];
        for (int i = 1; i <= x; i++) {
            stair[i] = sc.nextInt();
        }
        maxnum[1] = stair[1];
        maxnum[2] = stair[1] + stair[2];

        for (int i = 3; i <= x; i++) {
            maxnum[i] = Math.max(maxnum[i - 2], maxnum[i - 3] + stair[i - 1]) + stair[i];
        }
        System.out.println(maxnum[x]);

    }

    public static void main(String[] args) {
        Dp_계단오르기 dp_계단오르기 = new Dp_계단오르기();
        dp_계단오르기.run();
    }
}
