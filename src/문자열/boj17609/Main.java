package 문자열.boj17609;

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

    public static void main(String[] args) {
        int t = Integer.parseInt(read());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int answer = checkPseudoPalindrome(read());
            result.add(answer);
        }

        write(result);
        close();
    }

    private static int checkPseudoPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                if (isPseudoPalindrome(input, start + 1, end) || isPseudoPalindrome(input, start, end - 1)) {
                    return 1;
                } else {
                    return 2;
                }

            }
            start++;
            end--;
        }
        return 0;
    }

    private static boolean isPseudoPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

    private static String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(List<Integer> result) {
        try {
            for (int answer : result) {
                bw.write(String.valueOf(answer));
                bw.newLine();
            }
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
