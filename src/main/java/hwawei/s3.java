package hwawei;

import java.util.Arrays;
import java.util.Scanner;

public class s3 {
    public static boolean[] global_vis;
    public static int[] edges;
    public static Node[] nodes;
    // 每个节点的入度
    public static int[] in_degree;
    public static int pos;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        edges = new int[n];
        global_vis = new boolean[n];
        nodes = new Node[n];
        in_degree = new int[n];
        pos = 0;
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
            in_degree[edges[i]]++;
        }
        // 检测并保存所有的环，以编号最小的点为起点
        for (int i = 0; i < n; i++) {
            if (!global_vis[i]) {
                dfs(i, new boolean[n]);
            }
        }
        Arrays.sort(nodes, 0, pos, (o1, o2) -> {
            if (o1.H == o2.H){
                return o2.max_num - o1.max_num;
            }
            return o2.H - o1.H;
        });
        boolean[] flag = new boolean[n];
        int u = nodes[0].min_num;
        flag[u] = true;
        System.out.print(u);
        while (!flag[edges[u]]){
            u = edges[u];
            flag[u] = true;
            System.out.print(" " + u);
        }
    }
    static class Node{
        public int L;
        public int V;
        public int H;
        public int max_num;

        public int min_num;

        public Node(){}
    }

    public static void dfs(int u, boolean[] vis){
        vis[u] = true;
        global_vis[u] = true;
        int next = edges[u];
        if (vis[next]) {
            // 找到了一个环
            add_node(u);
        }else{
            vis[next] = true;
            global_vis[next] = true;
            dfs(next, vis);
        }
    }
    public static void add_node(int u){
        boolean[] vis = new boolean[n];
        vis[u] = true;
        int min_num = u;
        int max_num = u;
        int L = 1;
        int V = 0;
        while (!vis[edges[u]]){
            u = edges[u];
            min_num = Math.min(min_num, u);
            max_num = Math.max(max_num, u);
            L++;
            V+=(in_degree[u]-1);
            vis[u] = true;
        }
        int H = L - V;
        Node node = new Node();
        node.L = L;
        node.V = V;
        node.H = H;
        node.max_num = max_num;
        node.min_num = min_num;
        nodes[pos++] = node;
    }
}
