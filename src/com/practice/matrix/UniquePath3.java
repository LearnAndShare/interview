package com.practice.matrix;
/*
https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePath3 {

    public int uniquePathsIII(int[][] grid) {
        int sr = -1;
        int sc = -1;
        int totalWalkingSq = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }

                if(grid[i][j] ==0)
                    ++totalWalkingSq;
            }
        }

        return dfs(sr,sc,grid,totalWalkingSq+1);
    }

    private int dfs(int sr,int sc,int[][]grid,int n){
        if(sr <0 || sc<0|| sr>grid.length-1|| sc > grid[0].length-1 || grid[sr][sc] == -1)
            return 0;
        if(grid[sr][sc] == 2) {
            if (n == 0)
                return 1;
            else
                return 0;
        }
        grid[sr][sc] = -1;
        int p = dfs(sr+1,sc,grid,n-1)
                +dfs(sr,sc+1,grid,n-1)
                +dfs(sr-1,sc,grid,n-1)
                +dfs(sr,sc-1,grid,n-1);
        grid[sr][sc] = 0;
        return p;

    }

    public static void main(String[] args) {
        UniquePath3 up = new UniquePath3();
//        System.out.println( up.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
//        System.out.println( up.uniquePathsIII(new int[][]{{1,0},{0,0},{0,2}}));
//        System.out.println(up.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
        System.out.println(up.uniquePathsIII(new int[][]{{0,1},{2,0}}));
    }
}
