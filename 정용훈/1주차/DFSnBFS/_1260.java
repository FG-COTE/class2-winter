package DFSnBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _1260 {
    static final int MAX_VALUE = 1001;
    static int N, M, V;
    static int[][] matrix = new int[MAX_VALUE][MAX_VALUE];
    static boolean[] visited;

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 1; i < N+1; i++){
            if(matrix[start][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.remove();
            System.out.print(node + " ");

            for(int i = 1; i<N+1; i++){
                if(matrix[node][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = matrix[b][a] = 1;
        }

        dfs(V);

        System.out.println();
        visited = new boolean[N+1];

        bfs(V);

    }
}