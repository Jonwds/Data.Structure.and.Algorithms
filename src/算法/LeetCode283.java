package 算法;

import org.junit.Test;

import java.util.ArrayList;

/* 移动零
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
 */
public class LeetCode283 {
    @Test
    public  void test(){
        int[] arr={0,1,0,3,12};
        moveZeroes3(arr);
        for (int i=0;i<arr.length;++i)
            System.out.print(arr[i]+",");
    }
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;++i){  //遍历一遍数组,保存所有的非零元素
            if (nums[i]!=0)
                list.add(nums[i]);
        }
        //遍历一边数组,前面的元素全部赋值为非零元素,后面的元素全部赋值为 0
        for (int i=0;i<list.size();++i){
            nums[i]=list.get(i);
        }
        for (int i=list.size();i<nums.length;++i){
            nums[i]=0;
        }
    }
    //遍历数组,一旦遇到非零的元素,就把它放到前面
    public void moveZeroes2(int[] nums) {
        //i: [0...i)保存所有的非零元素
        int j=0;
        for (int i=0;i<nums.length;++i){
            if (nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        //剩余元素置为0
        for (;j<nums.length;++j)
            nums[j]=0;
    }

    public void moveZeroes3(int[] nums) {
        int j=0;//保证在nums中,[0...j)的元素均为非零元素

        //遍历到第i个元素后,保证[0...i]中所有非0元素都按照顺序排列在[0..j)中
        //同时,[j...i]为0
        for (int i=0;i<nums.length;++i){
            if (nums[i]!=0){
                if(i != j){
                    int temp = nums[j];
                    nums[j++]=nums[i];
                    nums[i]=temp;
                }
                else
                    j++;
            }
        }
    }
}
