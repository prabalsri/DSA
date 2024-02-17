package combinatorics.tiling;

public class TilingProblem1 implements TilingProblem {

    public final Integer widthBoard;

    public TilingProblem1(Integer widthBoard) {
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

        return getTotalWays(widthBoard - 1) + getTotalWays(widthBoard - 2);
    }

}
