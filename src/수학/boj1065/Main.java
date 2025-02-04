package 수학.boj1065;

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
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        write(count);
        close();
    }

    private static boolean isHansu(int num) {
        if (num < 100) {
            return true;
        }

        int hundred = num / 100;
        int ten = (num / 10) % 10;
        int one = num % 10;

        return (hundred - ten) == (ten - one);
    }

    private static int read() {
        try {
            return Integer.parseInt(br.readLine());
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
