package BFS;
import java.util.*;
public class BFS_토마토_7576 {
    int x,y;
    boolean[][]visited;
    int[][] map;
    int[]dx={0,0,-1,1};
    int[]dy={1,-1,0,0};
    int no=0;
    int maxDay=0;
    Queue<int[]> queue=new LinkedList<>();

    public void run() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        map=new int[y][x];
        //visited=new boolean[x][y];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

       bfs();
    }
    public void bfs(){
        while(!queue.isEmpty()){
            int[]arr=queue.poll();
            int nx=arr[0];
            int ny=arr[1];
            for(int i=0;i<4;i++){
                int tmpX=dx[i]+nx;
                int tmpY=dy[i]+ny;

                if(tmpX>=0&&tmpY>=0&&tmpX<y&&tmpY<x){
                    if(map[tmpX][tmpY]==0){
                        map[tmpX][tmpY]=map[nx][ny]+1;
                        queue.add(new int[]{tmpX,tmpY});
                    }
                }
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, map[i][j]);
            }
        }
        System.out.println(maxDay-1);
    }

    public static void main(String[] args) {
        BFS_토마토_7576 bfs_토마토_7576=new BFS_토마토_7576();
        bfs_토마토_7576.run();
    }
}
