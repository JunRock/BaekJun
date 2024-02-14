package 구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 구현_Snail_1913 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int expectNum = sc.nextInt();
        int[][] map = new int[size][size];
        int num = size * size;
        int top = size - 1;
        int bottom = 0;
        int left = 0;
        int right = size;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (num > 0) {
            for (int i = bottom; i <= top; i++) { //아래로 내려가는 경우
                map[i][left] = num--;
            }
            left++;

            for (int i = left; i < right; i++) { //오른쪽으로 가는 경우
                map[top][i] = num--;
            }
            top--;

            for (int i = top; i > bottom; i--) { //위쪽으로 가는 경우
                map[i][right - 1] = num--;
            }
            right--;

            for (int i = right; i >= left; i--) { //왼쪽으로 가는 경우
                map[bottom][i] = num--;
            }
            bottom++;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == expectNum) {
                    bw.write((i + 1) + " " + (j + 1));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }
}
