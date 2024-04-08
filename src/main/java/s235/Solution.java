package s235;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || res != null){
            return false;
        }
        boolean flag1 = dfs(root.left, p, q);
        boolean flag2 = dfs(root.right, p, q);
        if ((root.val == p.val && flag1)
                || (root.val == p.val && flag2)
                || (root.val == q.val && flag1)
                || (root.val == q.val && flag2) ){
            res = root;
            return false;
        }
        if (root.val == p.val || root.val == q.val){
            return true;
        }
        if (flag1 && flag2){
            res = root;
            return false;
        }
        return flag1 || flag2;
    }
}
