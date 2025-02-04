package backtracking.boj15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static List<Integer> result = new ArrayList<>();
    private static boolean[] isVisited;

    public static void main(String[] args) {
        String[] input = readWithSplit();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        isVisited = new boolean[n+1];
        backTracking(0);
        close();
    }

    private static void backTracking(int start) {
        if (start == m) {
            for (int num : result) {
                write(num);
            }
            newLine();
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result.add(i);
                backTracking(start + 1);
                result.remove(result.size() - 1);
                isVisited[i] = false;
            }
        }
    }

    private static String[] readWithSplit() {
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(int result) {
        try {
            bw.write(result+" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void newLine(){
        try {
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close() {
        try {
            bw.flush();
            bw.close();
            br.close();
        } catch (
            IOException e) {
            throw new RuntimeException(e);
        }
    }
}
