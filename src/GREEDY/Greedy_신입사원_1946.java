package GREEDY;

import java.util.*;

public class Greedy_신입사원_1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] testCase = new int[size];

        for (int i = 0; i < size; i++) {
            int person = sc.nextInt();
            int count = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < person; j++) {
                int s = sc.nextInt();
                int t = sc.nextInt();
                hashMap.put(s, t);
            }
            List<Integer> score1 = new ArrayList<>(hashMap.keySet());
            Collections.sort(score1); //키 값을 기준으로 정렬

            int min = hashMap.get(1);
            count++;
            for (int k = 2; k <= person; k++) {
                if (hashMap.get(k) < min) {
                    count++;
                    min = hashMap.get(k);
                }
            }
            testCase[i] = count;
        }
        for (int i = 0; i < size; i++)
            System.out.println(testCase[i]);
    }
}
