package DFS;
import java.util.*;
public class DFS_영역구하기 {
    int x,y,z;
    int count;
    int [][]map;
    int []dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    boolean [][]visited;
    List<Integer> area;
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        map=new int[y][x];
        visited=new boolean[y][x];
        area=new ArrayList<>();
        for(int i=0;i<z;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();

            for(int j=x1;j<x2;j++){
                for(int k=y1;k<y2;k++){
                    map[j][k]=1;
                }
            }
        }

        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(map[i][j]==0&&!visited[i][j]){
                    count=0;
                    dfs(i,j);
                    area.add(count);
                }
            }
        }
        Collections.sort(area);
        System.out.println(area.size());
        for(int i=0;i< area.size();i++){
            System.out.print(area.get(i)+" ");
        }
    }

    public void dfs(int x1,int y1){
        count++;
        visited[x1][y1]=true;
        for(int i=0;i<4;i++){
            int tmp1=x1+dx[i];
            int tmp2=y1+dy[i];

            if(tmp1>=0&&tmp2>=0&&tmp1<y&&tmp2<x)
                if(map[tmp1][tmp2]==0&&!visited[tmp1][tmp2])
                    dfs(tmp1,tmp2);
        }
    }

    public static void main(String[] args){
        DFS_영역구하기 dfs_영역구하기=new DFS_영역구하기();
        dfs_영역구하기.run();
    }
}
