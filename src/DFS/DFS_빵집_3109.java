package DFS;
import java.util.*;
public class DFS_빵집_3109 {
    int r,c;
    String [][]arr;
    boolean [][]visited;
    int []dx={-1,0,1};
    int count=0;
    public void run(){
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        arr=new String[r][c];
        visited=new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] s = sc.next().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = s[j];
            }
        }

        for(int i=0;i<r;i++){
             dfs(i,0);
         }
        System.out.println(count);
    }

    public void dfs(int index1,int index2){
        if(index2==c-1){
            count++;
            return;
            }

        for(int i=0;i<3;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+1;
            if (tmp1 < 0 || tmp1 >=r || tmp2 < 0 || tmp2 >= c)
                    continue;
                if(!visited[tmp1][tmp2]&&arr[tmp1][tmp2]!="x"){
                    visited[tmp1][tmp2]=true;
                    dfs(tmp1,tmp2);
                }


            }
        }


    public static void main(String[] args){
        DFS_빵집_3109 dfs_빵집_3109=new DFS_빵집_3109();
        dfs_빵집_3109.run();
    }
}
