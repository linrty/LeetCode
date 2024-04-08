package s78;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 19:51
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] ans ;
    int kk;
    int up;
    public List<List<Integer>> subsets(int[] nums) {
        lists.add(new ArrayList<>());
        ans = nums;
        for (int i = 1; i <= nums.length; i++) {
            kk = i;
            dfs(0,0);
        }
        return lists;
    }

    public void dfs(int n,int pos){
        if (pos == kk){
            List<Integer>integerList = new ArrayList<>(list);
            lists.add(integerList);
            return;
        }
        for (int i = n; i < ans.length; i++) {
            list.add(ans[i]);
            dfs(i+1,pos+1);
            list.remove(list.size()-1);
        }
    }
}
