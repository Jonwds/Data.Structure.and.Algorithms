package 算法;

import java.util.ArrayList;
import java.util.List;

/** 路径总和3
 *  给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 *  找出路径和等于给定数值的路径总数。
 *
 *  路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *  二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class LeetCode437 {

    //在以root为根节点的二叉树，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        //分情况讨论
        //1.如果当前的node在路径中,则findPath(sum-root.val)
        //2.如果当前的node不在路径中,则递归pathSum查询左右子树
        if (root==null)
            return 0;
        int res = findPath(root,sum);

        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);
        return res;
    }
    //在以root为根节点的二叉树，寻找包含root而且和为sum的路径，返回这样的路径个数
    private int findPath(TreeNode root,int sum){
        if( root == null)
            return 0;

        int res = 0;
        if(root.val==sum)
            res+=1;

        res += findPath(root.left,sum-root.val);
        res += findPath(root.right,sum-root.val);

        return res;
    }


    public int findPath2(TreeNode root,int sum){
        List<List<Integer>> result = new ArrayList<>();
        findPath(root,result,new ArrayList<>(),sum);
        return result.size();
    }
    public void findPath(TreeNode root,List<List<Integer>> result,List<Integer> path,int sum){
        if(root==null)
            return;
        path.add(root.val);

        if(root.val==sum && root.left==null && root.right==null){
            result.add(new ArrayList<>(path));
        }
        if (root.left!=null)
            findPath(root.left,result,path,sum-root.val);
        if (root.right!=null)
            findPath(root.right,result,path,sum-root.val);

        path.remove(path.size()-1);
    }
}
