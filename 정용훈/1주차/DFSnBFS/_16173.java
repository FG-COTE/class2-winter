package DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _16173 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static void dfs(int i, int j){
        // map의 범위를 나가는 경우;
        if(i>=map.length || j>=map.length) return ;
        // 이미 방문했던 좌표인 경우;
        if(visited[i][j] == true) return ;
        // 목적지에 도착;
        if(map[i][j] == -1){
            System.out.println("HaruHaru");
            exit(0);
        }
        visited[i][j] = true;
        dfs(i+map[i][j],j);
        dfs(i, j+map[i][j]);
    }

    static void bfs(int i, int j){ //return String으로 해도 됨
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {i,j});

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];

            if(map[x][y] == -1){
                System.out.println("HaruHaru");
                exit(0);
            }
            visited[x][y] = true;

            queue.poll();

            for(int u=0; u<2; u++){
                int cx = x + map[x][y]*dx[u];
                int cy = y + map[x][y]*dy[u];

                if(cx>=0 && cy>=0 && cx<N && cy<N){
                    if(!visited[cx][cy]) queue.offer(new int[] {cx, cy});
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new boolean[N][N];
        for(boolean a[]:visited){
            Arrays.fill(a, false);
        }

        dfs(0, 0);
        bfs(0, 0);
        System.out.println("Hing");

        br.close();
    }
}
