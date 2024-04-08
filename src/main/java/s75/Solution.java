package s75;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 18:24
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }


    public void sortColors(int[] nums) {
        int pos = 0;
        int len = nums.length;
        // 排序0，只要是0就向前交换
        for (int i = pos; i < len; i++) {
            if (nums[i] == 0){
                int c = nums[i];
                nums[i] = nums[pos];
                nums[pos] = c;
                pos++;
            }
        }
        if (pos == len) return;
        // 排序1
        for (int i = pos; i < len; i++) {
            if (nums[i] == 1){
                int c = nums[i];
                nums[i] = nums[pos];
                nums[pos] = c;
                pos++;
            }
        }
        if (pos == len) return;
        //排序2
        for (int i = pos; i < len; i++) {
            if (nums[i] == 2){
                int c = nums[i];
                nums[i] = nums[pos];
                nums[pos] = c;
                pos++;
            }
        }
    }
}
