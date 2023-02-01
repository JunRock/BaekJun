package 수학;

import java.util.*;

public class Apartment {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int[][] apart = new int[15][15];
        for (int i = 1; i < apart.length; i++) { //0층 주민인원 파악
            apart[0][i] = i;
        }

        for (int i = 1; i < apart.length; i++) {
            int number = 0;
            for (int j = 1; j < apart[i].length; j++) {
                apart[i][j] = apart[i - 1][j] + number;
                number = apart[i][j];
            }
        }

        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            int floor = sc.nextInt();
            int ho = sc.nextInt();
            System.out.println(apart[floor][ho]);
        }
        sc.close();
        return;
    }

    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        apartment.run();
    }
}
