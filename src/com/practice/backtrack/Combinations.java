package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:
Input: n = 1, k = 1
Output: [[1]]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineUtil(1,n,k,result,new ArrayList<Integer>());
        return result;
    }

    private void combineUtil(int start, int n, int k, List<List<Integer>> result, ArrayList<Integer> temp) {
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<=n;i++){
            temp.add(i);
            combineUtil(i+1,n,k,result,temp);
           temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations cs = new Combinations();
        for (List<Integer> integers : cs.combine(4, 2)) {
            integers.forEach(System.out::print);
            System.out.println("====================");
        }
    }
}
