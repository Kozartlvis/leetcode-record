package src;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 解题思路：用hashmap存放遍历的value和index，用hashmap的特性直接查找减法所得的key
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> temp=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            int cur=target-nums[i];
            if(temp.containsKey(cur)){
                return new int[]{i,temp.get(cur)};
            }
            temp.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

