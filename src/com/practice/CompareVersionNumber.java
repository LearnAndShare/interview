package com.practice;

/*


Example 1:
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:
Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number,
which means its third level revision number is default to "0"
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
       String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        for(int i=0;i<Math.max(n1,n2);i++){
            int i1 = i<n1?Integer.parseInt(s1[i]):0;
            int i2 = i<n2?Integer.parseInt(s2[i]):0;
            if(i1!=i2)
                return i1>i2?1:-1;

        }
        return 0;
    }
}
