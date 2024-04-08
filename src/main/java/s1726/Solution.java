package s1726;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int res = 0;
        for (int num:map.keySet()){
            int cnt = map.get(num);
            if (cnt >= 2){
                res += cnt*(cnt-1)*4;
            }
        }
        return res;
    }
}
