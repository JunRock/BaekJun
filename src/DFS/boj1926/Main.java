package DFS.boj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int area = 1;
    private static int pictureCount = 0;

    public static void main(String[] args) {
        String[] str = readWithSplit();
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            String[] input = readWithSplit();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    pictureCount++;
                    maxArea = Math.max(area, maxArea);
                    area = 1;
                }
            }
        }
        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                area++;
                dfs(nx, ny);
            }
        }
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
