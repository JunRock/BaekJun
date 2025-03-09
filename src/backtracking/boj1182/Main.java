package backtracking.boj1182;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, s;
    private static int result = 0;
    private static int[] arr;

    public static void main(String[] args) {
        String[] input = readWithSplit();
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        arr = Arrays.stream(readWithSplit())
            .mapToInt(Integer::parseInt)
            .toArray();
        backTracking(0, 0, 0);
        write(result);
        close();
    }

    private static void backTracking(int depth, int count, int currentValue) {
        if (depth == n) {
            if (s == currentValue && count > 0) {
                result++;
            }
            return;
        }

        backTracking(depth + 1, count + 1, currentValue + arr[depth]);
        backTracking(depth + 1, count, currentValue);
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
