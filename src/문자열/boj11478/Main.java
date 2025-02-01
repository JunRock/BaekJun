package 문자열.boj11478;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        String input = read();
        HashSet<String> set = new HashSet<>();
        int length = input.length();

        for (int current = 1; current <= length; current++) {
            for (int i = 0; i <= length - current; i++) {
                String str = input.substring(i,i+current);
                set.add(str);
            }
        }

        write(set.size());
        close();
    }

    private static String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(int result){
        try {
            bw.write(String.valueOf(result));
            bw.flush();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void close(){
        try {
            bw.close();
            bf.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
