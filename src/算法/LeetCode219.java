package 算法;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:
    输入: nums = [1,2,3,1], k = 3
    输出: true
示例 2:
    输入: nums = [1,0,1,1], k = 1
    输出: true
示例 3:
    输入: nums = [1,2,3,1,2,3], k = 2
    输出: false
 */
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0 || nums.length<2  ){
            return false;
        }
        if(nums.length==2 && nums[0]==nums[1])
            return true;
        //保持一个有 k+1 个元素的区间,能不能在区间中找到两个元素相等的值
        //每次向右滑动一个元素,对于新的元素,在区间中查找是否有和它相等的值
        int l=0,r=l+k;//[l..l+k] 区间一共有k+1个元素
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<r&&i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]); //set中始终保持 k 个元素
        }
        while(r < nums.length){
            if(!set.contains(nums[r])){
                set.add(nums[r]);set.remove(nums[l]);
                l++;r++;
            }else
                return true;
        }
        return false;
    }
    //优化版本
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size()==k+1)//保证set中仅有k个元素
                set.remove(nums[i-k]);
        }
        return false;
    }
    @Test
    public void test(){
        int[] arr={ 1,2,3,1,2,3};
        System.out.print(containsNearbyDuplicate2(arr,2));
    }
}
