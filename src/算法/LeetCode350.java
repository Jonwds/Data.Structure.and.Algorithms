package 算法;

import org.junit.Test;

import java.util.*;

/*
    给定两个数组，编写一个函数来计算它们的交集。

示例 1:
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2,2]
示例 2:
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [4,9]
说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。我们可以不考虑输出结果的顺序。
进阶:
    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i:nums1){
            if(!map.containsKey(i))
                map.put(i,1);
            else
                map.put(i,map.get(i)+1);
        }
        for (int key:nums2){
            if (map.containsKey(key)){
                list.add(key);
                map.put(key,map.get(key)-1);
                if(map.get(key)==0)
                    map.remove(key);
            }
        }
        int[] arr = new int[list.size()];
        int j=0;
        for (int i:list){
                arr[j++]=i;
        }
        return arr;
    }

    //如果数组有序
    // nums1 = [1,1,2,2], nums2 = [2,2]
    //    输出: [2,2]
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums2.length;i++){
            int index = binarySearch(nums1,nums2[i]);
            if(index!=-1){
                list.add(nums1[index]);
                if(i!=nums2.length-1)
                    nums1=remove(nums1,index);
            }
        }
        int[] arr = new int[list.size()];int j=0;
        for (int i:list){
            arr[j++]=i;
        }
        return arr;
    }
    private int[] remove(int[] arr,int index){
        int[] array = new int[arr.length-1];
        for(int j=index;j<arr.length-1;j++)
            arr[j]=arr[j+1];
        System.arraycopy(arr,0,array,0,array.length);
        return array;
    }
    private int binarySearch(int[] arr,int target){
        int l=0,r=arr.length-1;
        while(l <= r){
            int mid=(l+r)>>1;
            if(arr[mid] > target){
                r=mid-1;
            }else if(arr[mid] < target){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums1 = {4,9,5};int[] nums2 = {9,4,9,8,4};

        for (int i:intersect2(nums1, nums2))
            System.out.print(i+" ");
    }
}
