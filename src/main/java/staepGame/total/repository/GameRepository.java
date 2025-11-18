package staepGame.total.repository;

public class GameRepository {

    private boolean HasGameTwo = false;
    private boolean HasGameThree = false;

    public void setHasGameTwo(boolean hasGameTwo) {
        HasGameTwo = hasGameTwo;
    }

    public void setHasGameThree(boolean hasGameThree) {
        HasGameThree = hasGameThree;
    }

    public boolean isHasGameTwo() {
        return HasGameTwo;
    }

    public boolean isHasGameThree() {
        return HasGameThree;
    }
}
