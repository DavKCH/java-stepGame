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

    public static String gameResult(int userResult, int comResult) {

        if (userResult == comResult) {
            return "승리";
        }

        if (userResult > comResult) {
            return DOWN.name();
        }

        if (userResult < comResult) {
            return UP.name();
        }

        return null;
    }


}
