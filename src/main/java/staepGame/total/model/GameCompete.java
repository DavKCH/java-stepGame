package staepGame.total.model;

public enum GameCompete {
    WIN("승리"),
    LOSE("패배"),
    DRAW("무승부");

    private final String result;

    GameCompete(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
