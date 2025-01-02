package implementation.boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String[] number = read().split("");
        int count =0;
        int[] arr = new int[10];

        for (String s : number) {
            if (s.equals("9")) {
                s = "6";
            }
            arr[Integer.parseInt(s)]++;
        }
        arr[6] = (arr[6] + 1) / 2;
        for(int i=0;i<10;i++){
            count = Math.max(count,arr[i]);
        }
        System.out.println(count);
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
