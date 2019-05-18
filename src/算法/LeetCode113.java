package 算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，
 * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPath(root,res,path,sum);
        return res;
    }
    public void findPath(TreeNode root,List<List<Integer>> res,List<Integer> path, int sum ) {
        if(root==null)
            return;
        path.add(root.val);
        //叶子节点,并且路径上的节点和等于目标值
        if( root.val==sum && root.left==null && root.right==null){
            res.add(new ArrayList<>(path)) ;
        }
        if(root.left!=null)
            findPath(root.left,res,path,sum-root.val);
        if(root.right!=null)
            findPath(root.right,res,path,sum-root.val);

        path.remove(path.size()-1);
    }
    @Test
    public void test(){

    }
}
