package DFS;
import java.util.*;
public class DFS_그림_1926 {
    int n,m;
    int count;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    boolean [][] visited;
    int [][] arr;
    int max_area;
    int ma;

    public void run(){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        count=0;
        ma=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    max_area=1;
                    dfs(i,j);
                    count++; //그림의 개수
                }
                ma=Math.max(ma,max_area);
            }
            max_area=Math.max(ma,max_area);
        }
        System.out.println(count);
        System.out.println(max_area);
    }

    public void dfs(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(tmp1<n&&tmp2<m&&tmp1>=0&&tmp2>=0){
                if(!visited[tmp1][tmp2]&&arr[tmp1][tmp2]==1){
                    max_area++; //그림의 넓이 증가
                    dfs(tmp1,tmp2);
                }
            }
        }
    }

    public static void main(String[] args){
        DFS_그림_1926 dfs_그림_1926=new DFS_그림_1926();
        dfs_그림_1926.run();
    }
}
