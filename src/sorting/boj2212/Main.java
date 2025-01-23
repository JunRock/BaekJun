package sorting.boj2212;

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
        int n = Integer.parseInt(read());
        int k = Integer.parseInt(read());
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();

        String[] input = readWithSplit();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        Collections.sort(list);

        for (int i = 0; i < n - 1; i++) {
            diff.add(list.get(i+1)- list.get(i));
        }
        Collections.sort(diff);

        for (int i = 0; i < n - k; i++) {
            answer+=diff.get(i);
        }
        write(answer);
        close();
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

    private static void write(int answer) {
        try {
            bw.write(String.valueOf(answer));
            bw.flush();
        }catch (IOException e){
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
