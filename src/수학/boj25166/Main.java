package 수학.boj25166;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MY_PRICE = 1023;

    public static void main(String[] args) {
        int[] input = Arrays.stream(readWithSplit())
            .mapToInt(Integer::parseInt)
            .toArray();

        int sandwichPrice = input[0];
        int kogiPrice = input[1];
        write(isPossible(sandwichPrice, kogiPrice));
        close();
    }

    private static String isPossible(int sandwichPrice, int kogiPrice) {
        int change = sandwichPrice - MY_PRICE;
        if (sandwichPrice <= MY_PRICE) {
            return "No thanks";
        }
        if ((change & kogiPrice) == change) {
            return "Thanks";
        } else {
            return "Impossible";
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
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
