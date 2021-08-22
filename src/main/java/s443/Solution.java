package s443;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/21 13:52
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int compress(char[] chars) {
        int i = 1;
        int len = chars.length;
        int pos = i;
        char[] nums = new char[10];
        while (i < len) {
            if (chars[i] == chars[i - 1]) {
                int j = i;
                while (j < len && chars[j] == chars[j - 1]) {
                    j++;
                }
                int num = j - i;
                int flag = 0;
                while (num != 0) {
                    nums[flag++] = (char) ((num % 10) + '0');
                    num /= 10;
                }
                flag--;
                while (flag >= 0) {
                    chars[pos++] = nums[flag--];
                }
                i = j;
            } else {
                chars[pos++] = chars[i++];
            }
        }
        return pos;
    }
}
