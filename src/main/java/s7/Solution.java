package s7;

public class Solution {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(new Solution().reverse(x));
    }

    public int reverse(int x) {
        if (x == -2147483648) return 0;
        boolean flag = false;
        int maxi = 214748364;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        int y = 0;
        if (x > 1000000000 && x % 10 != 0) {
            while (x >= 10) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            if (y > maxi) {
                return 0;
            } else if (y < maxi) {
                y = y * 10 + x % 10;
                if (flag) y = -y;
                return y;
            } else {
                if (flag) {
                    if (x > 8) {
                        return 0;
                    } else {
                        y = y * 10 + x % 10;
                        return -y;
                    }
                } else {
                    if (x > 7) {
                        return 0;
                    } else {
                        y = y * 10 + x % 10;
                        return y;
                    }
                }
            }

        } else {
            while (x != 0) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            if (flag) y = -y;
        }
        return y;
    }

}
