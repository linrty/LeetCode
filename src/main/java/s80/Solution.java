package s80;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 20:25
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        int num = nums[i];
        int pos = 2;
        int end = i;
        while (i<len){
            if (nums[i]==num){
                if (pos>0){
                    pos--;
                    nums[end]=nums[i];
                    end++;
                    i++;
                }else{
                    num++;
                    pos=2;
                    i++;
                }
            }else if (nums[i]>num){
                num = nums[i];
                pos = 1;
                nums[end] = nums[i];
                end++;
                i++;
            }else{
                i++;
            }
        }
        return end;
    }
}
