package digitdp;

import util.DPUtil;

import java.util.List;

public class SumOfDigitsProblemMemoization {

    private final String numberFrom;

    private final String numberTill;

    private List<List<List<Integer>>> dp;

    @SuppressWarnings("unchecked")
    public SumOfDigitsProblemMemoization(String numberFrom, String numberTill) {
        this.numberFrom = numberFrom;
        this.numberTill = numberTill;
        //this.dp = (List<List<List<Integer>>>) DPUtil.init(Integer.class, 10, 2, 90); // assuming numbers can be 10^9 max.
    }

    public Integer sum() {
        new DigitDPRecursion(
                this.numberFrom,
                this.numberTill
        ).printAll();
        return getTotalSum(0, 0, true, true);
    }

    private Integer getTotalSum(int sum, int digitIndexLeftToRight, boolean firstChoiceOfDigit, boolean lastChoiceOfDigit) {

        if(digitIndexLeftToRight == this.numberTill.length()) {
            return sum;
        }

        //use 4d dp array to memoize

        int choiceOfDigitFrom = firstChoiceOfDigit ? Integer.parseInt(String.valueOf(this.numberFrom.charAt(digitIndexLeftToRight))) : 0;
        int choiceOfDigitTill = lastChoiceOfDigit ? Integer.parseInt(String.valueOf(this.numberTill.charAt(digitIndexLeftToRight))) : 9;

        int totalSum = 0;
        for (int choiceOfDigit = choiceOfDigitFrom; choiceOfDigit <= choiceOfDigitTill; choiceOfDigit++) {
            totalSum += getTotalSum(sum + choiceOfDigit, digitIndexLeftToRight + 1, (firstChoiceOfDigit && (choiceOfDigit == choiceOfDigitFrom)), (lastChoiceOfDigit && (choiceOfDigit == choiceOfDigitTill)));
        }

        return totalSum;
    }


}
