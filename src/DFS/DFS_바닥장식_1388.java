package DFS;
import java.util.*;
public class DFS_바닥장식_1388 {
    int x,y;
    boolean [][]visited;
    char [][]arr;
    int count=0;
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    public void run(){
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        arr=new char[x][y];
        visited=new boolean[x][y];

        for(int i=0;i<x;i++){
            String str=sc.next();
            for(int j=0;j<y;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<x;i++){
            int tmp=0;
            for(int j=0;j<y;j++){
                if(arr[i][j]=='|'){
                    tmp=0;
                }
                else{
                    if(++tmp==1)
                    count++;
                }
            }
        }

        for(int i=0;i<y;i++){
            int tmp=0;
            for(int j=0;j<x;j++){
                if(arr[j][i]=='-'){
                    tmp=0;
                }
                else{
                    if(++tmp==1)
                        count++;
                }

            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        DFS_바닥장식_1388 dfs_바닥장식_1388=new DFS_바닥장식_1388();
        dfs_바닥장식_1388.run();
    }
}


