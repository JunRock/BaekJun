package DFS.boj15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static ArrayList<Integer>[] list;
    private static int totalDepthSum = 0;

    public static void main(String[] args) {
        n = Integer.parseInt(read());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] input = readWithSplit();
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, -1, 0);

        System.out.println((totalDepthSum % 2 == 0) ? "No" : "Yes");
    }

    private static void dfs(int current, int parent, int depth) {
        boolean isLeaf = true;

        for (int neighbor : list[current]) {
            if (neighbor != parent) {
                isLeaf = false;
                dfs(neighbor, current, depth + 1);
            }
        }

        if (isLeaf) {
            totalDepthSum += depth;
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
