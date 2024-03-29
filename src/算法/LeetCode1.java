package 算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */
public class LeetCode1 {
  /*
  我们需要一种更有效的方法来检查数组中是否存在目标元素。
  如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
  在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
  在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]）是否存在于表中。
  注意，该目标元素不能是 nums[i]本身！
  */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++)
            map.put(nums[i],i); //隐藏了一个问题：数组中相等的元素会覆盖索引
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i ) //该目标元素不能是 nums[i]本身！
                return new int[]{i,map.get(target-nums[i])};
        }
        throw new IllegalArgumentException();
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int v = target-nums[i];
            if (map.containsKey(v) && map.get(v)!=i ) //该目标元素不能是 nums[i]本身！
                return new int[]{i,map.get(v)};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
    @Test
    public void test(){
        int[] nums = {2, 7, 7, 12,15};int target = 9;
        int[] arr = twoSum(nums, target);
        for (int i:arr)
            System.out.print(i+" ");
    }
}
