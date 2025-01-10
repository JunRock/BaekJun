package implementation.boj11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(read());
        int[] arr = new int[n];
        String[] split = read().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(split[i]));
        }
        run(arr);
    }

    public static void run(int[] arr) {
        int finalResult = 0;
        for (int i = 0; i < arr.length; i++) {


            int maxCount = 0 ;
            //기준점을 기준으로 작은 수
            for (int k = 0; k < i; k++) {
                int tempCount = 0;
                int max = Integer.MIN_VALUE;
                for (int n = 0; n < i; n++) {
                    if (max < arr[n]) {
                        max = arr[n];
                        tempCount++;
                    }
                }
                maxCount = Math.max(tempCount,maxCount);
            }
            int minCount = 0;
            //기준점을 기준으로 큰 수
            for (int j = i; j < arr.length; j++) {
                int tempCount = 0;
                int min = Integer.MAX_VALUE;
                for (int m = j + 1; m < arr.length; m++) {
                    if (min > arr[m]) {
                        min = arr[m];
                        tempCount++;
                    }
                }
                minCount = Math.max(minCount, tempCount);
            }
            finalResult = Math.max(finalResult, maxCount+minCount);
        }
        System.out.println(finalResult+1);
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
