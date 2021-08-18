package s4;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sumLen = len1 + len2;
        int ans = sumLen / 2;
        int pre = 0;
        double num = 0.0;
        while (i < len1 && j < len2 && ans > 0) {
            if (nums1[i] > nums2[j]) {
                pre = nums2[j];
                j++;
                ans--;
            } else {
                pre = nums1[i];
                i++;
                ans--;
            }
        }
        if (ans > 0) {
            while (ans > 0 && i < len1) {
                pre = nums1[i];
                ans--;
                i++;
            }
            while (ans > 0 && j < len2) {
                pre = nums2[j];
                ans--;
                j++;
            }
        }
        if (sumLen % 2 == 0) {
            double sum = 0.0;
            if (i >= len1) sum = nums2[j] + pre;
            else if (j >= len2) sum = nums1[i] + pre;
            else sum = Math.min(nums1[i], nums2[j]) + pre;
            num = sum / 2.0;
        } else {
            if (i >= len1) num = nums2[j];
            else if (j >= len2) num = nums1[i];
            else num = Math.min(nums1[i], nums2[j]);
        }
        return num;
    }
}
