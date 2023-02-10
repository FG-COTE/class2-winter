package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18429 {
    static int N, K, count;
    static int[] A;
    static int[] inc;
    static boolean[] visited;
//    static int weight = 500;

    static void dfs(int weight, int depth){
        // depth과 N의 값이 같다면 count값을 증가시키고 return
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]==true || weight+inc[i]<500) continue;
            visited[i]=true;
            dfs(weight+inc[i], depth+1);
            visited[i]=false;

//            weight = weight+inc[i];
//            visited[i]= true;
//            dfs(depth+1);
//            visited[i]=false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 증가량 배열 inc
        inc = new int[N];
        for(int i=0;i<A.length; i++){
            inc[i] = A[i]-K;
        }

        // 방문 처리 visited
        visited = new boolean[N];
        Arrays.fill(visited, false);

        dfs(500, 0);

        System.out.println(count);
    }
}
