package GREEDY;

import java.util.Scanner;

public class Greedy_대회or인턴_2875 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int girl=sc.nextInt();
        int boy=sc.nextInt();
        int intern=sc.nextInt();
        int result;

        if(girl+boy-intern<3){
            System.out.println(0);
            return;
        }
        if(girl%2!=0){
            intern-=1;
            girl-=1;
        }
        int tx=girl/2;

        while(intern>0){
           if(tx>boy){
               tx-=1;
               intern-=2;
           }
           else if(tx<boy){
               boy-=1;
               intern-=1;
           }

           else{
               boy-=1;
               intern-=1;
           }
        }

        result=Math.min(tx,boy);
        System.out.println(result);
    }
}
