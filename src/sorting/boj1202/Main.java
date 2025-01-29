package sorting.boj1202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long maxPrice = 0;

    public static void main(String[] args) {
        String[] str = readWithSplit();
        List<Jewel> jewelList = new ArrayList<>();
        List<Integer> bagList = new ArrayList<>();
        int jewelCount = Integer.parseInt(str[0]);
        int bagCount = Integer.parseInt(str[1]);

        for (int i = 0; i < jewelCount; i++) {
            String[] input = readWithSplit();
            int weight = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);
            jewelList.add(new Jewel(weight, price));
        }

        for (int i = 0; i < bagCount; i++) {
            bagList.add(Integer.parseInt(read()));
        }
        jewelList.sort(Comparator.comparingInt(jewel -> jewel.weight));
        Collections.sort(bagList);
        run(jewelList, bagList);
        write(maxPrice);
        close();
    }

    private static void run(List<Jewel> jewelList, List<Integer> bagList) {
        PriorityQueue<Jewel> availableJewels = new PriorityQueue<>(
            Comparator.comparingInt((Jewel jewel) -> jewel.price).reversed()
        );

        int jewelIndex = 0;
        for (int bagSize : bagList) {
            while (jewelIndex < jewelList.size() && jewelList.get(jewelIndex).weight <= bagSize) {
                availableJewels.add(jewelList.get(jewelIndex));
                jewelIndex++;
            }
            if (!availableJewels.isEmpty()) {
                maxPrice += availableJewels.poll().price;
            }
        }
    }

    private static class Jewel {

        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readWithSplit() {
        return read().split(" ");
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
            bf.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
