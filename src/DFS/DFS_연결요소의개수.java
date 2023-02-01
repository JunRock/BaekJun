package DFS;

import java.util.*;

public class DFS_연결요소의개수 {
    boolean[] visit;
    int[][] arr;
    int count = 0;
    int peak, line;

    public void run() {
        Scanner sc = new Scanner(System.in);
        peak = sc.nextInt();
        line = sc.nextInt();
        visit = new boolean[peak + 1];
        arr = new int[peak + 1][peak + 1];

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        for (int i = 1; i <= peak; i++) {
            if (!visit[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
        sc.close();
        return;
    }

    public void dfs(int x) {
        visit[x] = true;

        for (int i = 1; i <= peak; i++) {
            if (arr[x][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        DFS_연결요소의개수 dfs_연결요소의개수 = new DFS_연결요소의개수();
        dfs_연결요소의개수.run();
    }
}
