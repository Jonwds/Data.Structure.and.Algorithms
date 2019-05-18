package 算法;

import org.junit.Test;

/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
public class LeetCode88 {
    @Test
    public void test(){
        int[] nums1 = {2,0};int[] nums2 = {1};
        merge(nums1,1,nums2,1);
        for (int i=0;i<nums1.length;i++)
            System.out.print(nums1[i]+",");
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[m];//复制nums1
        for (int i=0;i<m;++i)
            temp[i]=nums1[i];
        int i=0,j=0;//i指向nums1,j指向nums2
        for (int k=0;k<nums1.length;k++) {
            if (i >= m) { //nums1归并完了,将nums2剩余的并入数组
                nums1[k] = nums2[j++];
            } else if (j >= n) { //nums2归并完了,将nums[1]剩余的并入数组
                nums1[k] = temp[i++];
            } else if (temp[i] < nums2[j]){
                nums1[k] = temp[i++];
            }else {
                nums1[k] = nums2[j++];
            }
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        m--;n--;
        while(m>=0 && n>=0){
            nums1[index--]= (nums1[m]>nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while(n>=0){
            nums1[index--]=nums2[n--];
        }
    }

}
