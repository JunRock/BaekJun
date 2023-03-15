package Dp;
import java.util.*;
public class Dp_이동하기_11048 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int [][] arr=new int[x+1][y+1];
        int [][]dp=new int[x+1][y+1];

        for(int i=1;i<=x;i++){ //배열 입력
            for(int j=1;j<=y;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int m=0;
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                m=Math.max(arr[i][j-1],Math.max(arr[i-1][j],arr[i-1][j-1]));
                arr[i][j]+=m;
            }
        }
        System.out.println(arr[x][y]);
    }

    public static void main(String[] args){
        Dp_이동하기_11048 dp_이동하기_11048=new Dp_이동하기_11048();
        dp_이동하기_11048.run();
    }
}
