#### 题目描述 
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

示例 1：
```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```
示例 2：
```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```
示例 3：
```
输入：nums = [3,3], target = 6
输出：[0,1]
```

提示：

- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- 只会存在一个有效答案

#### 解题思路
##### 哈希表
这是一个循环问题，不管如何都必须遍历一遍数组。由于数组同一个元素在答案里不能同时存在，且可以按照任意顺序返回答案，因此我们可以采用哈希表的方法。  
在一次循环遍历的时候，将目标值 ``target``减去当前循环值``int[i]`` 得到的值（记作当前结果值``temp``）与哈希表中的值进行比较，如果哈希表不含``temp``，则将该当前循环值``int[i]``以及它对应的数组下标``i``存入。
    
> 对于java而言：hashMap的containsKey()方法的时间复杂度是O(1),而containsValue()的时间复杂度为O(n)-O(n2)。因此我们将哈希表的Key设为``int[i]``,哈希表的Value设为``i``，这样情况下的时间复杂度最优。

**代码示例：**
```java
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
```


