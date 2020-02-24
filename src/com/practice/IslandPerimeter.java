package com.practice;
/*
https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length ==0)
            return 0;
        int p = 0;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    int top = (i == 0)? 1:(grid[i-1][j]==0?1:0);
                    int bottom = i == grid.length-1? 1:(grid[i+1][j]==0?1:0);
                    int left = j==0? 1:(grid[i][j-1]==0?1:0);
                    int right = j == grid[i].length-1? 1:(grid[i][j+1]==0?1:0);

                    p += top + bottom+left+right;


                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        System.out.println("IslandPermieter:: "+ip.islandPerimeter(new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}}));
    }
}
