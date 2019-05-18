package 算法;

import org.junit.Test;

import java.util.*;

/* 四数之和
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
    答案中不可以包含重复的四元组。
示例：
    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
    [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
    ]
    //        Map<Integer,Integer> map = new HashMap<>();
////        for (int i=0;i<nums.length;i++){
////            if (!map.containsKey(nums[i]))
////                map.put(nums[i],1);
////            else
////                map.put(nums[i],map.get(nums[i])+1);
////        }
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length==4){
            if (nums[0]+nums[1]+nums[2]+nums[3]==target){
                list.add(nums[0]);list.add(nums[1]);list.add(nums[2]);list.add(nums[3]);
                res.add(list);
                return res;
            }
        }
        int aindex=0,bindex=1;
        while( aindex < nums.length){
            bindex= aindex+1;
            while(bindex < nums.length-2){
                int targ=target-nums[aindex]-nums[bindex];
                int cindex = bindex+1 , dindex=nums.length-1;
                while( cindex < dindex ){
                    if ( nums[cindex]+nums[dindex] == targ){
                        list.add(nums[aindex]);list.add(nums[bindex]);list.add(nums[cindex]);list.add(nums[dindex]);
                        res.add(list);
                        list=new ArrayList<>();

                        cindex=moveRight(nums,cindex);
                        dindex=moveLeft(nums,dindex);
                    }else if( nums[cindex]+nums[dindex] < targ){
                        cindex=moveRight(nums,cindex);
                    }else{  //nums[cindex]+nums[dindex] > -targ
                        dindex=moveLeft(nums,dindex);
                    }
                }
                bindex=moveRight(nums,bindex);
            }
            aindex=moveRight(nums,aindex);
        }
        return  res;
    }
    private int moveRight(int[] nums,int cur){
        for (int i=cur+1;i<nums.length;i++){
            if (nums[i] != nums[cur])
                return i;
        }
        return nums.length;
    }
    private int moveLeft(int[] nums,int cur){
        for (int i=cur-1;i>=0;i--){
            if (nums[i] != nums[cur])
                return i;
        }
        return -1;
    }
    @Test
    public void test() {
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = fourSum(nums,-1);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
}
