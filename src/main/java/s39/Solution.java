package s39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 15:10
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] candidates = {1};
        int target = 2;
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>>[] lists = new List[target + 5];
        for (int i = 0; i <= target; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (candidates[i] > j) continue;
                if (candidates[i] == j) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(candidates[i]);
                    lists[j].add(integerList);
                }
                for (int k = 0; k < lists[j - candidates[i]].size(); k++) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.addAll(lists[j - candidates[i]].get(k));
                    integerList.add(candidates[i]);
                    lists[j].add(integerList);
                }
            }
        }
        return lists[target];
    }
}
