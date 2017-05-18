import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        String[] basicCodeArray = bowlingCode.replace("||", "|").split("\\|");

        // 通过|切分并且获取每一个的分数
        List<List> codeListList = new ArrayList<List>();
        for (String singleCode : basicCodeArray) {
            List<Integer> codeList = new ArrayList<Integer>();
            String[] singleCharArray = singleCode.split("");
            for (String singleChar : singleCharArray) {
                if ("X".equals(singleChar)) {
                    codeList.add(10);
                } else if ("-".equals(singleChar)) {
                    codeList.add(0);
                } else if ("/".equals(singleChar)) {
                    codeList.add(10 - Integer.parseInt(singleCharArray[0]));
                } else {
                    codeList.add(Integer.parseInt(singleChar));
                }
            }
            codeListList.add(codeList);
        }


        // 逐个分析得分
        Integer allCode = 0;
        for (int i = 0; i < 10; i++) {
            String singleCode = basicCodeArray[i];
            List<Integer> scoreList = codeListList.get(i);
            Integer code;
            if (singleCode.contains("X")) {
                List<Integer> scoreNextList = codeListList.get(i + 1);
                if (scoreNextList.size() == 2) {
                    code = 10 + scoreNextList.get(0) + scoreNextList.get(1);
                } else {
                    List<Integer> scoreNextNextList = codeListList.get(i + 2);
                    code = 10 + scoreNextList.get(0) + scoreNextNextList.get(0);
                }
            } else if (singleCode.contains("/")) {
                List<Integer> scoreNextList = codeListList.get(i + 1);
                code = 10 + scoreNextList.get(0);
            } else {
                code = scoreList.get(0) + scoreList.get(1);
            }
            allCode += code;
        }


        return allCode;
    }
}
