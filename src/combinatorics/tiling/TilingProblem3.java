package combinatorics.tiling;

public class TilingProblem3 implements TilingProblem {

    public final Integer widthBoard;

    public TilingProblem3(Integer widthBoard) {
        this.widthBoard = widthBoard;
    }

    @Override
    public Integer countWays() {
        return getTotalWays(this.widthBoard);
    }

    private Integer getTotalWays(Integer widthBoard) {

        if(widthBoard <= 2) {
            return widthBoard;
        }

        return getTotalWays(widthBoard - 1)
                + getTotalWays(widthBoard - 2)
                + (2 * getTotalWaysWithExtra1x1(widthBoard - 2));
    }

    private int getTotalWaysWithExtra1x1(int widthBoard) {

        if(widthBoard <= 2) {
            return widthBoard;
        }

        return getTotalWaysWithExtra1x1(widthBoard - 1)
                + getTotalWays(widthBoard - 1);
    }

}

