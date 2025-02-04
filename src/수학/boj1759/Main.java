package 수학.boj1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int l, c;
    private static String[] word;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[] input = readWithSplit();
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        word = readWithSplit();
        Arrays.sort(word);

        backTrack(0, 0, "", 0, 0);
        write(result);
        close();
    }

    private static void backTrack(int start, int length, String current, int vowel, int consonant) {
        if (length == l) {
            if (vowel >= 1 && consonant >= 2) {
                result.add(current);
            }
            return;
        }

        for (int i = start; i < c; i++) {
            String str = word[i];
            if (isVowel(str)) {
                backTrack(i + 1, length + 1, current + str, vowel + 1, consonant);
            } else {
                backTrack(i + 1, length + 1, current + str, vowel, consonant + 1);
            }
        }
    }

    private static boolean isVowel(String str) {
        return "aeiou".contains(str);
    }

    private static String[] readWithSplit() {
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(List<String> result) {
        try {
            for (String str : result) {
                bw.write(str);
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
