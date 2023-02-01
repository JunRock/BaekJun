package 수학;

import java.util.*;

public class ACMhotel {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            int h = sc.nextInt(); //층
            int w = sc.nextInt(); //층에 있는 방 개수
            int n = sc.nextInt();
            int[] arr = new int[10000];
            int count = 0;
            for (int j = 1; j <= w; j++) {
                for (int k = 1; k <= h; k++) {
                    arr[count] = ((k * 100) + j);
                    count++;
                }
            }
            System.out.println(arr[n - 1]);
        }
        sc.close();
        return;
    }

    public static void main(String[] args) {
        ACMhotel acMhotel = new ACMhotel();
        acMhotel.run();
    }
}
