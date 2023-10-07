package DFS;
import java.util.*;
import java.util.stream.IntStream;

public class DFS_음식물피하기_1743 {
    int[]dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    boolean[][] visited;
    int[][]map;
    int x,y,size;
    int count;
    public void run() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        size = sc.nextInt();
        map = new int[x + 1][y + 1];
        visited = new boolean[x + 1][y + 1];

        IntStream.range(0, size).map(i -> sc.nextInt()).forEach(xTemp -> {
            int yTemp = sc.nextInt();
            map[xTemp][yTemp] = 1;
        });
        int result=0;
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(!visited[i][j]&&map[i][j]==1){
                    count=0;
                    dfs(i,j);
                    result=Math.max(result,count);
                }
            }
        }
        System.out.println(result);
    }

    public void dfs(int x1,int y1){
        visited[x1][y1]=true;
        count++;
        for(int i=0;i<4;i++){
            int tx=x1+dx[i];
            int ty=y1+dy[i];

            if(tx>=0&&ty>=0&&tx<=x&&ty<=y){
                if(!visited[tx][ty]&&map[tx][ty]==1)
                    dfs(tx, ty);
            }
        }
    }

    public static void main(String[] args) {
        DFS_음식물피하기_1743 dfs_음식물피하기_1743=new DFS_음식물피하기_1743();
        dfs_음식물피하기_1743.run();
    }
}

