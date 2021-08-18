package s42;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 15:10
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(new Solution().trap(height));
    }

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int maxi = height[0];
        int posSta = 0;
        int posEnd = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxi) {
                posSta = posEnd = i;
                maxi = height[i];
            } else if (height[i] == maxi) {
                posEnd = i;
            }
        }
        //取出第二高的加满
        long sum = 0L;
        int j = 0;
        int pre = 0;
        while (height[j] < maxi) {
            if (height[j] > pre) {
                sum = sum - pre;
                sum = sum + 1L * (height[j] - pre) * (posSta - j - 1);
                pre = height[j];
            } else sum = sum - height[j];
            j++;
        }
        int k = height.length - 1;
        pre = 0;
        while (height[k] < maxi) {
            if (height[k] > pre) {
                sum = sum - pre;
                sum = sum + 1L * (height[k] - pre) * (k - posEnd - 1);
                pre = height[k];
            } else sum = sum - height[k];
            k--;
        }
        if (posEnd != posSta) {
            sum = sum + 1L * (posEnd - posSta - 1) * maxi;
            for (int i = posSta + 1; i < posEnd; i++) {
                sum = sum - height[i];
            }
        }
        return (int) sum;
    }
}
