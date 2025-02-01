package 문자열.boj9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        String input = read();
        String explosionKeyword = read();
        int length = explosionKeyword.length();
        StringBuilder stack = new StringBuilder();

        for (char c : input.toCharArray()) {
            stack.append(c);

            if (stack.length() >= length && stack.substring(stack.length() - length)
                .equals(explosionKeyword)) {
                stack.delete(stack.length() - length, stack.length());
            }
        }
        write(stack.isEmpty() ? "FRULA" : stack.toString());
        close();
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(String result) {
        try {
            bw.write(result);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close() {
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
