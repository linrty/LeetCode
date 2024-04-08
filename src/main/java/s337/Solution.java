package s337;


public class Solution {
    public static int[][] treeDp;
    public static int[] left;
    public static int[] right;
    public static int p;
    public int rob(TreeNode root) {
        treeDp = new int[10005][2];
        left = new int[10005];
        right = new int[10005];
        for (int i = 0;i < 10005;i++){
            left[i] = -1;
            right[i] = -1;
            for (int j = 0;j < 2;j++){
                treeDp[i][j] = -1;
            }
        }
        p = 0;
        return Math.max(dfs(root, 0,1), dfs(root, 0,0));
    }
    public int dfs(TreeNode root, int pos, int flag){
        if (root == null) return 0;
        // 保存状态，减枝
        if (treeDp[pos][flag] != -1) return treeDp[pos][flag];
        // 偷root，那么两个直接子节点就不能偷了
        if(left[pos] == -1) left[pos] = ++p;
        if(right[pos] == -1) right[pos] = ++p;
        if (flag == 1){
            treeDp[pos][flag] = root.val + dfs(root.left, left[pos], 0) + dfs(root.right, right[pos], 0);
        }else{
            // 不偷root,那么两个直接子节点可以偷也可以不偷
            treeDp[pos][flag] = Math.max(dfs(root.left, left[pos], 1), dfs(root.left, left[pos], 0))
                    + Math.max(dfs(root.right, right[pos], 1), dfs(root.right, right[pos], 0));
        }
        return treeDp[pos][flag];
    }
}
