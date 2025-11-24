package staepGame.level2.controller;


import staepGame.level2.model.TwoGameAction;
import staepGame.level2.view.TwoGameInputView;
import staepGame.level2.view.TwoGameOutputView;

import staepGame.total.model.Com;
import staepGame.total.model.StepRank;
import staepGame.total.model.User;

import staepGame.total.repository.GameRepository;
import staepGame.total.repository.UserRepository;

import staepGame.total.validate.UserNumValidate;
import staepGame.total.validate.YesNoInputValidate;

import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import static staepGame.total.model.GameCompete.WIN;

import java.util.Optional;

public class TwoGameController {

    private final TwoGameInputView twoGameInputView;
    private final TwoGameOutputView twoGameOutputView;

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    private static final int TWO_GAME_LAST = 8;
    private int twoGameCount = 0;
    private boolean gameBeforeCheck = true;


    public TwoGameController(UserRepository userRepository, GameRepository gameRepository) {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.twoGameInputView = new TwoGameInputView();
        this.twoGameOutputView = new TwoGameOutputView();

        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public void run() {

        if (!gameRepository.isHasGameTwo()) {
            return;
        }

        // 사용자 체크
        User defaultUser = null;
        Com com = new Com();

        defaultUser = userCheck(defaultUser);
        if (defaultUser == null) {
            return;
        }

        twoGameGuide();
        twoGameOutputView.gameStartBefore();

        // 게임 시작
        while (twoGameCount != TWO_GAME_LAST) {
            // 게임 행동
            int userInput = getActionInput();
            int comInput = com.getTwoGameResult();

            String gameResult = TwoGameAction.gameResult(userInput, comInput);

            // 게임 행동의 결과.
            twoGameOutputView.gameResult(gameResult);

            // 게임 승리시
            if (WIN.getResult().equals(gameResult)) {
                defaultUser.setStepRank(StepRank.SILVER);
                gameRepository.setHasGameThree(true);

                totalGameOutputView.userStatus(defaultUser);

                return;
            }
            twoGameCount++;

            // 게임에 졌을시
            if (twoGameCount == TWO_GAME_LAST) {
                twoGameOutputView.gameLoseStatus(TWO_GAME_LAST);
                reStartAction(defaultUser);
            }
        }

        totalGameOutputView.gameEndShow(defaultUser);
    }

    // =========== userCheck start ===========
    private User userCheck(User defaultUser) {
        while (gameBeforeCheck) {
            String nameCheckInput = totalGameInputView.nameCheck();
            Optional<User> findUser = userRepository.findUser(nameCheckInput)
                    .filter(user -> !user.getStepRank().equals(StepRank.BASIC));

            defaultUser = findUser.orElse(null);
            reNameInputAction(defaultUser);

            if (defaultUser != null) {
                gameBeforeCheck = false;
            }

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
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // =========== userCheck end ===========

    private void twoGameGuide() {
        while (true) {
            try {
                String guideInput = twoGameInputView.gameGuide();
                String oneGamedGuide = YesNoInputValidate.start(guideInput);

                boolean hasOneGameGuide = oneGamedGuide.equalsIgnoreCase("y");
                if (hasOneGameGuide) {
                    twoGameOutputView.gameGuide();
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getActionInput() {
        while (true){
            try {
                String numInput = twoGameInputView.gameInput();
                int result = UserNumValidate.start(numInput);

                return result;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void reStartAction(User user) {

        while (true) {
            try {
                String reStartGameInput = totalGameInputView.inputReStartGame(user);
                String reStratGameResult = YesNoInputValidate.start(reStartGameInput);

                boolean hasReStartGame = reStratGameResult.equalsIgnoreCase("y");
                if (hasReStartGame) {
                    twoGameCount = 0;
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}