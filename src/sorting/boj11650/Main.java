package sorting.boj11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final IOHandler ioHandler = new IOHandler();


    public static void main(String[] args) {
        int n = Integer.parseInt(ioHandler.read());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] strings = ioHandler.readWithSplit();
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);

            list.add(new Node(x, y));
        }

        list.sort(Node.getComparator());
        ioHandler.writeList(list);
        ioHandler.close();
    }

    private static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Comparator<Node> getComparator() {
            return Comparator.comparingInt((Node node) -> node.x)
                .thenComparingInt(node -> node.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
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

        public void write(String output) {
            try {
                bw.write(output);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeList(List<Node> list) {
            try {
                for (Node node : list) {
                    write(node.toString());
                }
                bw.flush();
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
