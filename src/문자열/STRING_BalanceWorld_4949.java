package 문자열;
import java.util.*;
public class STRING_BalanceWorld_4949 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true){
            Stack<String> stack=new Stack<>();
            String str=sc.nextLine();
            if(str.equals(".")){
                return;
            }
            int count=0;
            for(int i=0;i<str.length();i++){
                switch (str.charAt(i)){
                    case '(':
                        stack.push("(");
                        break;
                    case '[':
                        stack.push("[");
                        break;
                    case ')':
                        if(stack.isEmpty()||!stack.pop().equals("(")){
                            count++;
                        }
                        break;
                    case ']':
                        if(stack.isEmpty()||!stack.pop().equals("[")){
                            count++;
                        }
                        break;
                }
            }
            if(!stack.isEmpty()){
                System.out.println("no");
                continue;
            }
            if(count==0){
                System.out.println("yes");
            }
            else
                System.out.println("no");

        }
    }
}
