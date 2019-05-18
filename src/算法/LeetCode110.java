package 算法;

import com.sun.javafx.image.IntPixelGetter;
import org.junit.Test;

public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int leftDep=getDepth(root.left);
        int rightDep=getDepth(root.right);
        if(Math.abs(leftDep-rightDep)<=1){
            if (isBalanced(root.left) && isBalanced(root.right))
                return true;
        }
        return false;
    }
    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
    @Test
    public void test(){
        Integer[] arr = {1,2,2,3,null,null,3,4,null,null,null,null,null,null,4};
        TreeNode node = TreeNode.createTree(arr,0);
        System.out.println( isBalanced(node));
    }
}
