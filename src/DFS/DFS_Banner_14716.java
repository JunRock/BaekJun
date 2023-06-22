package DFS;
import java.util.*;
public class DFS_Banner_14716 {
    boolean visited[][];
    int[][] arr;
    int[]dx={-1, 1, 0, 0, -1, 1, 1, -1};
    int[]dy={0, 0, -1, 1, 1, -1, 1, -1};
    int count=0;
    int x,y;
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        arr=new int[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                arr[i][j]=sc.nextInt();

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(!visited[i][j]&&arr[i][j]==1){
                    dfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public void dfs(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<8;i++){
           int tmp1=index1+dx[i];
           int tmp2=index2+dy[i];
           if(tmp1<0||tmp2<0||tmp1>=x||tmp2>=y) continue;
           if(arr[tmp1][tmp2]==1&&!visited[tmp1][tmp2])
               dfs(tmp1,tmp2);
        }
    }

    public static void main(String[] args) {
        DFS_Banner_14716 dfs_banner_14716=new DFS_Banner_14716();
        dfs_banner_14716.run();
    }
}
