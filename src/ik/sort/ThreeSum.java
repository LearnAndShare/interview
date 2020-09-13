package ik.sort;

import java.util.*;

public class ThreeSum {
    static String[] findZeroSum(int[] arr) {
        // Write your code here.
        List<String> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            Map<Integer,Integer> sumMap = new HashMap<>();

            int targetSum = -arr[i];
            for(int j=0;j<arr.length;j++){
                if(i!=j){
                    int tempSum =targetSum-arr[j];
                    if(sumMap.containsKey(arr[j])){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[sumMap.get(arr[j])]);
                        Collections.sort(temp);
                        set.addAll(Collections.singleton(temp));
                    } else {
                        sumMap.put(tempSum,j);
                    }

                }
            }
        }

        String[] ret = new String[set.size()];
        int idx = 0;
        for (List<Integer> integers : set) {
            StringBuilder s = new StringBuilder();
            for (Integer integer : integers) {
                s.append(integer+",");
            }
            s.deleteCharAt(s.length()-1);
            ret[idx++] = s.toString();
        }
        return ret;
    }


    public static void main(String[] args) {
        for (String s : findZeroSum(new int[]{10, 3, -4, 1, -6, 9})) {
            System.out.print(s);
            System.out.println();
        }

        System.out.println();

        for (String s : findZeroSum(new int[]{0,0,0,0,0})) {
            System.out.print(s);
            System.out.println();
        }
    }

}
