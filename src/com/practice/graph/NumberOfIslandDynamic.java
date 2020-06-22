package com.practice.graph;

import java.util.*;
/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation
 * which turns the water at position (row, col) into a land. Given a list of positions to operate,
 * count the number of islands after each addLand operation. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * https://leetcode.com/problems/number-of-islands-ii/


 http://buttercola.blogspot.com/2016/01/leetcode-number-of-islands-ii.html
 */
public class NumberOfIslandDynamic {
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        if (positions.length == 0 || positions[0].length == 0) {
            return Collections.emptyList();
        }
        int count = 0;
        DisjointSet ds = new DisjointSet();
        Set<Integer> land = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int[] position : positions) {
            int index = position[0]*m + position[1];
            land.add(index);
            ds.makeSet(index);
            count++;
            //find the four neighbors;
            int n1 = (position[0] - 1)*m + position[1];
            int n2 = (position[0] + 1)*m + position[1];
            int n3 = (position[0])*m + position[1] + 1;
            int n4 = (position[0])*m + position[1] - 1;

            if (position[0] - 1 >= 0 && land.contains(n1)) {
                if (ds.union(index, n1)) {
                    count--;
                }
            }
            if (position[0] + 1 < n && land.contains(n2)) {
                if (ds.union(index, n2)) {
                    count--;
                }
            }
            if (position[1] + 1 < m && land.contains(n3)) {
                if (ds.union(index, n3)) {
                    count--;
                }
            }
            if (position[1] - 1 >= 0 && land.contains(n4)) {
                if (ds.union(index, n4)) {
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{0,0},{0, 1}, {0, 2}, {1, 1},{1,2}};
        NumberOfIslandDynamic nd = new NumberOfIslandDynamic();
        System.out.println(nd.numIslands2(3,3,input));
    }

}
