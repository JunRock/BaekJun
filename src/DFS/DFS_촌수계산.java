package DFS;
import java.util.*;
public class DFS_촌수계산 {
    int family;
    int [][]arr;
    int xfam,yfam,num;
    boolean [] visited;
    int chon;
    public void run(){
        Scanner sc=new Scanner(System.in);
        family=sc.nextInt();
        xfam=sc.nextInt();
        yfam=sc.nextInt();
        arr=new int[family+1][family+1];

        num=sc.nextInt();
        visited=new boolean[family+1];
        for(int i=0;i<num;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr[x][y]=1;
            arr[y][x]=1;
        }

       dfs(xfam,yfam,0);
        if(chon!=0)
            System.out.println(chon);
        else
            System.out.println("-1");
    }

    public void dfs(int index1,int index2,int count){
        if(index1==index2){
            chon=count;
        }
        visited[index1]=true;
        for(int i=0;i<arr[index1].length;i++){
            if(!visited[i]&&arr[index1][i]==1)
                dfs(i,index2,count+1);
        }
    }

    public static void main(String[] args){
        DFS_촌수계산 dfs_촌수계산=new DFS_촌수계산();
        dfs_촌수계산.run();
    }
}
