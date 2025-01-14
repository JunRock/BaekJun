package DFS.boj13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        String[] number = readWithSplit();
        n = Integer.parseInt(number[0]);
        m = Integer.parseInt(number[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = read();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int j = 0; j < m; j++) {
            if (dfs(0, j)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }

    private static boolean dfs(int x, int y) {
        visited[x][y] = true;
        if (x == n - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 0) {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }
        return false;
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
