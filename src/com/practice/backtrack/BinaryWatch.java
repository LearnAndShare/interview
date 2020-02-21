package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-watch/
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> l   =new ArrayList<>();
        for(int hour=0;hour<=11;hour++){
            for(int minute=0;minute<=59;minute++){
                if(Integer.bitCount(hour)+Integer.bitCount(minute) == num){
                    l.add(String.format("%d:%02d",hour,minute));
                }
            }
        }
        return  l;
    }


    public List<String> readBinaryWatchBT(int num) {
        List<String> l   =new ArrayList<>();
        String s = "0000000000";
        backtrack(s.toCharArray(),0,num,l);
        return l;
    }

    private void backtrack(char[]  s, int start, int num, List<String> l) {
        String m = new String(s);
        int hour = Integer.valueOf(m.substring(6),2);
        if(hour> 11 ) return;
        int minute = Integer.valueOf(m.substring(0,6),2);
        if(minute > 59){
            return;
        }
        if(num == 0){
            l.add(String.format("%d:%02d",hour,minute));
        }

        for(int i=start;i<s.length;i++){
            s[i] = '1';
            backtrack(s,i+1,num-1,l);
            s[i] = '0';
        }
    }

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        bw.readBinaryWatch(1).forEach(System.out::println);
        System.out.println("=====================");
        bw.readBinaryWatchBT(1).forEach(System.out::println);
    }
}
