package digitdp;

public class DigitDPRecursion {

    private final String numberFrom;

    private final String numberTill;

    public DigitDPRecursion(String numberFrom, String numberTill) {
        this.numberTill = numberTill;
        this.numberFrom = numberFrom;
    }

    public void printAll() {
        printAll("", 0, true, true);
    }

    private void printAll(String number, int digitIndexLeftToRight, boolean firstChoiceOfDigit, boolean lastChoiceOfDigit) {

        if(digitIndexLeftToRight == this.numberTill.length()) {
            System.out.println(number);
            return;
        }

        int choiceOfDigitFrom = firstChoiceOfDigit ? Integer.parseInt(String.valueOf(this.numberFrom.charAt(digitIndexLeftToRight))) : 0;
        int choiceOfDigitTill = lastChoiceOfDigit ? Integer.parseInt(String.valueOf(this.numberTill.charAt(digitIndexLeftToRight))) : 9;

        for (int choiceOfDigit = choiceOfDigitFrom; choiceOfDigit <= choiceOfDigitTill; choiceOfDigit++) {
            printAll(number + choiceOfDigit, digitIndexLeftToRight + 1, (firstChoiceOfDigit && (choiceOfDigit == choiceOfDigitFrom)), (lastChoiceOfDigit && (choiceOfDigit == choiceOfDigitTill)));

        }
    }


}
