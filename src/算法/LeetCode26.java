package 算法;

import org.junit.Test;

/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class LeetCode26 {
    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int j=removeDuplicates(nums);
        for (int i=0;i<j;i++)
            System.out.print(nums[i]+",");
    }
    //双指针法
    //i是慢指针,j是快指针.只要nums[i]==nums[j], 增加j以跳过重复项
    //当nums[i]!=nums[j]时,跳过重复项已结束,因此我们必须把nums[j]的值赋值给nums[j+1],然后i+1
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int j=1;j<nums.length;j++){
            if (nums[j]!=nums[i]){
                nums[++i]=nums[j] ;
            }
        }
        return i+1;
    }
}
