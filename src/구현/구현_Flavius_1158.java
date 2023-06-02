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
            count++;
            if(count==num)
                break;
            in_count=0;
            while(in_count<m){
                index++;
                if(index>num)
                    index-=num;
                if(arr[index]!=0){
                    in_count++;
                }
            }
        }
        int i;
        System.out.print("<");
        for(i=0;i<count-1;i++)
            System.out.print(result[i]+", ");
        System.out.print(result[count-1]);
        System.out.print(">");
    }
}
