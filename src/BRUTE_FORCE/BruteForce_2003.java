package BRUTE_FORCE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce_2003 {

    public static void main(String[] args) throws IOException {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringTokenizer st=new StringTokenizer(str);*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            /*String str1=br.readLine();
            StringTokenizer st1=new StringTokenizer(str1);*/
            int num = sc.nextInt();
            list.add(num); // 1 1 1 1
        }

        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            if (sum == M) {
                count++;
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (sum < M) {
                    sum += list.get(j);
                }
                if (sum == M) {
                    count++;
                    break;
                }
                if (sum > M) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
