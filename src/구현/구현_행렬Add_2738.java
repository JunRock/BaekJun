package 구현;
import java.util.*;
public class 구현_행렬Add_2738 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();

        int [][]arr1=new int[x][y];
        int [][]arr2=new int[x][y];
        int [][]tmp=new int[x][y];

        for(int n=0;n<2;n++){  //베열 정보 입력
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    if(n==0){
                        arr1[i][j]=sc.nextInt();
                    }
                    else{
                        arr2[i][j]=sc.nextInt();
                    }
                }
            }
        }

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                tmp[i][j]=arr1[i][j]+arr2[i][j];
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        구현_행렬Add_2738 구현_행렬_aad2738=new 구현_행렬Add_2738();
        구현_행렬_aad2738.run();
    }
}
