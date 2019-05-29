package com.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation
 * which turns the water at position (row, col) into a land. Given a list of positions to operate,
 * count the number of islands after each addLand operation. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * https://leetcode.com/problems/number-of-islands-ii/


http://buttercola.blogspot.com/2016/01/leetcode-number-of-islands-ii.html
 */
public class NumberOfIslandsDisjoint {

    public List<Integer> numIslands2(int n, int m, int[][] positions) {
     List<Integer> result = new ArrayList<>();
     Set<Integer> land = new HashSet<>();
     int count = 0;
     DisjointSet ds = new DisjointSet();
     int idx = positions[0][0]*m+positions[0][1];
     ds.makeSet(idx);
     land.add(idx);
     ++count;
     result.add(count);
     for(int i=1;i<positions.length;i++){
         int[] pos = positions[i];
         int index = pos[0]*m+pos[1];
         ds.makeSet(index);
         land.add(index);
         ++count;
         int left = pos[0]*m+(pos[1]-1);
         int right = pos[0]*m+(pos[1]+1);
         int top = (pos[0]-1)*m+pos[1];
         int bottom = (pos[0]+1)*m+pos[1];

         if((pos[1]-1) >=0 && land.contains(left)){
             if(ds.union(index,left)){
                 --count;
             }
         }

         if((pos[1]+1) <=n && land.contains(right)){
             if(ds.union(index,right)){
                 --count;
             }
         }

         if((pos[0]-1) >=0 && land.contains(top)){
             if(ds.union(index,top)){
                 --count;
             }
         }

         if((pos[0]+1) <=m && land.contains(bottom)){
             if(ds.union(index,bottom)){
                 --count;
             }
         }
            result.add(count);
     }
     return result;
    }

    public static void main(String[] args) {
        NumberOfIslandsDisjoint nd = new NumberOfIslandsDisjoint();
//        int[][] input = {{0,0},{0, 1}, {1, 2}, {2, 1}};
        int[][] input = {{0,0},{0, 1}, {0, 2}, {1, 1},{1,2}};
        System.out.println(nd.numIslands2(3,3,input));

    }
}
