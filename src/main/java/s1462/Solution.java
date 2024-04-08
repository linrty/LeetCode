package s1462;

import java.util.*;

import static java.util.Arrays.sort;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 先进行拓扑排序，然后再进行查询
        List<Integer> sorted = new ArrayList<>();
        // 计算每个节点的入度
        int[] inDegree = new int[numCourses];
        for (int[] preCourse : prerequisites) {
            inDegree[preCourse[0]]++;
        }
        // 将入度为0的节点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]==0) queue.add(i);
        }
        // 拓扑排序
        while (!queue.isEmpty()){
            int cur = queue.poll();
            sorted.add(cur);
            for (int[] preCourse : prerequisites) {
                if (preCourse[1]==cur){
                    inDegree[preCourse[0]]--;
                    // 如果入度为0，加入队列
                    if (inDegree[preCourse[0]]==0) queue.add(preCourse[0]);
                }
            }
        }
        // 按照拓扑排序的结果，对prerequisites进行排序
        sort(prerequisites, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int index1 = sorted.indexOf(o1[0]);
                int index2 = sorted.indexOf(o2[0]);
                return index1-index2;
            }
        });
        List<Boolean> res = new ArrayList<>();
        int[][] pre = new int[numCourses][numCourses];
        for (int[] preCourse : prerequisites) {
            // 第一个元素是先修课程，第二个元素是后修课程
            // 先将pre[preCourse[1]][preCourse[0]]置为1
            pre[preCourse[1]][preCourse[0]] = 1;
            // 然后将pre[preCourse[1]]数组与pre[preCourse[0]]进行或运算，并将结果赋值给pre[preCourse[1]]
            for (int i = 0; i < numCourses; i++) {
                pre[preCourse[1]][i] |= pre[preCourse[0]][i];
            }
        }
        for (int[] query : queries) {
            if (pre[query[1]][query[0]] == 1) res.add(true);
            else res.add(false);
        }
        return res;
    }
}