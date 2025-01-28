package sorting.boj1744;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int length = Integer.parseInt(read());

        List<Long> minuslist = new ArrayList<>();
        List<Long> pluslist = new ArrayList<>();
        long onesCount = 0;

        for (int i = 0; i < length; i++) {
            long number = Long.parseLong(read());
            if (number == 1) {
                onesCount++;
            } else if (number > 1) {
                pluslist.add(number);
            } else {
                minuslist.add(number);
            }
        }
        Collections.sort(minuslist);
        pluslist.sort(Comparator.reverseOrder());
        long result = maximizeSum(minuslist) + maximizeSum(pluslist) + onesCount;
        write(result);
        close();
    }

    private static long maximizeSum(List<Long> numbers) {
        long sum = 0;
        int size = numbers.size();

        for (int i = 0; i < size; i += 2) {
            if (i + 1 < size) {
                sum += numbers.get(i) * numbers.get(i + 1);
            } else {
                sum += numbers.get(i);
            }
        }

        return sum;
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
