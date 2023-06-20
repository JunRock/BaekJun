package GREEDY;
import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;
public class Greedy_Homework_13904 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        Vector<Integer> day=new Vector<>();
        Vector<Integer> score=new Vector<>();
        Vector<Integer> v=new Vector<>();
        int sum=0;
        int maxDay=0;
        int index = 0,maxScore=0;
        for(int i=0;i<x;i++){
            int d=sc.nextInt();
            int s=sc.nextInt();
            day.add(d);
            score.add(s);
            if(maxDay<d)
                maxDay=d;
        }

        while (maxDay!=0){
            maxScore=0;
            for(int i=0;i<day.size();i++){
                if(maxDay<=day.get(i)){
                    if(maxScore<score.get(i)){
                        maxScore=score.get(i);
                        index=i;
                    }
                }
            }
            if(maxScore!=0){
                sum+=maxScore;
                day.remove(index);
                score.remove(index);
            }
            maxDay--;
        }
        System.out.println(sum);
    }
}
