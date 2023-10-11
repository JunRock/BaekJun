package DFS;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class DFS_양_3184 {
    int[] dx = {0,0,-1,1};
    int[] dy ={-1,1,0,0};
    String[][]map;
    boolean[][]visited;
    int sheep;
    int wolf;
    int row;
    int col;

    public void run() {
        Scanner sc=new Scanner(System.in);
        row=sc.nextInt();
        col=sc.nextInt();
        int resultSheep=0;
        int resultWolf=0;

        map=new String[row][col];
        visited=new boolean[row][col];

        for(int i=0;i<row;i++){  //map생성
            String line=sc.next();
            for(int j=0;j<col;j++){
                map[i][j]= String.valueOf(line.charAt(j));
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!map[i][j].equals("#")&&!visited[i][j]){
                    sheep=0;
                    wolf=0;
                    dfs(i,j);
                    if(sheep>wolf)
                        resultSheep+=sheep;
                    else
                        resultWolf+=wolf;
                }
            }
        }
        System.out.println(resultSheep+" "+resultWolf);
    }

    public void dfs(int x,int y) {
        visited[x][y]=true;
        if(map[x][y].equals("o")) //양인 경우
            sheep++;
        if(map[x][y].equals("v")) //늑대인 경우
            wolf++;

        for(int i=0;i<4;i++){
            int xTemp=x+dx[i];
            int yTemp=y+dy[i];

            if(xTemp>=0&&yTemp>=0&&xTemp<row&&yTemp<col)
            if(!visited[xTemp][yTemp]&&!map[xTemp][yTemp].equals("#")){
                dfs(xTemp,yTemp);
            }
        }
    }

    public static void main(String[] args) {
        DFS_양_3184 dfs_양_3184 = new DFS_양_3184();
        dfs_양_3184.run();
    }
}
