package DFS;
import java.util.*;
public class DFS_CountingSheep_11123 {
    int x,y;
    char[][] arr;
    boolean[][]visited;
    int[]dx={0,0,-1,1};
    int[]dy={1,-1,0,0};

    public void run(){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[]re=new int[num];
        for(int k=0;k<num;k++){
            int count=0;
            x=sc.nextInt();
            y=sc.nextInt();
            arr=new char[x][y];
            visited=new boolean[x][y];

            for(int i=0;i<x;i++) {
                String str=sc.next();
                for (int j = 0; j < y; j++){
                    arr[i][j]=str.charAt(j);
                }
            }

            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    if(!visited[i][j]&&arr[i][j]=='#'){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            re[k]=count;
        }
        for(int i=0;i<num;i++)
            System.out.println(re[i]);
    }

    public void dfs(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(tmp1<0||tmp2<0||tmp1>=x||tmp2>=y) continue;
            if(!visited[tmp1][tmp2]&&arr[tmp1][tmp2]=='#')
                dfs(tmp1,tmp2);
        }
    }

    public static void main(String[] args) {
        DFS_CountingSheep_11123 dfs_countingSheep_11123=new DFS_CountingSheep_11123();
        dfs_countingSheep_11123.run();
    }
}
