package 算法;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *       1
 *     /   \
 *    2    3
 *   / \  /
 *  4  5 6
 *
 * 输出: 6
 */

public class LeetCode222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int lefts=countNodes(root.left);
        int rights=countNodes(root.right);
        return 1+lefts+rights;
    }
    /**
     完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     判断左右子树的高度:
     如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
     如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
     **/
    public int countNodes2(TreeNode root) {
        if (root==null)
            return 0;
        int leftDep = getDepth(root);
        int rightDep = getDepth(root);
        if (leftDep==rightDep)//1 << leftDep 即ld*2
            // 1(根节点) + (1 << leftDep)-1 (左完全左子树节点数) + 右子树节点数量
            return 1+(1<<leftDep)-1+countNodes2(root.right);
        else
            // 1(根节点) + (1 << leftDep)-1 (右完全左子树节点数) + 左子树节点数量
            return 1+(1<<rightDep)-1+countNodes2(root.left);
    }
    //完全二叉树的高度可以直接通过不断地访问左子树就可以获取
    public int getDepth(TreeNode root){
        int depth=0;
        while(root!=null){
            depth++;
            root=root.left;
        }
        return depth;
    }

}
