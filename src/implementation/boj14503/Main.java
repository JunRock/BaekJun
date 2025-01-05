package implementation.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};
    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] map;
    static int direction;
    static int count = 1;
    private static final Integer NOT_CLEAN_AREA = 0;
    private static final Integer ALREADY_CLEAN = 2;
    private static final Integer WALL = 1;

    public static void main(String[] args) {
        String[] num = read().split(" ");
        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);
        map = new int[n][m];

        String[] robotPosition = read().split(" ");
        x = Integer.parseInt(robotPosition[0]);
        y = Integer.parseInt(robotPosition[1]);
        direction = Integer.parseInt(robotPosition[2]);

        for (int i = 0; i < n; i++) {
            String[] split = read().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        run(x, y);
        System.out.println(count);
    }

    private static void run(int x, int y) {
        map[x][y] = ALREADY_CLEAN;

        for (int i = 0; i < 4; i++) {
            turnLeft();
            int nx = x + row[direction];
            int ny = y + col[direction];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == NOT_CLEAN_AREA) {
                    count++;
                    run(nx, ny);
                    return;
                }
            }
        }

        int direct = (direction + 2) % 4;
        int nx = x + row[direct];
        int ny = y + col[direct];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != WALL) {
            run(nx, ny);
        }
    }

    private static void turnLeft() {
        direction -= 1;
        if (direction < 0) {
            direction = 3;
        }
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
