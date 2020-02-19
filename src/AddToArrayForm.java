import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/add-to-array-form-of-integer/

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455


Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000


 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> l = new LinkedList<>();
        if(A != null && A.length>0){
            int idx  = A.length-1;
            boolean carry = false;
            int sum =0;
            while(idx>=0 || K != 0){
                int d = K%10;
                K = K/10;
                sum = d;
                if(idx>=0){
                    sum += + A[idx--];

                }
                if(carry) {
                    sum += 1;
                    carry = false;
                }
                if(sum>9){
                    sum -= 10;
                    carry = true;
                }
                l.add(sum);

            }
            if(carry) {
                l.add(0,1);
            }
        }
        return l;
    }


}
