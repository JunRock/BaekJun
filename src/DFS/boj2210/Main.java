package DFS.boj2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static String[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static HashSet<String> result = new HashSet<>();
    private static final Integer NUMBER_PLATE_SIZE = 5;

    public static void main(String[] args) {
        map = new String[NUMBER_PLATE_SIZE][NUMBER_PLATE_SIZE];

        for (int i = 0; i < NUMBER_PLATE_SIZE; i++) {
            String[] str = readWithSplit();
            for (int j = 0; j < NUMBER_PLATE_SIZE; j++) {
                map[i][j] = str[j];
            }
        }

        for (int i = 0; i < NUMBER_PLATE_SIZE; i++) {
            for (int j = 0; j < NUMBER_PLATE_SIZE; j++) {
                dfs(i, j, 0,"");
            }
        }

        System.out.println(result.size());
    }

    private static void dfs(int x, int y, int depth, String number) {
        if (depth == 6) {
            result.add(number);
            return;
        }

        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            if (nx < 0 || ny < 0 || nx >= NUMBER_PLATE_SIZE || ny >= NUMBER_PLATE_SIZE) {
                continue;
            }
            dfs(nx, ny, depth + 1,number+map[nx][ny]);
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
