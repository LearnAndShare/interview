package com.practice.graph;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii/
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>>nodeMap = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            Set<Integer> s =  nodeMap.getOrDefault(prerequisites[i][1],new HashSet<>());
            s.add(prerequisites[i][0]);
            nodeMap.putIfAbsent(prerequisites[i][1],s);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] ==0) {
                q.add(i);
                order[idx++] = i;
            }
        }


        int finishCount = q.size();
        while(!q.isEmpty()){
            int i = q.poll();
            Set<Integer> neighbors = nodeMap.getOrDefault(i,new HashSet<>());
            if(!neighbors.isEmpty()){
                for (Integer n : neighbors) {
                    indegree[n]--;
                    if(indegree[n] == 0){
                        q.add(n);
                        order[idx++] = n;
                        ++ finishCount;
                    }

                }
            }
        }
        if(finishCount==numCourses){
            return order;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        System.out.println("{1, 0}, {2, 0}");
        for (int i : cs.findOrder(3, new int[][]{{1, 0}, {2, 0}})) {
            System.out.print(i);
        }

        System.out.println("======{1, 0}, {0, 1}======");
        for (int i : cs.findOrder(3, new int[][]{{1, 0}, {0, 1}})) {
            System.out.println(i);
        }
//        System.out.println(cs.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
//        System.out.println(cs.findOrder(2, new int[][]{{0, 1}}));
    }
}
