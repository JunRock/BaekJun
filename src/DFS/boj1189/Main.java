package DFS.boj1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static int expectedNumber;
    private static int result = 0;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        String[] input = readWithSplit();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        expectedNumber = Integer.parseInt(input[2]);
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String mapStr = read();
            for (int j = 0; j < m; j++) {
                map[i][j] = mapStr.charAt(j);
            }
        }

        dfs(n - 1, 0,1);
        System.out.println(result);
    }

    private static void dfs(int x, int y,int count) {
        visited[x][y] = true;
        if (x == 0 && y == m - 1 && count == expectedNumber) {
            result++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny]=='.') {
                dfs(nx, ny,count+1);
                visited[nx][ny] = false;
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
