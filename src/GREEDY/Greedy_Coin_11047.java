package GREEDY;
import java.util.*;
public class Greedy_Coin_11047 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int money=sc.nextInt();
        int[] coin=new int[size+1];
        int count=0;
        int j=0;
        for(int i=1;i<=size;i++)
            coin[i]=sc.nextInt();

        while(money!=0) {
            for (j = 1; j <= size; j++) {
                if (money < coin[j])
                    break;
            }
            if(money==1){
                count++;
                break;
            }
            money-=coin[j-1];
            count++;
        }

        System.out.println(count);
    }
}
