package s6;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(new Solution().convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            int ans = numRows + numRows - 2;
            int len = s.length();
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    for (int j = 0; j * ans + i < len; j++) {
                        stringBuilder.append(s.charAt(j * ans + i));
                    }
                } else {
                    for (int j = 0; j * ans + i < len; j++) {
                        stringBuilder.append(s.charAt(j * ans + i));
                        if ((j + 1) * ans - i < len) {
                            stringBuilder.append(s.charAt((j + 1) * ans - i));
                        }
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
}
