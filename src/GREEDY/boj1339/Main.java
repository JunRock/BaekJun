package GREEDY.boj1339;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int wordCount = Integer.parseInt(read());
        Map<Character, Integer> map = new HashMap<>();
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < wordCount; i++) {
            String input = read();
            wordList.add(input);
            int length = input.length();

            for (int j = 0; j < length; j++) {
                char ch = input.charAt(j);
                int value = (int) Math.pow(10, (length - j - 1));
                map.put(ch, map.getOrDefault(ch, 0) + value);
            }
        }

        write(run(map, wordList));
        close();
    }

    private static int run(Map<Character, Integer> map, List<String> wordList) {
        int[] number = {9};
        LinkedHashMap<Character, Integer> collect = sortedMap(map, number);

        int result = 0;

        for (String word : wordList) {
            int num = 0;
            for (char ch : word.toCharArray()) {
                num = num * 10 + collect.get(ch);
            }
            result += num;
        }
        return result;
    }

    private static LinkedHashMap<Character, Integer> sortedMap(
        Map<Character, Integer> map,
        int[] number
    ) {
        return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> number[0]--,
                (a, b) -> a,
                LinkedHashMap::new
            ));
    }

    private static String read() {
        try {
            return br.readLine();
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
