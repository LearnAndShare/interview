package com.practice;

import java.util.TreeSet;

/*
https://leetcode.com/problems/exam-room/
In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
If there are multiple such seats, they sit in the seat with the lowest number.
(Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions:
ExamRoom.seat() returning an int representing what seat the student sat in,
ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.
It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.



Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student sits at the last seat number 5.


 */
public class ExamRoom {
    TreeSet<Integer> s;
    int N;
    public ExamRoom(int N) {
        s = new TreeSet<>();
        this.N = N;
    }

    public int seat() {
        int pos = 0;

        if(s.size() != 0){
            int dist =s.first();
           Integer prev = null;
            for(Integer i:s){
                if(prev != null){
                    int d = (i-prev)/2;
                    if(d>dist){
                        dist = d;
                        pos = prev+d;
                    }
                }
                prev = i;
            }
            if(N-1-s.last() > dist){
                pos = N-1;
            }
        }
        s.add(pos);
        return pos;
    }

    public void leave(int p) {
        s.remove(p);
    }
}
