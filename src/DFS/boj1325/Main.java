package DFS.boj1325;

import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<Integer>[] arrayLists;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        String[] split = bf.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] str = bf.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arrayLists[b].add(a);
        }

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = bfs(i);
        }

        int maxCount = Arrays.stream(result).max().getAsInt();

        for (int i = 1; i <= n; i++) {
            if (result[i] == maxCount) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : arrayLists[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}
