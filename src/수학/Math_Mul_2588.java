package 수학;
import java.util.*;
public class Math_Mul_2588 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x= sc.next();
        String y=sc.next();
        int[]arr=new int[3];
        int result=0;

        for(int i=0;i<y.length();i++) {
            arr[i]=Integer.parseInt(x)*Integer.parseInt(String.valueOf(y.charAt(i)));
        }

        for(int i=arr.length-1;i>=0;i--)
            System.out.println(arr[i]);

        arr[1]= Integer.parseInt(arr[1]+"0");
        arr[0]= Integer.parseInt(arr[0]+"00");

        for(int i=0;i<arr.length;i++)
            result+=arr[i];

        System.out.println(result);
    }
}
