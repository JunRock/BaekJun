package GREEDY;

import java.util.Scanner;

public class Greedy_병든나이트_1783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x == 1) {
            System.out.println(1);
            return;
        }
        if (x == 2) {
            System.out.println(Math.min(4, (y + 1) / 2));
            return;
        }
        if (y < 7) {
            System.out.println(Math.min(4, y));
        }
        else {
            System.out.println(y - 2);
        }
    }
}
