package DFS.boj1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int myTeamCountResult = 0;
    private static int opponentTeamCountResult = 0;

    public static void main(String[] args) {
        String[] split = read().split(" ");
        n = Integer.parseInt(split[1]);
        m = Integer.parseInt(split[0]);
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = read().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    int power = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        myTeamCountResult += power * power;
                    } else {
                        opponentTeamCountResult += power * power;
                    }
                }
            }
        }
        System.out.print(myTeamCountResult + " " + opponentTeamCountResult);
    }

    private static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == team) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return count;
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
