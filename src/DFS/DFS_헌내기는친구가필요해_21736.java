package DFS;
import java.util.*;
public class DFS_헌내기는친구가필요해_21736 {
    int x,y;
    boolean [][]visited;
    char [][]arr;
    int count=0;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        arr=new char[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){
            String str=sc.next();
            for(int j=0;j<y;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(arr[i][j]=='I'){
                    dfs(i,j);
                    break;
                }
            }
        }

        if(count==0){
            System.out.println("TT");
        }
        else
            System.out.println(count);
    }

    public void dfs(int index1,int index2){
        visited[index1][index2]=true;

        if(arr[index1][index2]=='P')
            count++;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(tmp1>=0&&tmp2>=0&&tmp1<x&&tmp2<y&&!visited[tmp1][tmp2]&&arr[tmp1][tmp2]!='X'){
                    dfs(tmp1,tmp2);
            }
        }
    }

    public static void main(String[] args){
        DFS_헌내기는친구가필요해_21736 dfs_헌내기는친구가필요해_21736=new DFS_헌내기는친구가필요해_21736();
        dfs_헌내기는친구가필요해_21736.run();
    }
}
