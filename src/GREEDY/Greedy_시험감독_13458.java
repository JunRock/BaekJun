package GREEDY;

import java.util.Scanner;

public class Greedy_시험감독_13458 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int place=sc.nextInt();
        int[]tempPlace=new int[place];
        for(int i=0;i<place;i++){
            tempPlace[i]=sc.nextInt();
        }
        int main=sc.nextInt(); //총감독관, 무조건 1명만 가능
        int sub=sc.nextInt(); //부감독관, 여러명이어도 상관없음
        long result=0;
        long res1=0;

        for(int i=0;i<place;i++){
            tempPlace[i]-=main;
            res1++;
            if(tempPlace[i]<0)
                continue;
            result= tempPlace[i]/sub;
            if(tempPlace[i]%sub!=0)
                result++;
            res1+=result;
        }
        System.out.println(res1);
    }
}
