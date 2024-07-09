package hwawei;

import java.util.Arrays;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] arg = s1.split(" ");
        int n = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);
        // 清空缓冲区
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        Node[] nodes = new Node[n];
        for (int i = 0 ; i < n ; i++){
            nodes[i] = new Node();
            String s = strs[i];
            nodes[i].id = i+1;
            // 最大连续进球数
            int max_score = 0;
            // 当前连续进球数
            int cur_score = 0;
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == '0'){
                    cur_score = 0;
                }else{
                    cur_score++;
                    max_score = Math.max(max_score, cur_score);
                    nodes[i].score++;
                }
            }
            nodes[i].max_score = max_score;
            nodes[i].pos = s;
        }
        Arrays.sort(nodes, (o1, o2) -> {
            // 如果进球总数一样，比较最大连续进球数
            if (o1.score == o2.score){
                // 如果最大连续进球数一样，比较第一次失球的位置
                if (o1.max_score == o2.max_score){
                    // 如果第一次失球的位置一样，比较编号
                    if (o1.pos.equals(o2.pos)){
                        return o1.id - o2.id;
                    }
                    return o2.pos.compareTo(o1.pos);
                }
                return o2.max_score - o1.max_score;
            }
            return o2.score - o1.score;
        });
        for (int i = 0; i < n; i++) {
            if(i == n-1) System.out.print(nodes[i].id);
            else System.out.print(nodes[i].id + " ");
        }
    }
    static class Node{
        // 进球总数
        public int score;
        // 连续进球数最大数
        public int max_score;
        // 第一次失球的位置
        public String pos;
        // 编号
        public int id;
        public Node(){}
    }
}
