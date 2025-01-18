package BFS.boj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, h;
    private static int[][][] map;
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {-1, 1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};
    private static Queue<TomatoPoint> queue = new LinkedList<>();

    public static void main(String[] args) {
        String[] input = readWithSplit();

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        map = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                String[] tomato = readWithSplit();
                for (int j = 0; j < m; j++) {
                    map[k][i][j] = Integer.parseInt(tomato[j]);
                    if (map[k][i][j] == 1) {
                        queue.offer(new TomatoPoint(i, j, k));
                    }
                }
            }
        }

        bfs();
        calculateDays();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            TomatoPoint point = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nz = point.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) {
                    continue;
                }

                if (map[nz][nx][ny] == 0) {
                    queue.offer(new TomatoPoint(nx, ny, nz));
                    map[nz][nx][ny] = map[point.z][point.x][point.y] + 1;
                }
            }
        }
    }

    private static void calculateDays() {
        int day = Integer.MIN_VALUE;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, map[k][i][j]);
                }
            }
        }

        System.out.println(day - 1);
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readWithSplit() {
        return read().split(" ");
    }

    public static class TomatoPoint {
        int x, y, z;

        public TomatoPoint(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
