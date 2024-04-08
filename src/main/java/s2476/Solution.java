package s2476;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    int[] arr = new int[100005];
    int pos;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        pos = 0;
        dfs(root);
        for (int i = 0; i < queries.size(); i++){
            int x = queries.get(i);
            int left = 0;
            int right = pos-1;
            int mid = 0;
            while(left < right){
                mid = (left + right) / 2;
                if (arr[mid] == x){
                    break;
                }
                if (arr[mid] < x){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if (arr[mid] == x){
                res.add(new ArrayList<>());
                res.get(i).add(arr[mid]);
                res.get(i).add(arr[mid]);
            }else if (arr[right] < x){
                res.add(new ArrayList<>());
                res.get(i).add(arr[right]);
                if (right == pos-1) res.get(i).add(-1);
                else res.get(i).add(arr[right+1]);
            }else{
                res.add(new ArrayList<>());
                if (right == 0) res.get(i).add(-1);
                else res.get(i).add(arr[right-1]);
                res.get(i).add(arr[right]);
            }
        }
        return res;
    }

    public void dfs(TreeNode root){
        if (root.left != null){
            dfs(root.left);
        }
        arr[pos++] = root.val;
        if (root.right != null){
            dfs(root.right);
        }
    }
}
