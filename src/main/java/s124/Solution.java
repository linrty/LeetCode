package s124;



public class Solution {
    public static int maxv = Integer.MIN_VALUE;
    public static TreeNode head;
    public int maxPathSum(TreeNode root) {
        head = root;
        dfs(root);
        return maxv;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.equals(head)){
            int res = root.val;
            if (left > 0) res += left;
            if (right > 0) res += right;
            maxv = Math.max(maxv, res);
            return res;
        }else if (root.left == null || root.right == null){
            int res = root.val;
            if (left > 0) res += left;
            if (right > 0) res += right;
            maxv = Math.max(maxv, res);
            return res;
        }else {
            int res = root.val;
            if (left > 0) res += left;
            if (right > 0) res += right;
            maxv = Math.max(maxv, res);
            res = root.val;
            if (left > 0 || right > 0) {
                res += Math.max(left, right);
                maxv = Math.max(maxv, res);
                return res;
            } else {
                maxv = Math.max(maxv, res);
                return res;
            }
        }
    }

}
