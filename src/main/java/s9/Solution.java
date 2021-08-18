package s9;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        StringBuilder s1 = new StringBuilder(Integer.toString(x));
        StringBuilder s2 = new StringBuilder(s1).reverse();
        if (s1.toString().equals(s2.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
