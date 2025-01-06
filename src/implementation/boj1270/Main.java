package implementation.boj1270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(read());

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            String[] str = read().split(" ");
            int t = Integer.parseInt(str[0]);
            for (int j = 0; j < t; j++) {
                int frequency = map.getOrDefault(str[j + 1], 0) + 1;
                map.put(str[j + 1], frequency);
            }
            String key = Collections.max(
                map.entrySet(), Entry.comparingByValue()
            ).getKey();
            Integer count = map.get(key);
            if ((t / 2) < count) {
                System.out.println(key);
            } else {
                System.out.println("SYJKGW");
            }
        }
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
