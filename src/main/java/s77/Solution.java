package s77;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 19:17
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int kk ;
    int up;
    public List<List<Integer>> combine(int n, int k) {
        kk = k;
        up = n;
        dfs(1,0);
        return lists;
    }

    public void dfs(int n,int pos){
        if (pos == kk){

            List<Integer>integerList = new ArrayList<>(list);
            lists.add(integerList);
            return;
        }
        for (int i = n; i <= up; i++) {
            list.add(i);
            dfs(i+1,pos+1);
            list.remove(list.size()-1);
        }
    }
}
