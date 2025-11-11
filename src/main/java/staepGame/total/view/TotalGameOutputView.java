package staepGame.total.view;


import staepGame.total.model.User;

import static staepGame.total.model.GameCompete.LOSE;

public class TotalGameOutputView {

    private static final String MESSAGE_START_DECO = "========= stepGame start =========";
    private static final String MESSAGE_EMD_DECO = "========== stepGame EMD ==========";
    private static final String MESSAGE_GAME_COMPETE = "축하 합니다. 모든 게임에 승리 하셧습니다!!";
    private static final String MESSAGE_GAME_WELCOME_GREETING = "단계 게임에 오신것을 환영 합니다.";


    public void gameStartShow() {
        System.out.println(MESSAGE_START_DECO);
        System.out.println(MESSAGE_GAME_WELCOME_GREETING);
    }

    public void userStatus(User user) {
        System.out.printf("%s 님의 현재 등급: %s\n", user.getName(), user.getStepRank());
    }

    public void gameEndShow(User user) {
        userStatus(user);
        System.out.println(MESSAGE_EMD_DECO);
    }

    public void gameCompleteShow(User user) {
        userStatus(user);
        System.out.println(MESSAGE_GAME_COMPETE);
        System.out.println(MESSAGE_EMD_DECO);
    }

}
