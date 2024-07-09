package s520;

public class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 1) return true;
        boolean isFirst = false;
        if (word.charAt(0) <= 'Z'){
            isFirst = true;
        }
        boolean isPre = false;
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                if (word.charAt(i) <= 'Z') isPre = true;
                if (!isFirst && isPre) return false;
            }else{
                if (isPre ^ (word.charAt(i) <= 'Z')){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
}
