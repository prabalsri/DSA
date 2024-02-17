package combinatorics.pairingfriends;

public class PairingFriendsProblem implements PairingFriends {

    public final Integer friends;

    public PairingFriendsProblem(Integer friends) {
        this.friends = friends;
    }

    @Override
    public Integer countWays() {
        return getTotalWays(this.friends);
    }

    private Integer getTotalWays(Integer friends) {

        if(friends <= 2) {
            return friends;
        }

        return getTotalWays(friends - 1) + (friends - 1) * getTotalWays(friends - 2);
    }
}
