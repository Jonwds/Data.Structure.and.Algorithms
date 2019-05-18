package 剑指Offer;

import org.junit.Test;

import java.util.ArrayList;

/*  连续子数组的最大和
    输入一个整形数组,数组里有正有负,数组中的一个或多个整数组成一个子数组.
    求所有子数组的和的最大值,要求时间复杂度O(n)
 */
public class Offer30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length<=0 || array==null)
            return 0;
        int currentSum=0,maxSum=Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            if(currentSum<=0)
                currentSum=array[i];
            else
                currentSum+=array[i];
            if(currentSum>maxSum)
                maxSum=currentSum;
        }
        return  maxSum;
    }
    @Test
    public void test(){
        int[] arr={1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }


}
