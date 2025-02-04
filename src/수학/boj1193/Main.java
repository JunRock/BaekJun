package 수학.boj1193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int number = read();
        int N = 1;
        while ((N * (N + 1)) / 2 < number) {
            N++;
        }

        int prevSum = (N - 1) * N / 2;
        int indexInGroup = number - prevSum;
        int numerator, denominator;

        if (N % 2 == 1) {
            numerator = N - indexInGroup + 1;
            denominator = indexInGroup;
        } else {
            numerator = indexInGroup;
            denominator = N - indexInGroup + 1;
        }

        write(numerator + "/" + denominator);
        close();
    }

    private static int read() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
