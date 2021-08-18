package s33;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 11:32
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }

    public int search(int[] nums, int target) {
        int sta = 0;
        int end = nums.length - 1;
        int n1 = nums[0];
        int nn = nums[nums.length - 1];
        if (target < n1 && target > nn) return -1;
        while (sta <= end) {
            int mid = (sta + end);
            if (target > nums[mid]) {
                if (nums[mid] < n1) {
                    if (target > nn) {
                        end = mid - 1;
                    } else {
                        sta = mid + 1;
                    }
                } else {
                    sta = mid + 1;
                }
            } else if (target < nums[mid]) {
                if (nn < nums[mid]) {
                    if (target > nn) {
                        end = mid - 1;
                    } else {
                        sta = mid + 1;
                    }
                } else {
                    end = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
