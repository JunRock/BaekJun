package implementation.boj18406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count1 = 0;

    static int count2 = 0;

    public static void main(String[] args) {
        String number = read();
        int size = number.length() / 2;

        String n = number.substring(0, size);
        String m = number.substring(size);
        System.out.println(run(n,m,size));
    }

    public static String run(String n, String m, int size) {
        for (int i = 0; i < size; i++) {
            count1 += n.charAt(i) - '0';
            count2 += m.charAt(i) - '0';
        }

        if (count1 == count2) {
            return "LUCKY";
        } else {
            return "READY";
        }
    }

    private static String read() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
