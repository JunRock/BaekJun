package 수학;

import java.util.*;

public class Sugar_deliver {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int fkg = 5;
        int tkg = 3;
        int count = 0;
        int[] save = new int[5000];
        for (int i = 0; i < 5000; i++) {
            for (int j = 0; j < 5000; j++) {
                if ((fkg * i) + (tkg * j) == kg) {
                    save[count] = i + j;
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println(-1);
            sc.close();
            return;
        }

        int min = save[0];
        for (int i = 1; i < count; i++) {
            if (save[i] < min)
                min = save[i];
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        Sugar_deliver sugar_deliver = new Sugar_deliver();
        sugar_deliver.run();
    }
}
