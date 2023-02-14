package DFS;
import java.util.*;
public class DFS_빵집_3109 {
    int r,c;
    String [][]arr;
    boolean [][]visited;
    int []dx={-1,0,1};
    int []dy={1,1,1};
    int count;
    boolean check;
    public void run(){
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        arr=new String[r][c];
        visited=new boolean[r][c];
        count=0;
        for (int i = 0; i < r; i++) {
            String[] s = sc.next().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = s[j];
            }
        }

        for(int i=0;i<r;i++){
            check=false;
             dfs(i,0);
         }
        System.out.println(count);
    }

    public void dfs(int index1,int index2) {
        if (index2 == c - 1) {
            count++;
            check = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int tmp1 = index1 + dx[i];
            int tmp2 = index2 + dy[i];
            if (tmp1 >=0 && tmp1 < r && tmp2 >= 0 && tmp2 < c) {
                if (arr[tmp1][tmp2] == ".") {
                    if (check) return;
                    arr[tmp1][tmp2] = "o";
                    dfs(tmp1, tmp2);
                }
            }
        }
    }


    public static void main(String[] args){
        DFS_빵집_3109 dfs_빵집_3109=new DFS_빵집_3109();
        dfs_빵집_3109.run();
    }
}
