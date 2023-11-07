package GREEDY;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_로프_2217 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[]arr=new int[size];

        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int maxWeight=0;
        for(int i=0;i<size;i++){
            int weight=arr[i]*(size-i);
            maxWeight=Math.max(weight,maxWeight);
        }
        System.out.println(maxWeight);
    }

}
