package backtracking.boj9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] board;
    private static int input;
    private static int answer = 0;

    public static void main(String[] args) {
        input = read();
        board = new int[input];
        backTracking(0);
        write(answer);
        close();
    }

    public static void backTracking(int start) {
        for (int i = 0; i < input; i++) {
            if (start == input) {
                answer++;
                return;
            }
            board[start] = i;
            if (isValid(start)) {
                backTracking(start + 1);
            }
        }
    }

    private static boolean isValid(int current) {
        for (int i = 0; i < current; i++) {
            if (board[i] == board[current]) {
                return false;
            } else if (Math.abs(current - i) == Math.abs(board[current] - board[i])) {
                return false;
            }
        }
        return true;
    }

    private static int read() {
        try {
            return Integer.parseInt(String.valueOf(br.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
