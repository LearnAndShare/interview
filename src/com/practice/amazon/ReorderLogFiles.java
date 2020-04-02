package com.practice.amazon;

import java.util.Arrays;

/*
https://leetcode.com/problems/reorder-data-in-log-files/
For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.
It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
The digit-logs should be put in their original order.

Return the final order of the logs.
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            int o1Idx = o1.indexOf(" ");
            String s1 = o1.substring(o1Idx + 1);
            String id1 = o1.substring(0,o1Idx);
            int o2Idx = o2.indexOf(" ");
            String id2 = o2.substring(0,o2Idx);
            String s2 = o2.substring(o2Idx + 1);
            boolean isDigit1 = Character.isDigit(s1.charAt(0));
            boolean isDigit2 = Character.isDigit(s2.charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = s1.compareTo(s2);
                if (cmp == 0)
                    cmp = id1.compareTo(id2);
                return cmp;
            }

            return isDigit1?isDigit2?0:1:-1;
        });
        return logs;
    }

    public static void main(String[] args) {
        ReorderLogFiles rlo = new ReorderLogFiles();
        for (String s : rlo.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})) {
            System.out.println(s);
        }

        for (String s : rlo.reorderLogFiles(new String[]{"g1 act car","a2 act car"
})) {
            System.out.println(s);
        }
    }
}
