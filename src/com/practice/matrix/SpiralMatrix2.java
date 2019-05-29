package com.practice.matrix;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;
        int val = 1;
        while (sr <= er && sc <= ec) {
            for (int i = sc; i <= ec; i++) {
                m[sr][i] = val++;
            }
            ++sr;
            for (int i = sr; i <= er; i++) {
                m[i][ec] = val++;
            }
            --ec;
            if (sr <= er)
                for (int i = ec; i >= sc; i--) {
                    m[er][i] = val++;
                }
            --er;
            if (sc <= ec)
                for (int i = er; i >= sr; i--) {
                    m[i][sc] = val++;
                }
            ++sc;
        }
        return m;
    }

    public static void main(String[] args) {
        SpiralMatrix2 m = new SpiralMatrix2();
        int[][] r = m.generateMatrix(3);
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }
    }
}
