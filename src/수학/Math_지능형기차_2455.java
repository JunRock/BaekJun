package 수학;
import java.util.*;
public class Math_지능형기차_2455 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int sum_in=0;
        int max=0;
        for(int i=0;i<4;i++){
            int out=sc.nextInt();
            int in=sc.nextInt();
            sum_in=sum_in+in-out;
            max=Math.max(sum_in,max);
        }

        System.out.println(max);
    }

    public static void main(String[] args){
        Math_지능형기차_2455 math_지능형기차_2455=new Math_지능형기차_2455();
        math_지능형기차_2455.run();
    }
}
