package 剑指Offer;
/*  树的子结构
    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Offer17 {
     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)
            return false;
        boolean result =false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if(root1!=null && root2!=null){
            if(root1.val==root2.val)
                result = DoesTree1HaveTree2(root1,root2);////以这个根节点为为起点判断是否包含Tree2
            if(!result)
                result=HasSubtree(root1.left,root2);//如果找不到，那么就再去root的左儿子当作起点，去判断是否包含Tree2
            if(!result)
                result=HasSubtree(root1.right,root2);////如果找不到，那么就再去root的右儿子当作起点，去判断是否包含Tree2
        }
        return result;
    }
    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2) {
         if(root2==null)//如果Tree2已经遍历完了都能对应的上，返回true
             return true;
         if (root1==null)//如果Tree2还没有遍历完,Tree1已经遍历完，返回false
             return false;
         if(root1.val!=root2.val)
             return false;
         return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }
}
