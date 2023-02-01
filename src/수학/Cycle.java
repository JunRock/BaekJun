package 수학;

import java.util.*;

public class Cycle {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 10) {
            num *= 10;
        }
        int count = 0;
        int sample = num;
        while (true) {
            int x = sample / 10;
            int y = sample % 10;
            int result = x + y;
            sample = y * 10 + result % 10;
            count++;
            if (num == sample) {
                sc.close();
                System.out.println(count);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        cycle.run();
    }
}
