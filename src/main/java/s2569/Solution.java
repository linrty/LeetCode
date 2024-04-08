package s2569;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static SeqTree[] tree;
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        tree = new SeqTree[nums1.length * 4];
        build(0,nums1.length-1,1,nums1);
        List<Long> res = new ArrayList<>();
        long sum = 0;
        for (int i = 0;i<nums2.length;i++){
            sum += nums2[i];
        }
        for (int i = 0;i < queries.length;i++){
            if (queries[i][0] == 1){
                update(queries[i][1],queries[i][2],1);
            }else if (queries[i][0] == 2){
                sum = sum + (long) query(0,nums1.length-1,1)*queries[i][1];
            }else{
                res.add(sum);
            }
        }
        long[] ans = new long[res.size()];
        for (int i = 0;i < res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public void build(int l,int r,int rt,int nums1[]){
        tree[rt] = new SeqTree();
        tree[rt].setL(l);
        tree[rt].setR(r);
        tree[rt].setLazy(false);
        if (l == r){
            tree[rt].setVal(nums1[l]);
            return;
        }
        int mid = (l + r) >> 1;
        build(l,mid,rt<<1,nums1);
        build(mid+1,r,rt<<1|1, nums1);
        tree[rt].setVal(tree[rt<<1].getVal() + tree[rt<<1|1].getVal());
    }
    // 懒惰更新
    public void pushDown(int rt){
        if (tree[rt].lazy){
            tree[rt<<1].setVal(tree[rt<<1].r-tree[rt<<1].l+1-tree[rt<<1].getVal());
            tree[rt<<1].setLazy(!tree[rt<<1].getLazy());
            tree[rt<<1|1].setVal(tree[rt<<1|1].r-tree[rt<<1|1].l+1-tree[rt<<1|1].getVal());
            tree[rt<<1|1].setLazy(!tree[rt<<1|1].getLazy());
            tree[rt].setLazy(false);
        }
    }
    // 更新
    public void update(int l,int r,int rt){
        if (tree[rt].getL() >= l && tree[rt].getR() <= r){
            tree[rt].setVal(tree[rt].r-tree[rt].l+1-tree[rt].getVal());
            tree[rt].setLazy(!tree[rt].getLazy());
            return;
        }
        pushDown(rt);
        int mid = (tree[rt].getL() + tree[rt].getR()) >> 1;
        if (l <= mid){
            update(l,r,rt<<1);
        }
        if (r > mid){
            update(l,r,rt<<1|1);
        }
        tree[rt].setVal(tree[rt<<1].getVal() + tree[rt<<1|1].getVal());
    }
    // 查询
    public int query(int l,int r,int rt){
        if (tree[rt].getL() >= l && tree[rt].getR() <= r){
            return tree[rt].getVal();
        }
        pushDown(rt);
        int mid = (tree[rt].getL() + tree[rt].getR()) >> 1;
        int res = 0;
        if (l <= mid){
            res += query(l,r,rt<<1);
        }
        if (r > mid){
            res += query(l,r,rt<<1|1);
        }
        return res;
    }
}

class SeqTree{
    int l;
    int r;
    int val;
    boolean lazy;

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public boolean getLazy() {
        return lazy;
    }

    public void setLazy(boolean lazy) {
        this.lazy = lazy;
    }
}


