package 문자열.boj5430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int testCaseCount = Integer.parseInt(read());
        for (int i = 0; i < testCaseCount; i++) {
            String commandStr = read();
            String[] command = inputWithSplit(commandStr, "");
            int listSize = Integer.parseInt(read());
            String input = read();

            Deque<String> deque = new LinkedList<>();

            if (listSize > 0) {
                String arrStr = input.substring(1, input.length() - 1);
                String[] arr = inputWithSplit(arrStr, ",");
                deque.addAll(Arrays.asList(arr));
            }

            write(run(command, deque) + "\n");
        }
        close();
    }

    private static String run(String[] command, Deque<String> deque) {
        boolean isReversed = false;

        for (String cmd : command) {
            if (cmd.equals("R")) {
                isReversed = !isReversed;
            } else if (cmd.equals("D")) {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (isReversed) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        return parseResult(deque, isReversed);
    }

    private static String parseResult(Deque<String> deque, boolean isReverse) {
        if (deque.isEmpty()) {
            return "[]";
        }

        if (isReverse) {
            List<String> reverseDeque = new ArrayList<>(deque);
            Collections.reverse(reverseDeque);
            return "[" + String.join(",", reverseDeque) + "]";
        } else {
            return "[" + String.join(",", deque) + "]";
        }
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] inputWithSplit(String input, String regex) {
        return input.split(regex);
    }

    private static void write(String result) {
        try {
            bw.write(result);
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
