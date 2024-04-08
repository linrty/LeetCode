package s1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i,j;
        i = j = 0;
        StringBuilder res = new StringBuilder("");
        while(i<len1 && j<len2){
            res.append(word1.charAt(i));
            res.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i < len1){
            res.append(word1.charAt(i));
            i++;
        }
        while (j < len2){
            res.append(word2.charAt(j));
                    j++;
        }
        return res.toString();
    }
}
