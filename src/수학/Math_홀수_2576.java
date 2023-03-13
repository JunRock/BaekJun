package 수학;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;
public class Math_홀수_2576 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x;
        int k=0;
        int sum=0;
        int []tmp=new int[7];

        for(int i=0;i<7;i++){
            x=sc.nextInt();
            tmp[i]=x;
            if(x%2!=0)
               ++k;
        }
        if(k==0){
            System.out.println(-1);
            return;
        }
        int []arr=new int[k];
        k=0;
        for(int i=0;i<7;i++){
            if(tmp[i]%2!=0){
                arr[k]=tmp[i];
                k++;
            }

        }

        int min1=arr[0];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            min1= Math.min(min1,arr[i]);
        }

        System.out.println(sum);
        System.out.println(min1);
    }


    public static void main(String[] args){
        Math_홀수_2576 math_홀수_2576=new Math_홀수_2576();
        math_홀수_2576.run();
    }
}
