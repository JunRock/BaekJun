package backtracking.boj14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static Integer maxValue = Integer.MIN_VALUE;
    private static Integer minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = Integer.parseInt(read());
        int[] input = Arrays.stream(readWithSplit())
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] operatorCount = Arrays.stream(readWithSplit())
            .mapToInt(Integer::parseInt)
            .toArray();

        backTracking(1, input[0], input, operatorCount);
        write(maxValue,minValue);
        close();
    }

    private static void backTracking(int depth, int result, int[] numbers, int[] operator) {
        if (depth == numbers.length) {
            maxValue = Math.max(result, maxValue);
            minValue = Math.min(result, minValue);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int newResult = calculate(result, numbers[depth], i);
                backTracking(depth+1,newResult,numbers,operator);
                operator[i]++;
            }
        }
    }

    private static int calculate(int result, int number, int operator) {
        switch (operator) {
            case 0:
                return result + number;
            case 1:
                return result - number;
            case 2:
                return result * number;
            case 3:
                return result / number;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

    private static String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readWithSplit() {
        return read().split(" ");
    }

    private static void write(int maxValue,int minValue) {
        try {
            bw.write(String.valueOf(maxValue));
            bw.newLine();
            bw.write(String.valueOf(minValue));
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
