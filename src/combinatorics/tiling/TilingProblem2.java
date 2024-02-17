package combinatorics.tiling;

public class TilingProblem2 implements TilingProblem {

    public final Integer widthBoard;

    public TilingProblem2(Integer widthBoard) {
        this.widthBoard = widthBoard;
    }

    @Override
    public Integer countWays() {
        return getTotalWays(this.widthBoard);
    }

    private Integer getTotalWays(Integer widthBoard) {

        if(widthBoard <= 1) {
            return widthBoard;
        }
        if(widthBoard <= 2) {
            return 3;
        }

        return getTotalWays(widthBoard - 1) + 2 * getTotalWays(widthBoard - 2);
    }

}

