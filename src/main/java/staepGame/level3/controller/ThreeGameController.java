package staepGame.level3.controller;



import camp.nextstep.edu.missionutils.Randoms;
import staepGame.level3.model.ThreeGameAction;
import staepGame.level3.view.ThreeGameInputView;
import staepGame.level3.view.ThreeGameOutputView;

import staepGame.total.model.Com;
import staepGame.total.model.StepRank;
import staepGame.total.model.User;
import staepGame.total.repository.UserRepository;

import staepGame.total.validate.UserRcpActionValidate;
import staepGame.total.validate.UserScissorsFromPaperInputValidate;
import staepGame.total.validate.YesNoInputValidate;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import java.util.Optional;

import static staepGame.total.model.GameCompete.LOSE;
import static staepGame.total.model.GameCompete.WIN;

public class ThreeGameController {

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final ThreeGameInputView threeGameInputView;
    private final ThreeGameOutputView threeGameOutputView;

    private final UserRepository userRepository;

    private static final int THREE_GAME_LAST = 20;
    private boolean gameBeforeCheck = true;

    private static final int MOVE_FORWARD = 3;
    private static final int MOVE_BACK = -1;
    private static final int MOVE_INIT = 0;

    public ThreeGameController(UserRepository userRepository) {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.threeGameInputView = new ThreeGameInputView();
        this.threeGameOutputView = new ThreeGameOutputView();

        this.userRepository = userRepository;
    }

    public void run() {
        User defaultUser = null;
        Com com = new Com();

        defaultUser = userCheck(defaultUser);
        if (defaultUser == null) {
            return;
        }

        threeGameGuide();
        threeGameOutputView.gameStartBefore();

        while(true) {

            // 가위 바위 보 행동
            String[] actionResult = getActionInput();
            String userActionInput = actionResult[0];
            String comActionInput = actionResult[1];

            int[] numResults = getNumResult(userActionInput, comActionInput);
            int userOneGameResultNum = numResults[0];
            int comOneGameResultNum = numResults[1];

            String gameResult = ThreeGameAction.gameResult(userOneGameResultNum, comOneGameResultNum);
            ThreeGameAction[] threeGames = ThreeGameAction.userAndGameAction(userOneGameResultNum, comOneGameResultNum);


            // 게임 행동의 대한 결과
            threeGameOutputView.threeGameUserAndComStatus(defaultUser, threeGames);
            threeGameOutputView.gameResult(gameResult);

            //이겼을시 3칸 전진
            if (WIN.getResult().equals(gameResult)) {
                defaultUser.setThreeGameResult(MOVE_FORWARD);
                com.setThreeGameResult(MOVE_BACK);

                threeGameOutputView.gameUserWinResult(defaultUser, MOVE_FORWARD, MOVE_BACK);
            }

            //졌을시 1칸 뒤로
            if (LOSE.getResult().equals(gameResult)) {
                defaultUser.setThreeGameResult(MOVE_BACK);
                com.setThreeGameResult(MOVE_FORWARD);

                threeGameOutputView.gameUserLoseResult(defaultUser, MOVE_FORWARD, MOVE_BACK);
            }

            // 사용자가 이겼을시
            if (defaultUser.getThreeGameResult() >= THREE_GAME_LAST) {
                moveInit(defaultUser, com);
                totalGameOutputView.gameCompleteShow(defaultUser);

                return;
            }

            // 컴퓨터가 이겼을시
            if (com.getThreeGameResult() >= THREE_GAME_LAST) {
                moveInit(defaultUser, com);
                threeGameOutputView.gameLoseStatus(THREE_GAME_LAST);

                return;
            }

        }

    }

    private User userCheck(User defaultUser) {
        while (gameBeforeCheck) {
            String nameCheckInput = totalGameInputView.nameCheck();
            Optional<User> findUser = userRepository.findUser(nameCheckInput)
                    .filter(user -> !user.getStepRank().equals(StepRank.BASIC))
                    .filter(user -> !user.getStepRank().equals(StepRank.BRONZE));

            defaultUser = findUser.orElse(null);
            reNameInputAction(defaultUser);
        }
        return defaultUser;
    }

    private void reNameInputAction(User user) {

        while (true) {
            try {
                if (user == null) {
                    String reInputNameResult = totalGameInputView.reInputName();
                    String reInputResult = YesNoInputValidate.start(reInputNameResult);

                    boolean hasReNameInput = reInputResult.equalsIgnoreCase("y");
                    if (!hasReNameInput) {
                        gameBeforeCheck = false;
                    }

                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void threeGameGuide() {
        while (true) {
            try {
                String guideInput = threeGameInputView.gameGuide();
                String oneGamedGuide = YesNoInputValidate.start(guideInput);

                boolean hasOneGameGuide = oneGamedGuide.equalsIgnoreCase("y");
                if (hasOneGameGuide) {
                    threeGameOutputView.gameGuide();
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getActionInput() {
        while (true){
            try {
                String scissorsFromPaperInput = threeGameInputView.gameInput();

                String[] ActionInput = new String[2];

                ActionInput[0] = UserScissorsFromPaperInputValidate.start(scissorsFromPaperInput);
                ActionInput[1] = String.valueOf(Randoms.pickNumberInRange(1, 3));

                return ActionInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static int[] getNumResult(String userActionInput, String comActionInput) {
        while (true) {
            try {
                return  UserRcpActionValidate.start(userActionInput, comActionInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void moveInit(User defaultUser, Com com) {
        defaultUser.setThreeGameResult(MOVE_INIT);
        com.setThreeGameResult(MOVE_INIT);
    }

}