package 구현;
import java.util.*;
public class 구현_Zero_10773 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] arr=new int[num];
        int sum=0,j=0;
        for(int i=0;i<num;i++){
            if(j==num) break;
            int x=sc.nextInt();
            arr[i]=x;
            if(x==0){
                i--;
                sum-=arr[i--];
                j++;
            }
            else{
                sum+=x;
                j++;
            }
        }
        System.out.println(sum);
    }
}
