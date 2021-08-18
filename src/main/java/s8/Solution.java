package s8;

public class Solution {
    public static void main(String[] args) {
        String s = "214748364600000";
        System.out.println(new Solution().myAtoi(s));
    }

    public int myAtoi(String s) {
        long x = 0;
        int sta = 0;
        int len = s.length();
        //丢弃无用的前导空格
        while (sta < len) {
            if (s.charAt(sta) == ' ') {
                sta++;
            } else {
                break;
            }
        }
        if (sta == len) {
            return 0;
        }
        //判断正负
        boolean flag = false;
        if (s.charAt(sta) == '-') {
            flag = true;
            sta++;
        } else if (s.charAt(sta) == '+') {
            flag = false;
            sta++;
        }
        long up = (1L << 31) - 1;
        long down = -(1L << 31);
        while (sta < len) {
            if (s.charAt(sta) >= '0' && s.charAt(sta) <= '9') {
                long num = s.charAt(sta) - '0';
                x = x * 10L + num;
                if (flag) {
                    if (-x < down) return (int) down;
                } else {
                    if (x > up) return (int) up;
                }
            } else {
                if (flag) x = -x;
                return (int) x;
            }
            sta++;
        }
        if (flag) x = -x;
        return (int) x;
    }
}
