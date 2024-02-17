package combinatorics.tiling;

public class TilingProblemAdvance  implements TilingProblem {

    public final Integer widthBoard;

    public TilingProblemAdvance(Integer widthBoard) {
        this.widthBoard = widthBoard;
    }

    @Override
    public Integer countWays() {
        return getTotalWays(this.widthBoard);
    }

    private Integer getTotalWays(Integer widthBoard) {

        if(widthBoard == 0) {
            return 1;
        }
        if(widthBoard == 1) {
            return 0;
        }

        return getTotalWays(widthBoard - 2)
                + (2 * getTotalWaysWithExtra2x1(widthBoard - 2));
    }

    private int getTotalWaysWithExtra2x1(int widthBoard) {

        if(widthBoard == 0) {
            return 1;
        }
        if(widthBoard == 1) {
            return 0;
        }

        return getTotalWaysWithExtra2x1(widthBoard - 2)
                + getTotalWays(widthBoard);
    }

}

