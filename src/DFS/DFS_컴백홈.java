package DFS;
import java.util.*;
public class DFS_컴백홈 {
    String []map;
    boolean [][] visited;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    int count;
    int x,y,road;
    int count_road;

    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        road=sc.nextInt();
        map=new String[x];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){
            //for(int j=0;j<y;j++){
                map[i]=sc.next();

        }
        count=1;
        visited[x-1][0]=true;
        count_road=0;
        dfs(x-1,0);
        System.out.println(count);
    }

    public void dfs(int x1,int y1){
        if(x1==0&&y1==y-1){
            if(count_road==road)
                count++;
            count_road=0;
        }
        visited[x1][y1]=true;
        for(int i=0;i<4;i++){
            int tmp1=x1+dx[i];
            int tmp2=y1+dy[i];

            if(tmp1>=0&&tmp2>=0&&tmp1<x&&tmp2<y){
                if(map[tmp1]!="T"&&!visited[tmp1][tmp2]){
                    count_road++;
                    dfs(tmp1,tmp2);
                    visited[tmp1][tmp2]=false;
                }
            }
        }
    }

    public static void main(String[] args){
        DFS_컴백홈 dfs_컴백홈=new DFS_컴백홈();
        dfs_컴백홈.run();
    }
}
