package s2678;

public class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (int i = 0;i < details.length;i++){
            String age_str = details[i].substring(11,13);
            int age = Integer.parseInt(age_str);
            if (age >= 60){
                res++;
            }
        }
        return res;
    }
}
