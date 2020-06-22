package com.practice.graph;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule/
Topological sort
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>>nodeMap = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            Set<Integer> s =  nodeMap.getOrDefault(prerequisites[i][1],new HashSet<>());
            s.add(prerequisites[i][0]);
            nodeMap.putIfAbsent(prerequisites[i][1],s);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] ==0)
                q.add(i);
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
                        ++ finishCount;
                    }

                }
            }
        }
        return finishCount==numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(3, new int[][]{{1, 0}, {2, 0}}));
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(cs.canFinish(2, new int[][]{{0, 1}}));
    }
}
