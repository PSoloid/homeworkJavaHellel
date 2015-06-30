package com.Hellel.PSoloid.homework3;

/**
 * Created by Morozov on 30.06.2015.
 */
public class Fibonacci {

    public static long run(int n) {
        long [] row = new long[n];
        if (n <= 0) return 0L;
            else if (n == 1) return 1L;
            else {
                row[0] = 0L;
                row[1] = 1L;
                row[2] = 1L;
                for (int i = 2; i < n; i++) {
                    row[i] = row[i-1] + row[i-2];
                }
                return row[n-1];

        }
    }
}
