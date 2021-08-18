package s167;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int x = target - numbers[i];
            int pos = Arrays.binarySearch(numbers, x);
            if (pos >= 0 && pos != i) {
                int[] s = null;
                Arrays.sort(s = new int[]{i + 1, pos + 1});
                return s;
            }
        }
        return null;
    }
}
