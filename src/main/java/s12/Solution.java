package s12;

public class Solution {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(new Solution().intToRoman(num));
    }

    public String intToRoman(int num) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int len = nums.length;
        int i = len - 1;
        StringBuilder stringBuilder = new StringBuilder("");
        while (i >= 0) {
            if (num / nums[i] > 0) {
                int ans = num % nums[i];
                for (int j = 0; j < num / nums[i]; j++) {
                    stringBuilder.append(strings[i]);
                }
                num = ans;
            }
            i--;
        }
        return stringBuilder.toString();
    }
}
