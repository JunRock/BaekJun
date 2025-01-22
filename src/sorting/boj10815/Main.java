package sorting.boj10815;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final IOHandler ioHandler = new IOHandler();

    public static void main(String[] args) {
        int n = Integer.parseInt(ioHandler.read());
        int[] ownNumberList = new int[n];

        String[] input = ioHandler.readWithSplit();
        for (int i = 0; i < n; i++) {
            ownNumberList[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(ownNumberList);

        int m = Integer.parseInt(ioHandler.read());
        String[] str = ioHandler.readWithSplit();

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(str[i]);
            if (binarySearch(ownNumberList, target)) {
                ioHandler.write(1);
            } else {
                ioHandler.write(0);
            }
        }
        ioHandler.close();
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
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
