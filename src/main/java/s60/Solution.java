package s60;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 12:18
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        int[] num = new int[n + 5];
        int[] vis = new int[n + 5];
        vis[0] = 1;
        for (int i = 0; i < n; i++) {
            num[i + 1] = i + 1;
            vis[i + 1] = vis[i] * (i + 1);
        }
        int end = n;
        StringBuilder s = new StringBuilder();
        for (int i = n; i > 1; i--) {
            int j;
            if (i == 2) j = k;
            else {
                j = (k - 1) / vis[i - 1];
                k = ((k - 1) % (vis[i - 1])) + 1;
                j++;
            }
            s.append(num[j]);
            for (int l = j; l < end; l++) {
                num[l] = num[l + 1];
            }
            end--;
        }
        s.append(num[1]);
        return s.toString();
    }
}
