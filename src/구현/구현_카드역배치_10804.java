package 구현;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 구현_카드역배치_10804 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20);

        for (int i = 0; i < 10; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Collections.reverse(list.subList(x-1,y));
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}