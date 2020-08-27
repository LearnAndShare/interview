package com.practice.binarySearch;
/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

Solution
Given an example of [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] (from first example after problem statement)

    Recognize that we're looking for an integer value as our answer (not a permutation of possible intervals or anything else, JUST return an int)
    Recognize that we can bound the solution space: lowest bound for the solution is the max weight of an individual container (10). In this case, we can use a day to ship each container, and that is the guaranteed to give us the largest amount of days needed to ship all the containers. The highest bound for the solution is the sum of all the individual weights (55): if you used this weight, you can ship ALL the containers in a day
    Now that we see that the answer HAS to be in this solution space, we need to find the answer that will give us the minimum max capacity that can ship out all containers within D days. So we can go through all the possible solutions linearly (from 10 to 55) and find the solution that will give us what we're looking for. We need to have a function that will calculate linearly (this function, calculate_days_to_ship, isn't too bad to implement, do it on your own) how many days it will take to ship out all the containers with our solutions ranging from 10 to 55.
    The above is a bit of a naive approach. 10 to 55 isn't that big of a range but what if we had 10 to 100000000000? Since we know the problem is bounded, we can do a binary search to significantly speed up our algorithm. If the calculate_days_to_ship function spits out a number of days <= D, then it COULD be the solution, so we keep it in our solution space, so we move the right bound to m (smaller minimum max capacity will give us a bigger days_to_ship number), and if we get a number of days > D, then we know it CAN'T be the solution because we're only interested in days within D (<= D).


Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation:
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:

Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation:
A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:

Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

 */
public class ShipPackageWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int right = 0;
        int left = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left,weight);
        }

        while(left<=right){
            int mid = (left+right)/2;
            int days =1;
            int curr_w_inbag  = 0;
            for (int weight : weights) {
                if((curr_w_inbag + weight) > mid ){
                    curr_w_inbag = 0;
                    ++days;
                }
                curr_w_inbag += weight;
            }
            if(days > D){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        ShipPackageWithinDays sp = new ShipPackageWithinDays();
        System.out.println(sp.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(sp.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(sp.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
