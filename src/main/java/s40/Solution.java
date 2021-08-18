package s40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 15:32
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] candidates = {4, 1, 1, 4, 4, 4, 4, 2, 3, 5};
        int target = 10;
        System.out.println(new Solution().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] lists = new List[target + 5];
        for (int i = 0; i <= target; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < candidates.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (candidates[i] > j) continue;
                if (candidates[i] == j) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(candidates[i]);
                    boolean flag = true;
                    for (int k = 0; k < lists[j].size(); k++) {
                        if (lists[j].get(k).size() != 1) continue;
                        if (lists[j].get(k).get(0) != candidates[i]) continue;
                        else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) lists[j].add(integerList);
                }
                for (int k = 0; k < lists[j - candidates[i]].size(); k++) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.addAll(lists[j - candidates[i]].get(k));
                    integerList.add(candidates[i]);
                    boolean flag = true;
                    for (int l = 0; l < lists[j].size(); l++) {
                        if (lists[j].get(l).size() != integerList.size()) {
                            continue;
                        } else {
                            for (int p = 0; p < integerList.size(); p++) {
                                if (integerList.get(p) != lists[j].get(l).get(p)) {
                                    flag = false;
                                    break;
                                }
                            }
                            flag = !flag;
                            if (!flag) break;
                        }
                    }
                    if (flag) {
                        lists[j].add(integerList);
                    }
                }
            }
        }
        return lists[target];
    }
}
