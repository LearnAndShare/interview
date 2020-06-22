package com.practice;
/*
https://leetcode.com/problems/string-compression/

Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.
Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length==1) return 1;
        int index = 0, cur = 0;
        while(cur<chars.length){
            char curr_ch = chars[cur];
            int count =0;
            while(cur<chars.length && chars[cur] == curr_ch) {
                count++;
                cur++;
            }
            chars[index] = curr_ch;
            index++;

            if(count>1){
                String s = String.valueOf(count);
                for(int i=0;i<s.length();i++){
                    chars[index] = s.charAt(i);
                    index++;
                }
            }
        }
        return index;
    }



    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        System.out.println("I/P char array::");
        System.out.println(chars);

        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        System.out.println("O/P char array::");
        System.out.println(chars);
        return write;
    }
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        System.out.println("{'a', 'a', 'b', 'b'}::"+sc.compress2(new char[]{'a', 'a', 'b', 'b'}));
//        System.out.println("{'a', 'b', 'b', 'b'}::"+sc.compress2(new char[]{'a', 'b', 'b', 'b'}));
    }
}
