package s278;

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        long sta, end;
        sta = 1;
        end = n;
        long mid = sta;
        boolean flag = false;
        while (sta <= end) {
            mid = (sta + end) / 2;
            if (isBadVersion((int) mid)) {
                flag = true;
                end = mid - 1;
            } else {
                flag = false;
                sta = mid + 1;
            }
        }
        if (flag) return (int) mid;
        else return (int) mid + 1;
    }
}
