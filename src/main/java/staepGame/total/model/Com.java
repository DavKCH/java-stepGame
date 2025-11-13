package staepGame.total.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Com {

    private int twoGameResult;

    private int threeGameResult;

    public Com() {
        twoGameResult = Randoms.pickNumberInRange(1, 100);
        threeGameResult = 0;
    }

    public int getTwoGameResult() {
        return twoGameResult;
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
