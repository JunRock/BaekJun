package 수학;
import java.util.*;
public class 날짜계산_1476 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int e,s,m;
        int year=0;
        e=sc.nextInt();
        s=sc.nextInt();
        m=sc.nextInt();

        while(true){
            year++;
            if(((year-e)%15==0)&&((year-s)%28==0)&&((year-m)%19==0))
                break;
        }
        System.out.println(year);
    }

    public static void main(String[] args){
        날짜계산_1476 m_날짜계산_1476=new 날짜계산_1476();
        m_날짜계산_1476.run();
    }
}
