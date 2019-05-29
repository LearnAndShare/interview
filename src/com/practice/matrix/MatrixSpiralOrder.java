package com.practice.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
https://leetcode.com/problems/spiral-matrix/
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
 */
public class MatrixSpiralOrder {

    public List<Integer> spiralOrderR(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return l;
        int sr=0,sc=0;
        int er= matrix.length-1,ec = matrix[0].length-1;
        while(sr <= er && sc<=ec){
            for(int i=sr;i<=ec;i++)
                l.add(matrix[sr][i]);
            ++sr;
            for(int i=sr;i<=er;i++)
                l.add(matrix[i][ec]);
            --ec;

            if(sr<=er)
            for(int i=ec;i>=sc;i--)
                l.add(matrix[er][i]);
            --er;
            if(sc <=ec)
            for(int i=er;i>=sr;i--)
                l.add(matrix[i][sc]);
            ++sc;
        }
        return l;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return l;
        int m = matrix.length;
        int n= matrix[0].length;
        int x = 0;
        int y=0;
        while(m>0 && n>0){
            if(m ==1){
                for(int i=0;i<n;i++){
                    l.add(matrix[x][y++]);
                }
                break;
            }

            if(n ==1){
                for(int i=0;i<m;i++){
                    l.add(matrix[x++][y]);
                }
                break;
            }

            for(int i=0;i<n-1;i++){
                l.add(matrix[x][y++]);
            }

            for(int i=0;i<m-1;i++){
                l.add(matrix[x++][y]);
            }

            for(int i=0;i<m-1;i++){
                l.add(matrix[x][y--]);
            }

            for(int i=0;i<m-1;i++){
                l.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n = n-2;



        }
        return  l;
    }

    public static void main(String[] args) {
        MatrixSpiralOrder ma = new MatrixSpiralOrder();
//        int [][] ip1 = new int[][]{{2,5},{8,4},{0,-1}};
//        int [][] ip1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] ip1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer>li = ma.spiralOrderR(ip1);
        System.out.print(li);

    }

}
