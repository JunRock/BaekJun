package 문자열;
import java.util.*;
public class STRING_StringMuster_14425 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        HashMap<String,Integer> map=new HashMap<>();
        Vector<String> v=new Vector<>();
        int count=0;

        for(int i=0;i<x;i++){
            String str=sc.next();
            map.put(str,1);
        }

        for(int i=0;i<y;i++){
            String str=sc.next();
            if(map.containsKey(str))
                count++;
        }

        System.out.println(count);
    }
}
