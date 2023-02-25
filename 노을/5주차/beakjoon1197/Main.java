package com.sunset.baekjoon.kruskal.beakjoon1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int v, e;
    static List<Edge> graph;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(cost, a, b));
        }

        // parent 배열 초기화
        parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }


        // 비용 순으로 정렬
        graph.sort(((o1, o2) -> o1.cost - o2.cost));

        for (int i = 0; i < e; i++) {
            Edge edge = graph.get(i);
            if (findParent(edge.a) != findParent(edge.b)){
                union(edge.a, edge.b);
                result += edge.cost;
            }
        }

        System.out.println(result);

    }


    /**
     * findParent()로 루트 노드를 찾는다.
     * parent 배열은 루트노드를 담고 있는 배열이 아닌 "루트노드를 찾기 위한" 배열이다.
     * 따라서 i의 루트노드는 parent[i]가 아님
     */
    private static int findParent(int node) {
        if (parent[node] != node) {
            return findParent(parent[node]);
        }
        return parent[node];
    }

    // 집합 합치기
    private static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else{
            parent[parentA] = parentB;
        }
    }

    public static class Edge{
        public int cost;
        public int a;
        public int b;

        public Edge(int cost, int a, int b) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }
    }
}
