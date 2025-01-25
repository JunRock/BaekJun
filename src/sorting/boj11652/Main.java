package sorting.boj11652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int n = Integer.parseInt(read());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(read());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<Entry<Long, Integer>> entryList = map.entrySet().stream()
            .sorted((e1, e2) -> {
                int valueCompareTo = e2.getValue().compareTo(e1.getValue());
                if (valueCompareTo == 0) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return valueCompareTo;
            })
            .collect(Collectors.toList());

        write(entryList.get(0).getKey());
        close();
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(long result) {
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
