import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        // 通过||切分
        String[] isPlusArray = bowlingCode.split("\\|\\|");
        String[] basicCodeArray = isPlusArray[0].split("\\|");
        if (isPlusArray.length > 1) {
            String plusCode = isPlusArray[1];
        } else {
            String plusCode = "--";
        }

        // 通过|切分并且获取每一个的分数
//        ArrayList<ArrayList<Integer>> = new ArrayList<ArrayList<Integer>>();

        List<Integer> codeList = new ArrayList<Integer>();
        for (String singleCode : basicCodeArray) {
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
        }

        // 逐个分析得分
        for (String singleCode : basicCodeArray) {
            Integer code;
            if (singleCode.contains("X")) {
                code = 10 + 1 + 2;
            } else if (singleCode.contains("/")) {
                code = 10 + 4;
            } else {
                code = 1 + 5;
            }
            System.out.println(code);

        }
        System.out.println(codeList);


        return 0;
    }

    public static void main(String[] args) {
        BowlingGame bg = new BowlingGame();
//        bg.getBowlingScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
//        bg.getBowlingScore("X|X|X|X|X|X|X|X|X|X||XX");
//        bg.getBowlingScore("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||");
        bg.getBowlingScore("2/|2/|5/|5/|5/|5/|5/|5/|5/|5/||5");
    }
}
