package GREEDY;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy_보물_1026 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int result=0;
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();

        for(int i=0;i<size;i++){
            arr1.add(sc.nextInt());
        }

        for(int i=0;i<size;i++){
            arr2.add(sc.nextInt());
        }

        arr1=arr1.stream().sorted().collect(Collectors.toList());
        arr2=arr2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for(int i=0;i<size;i++){
            result+= arr1.get(i)* arr2.get(i);
        }
        System.out.println(result);
    }
}
