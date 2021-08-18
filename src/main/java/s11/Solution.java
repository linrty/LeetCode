package s11;

public class Solution {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(height));
    }

    public int maxArea(int[] height) {
        int sta = 0;
        int end = height.length - 1;
        int maxi = 0;
        while (sta < end) {
            int len = end - sta;
            int hei = Math.min(height[sta], height[end]);
            maxi = Math.max(maxi, len * hei);
            if (height[sta] > height[end]) end--;
            else sta++;
        }
        return maxi;
    }
}
