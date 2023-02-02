package com.sunset.baekjoon.backTracking.baekjoon18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static boolean[] visited;
    static List<Integer> kit = new ArrayList<>();;
    private static int count = 0;
    static int result;
    static int weight = 500;

    public static void main(String[] args) throws IOException {
        //입력값 받기
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kit.add(Integer.parseInt(st.nextToken()));
        }
        visited = new boolean[n];
        dfs(0);
        System.out.println(result);


    }

    public static void dfs(int count) {
        if (count == n){
            result += 1;
            return;
        }
        for (int i = 0; i < kit.size(); i++) {
            if (visited[i] == false) {
                if (weight-k+kit.get(i) >= 500){
                    weight = weight-k+kit.get(i);
                    visited[i] = true;
                    dfs(count + 1);
                    weight = weight+k-kit.get(i);
                    visited[i] = false;
                }
            }
        }
    }
}
