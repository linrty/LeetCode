package m0109;

public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        String s3 = s2 + s2;
        return s1.length()==s2.length() && s3.contains(s1);
    }
}
