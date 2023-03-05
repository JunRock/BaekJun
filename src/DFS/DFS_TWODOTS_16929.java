package DFS;
import java.util.*;
public class DFS_TWODOTS_16929 {
    char [][]arr;
    boolean [][]visited;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    int count=0;
    int x,y,s1,s2;
    char s;
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        arr=new char[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){ //배열 입력
            String str=sc.next();
            for(int j=0;j<y;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(!visited[i][j]){
                    visited[i][j]=true;
                    dfs(i,j,arr[i][j],-1);
                }

                if(count!=0){
                    System.out.println("Yes");
                    return;
                }

            }
        }
            System.out.println("No");
    }

    public void dfs(int index1,int index2,char ar1,int idx){

        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(idx+i==1 || idx+i==5) continue;
            if(tmp1<0||tmp2<0||tmp1>=x||tmp2>=y)
                continue;


            if(ar1==arr[tmp1][tmp2]){
                if(visited[tmp1][tmp2]){
                    count++;
                    return;
                }
                visited[tmp1][tmp2]=true;
                    dfs(tmp1,tmp2,arr[tmp1][tmp2],i);
            }

        }
    }

    public static void main(String[] args){
        DFS_TWODOTS_16929 dfs_twodots_16929=new DFS_TWODOTS_16929();
        dfs_twodots_16929.run();
    }
}
