package s13;

public class Solution {
    public static void main(String[] args) {
        String s = "DCXXI";
        System.out.println(new Solution().romanToInt(s));
    }

    public int romanToInt(String s) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int len = nums.length;
        int i = len - 1;
        int x = 0;
        int sta = 0;
        int end = s.length();
        while (i >= 0 && sta < end) {
            while (sta < end && sta + strings[i].length() <= end && s.substring(sta, sta + strings[i].length()).equals(strings[i])) {
                x += nums[i];
                sta += strings[i].length();
            }
            i--;
        }
        return x;
    }
}
