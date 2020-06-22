package com.practice.matrix;

import java.util.LinkedList;
import java.util.Queue;

/*
https://zhuhan0.blogspot.com/2017/07/leetcode-286-walls-and-gates.html
 You are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {
    private final int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0)
                    queue.offer(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] ele=queue.poll();
            int dist = rooms[ele[0]][ele[1]];
            for(int i=0;i<4;i++){
                int nr = ele[0]+DIRECTIONS[i][0];
                int nc = ele[1] + DIRECTIONS[i][1];
                if(nr>=0 && nr< rooms.length&& nc>=0 && nc < rooms[0].length && rooms[nr][nc]== Integer.MAX_VALUE){
                    rooms[nr][nc] = dist +1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] m= new int[][]{
                {Integer.MAX_VALUE,  -1,  0 , Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,  -1},
                {Integer.MAX_VALUE,  -1 ,Integer.MAX_VALUE , -1},
                {0,  -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        WallsAndGates wg = new WallsAndGates();
        wg.wallsAndGates(m);
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();

        }
    }
}
