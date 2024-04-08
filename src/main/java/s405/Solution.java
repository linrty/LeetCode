package s405;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/10/2 14:08
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().toHex(-1));
    }

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] vis = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num > 0){
            int ans = num;
            StringBuilder stringBuilder =  new StringBuilder();
            while (ans!=0){
                stringBuilder.append(vis[ans%16]);
                ans/=16;
            }
            return stringBuilder.reverse().toString();
        }else{
            int ans = -num;
            // 先转化成二进制，然后计算补码，再转化成16进制
            StringBuilder stringBuilder = new StringBuilder();
            while (ans != 0){
                int nn = ans%2;
                if (nn == 0) nn =1;
                else nn = 0;
                stringBuilder.append(nn);
                ans/=2;
            }
            // 补齐32位数
            while (stringBuilder.length() < 32){
                stringBuilder.append(1);
            }
            StringBuilder str = new StringBuilder();
            // 补码的加1操作
            int len = stringBuilder.length();
            int i = 0;
            int pre = 1;
            while (i < len){
                int mm = stringBuilder.charAt(i)-'0';
                if (mm+pre == 2){
                    str.append(0);
                }else{
                    str.append(mm+pre);
                    pre = 0;
                }
                i++;
            }
            stringBuilder.delete(0,stringBuilder.length());
            // 转化成16进制，每4位二进制合并
            int j = 0;
            len = str.length();
            while (j < len){
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    cnt+=((1<<k)*(str.charAt(j+k)-'0'));
                }
                stringBuilder.append(vis[cnt]);
                j+=4;
            }
            return stringBuilder.reverse().toString();
        }
    }
}
