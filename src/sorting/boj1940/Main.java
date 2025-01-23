package sorting.boj1940;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final IOHandler ioHandler = new IOHandler();

    public static void main(String[] args) {
        int n = Integer.parseInt(ioHandler.read());
        int m = Integer.parseInt(ioHandler.read());

        List<Integer> list = new ArrayList<>();
        String[] input = ioHandler.readWithSplit();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        Collections.sort(list);
        ioHandler.write(findPairs(list, m));
        ioHandler.close();
    }

    private static int findPairs(List<Integer> list, int target) {
        int count = 0;
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int sum = list.get(start) + list.get(end);

            if (sum == target) {
                count++;
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return count;
    }

    private static class IOHandler {

        private final BufferedReader bf;
        private final BufferedWriter bw;

        public IOHandler() {
            this.bf = new BufferedReader(new InputStreamReader(System.in));
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public String read() {
            try {
                return bf.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] readWithSplit() {
            return read().split(" ");
        }

        public void write(int output) {
            try {
                bw.write(output + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void close() {
            try {
                bf.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
