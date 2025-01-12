package DFS.boj16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] map;

    private static boolean[][] visited;

    public static void main(String[] args) {
        n = Integer.parseInt(read());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] number = readWithSplit();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(number[j]);
            }
        }

        if (dfs(0, 0)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static boolean dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] jump = queue.poll();
            int a = jump[0];
            int b = jump[1];
            if (map[a][b] == -1) {
                return true;
            }
            int jumpCount = map[a][b];

            int nx = a + jumpCount;
            if (nx < n && !visited[nx][b]) {
                queue.offer(new int[]{nx, b});
                visited[nx][b] = true;
            }

            int ny = b + jumpCount;
            if (ny < n && !visited[a][ny]) {
                queue.offer(new int[]{a, ny});
                visited[a][ny] = true;

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