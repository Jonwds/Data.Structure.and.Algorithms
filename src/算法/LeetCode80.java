package 算法;

import org.junit.Test;

/*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
示例 1:

给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素。

 */
public class LeetCode80 {
    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int j=removeDuplicates2(nums);
        System.out.println("j:"+j);
        for (int i=0;i<j;i++)
            System.out.print(nums[i]+",");
    }

    //{0,0,1,1,1,1,2,3,3}
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
    public int removeDuplicates2(int[] nums) {
        if(nums.length<3)
            return nums.length;
        int count=1,j=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                count++;
            else
                count=1;

            if(count<3) {
                if(j!=i+1)
                    nums[j++] = nums[i + 1];
                else
                    j++;
            }
        }
        return j;
    }
}
