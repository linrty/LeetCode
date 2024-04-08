package s260;

public class Solution{
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        int[] res = new int[2];
        int xor = 0;
        for (int i = 0;i < len;i++){
            xor ^= nums[i];
        }
        int mask = 1;
        while((xor & mask) == 0){
            mask <<= 1;
        }
        for (int i = 0;i < len;i++){
            if ((nums[i] & mask) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
