package com.sunset.baekjoon.graph_traversal.baekjoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static LinkedList<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        // 입력값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // graph 초기화
        initialize(br, n, m);

        // dfs
        visited = new boolean[n+1];
        dfs(start, visited);

        System.out.println();

        // bfs
        visited = new boolean[n+1];
        bfs(start, visited);


        br.close();
    }

    private static void initialize(BufferedReader br, int n, int m) throws IOException {
        for (int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n+1; i++){
            Collections.sort(graph.get(i));
        }
    }


    private static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start+" ");
        for (int a : graph.get(start)) {
            if (!visited[a]){
                dfs(a, visited);
            }
        }
    }

    private static void bfs(int start, boolean[] visited) {

        queue.offer(start);
        visited[start] = true;
        System.out.print(start+" ");

        while(!queue.isEmpty()){
            int num = queue.poll();
            for (int i : graph.get(num)) {
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }

        }

    }

}
