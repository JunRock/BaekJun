package 수학;
import java.util.*;
public class Math_평균은넘겠지_4344 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        double [][]arr=new double[num][1000];
        int []sum=new int[num];
        double []average=new double[num];

        for(int i=0;i<num;i++){
            int size=sc.nextInt();
            for(int j=0;j<size;j++){
                arr[i][j]=sc.nextInt();
                sum[i]+=arr[i][j];
            }
            average[i]=sum[i]/size;
        }

        int count;
        int count1;
        for(int i=0;i<num;i++){
            count=0;
            count1=0;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0)
                    count1++;
                if(arr[i][j]>average[i]){
                    count++;
                }
            }
            System.out.println(((count/count1)*100));
        }
    }

    public static void main(String[] args) {
        Math_평균은넘겠지_4344 math_평균은넘겠지_4344=new Math_평균은넘겠지_4344();
        math_평균은넘겠지_4344.run();
    }
}
