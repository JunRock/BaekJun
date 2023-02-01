package 수학;
import java.util.*;
public class Math_영수증 {
    public void run(){
        int mymoney;
        int 제품가격;
        int num;
        int count=0;
        int sum=0;
        Scanner sc=new Scanner(System.in);
        mymoney=sc.nextInt();
        num=sc.nextInt();

        for(int i=0;i<num;i++){
            제품가격=sc.nextInt();
            count=sc.nextInt();
            sum+=제품가격*count;
        }
        if(sum==mymoney)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args){
        Math_영수증 math_영수증=new Math_영수증();
        math_영수증.run();
    }
}
