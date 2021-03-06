package com.practice.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.
Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:
Input: [[7,10],[2,4]]
Output: 1
Algorithm
Sort the given meetings by their start time.
Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
If not, then we allocate a new room and add it to the heap.
After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */
public class MeetingRoomsII {
    /*
    TC: o(n logn)
    SC: o(n)
     */
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length ==0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Min heap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(
                        intervals.length,
                        (a, b) -> a - b);
        //Add first meeting
        pq.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            int[] nextMeeting = intervals[i];
            // If the room due to free up the earliest is free, assign that room to this meeting.s
            if(nextMeeting[0]>=pq.peek()){
                pq.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            pq.add(nextMeeting[1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return pq.size();

    }
}
