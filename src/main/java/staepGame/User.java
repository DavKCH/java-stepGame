package staepGame;

public class User {

    private final String name;
    private StepRank stepRank;

    public User(String name) {
        this.name = name;
        stepRank = StepRank.BASIC;
    }

    public String getName() {
        return name;
    }

    public void setStepRank(StepRank stepRank) {
        this.stepRank = stepRank;
    }

    public StepRank getStepRank() {
        return stepRank;
    }
}
