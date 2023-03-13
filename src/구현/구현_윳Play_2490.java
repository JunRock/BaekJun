package 구현;
import java.util.*;
public class 구현_윳Play_2490 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int [][]arr=new int[3][4];

        for(int i=0;i<3;i++){ //윳놀이 저장
            for(int j=0;j<4;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<3;i++){ //윳놀이 등인지 배인지 구분
            int count=0;
            for(int j=0;j<4;j++){
                if (arr[i][j]==1){
                    count++;
                }
            }
            if(count==1){
                System.out.println("C");
            }
            else if(count==2){
                System.out.println("B");
            }
            else if(count==3){
                System.out.println("A");
            }
            else if(count==4){
                System.out.println("E");
            }
            else if(count==0){
                System.out.println("D");
            }
        }
    }

    public static void main(String[] args){
        구현_윳Play_2490 구현_윳Play_2490 =new 구현_윳Play_2490();
        구현_윳Play_2490.run();
    }
}
