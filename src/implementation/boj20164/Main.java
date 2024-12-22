package implementation.boj20164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args){
        String number = read();
        divide(number, 0);
        System.out.println(min + " " + max);
    }

    public static void divide(String number, int count) {

        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            if (n % 2 == 1) {
                count++;
            }
        }

        if (number.length() == 1) {
            max = Math.max(max, count);
            min = Math.min(min, count);
        }
        else if (number.length() == 2) {
            number = String.valueOf((number.charAt(0) - '0') + (number.charAt(1) - '0'));
            divide(number, count);
        }
        //3자리 이상인 경우
        else {
            for (int i = 1; i < number.length()-1; i++) {
                for (int j = i + 1; j < number.length(); j++) {
                    int x = Integer.parseInt(number.substring(0,i));
                    int y = Integer.parseInt(number.substring(i, j));
                    int z = Integer.parseInt(number.substring(j));
                    divide(String.valueOf(x + y + z), count);
                }
            }
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
