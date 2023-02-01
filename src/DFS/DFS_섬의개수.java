package DFS;

import java.util.*;

public class DFS_섬의개수 {
    int h, w;
    int[][] land;
    int count;
    boolean[][] visit;
    ArrayList<Integer> arr = new ArrayList<>();
    int a = 0;
    int[] high = {-1, 1, 0, 0, -1, 1, 1, -1};
    int[] left = {0, 0, -1, 1, 1, -1, 1, -1};

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();

            if (h == 0 && w == 0) {
                for (int i = 0; i < arr.size(); i++)
                    System.out.println(arr.get(i));
                sc.close();
                return;
            }

            land = new int[w][h];
            visit = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    land[i][j] = sc.nextInt();
                }
            }

            count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (land[i][j] == 1 && !visit[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            arr.add(count);
        }

    }

    public void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + high[i];
            int ny = y + left[i];
            if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                if (land[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS_섬의개수 dfs_섬의개수 = new DFS_섬의개수();
        dfs_섬의개수.run();
    }
}
