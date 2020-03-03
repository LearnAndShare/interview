package com.practice.matrix;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/
In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

 */
public class RottingOranges {

   public int orangesRotting(int[][] grid) {
      if(grid == null || grid.length == 0)
       return -1;
       int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
       Queue<int[]> queue = new LinkedList<>();
       int freshCount = 0;
       for(int i=0;i<grid.length;i++){
           for(int j = 0;j<grid[i].length;j++){
               if(grid[i][j] == 2){
                   queue.offer(new int[]{i,j});
               } else if(grid[i][j] == 1){
                   ++freshCount;
               }
           }
       }
       if(freshCount == 0) {
           return 0;
       }

       if(queue.size() == 0) {
           return -1;
       }

       int minutes = -1;

       while(!queue.isEmpty()){
           minutes++;
           int size = queue.size();
           for(int i=0;i<size;i++) {
               int[] p = queue.poll();


               for (int[] dir : dirs) {
                   int x = p[0] + dir[0];
                   int y = p[1] + dir[1];
                   if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
                       continue;
                   if (grid[x][y] == 1) {
                       grid[x][y] = 2;
                       queue.offer(new int[]{x, y});
                       --freshCount;
                   }
               }
           }
       }

       return freshCount!=0?-1:minutes;
   }
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(ro.orangesRotting(new int[][]{{2, 1, 1}, {0,1, 1}, {1,0, 1}}));
        System.out.println(ro.orangesRotting(new int[][]{{0,1}}));
        System.out.println(ro.orangesRotting(new int[][]{{1},{2}}));
        System.out.println(ro.orangesRotting(new int[][]{{1},{2},{1},{2}}));

    }
}
