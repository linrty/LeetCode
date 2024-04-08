package s1894;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/10 8:42
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0L;
        for (int i = 0; i < chalk.length; i++) {
            sum+=chalk[i];
        }
        if (sum < k)  {
            k = k % (int)sum;
        }
        for (int i = 0; i < chalk.length; i++) {
            if (k<chalk[i]){
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
}
