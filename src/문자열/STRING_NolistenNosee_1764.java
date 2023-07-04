package 문자열;
import java.util.*;
public class STRING_NolistenNosee_1764 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int noListen=sc.nextInt();
        int noSee=sc.nextInt();
        HashMap<String,Integer> nL=new HashMap<>();
        Vector<String> v=new Vector<>();

        for(int i=0;i<noListen;i++){
            String str=sc.next();
            nL.put(str,1);
        }

        for(int i=0;i<noSee;i++){
            String str=sc.next();
            if(nL.containsKey(str)){
                v.add(str);
            }
        }
        Collections.sort(v);

        System.out.println(v.size());
        Iterator it=v.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
