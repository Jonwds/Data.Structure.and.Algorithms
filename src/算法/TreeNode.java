package 算法;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode createTree(Integer []array,int index)
    {
        TreeNode root = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            root = new TreeNode(value);
            root.left = createTree(array, 2*index+1);
            root.right = createTree(array, 2*index+2);
            return root;
        }
        return root;
    }

}
