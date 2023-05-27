package 구현;
import java.util.Scanner;
public class 구현_Frame_7568 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] weight=new int[num];
        int[] height=new int[num];
        int[] rank=new int[num];
        int count=1;
        for(int i=0;i<num;i++){
            weight[i]=sc.nextInt();
            height[i]=sc.nextInt();
        }

        for(int i=0;i<num;i++){
            count=1;
            for(int j=0;j<num;j++){
                if(weight[i]>weight[j]&&height[i]>height[j])
                    count++;
            }
            rank[i]=count;
        }
        int[] ranking =new int[num];
        int max=0;
        for(int i=0;i<num;i++){
            if(max<rank[i])
        }
    }

    public static void main(String[] args) {
        구현_Frame_7568 구현_frame_7568 = new 구현_Frame_7568();
        구현_frame_7568.run();
    }
}
