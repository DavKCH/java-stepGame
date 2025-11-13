package staepGame.level2.model;


public enum TwoGameAction {

    UP(1),
    DOWN(2);

    private final int result;

    TwoGameAction(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }


}
