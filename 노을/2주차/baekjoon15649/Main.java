package com.sunset.baekjoon.backTracking.baekjoon15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] result;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        result = new int[m+1];
        dfs(0);
    }

    private static void dfs(int count) {
        if (count == m){
            for (int i=0; i<m; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<n+1; i++){
            if (visited[i] == false){
                visited[i] = true;
                result[count] = i;
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
}
