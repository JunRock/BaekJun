package BFS;
import java.util.*;
public class BFS_미로찾기_2178 {
    int []dx={0,0,-1,1};
    int []dy={-1,1,0,0};
    boolean [][]visited;
    int [][]map;
    int x,y;
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        map=new int[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){
            String str=sc.next();
            for(int j=0;j<y;j++){
                map[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(0,0);
        System.out.println(map[x-1][y-1]);
    }

    public void bfs(int index1, int index2) {
        Queue<int []> queue=new LinkedList<>();
        queue.offer(new int[]{index1,index2});
        while(!queue.isEmpty()){
            int []arr=queue.poll();
            visited[index1][index2]=true;

            for(int i=0;i<4;i++){
                int tmp1=dx[i]+arr[0];
                int tmp2=dy[i]+arr[1];
                if(tmp1>=0&&tmp2>=0&&tmp1<x&&tmp2<y){
                    if(map[tmp1][tmp2]!=0&&!visited[tmp1][tmp2]){
                        visited[tmp1][tmp2]=true;
                        map[tmp1][tmp2]=map[arr[0]][arr[1]]+1;
                        queue.add(new int[]{tmp1,tmp2});
                    }
                }
            }
        }
    }


    public static void main(String[] args){
        BFS_미로찾기_2178 bfs_미로찾기_2178=new BFS_미로찾기_2178();
        bfs_미로찾기_2178.run();
    }
}
