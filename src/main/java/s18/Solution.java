package s18;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2};
        int target = 8;
        System.out.println(new Solution().fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        long[] num = new long[nums.length];
        int pos = 0;
        num[pos++] = nums[0];
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                num[pos++] = nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        //四个数都不相同
        for (int i = 0; i < pos; i++) {
            for (int j = i + 1; j < pos; j++) {
                for (int k = j + 1; k < pos; k++) {
                    long x = (long) target - num[i] - num[j] - num[k];
                    if (x > num[k] && map.containsKey((int) x)) {
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add((int) num[i]);
                        integerList.add((int) num[j]);
                        integerList.add((int) num[k]);
                        integerList.add((int) x);
                        list.add(integerList);
                    }
                }
            }
        }

        //三个不同的数组成
        for (int i = 0; i < pos; i++) {
            for (int j = i + 1; j < pos; j++) {
                //两个i
                long x = (long) target - 2L * num[i] - num[j];
                if (x > num[j] && map.containsKey((int) x)
                        && map.getOrDefault((int) num[i], 0) >= 2) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add((int) num[i]);
                    integerList.add((int) num[i]);
                    integerList.add((int) num[j]);
                    integerList.add((int) x);
                    list.add(integerList);
                }

                //两个j
                x = (long) target - num[i] - 2L * num[j];
                if (x > num[j] && map.containsKey((int) x)
                        && map.getOrDefault((int) num[j], 0) >= 2) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add((int) num[i]);
                    integerList.add((int) num[j]);
                    integerList.add((int) num[j]);
                    integerList.add((int) x);
                    list.add(integerList);
                }

                //两个x
                x = (long) target - num[i] - num[j];
                if (x % 2 == 0 && (x / 2) > num[j]
                        && map.getOrDefault((int) (x / 2), 0) >= 2) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add((int) num[i]);
                    integerList.add((int) num[j]);
                    integerList.add((int) (x / 2));
                    integerList.add((int) (x / 2));
                    list.add(integerList);
                }
            }
        }

        //两个不同的数组成（需要注意2+2和1+3）
        //2+2
        for (int i = 0; i < pos; i++) {
            long x = (long) target - 2L * num[i];
            if (x % 2 == 0 && x / 2 > num[i]
                    && map.getOrDefault((int) (x / 2), 0) >= 2
                    && map.getOrDefault((int) num[i], 0) >= 2) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                integerList.add((int) (x / 2));
                integerList.add((int) (x / 2));
                list.add(integerList);
            }
        }

        //1+3
        for (int i = 0; i < pos; i++) {
            long x = (long) target - num[i];
            if (x % 3 == 0 && x / 3 > num[i] && map.getOrDefault((int) (x / 3), 0) >= 3) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add((int) num[i]);
                integerList.add((int) (x / 3));
                integerList.add((int) (x / 3));
                integerList.add((int) (x / 3));
                list.add(integerList);
            }

            x = (long) target - 3L * num[i];
            if (x > num[i] && map.containsKey((int) x) && map.getOrDefault((int) num[i], 0) >= 3) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                integerList.add((int) x);
                list.add(integerList);
            }

        }

        //四个数都相同
        for (int i = 0; i < pos; i++) {
            if (4L * num[i] == target && map.getOrDefault((int) num[i], 0) >= 4) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                integerList.add((int) num[i]);
                list.add(integerList);
                break;
            }
        }

        return list;
    }

}
