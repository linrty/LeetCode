package s5855;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/29 12:53
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return -o1.compareTo(o2);
                if (o1.length()>o2.length()) return -1;
                return 1;
            }
        });
        return nums[k-1];
    }
}
