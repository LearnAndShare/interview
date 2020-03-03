package com.practice.array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

 */
public class WordsByChars {
    public int countCharacters(String[] words, String chars) {
        if(words == null || words.length == 0 || chars == null || chars.length() == 0)
            return 0;

        int len = 0;
        Map<Character,Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCount.putIfAbsent(c,0);
            charCount.put(c,charCount.get(c)+1);
        }
boolean isPresent = true;
        for(int i=0;i<words.length;i++){
            isPresent = true;
            char[] w = words[i].toCharArray();
            Map<Character,Integer> tmpHash = new HashMap<>(charCount);
            for(int j=0;j<w.length;j++){

                char wc = w[j];
                if(!tmpHash.containsKey(wc) || tmpHash.get(wc) <= 0) {
                    isPresent = false;
                    break;
                }
                tmpHash.put(wc, tmpHash.get(wc) - 1);
            }

            if(isPresent){
                len += w.length;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        WordsByChars ws = new WordsByChars();
        System.out.println(ws.countCharacters(new String[]{"hello","world","leetcode"},"welldonehoneyr"));
        System.out.println(ws.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(ws.countCharacters(new String[]
        {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                "boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl",
                "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                "qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob",
                "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"},
        "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
    }

}
