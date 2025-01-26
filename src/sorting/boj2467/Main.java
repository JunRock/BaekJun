package sorting.boj2467;

import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int solutionCount = Integer.parseInt(read());
        int[] solutionList = new int[solutionCount];

        String[] input = readWithSplit();
        for (int i = 0; i < solutionCount; i++) {
            solutionList[i] = Integer.parseInt(input[i]);
        }

        Node result = findClosestPair(solutionList);
        write(result);
        close();
    }

    private static Node findClosestPair(int[] solutionList) {
        int start = 0;
        int end = solutionList.length - 1;

        int closestSum = Integer.MAX_VALUE;
        int closestX = 0, closestY = 0;

        while (start < end) {
            int x = solutionList[start];
            int y = solutionList[end];
            int sum = x + y;

            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                closestX = x;
                closestY = y;
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        return new Node(closestX, closestY, closestSum);
    }

    private static class Node {

        int x, y, sum;

        public Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
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
            bw.write(result.x + " " + result.y);
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
