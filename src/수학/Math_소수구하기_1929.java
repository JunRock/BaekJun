package 수학;
import java.util.*;
public class Math_소수구하기_1929 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int count=0;
        int [] tmp=new int[y-x];

        for(int i=0;i< tmp.length;i++){
            if(x!=y)
                tmp[count++]=x++;
        }

        for(int i=2;i<Math.sqrt(y);i++){
            for(int a=i*2;a<=y;a+=i) {
                for (int j = 0; j < tmp.length; j++)
                    if (tmp[j] % a == 0) {
                        tmp[j] = 0;
                    }
            }
        }

        for(int i=0;i<tmp.length;i++){
            if(tmp[i]!=0){
                System.out.println(tmp[i]);
            }
        }
    }

    public static void main(String[] args){
        Math_소수구하기_1929 math_소수구하기=new Math_소수구하기_1929();
        math_소수구하기.run();
    }
}
