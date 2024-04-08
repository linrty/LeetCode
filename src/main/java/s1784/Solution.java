package s1784;

public class Solution {
    public boolean checkOnesSegment(String s) {
        String str = "01";
        int x = s.indexOf(str);
        int len = s.length();
        if (x >= 0 && x < len) return false;
        else return true;
    }
}
