package digitdp;

import util.DPUtil;

import java.util.List;

public class DMagicNumberProblem {

    private final Integer dMagic;

    private final String numberFrom;

    private final String numberTill;

    private final Integer divisibleBy;

    private List<List<List<List<Integer>>>> dp;

    private int iteration = 0;

    @SuppressWarnings("unchecked")
    public DMagicNumberProblem(Integer dMagic, String numberFrom, String numberTill, Integer divisibleBy) {
        this.dMagic = dMagic;
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
        int a = checkDivisibility(this.numberTill, 0, 0, true);
        this.dp = (List<List<List<List<Integer>>>>) DPUtil // assuming numbers can be 10^9 max.
                .init(Integer.class, "-1", this.divisibleBy + 1, this.divisibleBy + 1, 10, 2);
        int b = checkDivisibility(getMinusOne(this.numberFrom), 0, 0, true);

        return a - b;
    }

    private String getMinusOne(String number) {

        //TODO: To implement -1 logic to get the correct result for inclusive case in case of checkDivisibility(numberFrom,..)
        return number;
    }

    private Integer checkDivisibility(String numberTill, int numberMod,
                                      int digitIndexLeftToRight, boolean lastChoiceOfDigit) {

        System.out.println(++iteration);

        if (digitIndexLeftToRight == this.numberTill.length()) {
            return (numberMod == 0) ? 1 : 0;
        }

//        if (dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).get(lastChoiceOfDigit ? 0 : 1) != -1) {
//            return dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).get(lastChoiceOfDigit ? 0 : 1);
//        }

        int choiceOfDigitTill = lastChoiceOfDigit ? Integer.parseInt(String.valueOf(numberTill.charAt(digitIndexLeftToRight))) : 9;

        int totalCount = 0;
        if(digitIndexLeftToRight % 2 != 1) { // odd
            for (int choiceOfDigit = 0; choiceOfDigit <= choiceOfDigitTill; choiceOfDigit++) {
                if (choiceOfDigit == this.dMagic) continue;
                totalCount += checkDivisibility(
                        numberTill,
                        (numberMod * 10 + choiceOfDigit) % this.divisibleBy,
                        digitIndexLeftToRight + 1,
                        (lastChoiceOfDigit && (choiceOfDigit == choiceOfDigitTill))
                );
            }
        } else { //even
            totalCount += checkDivisibility(
                    numberTill,
                    (numberMod * 10 + this.dMagic) % this.divisibleBy,
                    digitIndexLeftToRight + 1,
                    (lastChoiceOfDigit && (this.dMagic == choiceOfDigitTill))
            );
        }

//        dp.get(numberMod).get(digitSumMod).get(digitIndexLeftToRight).set(lastChoiceOfDigit ? 0 : 1, totalCount);

        return totalCount;
    }


}
