package DFS;

import java.util.*;

public class DFS_유기농배추 {
    int x;
    int h, w, cabbage;
    int[] high = {-1, 1, 0, 0};
    int[] left = {0, 0, -1, 1};
    boolean[][] visit;
    int[][] arr;
    int count;
    ArrayList<Integer> group;

    public void run() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        group = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            h = sc.nextInt();
            w = sc.nextInt();
            cabbage = sc.nextInt();
            count = 0;
            arr = new int[h][w];
            visit = new boolean[h][w];

            for (int j = 0; j < cabbage; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (arr[j][k] == 1 && !visit[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            group.add(count);
        }
        for (int c : group)
            System.out.println(c);
        sc.close();
        return;
    }

    public void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + high[i];
            int ny = y + left[i];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS_유기농배추 dfs_유기농배추 = new DFS_유기농배추();
        dfs_유기농배추.run();
    }
}
