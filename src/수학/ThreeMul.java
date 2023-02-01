package 수학;

import java.util.*;

class ThreeMul {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int one = y % 10;
        int ten = y % 100 / 10;
        int hun = y / 100;
        int[] arr = new int[]{one, ten, hun};
        for (int i = 0; i < arr.length; i++)
            System.out.println(x * arr[i]);
        System.out.println(x * y);
        sc.close();
    }

    public static void main(String[] args) {
        ThreeMul threeMul = new ThreeMul();
        threeMul.run();
    }
}
