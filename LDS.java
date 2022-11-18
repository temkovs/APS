package com.apsaud6_3;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka
        int dp[] = new int[a.length];
        dp[0] = 1;
        int max_d = 1;

        for(int i=1;i<a.length;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(a[i] < a[j] && dp[j] > max)
                    max = dp[j];
            }
            dp[i] = max + 1;

            if(dp[i] > max_d)
                max_d = dp[i];
        }

        return max_d;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
