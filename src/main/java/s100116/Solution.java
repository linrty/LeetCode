package s100116;

public class Solution {
    public int findChampion(int n, int[][] edges) {
        int []in = new int[n];
        for (int i = 0;i<edges.length;i++){
            in[edges[i][1]]++;
        }
        int count = 0;
        for (int i = 0;i<n;i++){
            if (in[i] == 0){
                count++;
            }
        }
        if (count > 1)
            return -1;
        else {
            for (int i = 0;i<n;i++){
                if (in[i] == 0){
                    return i;
                }
            }
        }
        return -1;
    }
}
