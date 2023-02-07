package DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {

    static int M, N;
    static int[][] box;
    static boolean[][] visited;
    static int day;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    static void bfs(int x, int y){
        for(boolean[] a:visited){
            Arrays.fill(a, false);
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x,y});

        while(!queue.isEmpty()){
            int px = queue.peek()[0];
            int py = queue.peek()[1];
            visited[px][py] = true;

            queue.poll();

            for(int i=0; i<4; i++){
                int cx = px + dx[i];
                int cy = py + dy[i];

                if(box[cx][cy] != -1 && !visited[cx][cy]){
                    if(box[cx][cy] > 1){
                        box[cx][cy] = (box[cx][cy]> day) ? day++ : box[cx][cy];
                    }
                    else if(box[cx][cy] == 0){
                        box[cx][cy] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // box initialized
        box = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ripen initialized
        visited = new boolean[N][M];
//        for(boolean[] a:visited){
//            Arrays.fill(a, false);
//        }

        // bfs 이용 (1과 1사이(없다면 끝까지)의 최소 거리 즉, 노드 사이의 최단 거리 구하기)
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j]==1 && !visited[i][j]){
                    day = 1;
                    bfs(i,j);
                }
            }
        }


    }
}
