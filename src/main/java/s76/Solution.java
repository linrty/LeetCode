package s76;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 18:46
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }


    public String minWindow(String s, String t) {
       int[] aa = new int[130];
       int[] bb = new int[130];

       int len1 = s.length();
       int len2 = t.length();
       for (int i = 0; i < len2; i++) {
           aa[t.charAt(i)]++;
       }
       int sta = 0;
       int end = 0;
       boolean flag = false;
       while (end < len1){
           bb[s.charAt(end)]++;
           if (isCheck(aa,bb)){
               flag = true;
               break;
           }
           end++;
       }
       if (!flag) return "";
       int minsta,minend;
       minsta = sta;
       minend = end;
       while (end<len1){
           bb[s.charAt(sta)]--;
           sta++;
           if(isCheck(aa,bb)){
               if (end-sta<minend-minsta){
                   minsta = sta;
                   minend = end;
               }
           }else{
               end++;
               flag = false;
               while (end<len1){
                   bb[s.charAt(end)]++;
                   if (isCheck(aa,bb)){
                       flag = true;
                       break;
                   }
                   end++;
               }
               if (!flag){
                   break;
               }
           }
       }
       return s.substring(minsta,minend+1);
    }

    boolean isCheck(int[] a,int[] b){
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i]>b[i]) return false;
        }
        return true;
    }
}
