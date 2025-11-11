package staepGame.total.model;

public enum StepRank {
    BASIC("기본"),
    BRONZE("동"),
    SILVER("실버"),
    GOLD("골드");

    private final String level;

    StepRank(String level) {
        this.level = level;
    }

}
