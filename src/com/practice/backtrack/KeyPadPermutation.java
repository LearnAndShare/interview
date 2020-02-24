package com.practice.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class KeyPadPermutation {
    static Map<Character,Character[]> dialPad = new HashMap<>();
    static {
        dialPad.put('2',new Character[]{'a','b','c'});
        dialPad.put('3',new Character[]{'d','e','f'});
        dialPad.put('4',new Character[]{'g','h','i'});
        dialPad.put('5',new Character[]{'j','k','l'});
        dialPad.put('6',new Character[]{'m','n','o'});
        dialPad.put('7',new Character[]{'p','q','r','s'});
        dialPad.put('8',new Character[]{'t','u','v'});
        dialPad.put('9',new Character[]{'w','x','y','z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String> listString = new ArrayList<>();
        if(digits == null || digits.length()<=0)
            return listString;
        char[] result = new char[digits.length()];
        backTrack(digits.toCharArray(),0,listString,result);
        return listString;
    }

    private void backTrack(char[] inputArray, int pos, List<String> listString,char [] resultArray) {
        if(pos == inputArray.length){
            listString.add(new String(resultArray));
            return;
        }
        Character[] ch = dialPad.get(inputArray[pos]);
        if(ch != null) {

            for (char c : ch) {
                resultArray[pos] = c;
                backTrack(inputArray, pos + 1, listString, resultArray);
            }
        } else {
            backTrack(inputArray, pos + 1, listString, resultArray);
        }
    }

    public static void main(String[] args) {
        KeyPadPermutation kp = new KeyPadPermutation();
        kp.letterCombinations("13").forEach(System.out::println);
    }
}
