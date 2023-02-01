package Dp;

import java.util.*;

public class Dp_계단수 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        long[][] arr = new long[x + 1][10]; //행은 자릿수개수 열은 수

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1L;
        }

        for (int i = 2; i <= x; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][j - 1] % 1000000000;
                } else {
                    arr[i][j] = (arr[i - 1][j + 1] + arr[i - 1][j - 1]) % 1000000000;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += arr[x][i];
        }
        System.out.println(result % 1000000000);
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Dp_계단수 dp_계단수 = new Dp_계단수();
        dp_계단수.run();
    }
}
