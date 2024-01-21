package 구현;

import java.util.*;

public class 구현_HelpC_11098 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        List<String> list=new ArrayList<>();

        for(int i=0;i<x;i++){
            int size=sc.nextInt();
            Map<Integer,String> map=new HashMap<>();
            for(int j=0;j<size;j++){
                Integer price=sc.nextInt();
                String name=sc.next();
                map.put(price,name);
            }
            Object[] sort=map.keySet().toArray();
            Arrays.sort(sort,Collections.reverseOrder());
            list.add(map.get(sort[0]));
        }
        for(String str:list){
            System.out.println(str);
        }
    }
}
