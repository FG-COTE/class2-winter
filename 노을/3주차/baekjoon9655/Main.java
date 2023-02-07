package com.sunset.baekjoon.dp.baekjoon9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static String[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


//        math(n);
        dp(n);


    }

    private static void dp(int n) {
        dp = new String[1001];
        dp[1] = "SK";
        dp[2] = "CY";
        dp[3] = "SK";

        if (n >= 4) {
            for (int i = 4; i < n + 1; i++) {
                if (dp[i - 1].equals("SK") || dp[i - 3].equals("SK")) {
                    dp[i] = "CY";
                }
                else{
                    dp[i] = "SK";
                }
            }
        }
        System.out.println(dp[n]);
    }

    private static void math(int n) {
        if (n % 2 == 0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
