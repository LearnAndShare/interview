package com.practice.graph;
/*
https://leetcode.com/problems/number-of-islands/
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

 */
public class NumberOfIslandDFS {
    public int numIslands(char[][] grid) {
        int islandCount  =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    islandCount += 1;
                    mergeIslands(grid,i,j);
                }

            }
        }
        return islandCount;
    }

    private void mergeIslands(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if(i<0||i>=r||j<0||j>=c|| grid[i][j]!= '1')
            return;
        grid[i][j]='X';
        mergeIslands(grid,i+1,j);
        mergeIslands(grid,i-1,j);
        mergeIslands(grid,i,j+1);
        mergeIslands(grid,i,j-1);
    }
    public int numberOfIsland(int[][] graph){
        int count  = 0;
        int r = graph.length;
        int c = graph[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(visited[i][j] == false && graph[i][j] == 1){
                    ++count;
                    cellsPartOfIsland(graph,visited,i,j);
                }
            }
        }

            return count;
    }

    private void cellsPartOfIsland(int[][] graph, boolean[][] visited, int i, int j) {
        if(i <0 || j < 0 || i == graph.length || j == graph[0].length || visited[i][j] == true)
        {
            return;

        }
        visited[i][j] = true;
        if(graph[i][j] == 0){
            return;
        }
        cellsPartOfIsland(graph,visited,i,j+1);
        cellsPartOfIsland(graph,visited,i+1,j);
        cellsPartOfIsland(graph,visited,i+1,j+1);
        cellsPartOfIsland(graph,visited,i-1, j+1);

        cellsPartOfIsland(graph,visited,i+1, j);
        cellsPartOfIsland(graph,visited,i-1, j);
        cellsPartOfIsland(graph,visited,i-1, j-1);
        cellsPartOfIsland(graph,visited,i, j-1);

    }

   /* private void cellsPartOfIsland(int[][] graph, boolean[][] visited, int i, int j) {
        if(i<0||i==graph.length||j<0||j==graph[0].length ) {
            return;
        }
        visited[i][j] = true;
        if(graph[i][j] == 0)
            return;
        cellsPartOfIsland(graph,visited,i,j+1);
        cellsPartOfIsland(graph,visited,i,j-1);
        cellsPartOfIsland(graph,visited,i+1,j+1);
        cellsPartOfIsland(graph,visited,i-1,j+1);
    }*/

    public static void main(String args[]){

        int matrix[][] = {{1,1,0,1,0},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,0,1},
                {1,0,0,0,0}
        };
        NumberOfIslandDFS island = new NumberOfIslandDFS();
        int count = island.numberOfIsland(matrix);
        System.out.println(count);



        int[][] p = new int[][]{{0,0},{0,1},{1,2},{2,1}};
        int m = p.length;
        int n = p[0].length;
        for(int[]pos:p) {
            System.out.print(pos[0] + pos[1]);
            int index = pos[0]*m + pos[1];
            System.out.println("Index::"+index);
        }
    }
}



