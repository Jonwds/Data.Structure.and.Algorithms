package 算法;

import org.junit.Test;

import java.util.Arrays;

/**  将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,-1,0,5,9,10],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *         0
 *      /    \
 *    -3      9
 *    / \    /  \
 *  -10 -1  5   10
 */
public class LeetCode108 {
    //平衡二叉树的中序遍历结果即为给的升序数组
    //[-10,-3,-1,0,5,9,10]
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int mid = nums.length>>1 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        if(nums ==null)
            return null;

        return toBST(nums,0,nums.length-1);
    }
    public TreeNode toBST(int[] nums,int l,int r) {
        if( r < l ){
            return null;
        }
        int mid = l+ (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,l,mid-1);
        root.right = toBST(nums,mid+1,r);
        return root;
    }


    @Test
    public void test(){
        int[] arr = {-10,-3,-1,0,5,9,10};
        TreeNode treeNode = sortedArrayToBST2(arr);
        System.out.println(treeNode);
    }
}
