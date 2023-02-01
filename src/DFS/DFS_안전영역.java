package DFS;
import java.util.*;
public class DFS_안전영역 {
    static int [][]height;
    int n;
    static boolean [][]visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    int safe_count=0;
    int max=0;
    public void run(){
        int max_count=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        height=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                height[i][j]=sc.nextInt();
                max_count=Math.max(max_count,height[i][j]);
            }
        }

       for(int i=0;i<=max_count;i++){
           safe_count=0;
           visited=new boolean[n][n];
           for(int j=0;j<n;j++){
               for(int k=0;k<n;k++){
                   if(!visited[j][k]&&height[j][k]>i){
                       DFS(j,k,i);
                       safe_count++;
                   }
               }
           }
           max=Math.max(max,safe_count);
       }

        System.out.println(max);
    }

    public void DFS(int index1,int index2,int m){
        visited[index1][index2]=true;

        for(int i=0;i<4;i++) {
            int tmp1 = index1 + dx[i];
            int tmp2 = index2 + dy[i];
            if(tmp1<0||tmp2<0||tmp1>=n||tmp2>=n) {
                continue;
            }

            if(!visited[tmp1][tmp2] && height[tmp1][tmp2] > m) {
                DFS(tmp1, tmp2, m);
            }
        }
    }

    public static void main(String[] args){
        DFS_안전영역 dfs_안전영역=new DFS_안전영역();
        dfs_안전영역.run();
    }
}
