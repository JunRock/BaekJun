package Dp;

import java.util.*;

public class Dp_정수삼각형 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[][] arr = new int[x + 1][9999];
        int[] dp = new int[x + 1];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;
            }
        }

        for (int i = x - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }
        }
        System.out.println(arr[0][0]);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_정수삼각형 dp_정수삼각형 = new Dp_정수삼각형();
        dp_정수삼각형.run();
    }
}
