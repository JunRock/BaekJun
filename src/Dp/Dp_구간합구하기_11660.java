package Dp;
import java.util.*;
public class Dp_구간합구하기_11660 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();

        int [][]arr=new int[n+1][n+1];
        int [][]dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int []sum=new int[m];

        for(int i=0;i<m;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            for(int h=x1;h<=x2;h++){
                for(int w=y1;w<=y2;w++){
                    sum[i]+=arr[h][w];
                }
            }
        }

        for(int i=0;i<m;i++){
            System.out.println(sum[i]);
        }
    }

    public static void main(String[] args){
        Dp_구간합구하기_11660 dp_구간합구하기_11660=new Dp_구간합구하기_11660();
        dp_구간합구하기_11660.run();
    }
}
