package 算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 说明: 叶子节点是指没有子节点的节点。

 示例 1:

 输入: [1,2,3]
 1
 / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 *      [ [5,4,1,2],[5,8,4,5] ]
 *
 *
 */
public class LeetCode129 {
    @Test
    public void test(){
        Integer[] arr = {4,9,0,5,1};
        TreeNode node = TreeNode.createTree(arr, 0);
        System.out.println(sumNumbers(node));
    }
    public int sumNumbers(TreeNode root) {
        int sum=0;
        List<List<Integer>> lists = pathSum(root);
        for (List<Integer> list:lists){
            for(int i=list.size()-1,j=1;i>=0;i--,j*=10){
                sum+=list.get(i)*j;
            }
        }
        return sum;
    }
    public List<List<Integer>> pathSum(TreeNode root) {
        if(root==null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPath(root,res,path);
        return res;
    }
    public void findPath(TreeNode root,List<List<Integer>> res,List<Integer> path) {
        if(root==null)
            return;
        path.add(root.val);
        //叶子节点
        if(  root.left==null && root.right==null){
            res.add(new ArrayList<>(path)) ;
        }
        if(root.left!=null)
            findPath(root.left,res,path);
        if(root.right!=null)
            findPath(root.right,res,path);

        path.remove(path.size()-1);
    }
}
