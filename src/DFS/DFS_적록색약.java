package DFS;
import java.util.*;
public class DFS_적록색약 {
    int [][] arr;
    int count1=0;
    int count2=0;
    int size;
    boolean [][] visited;
    int []dx={1,-1,0,0}; //좌우
    int []dy={0,0,-1,1};//상하

    public void run(){
        Scanner sc=new Scanner(System.in);
        size=sc.nextInt();
        arr=new int[size][size];
        visited=new boolean[size][size];

        for(int i=0;i<size;i++){
            String str=sc.next();
            for(int j=0;j<size;j++){
                arr[i][j]=str.charAt(j)-'A';
            }
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(!visited[i][j]) {
                    dfs1(i, j);
                    count1++;
                }
            }
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                visited[i][j]=false;
            }
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(!visited[i][j]) {
                    dfs2(i, j);
                    count2++;
                }
            }
        }
        System.out.println(count1+" "+count2);
    }

    public void dfs1(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];

            if(tmp1>=0&&tmp2>=0&&tmp1<size&&tmp2<size){
                if(!visited[tmp1][tmp2]&&arr[index1][index2]==arr[tmp1][tmp2]){
                    dfs1(tmp1,tmp2);
                }
            }
        }
    }

    public void dfs2(int index1,int index2){
        visited[index1][index2]=true;
        for(int i=0;i<4;i++){
            int tmp1=index1+dx[i];
            int tmp2=index2+dy[i];
            if(tmp1>=0&&tmp2>=0&&tmp1<size&&tmp2<size){
                if(!visited[tmp1][tmp2]&&(arr[index1][index2]==arr[tmp1][tmp2]-11||arr[index1][index2]==arr[tmp1][tmp2]+11||arr[index1][index2]==arr[tmp1][tmp2])){
                    dfs2(tmp1,tmp2);
                }
            }
        }
    }

    public static void main(String[] args){
        DFS_적록색약 dfs_적록색약=new DFS_적록색약();
        dfs_적록색약.run();
    }
}
