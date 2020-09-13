package ik.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
   Array of integers find if targetsum Return true or false
*/
    public boolean targetSum(int[] arr,int targetSum){
        Arrays.sort(arr);
        int l=0,r=arr.length-1;
        while(l<r){
            int sum = arr[l] + arr[r];
            if(sum == targetSum)
                return true;
            if(sum > targetSum)
                r--;
            else
                l++;
        }
        return false;
    }
    /*
    Find indices for target sum
     */

    public int[] findIndicesTargetSum(int[] arr,int targetSum){
        int[] idx = new int[2];
        Map<Integer,Integer> set = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int remSum = targetSum - arr[i];
            if(set.containsKey(remSum)){
                idx[0] = i;
                idx[1] = set.get(remSum);
            } else{
                set.put(remSum,i);
            }

        }
        return idx;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(ts.targetSum(new int[]{7, 6, 1, 3, 5, 2}, 6));
        System.out.println(ts.targetSum(new int[]{7, 6, 1, 3, 5, 0}, 2));
    }
}
