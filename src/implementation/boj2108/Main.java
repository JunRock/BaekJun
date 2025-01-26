package implementation.boj2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    private final static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(read());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(read()));
        }

        run(list);
    }

    public static void run(List<Integer> list) {
        System.out.println(calculateArithmeticValue(list));
        System.out.println(calculateCenterValue(list));
        System.out.println(calculateModeValue(list));
        System.out.println(calculateRangeValue(list));
    }

    public static int calculateArithmeticValue(List<Integer> list) {
        return (int) Math.round(list.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0));
    }

    public static int calculateCenterValue(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() / 2);
    }

    public static int calculateModeValue(List<Integer> list) {
        Map<Integer, Long> map = list.stream()
            .collect(Collectors.groupingBy(i -> i, (Collectors.counting())));

        Long count = Collections.max(map.values());

        List<Integer> integerList = map.entrySet().stream()
            .filter(it -> it.getValue().equals(count))
            .map(Entry::getKey)
            .sorted()
            .collect(Collectors.toList());

        return integerList.size() == 1 ? integerList.get(0) : integerList.get(1);
    }

    public static int calculateRangeValue(List<Integer> list) {
        Collections.sort(list);
        return Collections.max(list) - Collections.min(list);
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
