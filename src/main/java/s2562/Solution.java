package s2562;

public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int len = nums.length;
        long res = 0;
        int i = 0;
        len--;
        while(i <= len){
            int num1 = nums[i];
            int num2 = nums[len];
            if ( i == len ){
                res += num1;
                break;
            }
            while(num2 != 0){
                num2 /= 10;
                num1 *= 10;
            }
            res += (num1 + nums[len]);
        }
        return res;
    }
}
