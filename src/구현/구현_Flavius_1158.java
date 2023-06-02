package 구현;
import java.util.*;
import java.util.stream.Stream;

public class 구현_Flavius_1158 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int m=sc.nextInt();
        int[]arr=new int[num+1];
        int[] result=new int[num+1];
        int index=m;
        int in_count;
        int count=0;
        for(int i=1;i<=num;i++){
            arr[i]=i;
        }

        while(count!=num){
            result[count]=arr[index];
            arr[index]=0;
            in_count=0;
            index++;
            count++;
            while(in_count<m){
                if(arr[index]!=0){
                    index++;
                    in_count++;
                    if(index>num)
                        index-=num;
                }
                else
                    index++;
            }
        }

        for(int i=0;i< result.length;i++)
            System.out.print(result[i]+" ");
    }
}
