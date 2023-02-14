package 수학;
import java.util.*;
public class Math_대표값2_2587 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        int [] arr=new int[5];
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        Arrays.sort(arr);
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
        }

        System.out.println(sum/arr.length);
        System.out.println(arr[arr.length/2]);

    }

    public static void main(String[] args){
        Math_대표값2_2587 math_대표값2_2587 = new Math_대표값2_2587();
        math_대표값2_2587.run();
    }
}
