package s704;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        new Solution().search(nums, target);
    }

    public int search(int[] nums, int target) {
        int sta, end;
        sta = 0;
        end = nums.length - 1;
        while (sta <= end) {
            int mid = (sta + end) / 2;
            if (target > nums[mid]) {
                sta = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                System.out.println(mid);
                break;
            }
        }
        return 0;
    }
}
