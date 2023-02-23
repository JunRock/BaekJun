package 수학;
import java.util.*;
public class Math_쉽게푸는문제_1292 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int []arr=new int[y+1];
        int count=0;
        int k=0;
        int sum=0;
            for(int i=1;i<=1000;i++){
                for(int j=1;j<=i;j++){
                    arr[k++]=i;
                    count++;
                    if(count==y){
                        for(int a=x;a<=y;a++)
                            sum+=arr[a-1];
                        System.out.println(sum);
                        return;
                    }
                }
            }

    }

    public static void main(String[] args){
        Math_쉽게푸는문제_1292 math_쉽게푸는문제_1292=new Math_쉽게푸는문제_1292();
        math_쉽게푸는문제_1292.run();
    }
}
