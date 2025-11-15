package staepGame.level3.view;

import staepGame.level1.model.OneGameAction;
import staepGame.level3.model.ThreeGameAction;
import staepGame.total.model.GameGuide;
import staepGame.total.model.User;
import staepGame.total.view.OutputView;

import static staepGame.total.model.GameCompete.LOSE;

public class ThreeGameOutputView implements OutputView {

    private static final String MESSAGE_START_BEFORE = "세번째 게임을 시작합니다.";

    @Override
    public void gameGuide() {
        GameGuide.stepTwoGuide();
    }

    @Override
    public void gameStartBefore() {
        System.out.println(MESSAGE_START_BEFORE);
    }

    @Override
    public void gameResult(String gameResult) {
        System.out.printf("%s\n", gameResult);
    }

    @Override
    public void gameLoseStatus(int lastCount) {
        System.out.printf("%d번의 기회를 모두 잊어 버렸습니다.\n", lastCount);
        System.out.printf("%s 하였 습니다.\n", LOSE.getResult());
    }

    public void threeGameUserAndComStatus(User user, ThreeGameAction[] threeGames) {
        String userKoreaStr = threeGames[0].getKoreaStr();
        String comKoreaStr = threeGames[1].getKoreaStr();

        System.out.printf("%s님: %s, 컴퓨터: %s\n", user.getName(), userKoreaStr, comKoreaStr);
    }

}
