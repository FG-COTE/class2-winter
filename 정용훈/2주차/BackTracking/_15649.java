package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _15649 {

    static int N, M;
    static int[] nList;
    static boolean[] visited;
    static int[] arr;

    static void dfs(int depth){
        if(depth == M){
            for(int v=0; v<M; v++){
                System.out.print(arr[v]+" ");
            }
            System.out.println("");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue; //이미 방문했다면 continue
            visited[i] = true; //방문 처리하고
            arr[depth] = i;    //arr배열에 넣기
            dfs(depth+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 방문 처리 Boolean형 배열
        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        // 순열 저장할 배열
        arr = new int[M];

        dfs(0);
    }
}
