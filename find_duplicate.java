/*
 * 287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            else
            map.put(nums[i], 1);
        }
        return -1;
    }
}

class Solution2 {
    public int findDuplicate(int[] nums) {
        int t=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                if(nums[i] == nums[nums[i]-1]){
                    return nums[i];
                }
                t = nums[nums[i-1]];
                nums[nums[i]-1]=nums[i];
            }
            if(i+1 == t){
                nums[i] = t;
            }
        }
        return -1;
    }
}