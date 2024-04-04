package BRUTE_FORCE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BruteForce_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int count = 1;
        int initalNum = 666;
        while (count != num) {
            initalNum++;
            if (String.valueOf(initalNum).contains("666")) {
                count++;
            }
        }
        System.out.println(initalNum);
    }
}
