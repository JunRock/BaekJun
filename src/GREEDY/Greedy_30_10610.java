package GREEDY;

import java.util.*;
import java.util.stream.Collectors;
public class Greedy_30_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int temp=0;
        int count=0;
        List<String> str = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            str.add(String.valueOf(num.charAt(i)));
            int x=Integer.parseInt(String.valueOf(num.charAt(i)));
            temp+=x;
            if(x==0)
                count++;
        }
        if(temp%3!=0){
            System.out.println(-1);
            return;
        }
        if(count==0){
            System.out.println(-1);
            return;
        }

        String sorted = "";

        str = str.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < str.size(); i++) {
            sorted = sorted.concat(str.get(i));
        }

        System.out.println(sorted);
    }
}
