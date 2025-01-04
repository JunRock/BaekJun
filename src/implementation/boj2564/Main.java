package implementation.boj2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int storeCount;

    public static void main(String[] args) {
        String[] coordinate = read().split(" ");
        int row = Integer.parseInt(coordinate[0]);
        int col = Integer.parseInt(coordinate[1]);
        storeCount = Integer.parseInt(read());
        int result = 0;
        int[] position = new int[storeCount + 1];
        int round = row*2+col*2;

        for (int i = 0; i < storeCount + 1; i++) {
            String[] split = read().split(" ");
            int direct = Integer.parseInt(split[0]);
            position[i] = Integer.parseInt(split[1]);

            switch (direct){
                case 2:
                    position[i] = row+col+(row-position[i]);
                    break;
                case 3:
                    position[i] = row+row+col+(col-position[i]);
                    break;

                case 4:
                    position[i] = row + position[i];
                    break;
            }
        }

        for(int i = 0;i<storeCount;i++){
            int div = Math.abs(position[i]-position[storeCount]);
            result += Math.min(div,round-div);
        }
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
