package implementation.boj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int x = Integer.parseInt(String.valueOf(read()));

        for (int i = 0; i < x; i++) {
            String[] s = read().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            String[] strings = read().split(" ");
            int[] list = new int[n];
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(strings[j]);
            }
            System.out.println(run(n, m, list));
        }
    }

    public static int run(int n, int m, int[] list) {
        Queue<Priority> queue = new LinkedList<>();
        IntStream.range(0, n)
            .mapToObj(it -> {
                if (it == m) {
                    return new Priority(true, list[it]);
                } else {
                    return new Priority(false, list[it]);
                }
                }
            ).forEach(queue::offer);
        int count = 0;
        while (!queue.isEmpty()) {
            Priority priority = queue.poll();
            if (queue.stream().anyMatch(it -> it.priority > priority.priority)) {
                queue.offer(priority);
            } else {
                count++;
                if (priority.isCheckedNum) {
                    return count;
                }
            }
        }
        return count;
    }

    public static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Priority {

        final boolean isCheckedNum;
        final int priority;

        public Priority(boolean isCheckedNum, int priority) {
            this.isCheckedNum = isCheckedNum;
            this.priority = priority;
        }
    }
}
