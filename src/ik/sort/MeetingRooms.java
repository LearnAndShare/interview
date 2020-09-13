package ik.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/meeting-rooms/


 */
public class MeetingRooms {
/*
TC:o(nlogn)

 */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length ==1 || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] prevMetting = intervals[0];
       for(int i=1;i<intervals.length;i++){
           int[] currMeeting = intervals[i];
           if(currMeeting[0]<prevMetting[1])
               return false;
           prevMetting = currMeeting;
       }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr  = new MeetingRooms();
        System.out.println(mr.canAttendMeetings(new int[][]{{6, 10}, {13, 14}, {12, 14}}));
//        System.out.println(mr.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
//        System.out.println(mr.canAttendMeetings(new int[][]{{7,10}, {2,4}}));
    }
}
