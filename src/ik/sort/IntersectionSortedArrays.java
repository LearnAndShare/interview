package ik.sort;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSortedArrays {
    //TC : O(m+n)
    //SC: O(m intersection n)
//    Follow up question: What if size of 1 array is very large? Replace linear search with binary search.
//    Pick an element from smaller array and do binary search in other array
    //TC: o(n+log m)

    //Another follow up
    public Set<Integer> findInterSectionOfSortedArray(int [] arr1, int [] arr2){
        Set<Integer> s = new HashSet<>();
        int arr1Idx = 0;
        int arr2Idx = 0;
        while(arr1Idx<arr1.length && arr2Idx<arr2.length){
            if(arr1[arr1Idx] == arr2[arr2Idx]) {
                s.add(arr1[arr1Idx]);
                arr2Idx++;
                arr1Idx++;
            } else if(arr1[arr1Idx] > arr2[arr2Idx])
                arr2Idx++;
            else {
                arr1Idx++;
            }

        }

        return s;
    }
}
