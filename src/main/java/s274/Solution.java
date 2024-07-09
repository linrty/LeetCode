package s274;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations) {
            papers[Math.min(n, c)]++;
        }
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            k--;
        }
        return k;
    }
}
