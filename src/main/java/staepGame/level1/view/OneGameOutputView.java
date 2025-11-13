package staepGame.level1.view;

import staepGame.level1.model.OneGameAction;
import staepGame.total.model.GameGuide;
import staepGame.total.model.User;
import staepGame.total.view.OutputView;

import static staepGame.total.model.GameCompete.LOSE;

public class OneGameOutputView implements OutputView {

    private static final String MESSAGE_START_BEFORE = "첫번째 게임을 시작합니다.";

    @Override
    public void gameGuide() {
        GameGuide.stepOneGuide();
    }

    @Override
    public void gameStartBefore() {
        System.out.println(MESSAGE_START_BEFORE);
    }

    @Override
    public void gameResult(String gameResult) {
        System.out.printf("%s\n", gameResult);
    }

    public void oneGameUserAndComStatus(User user, OneGameAction[] oneGames) {
        String userKoreaStr = oneGames[0].getKoreaStr();
        String comKoreaStr = oneGames[1].getKoreaStr();

        System.out.printf("%s님: %s, 컴퓨터: %s\n", user.getName(), userKoreaStr, comKoreaStr);
    }

   @Override
    public void gameLoseStatus(int lastCount) {
        System.out.printf("%d번의 기회를 모두 잊어 버렸습니다.\n", lastCount);
        System.out.printf("%s 하였 습니다.\n", LOSE.getResult());
    }

}
