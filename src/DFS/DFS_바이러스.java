package DFS;

import java.util.*;

public class DFS_바이러스 {
    int count = 0;
    int computer;
    int couple;
    int[][] map;
    int[] visit;

    public void run() {
        Scanner sc = new Scanner(System.in);
        computer = sc.nextInt();
        couple = sc.nextInt();
        map = new int[computer + 1][computer + 1];
        visit = new int[computer + 1];

        for (int i = 0; i < couple; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(1);
        System.out.println(count);
        sc.close();
        return;
    }

    public void dfs(int index) {
        visit[index] = 1;

        for (int i = 1; i <= computer; i++) {
            if (map[index][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                count++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        DFS_바이러스 dfs_바이러스 = new DFS_바이러스();
        dfs_바이러스.run();
    }
}
