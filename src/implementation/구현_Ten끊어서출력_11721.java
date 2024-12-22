package implementation;
import java.util.*;
public class 구현_Ten끊어서출력_11721 {
    public void run(){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int count=0;
        char []arr=new char[100];
        for(int i=0;i<str.length();i++){
            arr[i]=str.charAt(i);
        }
        for(int i=0;i<str.length();i++){
            if(count==10){
                System.out.println();
                count=0;
            }

            System.out.print(arr[i]);
            count++;
        }
    }

    public static void main(String[] args){
        구현_Ten끊어서출력_11721 구현_ten끊어서출력_11721=new 구현_Ten끊어서출력_11721();
        구현_ten끊어서출력_11721.run();
    }
}
