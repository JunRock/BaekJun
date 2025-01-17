package DFS.boj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int maxCount = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String[] input = readWithSplit();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = readWithSplit();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        dfs(0);
        System.out.println(maxCount);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, m);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (copyMap[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    copyMap[nx][ny] = 2;
                }
            }
        }
        calculateSafeArea(copyMap);
    }

    private static void calculateSafeArea(int[][] copyMap) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        maxCount = Math.max(maxCount, count);
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
}
