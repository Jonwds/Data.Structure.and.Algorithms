package 算法;

import org.junit.Test;

import java.util.*;

/*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
        [ [-1, 0, 1],[-1, -1, 2] ]
    思路：
    1.先sort一下array，为啥要sort呢，因为要用到two pointers 来遍历找两数之和，只有在从小到大排序之后的结果上，才能根据情况移动left 和right。
    2.首先是如果数组只有3个数字，那么直接返回这三个数字之和；（最少三个数）
    3.当确定好了第一个数字后，就在剩下的array里找两数之和，在加上第一个数字，得到tempSum,
    比较这个tempSum是不是等于0，如果是0，则把这个结果保存下来（这里注意先把结果存到hashSet里面，去重）
    4.之后如果tempSum与0不相等 利用two pointers 特性， 如果tempSum 比0 小的话，说明我们需要更大的sum，
    所以要让left++以便得到更大的sum。 如果tempSum 比0 大的话，我们就需要更小的sum，所以right--。
*/
public class LeetCode15 {
    @Test
    public void test() {
        int[] nums={-2,0,1,1,2};
        List<List<Integer>> lists = threeSum2(nums);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==3){
            if(nums[0]+nums[1]+nums[2]==0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[0]);temp.add(nums[1]);temp.add(nums[2]);
                result.add(temp);
                return result;
            }
            return result;
        }
        Arrays.sort(nums);//对数组进行排序,才能用二分查找法
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;int right=nums.length-1;
            while(left<right){
                int tempSum = nums[i]+nums[left]+nums[right];
                if( tempSum==0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);tempList.add(nums[left]);tempList.add(nums[right]);
                    set.add(tempList);
                    //跳过与当前数字重复的数字,例如[-1,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,-1,-4]
                    int j=nums[left],k=nums[right];
                    while(j==nums[left]){
                        left++;
                        if(left>=right)
                            break;
                    }
                    while(k==nums[right]){
                        right--;
                        if(left>=right)
                            break;
                    }
                }
                else if(tempSum<0)
                    left++;
                else
                    right--;
            }
        }
        for(List<Integer> list:set){
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while( index < nums.length ){

            if( nums[index] > 0 )
                break;

            int bindex = index + 1;
            int cindex = nums.length-1;
            while( bindex < cindex) {

                if (nums[bindex] + nums[cindex] == -nums[index]) {
                    list.add(nums[index]);list.add(nums[bindex]);list.add(nums[cindex]);
                    res.add(list);
                    list=new ArrayList<>();

                    bindex = next_num_index( nums, bindex );//bindex向右移一位,跳过重复的元素
                    cindex = pre_num_index( nums, cindex);//cindex向右移一位,跳过重复的元素
                }
                else if (nums[bindex] + nums[cindex] < -nums[index])
                    bindex = next_num_index( nums, bindex );
                else //nums[bindex] + nums[cindex] > -nums[index]
                    cindex = pre_num_index( nums, cindex);
            }
            index = next_num_index( nums , index ); //index向右移一位,跳过重复的元素
        }

        return res;
    }

    private int next_num_index( int[] nums, int cur ){

        for( int i = cur + 1; i < nums.length ; i ++ )
            if( nums[i] != nums[cur] )
                return i;
        return nums.length;
    }

    int pre_num_index( int[] nums, int cur){

        for( int i = cur - 1; i >= 0 ; i -- )
            if( nums[i] != nums[cur] )
                return i;
        return -1;
    }


}
