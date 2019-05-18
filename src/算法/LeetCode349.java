package 算法;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    给定两个数组，编写一个函数来计算它们的交集。
示例 1:
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2]
示例 2:
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
说明:
    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i:nums1)
            set.add(i);
        for (int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i]))
                result.add(nums2[i]);
        }
        int[] arr= new int[result.size()];int count=0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            arr[count++]=iterator.next();
        }
        return arr;
//        for (int i:result) {
//            arr[count++] = i;
//        }
//        return arr;
    }
    @Test
    public void test(){
        int[] nums1 = {4,9,5};int[] nums2 = {9,4,9,8,4};
        for (int i:intersection(nums1, nums2))
            System.out.print(i+" ");
    }
}
