package sorting.boj2467;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int solutionCount = Integer.parseInt(read());
        int[] solutionList = new int[solutionCount];

        String[] input = readWithSplit();

        for (int i = 0; i < solutionCount; i++) {
            solutionList[i] = Integer.parseInt(input[i]);
        }

        Node node = binarySearch(solutionList);
        write(node);
        close();
    }

    private static Node binarySearch(int[] solutionList) {
        int start = 0;
        int end = solutionList.length - 1;
        List<Node> result = new ArrayList<>();
        while (start < end) {
            int x = solutionList[start];
            int y = solutionList[end];
            int diff = x + y;
            result.add(new Node(x, y, diff));
            if (Math.abs(x) > Math.abs(y)) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return findMinimum(result);

    }

    private static Node findMinimum(List<Node> list) {
        return list.stream()
            .min(Comparator.comparingInt(node -> Math.abs(node.diff)))
            .orElseThrow();
    }

    private static class Node {

        int x;
        int y;
        int diff;

        public Node(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
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

    private static void write(Node result) {
        try {
                bw.write(result.x + " "+result.y);
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
