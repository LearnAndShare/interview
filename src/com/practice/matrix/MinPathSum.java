package com.practice.matrix;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null|| grid.length == 0){
            return 0;
        }

        return dfsDP(grid);
    }

    private int dfs(int i, int j, int[][] grid) {
        if(i>grid.length -1 || j>grid[0].length -1)
            return Integer.MAX_VALUE;
        if(i == grid.length -1 && j == grid[0].length -1)
            return grid[i][j];

        int r1 =  dfs(i+1, j, grid);
        int r2 =  dfs(i, j+1, grid);
        return grid[i][j] + Math.min(r1,r2);
    }

    private int dfsDP(int[][]matrix){
        int rows = matrix.length;
        int col = matrix[0].length;
        int[][] tmp = new int [rows][col];
        tmp[0][0] = matrix[0][0];
        //Top row
        for(int i = 1; i< col; i++){
            tmp[0][i] = tmp[0][i-1]+matrix[0][i];
        }

        //Left Col

        for(int i = 1; i< rows; i++){
            tmp[i][0] = tmp[i-1][0]+matrix[i][0];
        }

        for(int i = 1; i< rows; i++){
            for(int j = 1; j< col; j++){
                tmp[i][j] = Math.min(tmp[i-1][j],tmp[i][j-1])+ matrix[i][j];
            }
        }
        return tmp[rows -1][col -1];
    }

    public static void main(String[] args) {
        MinPathSum m = new MinPathSum();
//        System.out.println(m.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(m.minPathSum(new int[][]{{1,2},{5,6},{1,1}}));
    }

}
