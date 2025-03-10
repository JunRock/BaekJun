package backtracking.boj10819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int maxValue = Integer.MIN_VALUE;
    private static int[] array;
    private static int[] perm;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        n = Integer.parseInt(read());
        array = Arrays.stream(readWithSplit())
            .mapToInt(Integer::parseInt)
            .toArray();
        perm = new int[n];
        visited = new boolean[n];
        backTracking(0);
        write(maxValue);
        close();
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            maxValue = Math.max(maxValue, calculate());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = array[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculate() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(perm[i] - perm[i + 1]);
        }
        return sum;
    }

    private static String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readWithSplit() {
        return read().split(" ");
    }

    private static void write(int result) {
        try {
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close() {
        try {
            bw.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
