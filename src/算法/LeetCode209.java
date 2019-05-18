package 算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/*  最小的连续子数组
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
    如果不存在符合条件的连续子数组，返回 0。

示例:
    输入: s = 7, nums = [2,3,1,2,4,3]
    输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l=0,r=-1;//[l..r]为滑动窗口
        int sum=0;
        int result = nums.length+1;
        while ( l < nums.length ){
            if(sum < s && r<nums.length-1)
                sum+=nums[++r];
            else
                sum-=nums[l++];

            if(result > (r-l+1) && sum>=s)
                result = r-l+1;
        }
        if(result==nums.length+1)
            return 0;
        else
            return result;
    }
    @Test
    public void test(){
        int[] arr={2,3,1,2,4,3};
        int sum = minSubArrayLen(7, arr);
        System.out.println(sum);
    }















    /*
    输入描述:
    第一行： 员工数和大巴容量
    第二行： 所有员工工号（按到达顺序）
    输出描述:
    员工编号

    输入例子1:
    5 3
    1 3 5 2 4

    输出例子1:
    2 4 1 3 5
     */
    public static void main(String[] args) {
        int memberCount, carCount;//8 3
        Scanner sc = new Scanner(System.in);
        memberCount=sc.nextInt();
        carCount=sc.nextInt();

        int[] members = new int[memberCount];
        for (int i = 0; i < memberCount; i++) {
             members[i]=sc.nextInt(); //1 2 3 4 5 6 7 8
        }                             //7 8 ; 4 5 6; 1 2 3;
        // TODO: 按规则调整顺序
        ArrayList<ArrayList<Integer>> arrayLists= new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>(carCount);
        int j=0,count=0;
        for(int i:members){
            count++;
            arrayList.add(i);
            if(count==carCount || i==members[memberCount-1]){
                count=0;j++;
                arrayLists.add(arrayList);
                arrayList = new ArrayList<>(carCount);
            }
        }
        int[] arr=new int[memberCount];int num=0;
        while(j > 0) {
            ArrayList<Integer> list = arrayLists.get(j - 1);
            for(int i:list)
                arr[num++]=i;
            j--;
        }
        while(true)
        {
            // TODO: 输出，注意有空格隔开
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            break;
        }
    }

}
