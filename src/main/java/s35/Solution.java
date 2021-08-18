package s35;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(new Solution().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int sta, end;
        sta = 0;
        end = nums.length - 1;
        int mid = sta;
        while (sta <= end) {
            mid = (sta + end) / 2;
            if (target > nums[mid]) {
                sta = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        if (nums[mid] > target) return mid;
        else return mid + 1;
    }
}
