package 문자열;

import java.util.*;

public class STRING_전화번호목록_5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Vector<String> vector = new Vector<>();
        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            String[] arr = new String[size];
            int count = 0;
            HashMap<String,Integer> map=new HashMap<>();


            for (int j = 0; j < size; j++) { //문자열 입력
                arr[j] = sc.next();
                map.put(arr[j], 0);
            }

            Arrays.sort(arr, Comparator.comparing(String::length));  //문자열 길이만큼 정렬

            for (int k = 1; k < size; k++) {
                for (int a = 1; a < arr[k].length(); a++) {
                    if(map.containsKey(arr[k].substring(0,a)))
                        count++;
                }
            }

            if (count == 0)
               vector.add("YES");
            else
                vector.add("NO");
        }
        for(int i=0;i<vector.size();i++)
            System.out.println(vector.get(i));
    }
}
