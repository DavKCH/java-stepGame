package staepGame;

public enum OneGame {

    SCISSORS(1,"가위"),
    ROCK(2,"바위"),
    PAPER(3,"보");

    private int result;
    private String koreaStr;

    OneGame(int result, String koreaStr) {
        this.result = result;
        this.koreaStr = koreaStr;
    }

    public int getResult() {
        return result;
    }

    public String getKoreaStr() {
        return koreaStr;
    }


}
