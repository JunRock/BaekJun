package GREEDY;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy_도서관_1461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int book = sc.nextInt();
        int available = sc.nextInt();
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int[] arr = new int[book];
        int result = 0;
        int maxNumber;
        for (int i = 0; i < book; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > 0)
                plus.add(arr[i]);
            else
                minus.add(arr[i]);
        }

        plus = plus.stream().sorted().collect(Collectors.toList()); //양수 오름사순 정렬
        minus = minus.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());  //음수 내림차순 정렬
        if(plus.size()==0){
            maxNumber=Math.abs(minus.get(minus.size()-1));
        }
        else if(minus.size()==0){
            maxNumber=plus.get(plus.size()-1);
        }
        else {
            maxNumber = Math.max(plus.get(plus.size() - 1), Math.abs(minus.get(minus.size() - 1))); //절대값이 제일 큰 값
        }
        while (!plus.isEmpty()){ //2, 11, -6, -28, -29, -37, -39
            for(int i=0;i<available;i++){
                if(plus.isEmpty()) break;

                int a=plus.remove(plus.size()-1);
                if(i==0) {
                    if (a == maxNumber){
                        result += a;
                        continue;
                    }
                    result += a * 2;
                }
            }
        }

        while(!minus.isEmpty()){
            for(int i=0;i<available;i++){
                if(minus.isEmpty()) break;
                int a=Math.abs(minus.remove(minus.size()-1));

                if(i==0){
                    if(a==maxNumber){
                        result+=a;
                        continue;
                    }
                    result+=Math.abs(a)*2;
                }
            }
        }
        System.out.println(result);
    }
}
