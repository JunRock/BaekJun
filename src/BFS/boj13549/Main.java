package BFS.boj13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static boolean[] visited;
    private static final int MAX_VALUE = 100000;

    public static void main(String[] args) {
        String[] input = readWithSplit();
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        visited = new boolean[MAX_VALUE + 1];


        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Position> deque = new ArrayDeque<>();
        deque.offer(new Position(n, 0));

        while (!deque.isEmpty()) {
            Position current = deque.poll();
            int location = current.location;
            int time = current.time;

            if (visited[location]) continue;
            visited[location] = true;

            if (location == k) return time;

            if (location * 2 <= MAX_VALUE && !visited[location * 2]) {
                deque.offerFirst(new Position(location * 2, time));
            }

            if (location - 1 >= 0 && !visited[location - 1]) {
                deque.offerLast(new Position(location - 1, time + 1));
            }

            if (location + 1 <= MAX_VALUE && !visited[location + 1]) {
                deque.offerLast(new Position(location + 1, time + 1));
            }
        }

        return -1;
    }


    private static class Position {

        int location;
        int time;

        public Position(int location, int time) {
            this.location = location;
            this.time = time;
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
}
