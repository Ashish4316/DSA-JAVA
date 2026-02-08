import javax.swing.tree.TreeNode;

public class balancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return findHight(root) == -1 ? false : true; 
    }
    public int findHight(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = findHight(root.left);
        int rh = findHight(root.right);

        if(lh == -1 || rh == -1){
            return -1;
        }   

        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return Math.max(lh,rh) + 1;
    }
}
