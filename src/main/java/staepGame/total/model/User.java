package staepGame.total.model;

public class User {

    private final String name;
    private StepRank stepRank;

    private int threeGameResult;

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

    public void setThreeGameResult(int inputGameResult) {
        if (this.threeGameResult == 0 && inputGameResult == -1) {
            return;
        }

        this.threeGameResult = inputGameResult;
    }

    public int getThreeGameResult() {
        return threeGameResult;
    }
}
