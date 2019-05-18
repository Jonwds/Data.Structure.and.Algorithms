package 算法;
/*  盛最多水的容器
    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。

示例:
    输入: [1,8,6,2,5,4,8,3,7]
    输出: 49
 */

import org.junit.Test;

public class LeetCode11 {
    //每次更新面积后,将指向较短线段的指针向较长线段那端移动一步。
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxArea=0;
        while(i<j){
            int area=(j-i)*Math.min(height[i],height[j]);
            if(area>maxArea){
                maxArea=area;
            }
            if(height[i]<height[j]) {
                i++;
            }else
                j--;
        }
        return maxArea;
    }
    @Test
    public void test(){
       int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
