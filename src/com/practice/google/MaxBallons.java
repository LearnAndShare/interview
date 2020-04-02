package com.practice.google;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/maximum-number-of-balloons/
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:

Input: text = "nlaebolko"
Output: 1

Example 2:

Input: text = "loonbalxballpoon"
Output: 2

Example 3:

Input: text = "leetcode"
Output: 0


 */
public class MaxBallons {
    public int maxNumberOfBalloons2(String text) {
        String word = "balloon";
        if(text == null || text.length() == 0|| text.length()<word.length())
            return 0;
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        for (char c : text.toCharArray()) {
            switch (c) {
                case 'a':a++;break;
                case 'b':b++;break;
                case 'l':l++;break;
                case 'o': o++;break;
                case 'n': n++;break;
            }
        }
         return Math.min(b,Math.min(a,Math.min(l/2,Math.min(o/2,n))));
    }
    public int maxNumberOfBalloons(String text) {
        String word = "balloon";
        if(text == null || text.length() == 0|| text.length()<word.length())
            return 0;
        /*Map<Character,Integer> bchar= new HashMap<>();

        int num = 0;
        for (char c : word.toCharArray()) {
            int j = bchar.getOrDefault(c,0);
            bchar.put(c,j+1);
        }*/

        Map<Character,Integer> schar= new HashMap<>();
        for (char c : text.toCharArray()) {
            int j = schar.getOrDefault(c,0);
            schar.put(c,j+1);
        }
        int m = Integer.MAX_VALUE;
        for (char c : word.toCharArray()) {
            if(!schar.containsKey(c))
                return 0;
            int j = schar.get(c);

            if(c == 'l' || c =='o')
                m = Math.min(j/2,m);
            else
                m = Math.min(j,m);


        }

        return m;

    }

    public static void main(String[] args) {
        MaxBallons mb = new MaxBallons();
        System.out.println(mb.maxNumberOfBalloons2("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
        System.out.println(mb.maxNumberOfBalloons2("nlaebolko"));
        System.out.println(mb.maxNumberOfBalloons2("loonbalxballpoon"));
        System.out.println(mb.maxNumberOfBalloons2("leetcode"));
    }
}
