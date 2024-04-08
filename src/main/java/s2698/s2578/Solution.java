package s2698.s2578;

import java.util.Arrays;

public class Solution {
    public static int[] nums;
    public static int len;
    public static int[] vis;
    public static int res;
    public int splitNum(int num) {
        nums = new int[10];
        res = Integer.MAX_VALUE;
        int pos = 0;
        while(num != 0){
            nums[pos++] = num % 10;
            num /= 10;
        }
        len = pos;
        vis = new int[len];

        Arrays.sort(nums, 0, len);
        for (int i = 0; i < len;i++){
            vis[i] = 0;
        }
        dfs(0, 0);
        return res;
    }
    public void dfs(int pre,int pos){
        if (pos == len-1) return;
        for(int i = 0; i < len;i++){
            if (vis[i] == 0){
                vis[i] = 1;
                int pre2 = 0;
                for (int j = 0;j < len;j++){
                    if (vis[j] == 0){
                        pre2 = pre2 * 10 + nums[j];
                    }
                }
                res = Math.min(res, pre * 10 + nums[i] + pre2);
                dfs(pre * 10 + nums[i], pos + 1);
                vis[i] = 0;
            }
        }
    }
}
