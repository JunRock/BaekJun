package sorting.boj2437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int scalpCount = Integer.parseInt(read());
        List<Integer> list = new ArrayList<>();
        String[] input = readWithSplit();
        for (int i = 0; i < scalpCount; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        Collections.sort(list);
        write(calculateMinimumWeight(list) + 1);
        close();
    }

    private static int calculateMinimumWeight(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            if (sum + 1 < number) {
                break;
            }
            sum += number;
        }
        return sum;
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
