package sorting.boj2170;

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
    private static long totalLength = 0;

    public static void main(String[] args) {
        int pointCount = Integer.parseInt(read());
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            String[] input = readWithSplit();
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            nodeList.add(new Node(x, y));
        }
        nodeList.sort(Comparator.comparingLong(node -> node.x));
        run(nodeList);
        write(totalLength);
        close();
    }

    private static void run(List<Node> nodeList) {
        long currentX = nodeList.get(0).x;
        long currentY = nodeList.get(0).y;
        for (int i = 1; i < nodeList.size(); i++) {
            long x = nodeList.get(i).x;
            long y = nodeList.get(i).y;
            if (x > currentY) {
                totalLength += (currentY - currentX);
                currentX = x;
                currentY = y;
            } else{
                currentY = Math.max(currentY, y);
            }
        }
        totalLength += (currentY - currentX);
    }

    private static class Node {

        long x;
        long y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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

    private static void write(long result) {
        try {
            bw.write(String.valueOf(result));
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
