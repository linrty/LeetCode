package s68;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/9 15:48
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        //System.out.println(new Solution().fullJustify(words, maxWidth).toArray());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> stringList = new ArrayList<>();
        int i = 0;
        int len = words.length;
        List<String> list = new ArrayList<>();
        int sumSize = 0;
        while(i < len){
            if (sumSize + words[i].length() + list.size() <= maxWidth){
                list.add(words[i]);
                sumSize += words[i].length();
            }else{
                int spaceNum = maxWidth - sumSize;
                int wordNum = list.size();

                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    int midSpaceNum = 0;
                    int moreSpace = 0;
                    if (wordNum == 1){
                        midSpaceNum = spaceNum;
                    }else{
                        midSpaceNum = spaceNum / (wordNum - 1);
                        moreSpace = spaceNum % (wordNum - 1);
                    }

                    stringBuilder.append(list.get(j));
                    if (j != list.size()-1 || list.size()==1){
                        for (int k = 0; k < midSpaceNum; k++) {
                            stringBuilder.append(" ");
                        }
                    }
                    if (j < moreSpace){
                        stringBuilder.append(" ");
                    }
                }
                list.clear();
                list.add(words[i]);
                sumSize = words[i].length();
                stringList.add(stringBuilder.toString());
            }
            i++;
        }
        int spaceNum = maxWidth - sumSize;
        int wordNum = list.size();


        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            int midSpaceNum = 0;
            int moreSpace = 0;
            if (wordNum == 1){
                midSpaceNum = spaceNum;
            }else{
                midSpaceNum = spaceNum / (wordNum - 1);
                moreSpace = spaceNum % (wordNum - 1);
            }

            stringBuilder.append(list.get(j));

            if (j != list.size()-1) {
                stringBuilder.append(" ");
            }else{
                moreSpace = spaceNum - list.size() + 1;
                while(moreSpace!=0){
                    stringBuilder.append(" ");
                    moreSpace--;
                }
            }
        }
        stringList.add(stringBuilder.toString());
        return stringList;
    }
}
