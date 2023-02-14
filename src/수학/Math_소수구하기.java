package 수학;
import java.util.*;
public class Math_소수구하기 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int []arr;
        int k=0;
        int index=0;
        int count;

        for(int i=x;i<=y;i++){
            count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    count++;
            }
            if(count==2){
                k++;
            }
        }

        arr=new int[k];

        for(int i=x;i<=y;i++){
            count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    count++;
            }
            if(count==2){
                arr[index]=i;
                index++;
            }
        }

        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args){
        Math_소수구하기 math_소수구하기=new Math_소수구하기();
        math_소수구하기.run();
    }
}
