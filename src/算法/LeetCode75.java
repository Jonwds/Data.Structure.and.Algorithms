package 算法;
import org.junit.Test;

/*
    给定一个有n个元素的数组,数组中元素的取值只有0,1,2三种可能。为这个数组排序。
 */

public class LeetCode75 {
    @Test
    public void test(){
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
        for (int i=0;i<nums.length;i++)
           System.out.print(nums[i]+",");
    }
    //时间复杂度:O(n)
    //空间复杂度:O(k),k为元素的取值范围
    public void sortColors(int[] nums) {
        int[] arr=new int[3];  //arr保存数组中0、1、2的次数
        for (int i=0;i<nums.length;++i){
            arr[nums[i]]++;
        }
        int index=0;
        for (int i=0;i<arr[0];i++)
            nums[index++]=0;
        for (int i=0;i<arr[1];i++)
            nums[index++]=1;
        for (int i=0;i<arr[2];i++)
            nums[index++]=2;
    }

    public void sortColors2(int[] nums) {
        int zero=-1;//zero, [0...zero]==0
        int two=nums.length;//two,  [two...n-1]==2
        for (int i=0;i<two;){
            if(nums[i]==1){
                i++;
            }
            else if(nums[i]==2) {
//                int temp = nums[i];
//                nums[i]=nums[--two];
//                nums[two]=temp;
                swap(nums,i,--two);
            }else{
//                int temp = nums[i];
//                nums[i++]=nums[++zero];
//                nums[zero]=temp;
                swap(nums,i++,++zero);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
