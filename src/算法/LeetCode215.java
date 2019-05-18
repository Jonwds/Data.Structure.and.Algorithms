package 算法;

import org.junit.Test;

import java.util.ArrayList;

/*      数组中的第K个最大元素
    在未排序的数组中找到第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5
示例 2:
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4
 */
public class LeetCode215 {

    //利用三路快排的思路
    public int findKthLargest(int[] nums, int k) {
        if(nums.length <=0 || nums==null || k>nums.length || k<=0)
            return -1;
        int l=0,r=nums.length-1;
        int index = partition(nums, l,r);
        while(index != k-1){
            if(index < k-1){
                l=index+1;
                index=partition(nums, l,r);
            }else if(index > k-1 ){
                r=index-1;
                index=partition(nums, l,r);
            }
        }
        int result = nums[index];
        return result;
    }
    public int partition(int[] arr, int l ,int r){
        int rand = (int) (Math.random()*(r-l+1)+l);
        swap(arr,l,rand);
        int v=arr[l];
        int lt=l;   // arr[l+1..lt]  > v
        int gt=r+1; // arr[gt..r] < v
        int i=l+1;  // arr[lt+1..i) == v
        while (i<gt){
            if( arr[i] > v){
                swap(arr,++lt,i++);
            }
            else if( arr[i] < v){
                swap(arr,--gt,i);
            }
            else{
                i++;
            }
        }
        swap(arr,l,lt);
        return lt;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];arr[a]=arr[b];arr[b]=temp;
    }



    @Test
    public void test(){
        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println( findKthLargest(arr, 2) );
    }


}
