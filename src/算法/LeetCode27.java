package 算法;

import org.junit.Test;
//  从数组中删除所有数值等于val的元素
//  你思考了嘛：如何定义删除？从数组中去除？还是放在数组末尾？
//            剩余元素要的排列要保持原有的相对顺序么？
//            是否有空间复杂度的要求?
/*
    给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 :
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
    函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    注意这五个元素可为任意顺序。
    你不需要考虑数组中超出新长度后面的元素。
 */

public class LeetCode27 {
    @Test
    public void test(){
        int[] arr={0,1,2,2,3,0,4,2};
        int j= removeElement2(arr,2);
        for (int i=0;i<j;i++)
            System.out.print(arr[i]+",");
    }

    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;++i){
            if(val!=nums[i]){
                nums[j++]=nums[i];
            }
        }
        return j;
    }

    //当我们遇到 nums[i] = valnums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，
    // 并释放最后一个元素。这实际上使数组的大小减少了 1。
    public int removeElement2(int[] nums, int val) {
        int i=0;
        int length=nums.length;
        while(i<length){
            if(val==nums[i]){
                nums[i]=nums[length-1];
                length--;
            }else
                i++;
        }
        return length;
    }


}
