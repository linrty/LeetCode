package s65;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 20:43
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "2e0";
        System.out.println(new Solution().isNumber(s));
    }

    public boolean checkFloat(String s) {  //判断小数格式
        int len = s.length();
        if (len == 0) return false;
        //检查点的数量
        boolean flag = false;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '.') {
                if (flag) return false;
                else {
                    flag = true;
                    pos = i;
                }
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0) return false;
            }
        }
        if (!flag) return false;
        String pre = s.substring(0, pos);
        String back = s.substring(pos + 1, len);
        if (("".equals(pre) || "+".equals(pre) || "-".equals(pre)) && checkInteger(back)) {
            return true;
        } else if (checkInteger(pre) && "".equals(back)) {
            return true;
        } else if (checkInteger(pre) && checkInteger(back)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkInteger(String s) { //判断整数格式
        int len = s.length();
        if (len == 0) return false;
        int nums = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0) return false;
                else continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                nums++;
            } else {
                return false;
            }
        }
        if (nums == 0) return false;
        return true;
    }

    public boolean isNumber(String s) {
        int pos = 0;
        boolean flag = false;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (flag) return false;
                else {
                    flag = true;
                    pos = i;
                }
            }
        }

        if (!flag) {  //没有e
            return checkInteger(s) || checkFloat(s);
        } else { //有e
            String pre = s.substring(0, pos);
            String back = s.substring(pos + 1, len);
            return (checkInteger(pre) || checkFloat(pre)) && checkInteger(back);
        }
    }
}
