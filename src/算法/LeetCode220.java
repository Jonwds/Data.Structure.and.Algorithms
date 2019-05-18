package 算法;

import org.junit.Test;

import java.util.*;

/*
    给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
    使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
public class LeetCode220 {
    //  |num[i]-nums[j]|<=t
    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new TreeSet<Integer>(new MyComparator());
        for (int i=0;i<nums.length;i++){
            //  | v-x | <= t
            if( lowerBound(set,(long)nums[i]-t)!=-987654321
                    && lowerBound(set,(long)nums[i]-t) <= (long)nums[i]+t )  //  nums[i]-t <= v <= nums[i]+t
                return true;

            set.add( nums[i] );

            if(set.size()==k+1)
                set.remove(nums[i-k]);
        }
        return false;
    }
    // *record.lower_bound(x)则返回record中大于等于x的第一个元素的值：
    private long lowerBound(Set<Integer> list,long x){
        for (int i:list) {
            if (i >= x) {
                return i;
            }
        }
        return  -987654321;
    }
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(k<0)
            return false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long l = (long)Math.abs( (long)nums[j] - (long)nums[i]);
                if( l<=t && Math.abs(j-i)<=k )
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (k <= 0) {
            return false;
        }
        int len = nums.length;
        int end = 1;
        int start = 0;
        while (start < len - 1) {
            if (start != end && Math.abs((long) nums[start] - nums[end]) <= t) {
                return true;
            }

            if (end - start == k || end+1 ==len) {
                start++;
                if (t != 0)
                    end = start + 1;

            } else {
                end++;
            }
        }
        return false;
    }
    @Test
    public void test(){
        int[] arr={ -1,2147483647};
        System.out.print(containsNearbyAlmostDuplicate2(arr,1,2147483647));
    }
}
