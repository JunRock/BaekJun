package DFS;
import java.util.*;
public class DFS_미로탐색_2178 {
    int x,y;
    int [][]arr;
    boolean [][]visited;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    int min_count=0;

    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();

        arr=new int[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        dfs(0,0);
        return;
    }

    public void dfs(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(tmp1<0||tmp2<0||tmp1>=x||tmp2>=y) continue;
            if(tmp1==x&&tmp2==y) {
                System.out.println(min_count);
                return;
            }
            if(arr[tmp1][tmp2]==1&&!visited[tmp1][tmp2]){
                min_count++;
                dfs(tmp1,tmp2);
            }
        }
    }

    public static void main(String[] args){
        DFS_미로탐색_2178 dfs_미로탐색_2178 = new DFS_미로탐색_2178();
        dfs_미로탐색_2178.run();
    }
}
