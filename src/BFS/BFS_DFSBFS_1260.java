package BFS;
import java.util.*;
public class BFS_DFSBFS_1260 {
    int v,e,vertex;
    int [][] grape;
    boolean [] visited;
    Queue<Integer> queue=new LinkedList<>();
    public void run(){
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        vertex=sc.nextInt();
        grape=new int[v+1][v+1];
        visited=new boolean[v+1];

        for(int i=0;i<e;i++){
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            grape[num1][num2]=1;
            grape[num2][num1]=1;
        }
        System.out.print(vertex+" ");
        dfs(vertex);
        System.out.println();

        visited=new boolean[v+1];
        System.out.print(vertex+" ");
        bfs(vertex);
    }

    public void dfs(int vertex) {
        visited[vertex]=true;

        for(int i=1;i<v+1;i++){
            if(grape[vertex][i]==1&&!visited[i]){
                System.out.print(i+" ");
                dfs(i);
            }
        }
    }

    public void bfs(int vertex) {
        visited[vertex]=true;

        for(int i=1;i<v+1;i++){
            if(grape[vertex][i]==1&&!visited[i]){
                queue.offer(i);
                visited[i]=true;
            }
        }
        while(!queue.isEmpty()){
            int x=queue.poll();
            System.out.print(x+" ");
            bfs(x);
        }
    }

    public static void main(String[] args){
        BFS_DFSBFS_1260 bfs_dfsbfs_1260=new BFS_DFSBFS_1260();
        bfs_dfsbfs_1260.run();
    }
}
