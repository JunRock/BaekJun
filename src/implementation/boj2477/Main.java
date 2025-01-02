package implementation.boj2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int k = Integer.parseInt(read());
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int[] direction = new int[6];
        int[] length = new int[6];
        int minLength = Integer.MAX_VALUE;
        int minWidth = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            String[] move = read().split(" ");
            direction[i] = Integer.parseInt(move[0]);
            length[i] = Integer.parseInt(move[1]);
        }

        for (int i = 0; i < 6; i++) {
            if (direction[i] == 3 || direction[i] == 4) {
                maxHeight = Math.max(maxHeight, length[i]);
            }
            if (direction[i] == 1 || direction[i] == 2) {
                maxWidth = Math.max(maxWidth, length[i]);
            }
        }

        for (int i = 0; i < 6; i++) {
            if (length[i] == maxHeight) {
                if (i == 0) {
                    minLength = Math.abs(length[5] - length[i + 1]);
                } else if (i == 5) {
                    minLength = Math.abs(length[i - 1] - length[0]);
                } else {
                    minLength = Math.abs(length[i - 1] - length[i + 1]);
                }

            }
            if (length[i] == maxWidth) {
                if (i == 0) {
                    minWidth = Math.abs(length[5] - length[i + 1]);

                } else if (i == 5) {
                    minWidth = Math.abs(length[i - 1] - length[0]);
                }else
                    minWidth = Math.abs(length[i - 1] - length[i+1]);
            }
        }

        int minExtent = minWidth * minLength;
        int maxExtent = maxWidth * maxHeight;
        int result = (maxExtent - minExtent)*k;
        System.out.println(result);
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
