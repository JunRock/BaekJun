package implementation.boj12871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        String s = read();
        String t = read();
        String newS = s.repeat(t.length());
        String newT = t.repeat(s.length());

        if (newS.equals(newT)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static String read(){
        try{
            return bf.readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
