package GREEDY;
import java.util.*;

public class Greedy_회의실배정_1931{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[][] arr=new int[size][2];
        int count=0;
        int time=0;
        for(int i=0;i<size;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() { //Point!
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        for(int i=0;i<size;i++){
            if(time<=arr[i][0]){
                time=arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
