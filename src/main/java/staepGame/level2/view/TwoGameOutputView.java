package staepGame.level2.view;

import staepGame.total.model.GameGuide;

import static staepGame.total.model.GameCompete.LOSE;

public class TwoGameOutputView {

    private static final String MESSAGE_START_BEFORE = "두번째 게임을 시작합니다.";
    private static final String MESSAGE_UP = "UP";
    private static final String MESSAGE_DOWN = "DOWN";

    public void gameGuideTwo() {
        GameGuide.stepTwoGuide();
    }

    public void twoGameStartBefore() {
        System.out.println(MESSAGE_START_BEFORE);
    }

    public void gameUpShow() {
        System.out.println(MESSAGE_UP);
    }

    public void gameDownShow() {
        System.out.println(MESSAGE_DOWN);
    }

    public void twoGameLoseStatus(int lastCount) {
        System.out.printf("%d번의 기회를 모두 잊어 버렸습니다.\n", lastCount);
        System.out.printf("%s 하였 습니다.\n", LOSE.getResult());
    }

}
