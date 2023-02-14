package com.sunset.baekjoon.shortest_path.baekjoon1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];

        //최소 거리를 담는 distance 배열 초기화
        distance = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }


        // 입력값 받아서 graph 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        dijkstra(start);
        System.out.println(distance[end]);

    }

    private static void dijkstra(int start) {
        distance[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node nodeQueue = priorityQueue.poll();
            if (nodeQueue.cost > distance[nodeQueue.idx]) {
                continue;
            }
            for (Node node : graph[nodeQueue.idx]) {
                int updateDistance = node.cost + nodeQueue.cost;
                if (updateDistance < distance[node.idx]) {
                    distance[node.idx] = updateDistance;
                    priorityQueue.add(new Node(node.idx, updateDistance));
                }
            }

        }

    }
}



class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
