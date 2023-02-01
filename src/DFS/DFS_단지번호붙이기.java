package DFS;

import java.util.*;

public class DFS_단지번호붙이기 {
    int[][] home;
    int map;
    ArrayList<Integer> group;
    boolean[][] visit;
    int count = 0;
    int high[] = {-1, 1, 0, 0}; //상하
    int left[] = {0, 0, -1, 1}; //좌우

    public void run() {
        Scanner sc = new Scanner(System.in);
        map = sc.nextInt();
        home = new int[map][map];
        visit = new boolean[map][map];

        for (int i = 0; i < map; i++) {
            String input = sc.next();
            for (int j = 0; j < map; j++) {
                home[i][j] = input.charAt(j) - '0';
            }
        }
        group = new ArrayList<>();

        for (int i = 0; i < map; i++) {
            for (int j = 0; j < map; j++) {
                if (home[i][j] == 1 && !visit[i][j]) {
                    count = 1;
                    dfs(i, j);
                    group.add(count);
                }
            }
        }
        Collections.sort(group);
        System.out.println(group.size());
        for (int i : group)
            System.out.println(i);
        sc.close();
        return;
    }

    public int dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int h = x + high[i];
            int w = y + left[i];
            if (h >= 0 && w >= 0 && h < map && w < map) {
                if (home[h][w] == 1 && !visit[h][w]) {
                    count++;
                    dfs(h, w);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DFS_단지번호붙이기 dfs_단지번호붙이기 = new DFS_단지번호붙이기();
        dfs_단지번호붙이기.run();
    }
}
