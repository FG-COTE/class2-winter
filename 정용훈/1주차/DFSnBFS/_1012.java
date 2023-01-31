package DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012 {
    static int T, M, N, K;
    static int[][] field;
    static boolean[][] visited;
    static int count;

    // 상하좌우 이동 좌표계
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void bfs(int X, int Y){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{X,Y});

        while(!queue.isEmpty()){

            //peek의 X값과 Y값을 사용하기 위해 뽑기
            int x = queue.peek()[0];
            int y = queue.peek()[1];

            visited[x][y] = true;

            queue.poll();

            for(int i =0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx>=0 && cy>=0 && cx<M && cy<N){
                    if(!visited[cx][cy] && field[cx][cy]==1){
                        visited[cx][cy] = true;
                        queue.offer(new int[]{cx,cy});
                    }
                }
            }

            // range out of index 오류 처리 방법 고민
//            // X값+1
//            if(field[1+node[0]][node[1]]==1 && visited[1+node[0]][node[1]]==false){
//                visited[1+node[0]][node[1]] = true;
//                queue.offer(new int[]{X+1,Y});
//            }
//            // X값-1
//            if(field[-1+node[0]][node[1]]==1 && visited[-1+node[0]][node[1]]==false){
//                visited[-1+node[0]][node[1]] = true;
//                queue.offer(new int[]{X-1,Y});
//            }
//            // Y값+1
//            if(field[node[0]][1+node[1]]==1 && visited[node[0]][1+node[1]]==false){
//                visited[node[0]][1+node[1]] = true;
//                queue.offer(new int[]{X,Y+1});
//            }
//            // Y값-1
//            if(field[node[0]][-1+node[1]]==1 && visited[node[0]][-1+node[1]]==false){
//                visited[node[0]][-1+node[1]] = true;
//                queue.offer(new int[]{X,Y-1});
//            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            count = 0;

            field = new int[M][N];

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[X][Y] = 1;
            }

            // visited
            visited = new boolean[M][N];
            for(boolean[] a:visited){
                Arrays.fill(a,false);
            }
            // field 1 이면서 visited이 false일 때 bfs 함수 호출
            for(int u=0; u<M;u++){
                for(int v=0; v<N;v++){
                    if(field[u][v]==1 && !visited[u][v]){
                        bfs(u, v);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
