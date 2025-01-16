package DFS.boj3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int r, c;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int wolfCount;
    private static int sheepCount;

    public static void main(String[] args) {
        String[] input = readWithSplit();
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new char[r][c];
        visited = new boolean[r][c];
        int wolfTotalCount = 0;
        int sheepTotalCount = 0;

        for (int i = 0; i < r; i++) {
            String str = read();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    sheepCount = 0;
                    wolfCount = 0;
                    dfs(i, j);
                    if (wolfCount >= sheepCount) {
                        wolfTotalCount += wolfCount;
                    } else {
                        sheepTotalCount += sheepCount;
                    }
                }
            }
        }

        System.out.println(sheepTotalCount + " " + wolfTotalCount);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'k') {
            sheepCount++;
        } else if (map[x][y] == 'v') {
            wolfCount++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] != '#') {
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
