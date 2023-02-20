package com.sunset.baekjoon.shortest_path.baekjoon1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {


    static BufferedReader br;
    static StringTokenizer st;
    static List<Integer> result;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] distance = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++){
                if (i == j) {
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = c;
        }

        for (int i = 1; i < v + 1; i++){
            for (int j = 1; j < v + 1; j++){
                for (int k = 1; k < v + 1; k++){
                    if (distance[i][j]!=Integer.MAX_VALUE && distance[j][k]!=Integer.MAX_VALUE)
                    if (distance[i][k] > distance[i][j] + distance[j][k]) {
                        distance[i][k] = distance[i][j] + distance[j][k];
                    }
                }
            }
        }

        result = new ArrayList<>();
        for (int i = 1; i < v + 1; i++){
            for (int j = i+1; j < v + 1; j++){
                if (distance[i][j]!=Integer.MAX_VALUE && distance[j][i]!= Integer.MAX_VALUE)
                    result.add(distance[i][j] + distance[j][i]);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        }else{
            System.out.println(Collections.min(result));
        }

    }
}
