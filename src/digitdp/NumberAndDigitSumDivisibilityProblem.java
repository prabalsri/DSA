package digitdp;

import util.DPUtil;

import java.util.List;

public class NumberAndDigitSumDivisibilityProblem {

    private final String numberFrom;

    private final String numberTill;

    private final Integer divisibleBy;

    private List<List<List<List<Integer>>>> dp;

    private int iteration = 0;

    @SuppressWarnings("unchecked")
    public NumberAndDigitSumDivisibilityProblem(String numberFrom, String numberTill, Integer divisibleBy) {
        this.numberFrom = numberFrom;
        this.numberTill = numberTill;
        this.divisibleBy = divisibleBy;
        this.dp = (List<List<List<List<Integer>>>>) DPUtil // assuming numbers can be 10^9 max.
                .init(Integer.class, "-1", this.divisibleBy + 1, this.divisibleBy + 1, 10, 2);
    }

    @SuppressWarnings("unchecked")
    public Integer checkDivisibility() {
//        new DigitDPRecursion(
//                this.numberFrom,
//                this.numberTill
//        ).printAll();
        int a = checkDivisibility(this.numberTill, 0, 0, 0, true);
        this.dp = (List<List<List<List<Integer>>>>) DPUtil // assuming numbers can be 10^9 max.
                .init(Integer.class, "-1", this.divisibleBy + 1, this.divisibleBy + 1, 10, 2);
        int b = checkDivisibility(getMinusOne(this.numberFrom), 0, 0, 0, true);

        return a - b;
    }

    private String getMinusOne(String number) {

        //TODO: To implement -1 logic to get the correct result for inclusive case in case of checkDivisibility(numberFrom,..)
        return number;
    }

    private Integer checkDivisibility(String numberTill, int numberMod, int digitSumMod, int digitIndexLeftToRight,
                                boolean lastChoiceOfDigit) {

        System.out.println(++iteration);

        if(digitIndexLeftToRight == this.numberTill.length()) {
            return (numberMod == 0 && digitSumMod == 0) ?  1 : 0;
        }

        if (dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).get(lastChoiceOfDigit ? 0 : 1) != -1) {
            return dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).get(lastChoiceOfDigit ? 0 : 1);
        }

        int choiceOfDigitTill = lastChoiceOfDigit ? Integer.parseInt(String.valueOf(numberTill.charAt(digitIndexLeftToRight))) : 9;

        int totalCount = 0;
        for (int choiceOfDigit = 0; choiceOfDigit <= choiceOfDigitTill; choiceOfDigit++) {
            totalCount += checkDivisibility(
                    numberTill,
                    (numberMod * 10 + choiceOfDigit) % this.divisibleBy,
                    (digitSumMod + choiceOfDigit) % this.divisibleBy,
                    digitIndexLeftToRight + 1,
                    (lastChoiceOfDigit && (choiceOfDigit == choiceOfDigitTill))
            );
        }

        dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).set(lastChoiceOfDigit ? 0 : 1, totalCount);

        return totalCount;
    }


}
