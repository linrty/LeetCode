package s15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length < 3) return list;
        int[] nums2 = new int[nums.length];
        Arrays.sort(nums);
        int pos = 0;
        nums2[pos] = nums[0];
        map.put(nums[0], 1);
        pos++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums2[pos++] = nums[i];
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        //先将三元组中没有重复项的搞定
        for (int i = 0; i < pos; i++) {
            for (int j = i + 1; j < pos; j++) {
                int num3 = -nums2[i] - nums2[j];
                if (num3 > nums2[j] && map.containsKey(num3)) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(nums2[i]);
                    integerList.add(nums2[j]);
                    integerList.add(num3);
                    list.add(integerList);
                }
            }
        }
        //搞定有两个相同值的三元组
        for (int i = 0; i < pos; i++) {
            int x = map.get(nums2[i]);
            if (x > 1 && nums2[i] != 0) {  //数组中有两个以上的值
                int ans = nums2[i] + nums2[i];
                if (map.containsKey(-ans)) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(nums2[i]);
                    integerList.add(nums2[i]);
                    integerList.add(-ans);
                    list.add(integerList);
                }
            }
        }

        //三项全为0
        if (map.containsKey(0) && map.get(0) > 2) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(0);
            integerList.add(0);
            integerList.add(0);
            list.add(integerList);
        }

        return list;

    }
}
