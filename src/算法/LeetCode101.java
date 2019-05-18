package 算法;

import java.util.LinkedList;
import java.util.Queue;

/** 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

      1
   /     \
  2      2
 /  \    / \
 3  4   4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

   1
 /  \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */

public class LeetCode101 {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }
    //递归
    public boolean isSymmetric(TreeNode p,TreeNode q) {
        if( p==null && q==null){
            return true;
        }
        if( p==null || q==null)
            return false;
        if( p.val != q.val)
            return false;
        return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }
    //队列
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();TreeNode t2 = queue.poll();
            if(t1==null && t2==null)
                continue;
            if(t1==null || t2==null)
                return false;
            if(t1.val!=t2.val)
                return false;
            queue.add(t1.left);queue.add(t2.right);
            queue.add(t1.right);queue.add(t2.left);
        }
        return true;
    }
}
