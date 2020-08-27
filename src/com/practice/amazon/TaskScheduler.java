package com.practice.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*

The main idea is to schedule the most frequent tasks as frequently as possible. Begin with scheduling the most frequent task. Then cool-off for n, and in that cool-off period schedule tasks in order of frequency, or if no tasks are available, then be idle.

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
Tasks could be done without original order. Each task could be done in one interval.
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.


Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i : taskCount) {
            if(i>0)
            pq.add(i);
        }

        while(!pq.isEmpty()){
            int i=0;
            List<Integer> temp = new ArrayList<>();
            while(i<=n){
                if(!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                time++;
                if(pq.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            if(temp.size()>0) {

                pq.addAll(temp);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//        System.out.println(ts.leastInterval(new char[]{'A', 'B', 'C','D'}, 2));
//        System.out.println(ts.leastInterval(new char[]{'A', 'A', 'A'}, 2));

    }
}
