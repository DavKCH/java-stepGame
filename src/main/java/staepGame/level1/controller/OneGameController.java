package staepGame.level1.controller;



import camp.nextstep.edu.missionutils.Randoms;

import staepGame.level1.view.OneGameInputView;
import staepGame.level1.view.OneGameOutputView;
import staepGame.level1.model.OneGameAction;

import staepGame.total.model.StepRank;
import staepGame.total.model.User;
import static staepGame.total.model.GameCompete.WIN;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import staepGame.total.repository.UserRepository;
import staepGame.total.validate.*;


public class OneGameController {

    private final OneGameInputView oneGameInputView;
    private final OneGameOutputView oneGameOutputView;

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final UserRepository userRepository;

    private static final int ONE_GAME_LAST = 3;
    private int oneGameCount = 0;

    public OneGameController(UserRepository userRepository) {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.oneGameInputView = new OneGameInputView();
        this.oneGameOutputView = new OneGameOutputView();

        this.userRepository = userRepository;
    }

    public void run() {

        totalGameOutputView.gameStartShow();

        String userName = getUserName();
        User user = new User(userName);
        oneGameGuide();
        oneGameOutputView.gameStartBefore();

        while (oneGameCount != ONE_GAME_LAST) {

            // 가위 바위 보 행동
            String[] actionResult = getActionInput();
            String userActionInput = actionResult[0];
            String comActionInput = actionResult[1];

            int[] numResults = getNumResult(userActionInput, comActionInput);
            int userOneGameResultNum = numResults[0];
            int comOneGameResultNum = numResults[1];

            String gameResult = OneGameAction.gameResult(userOneGameResultNum, comOneGameResultNum);
            OneGameAction[] oneGames = OneGameAction.userAndGameAction(userOneGameResultNum, comOneGameResultNum);

            // 게임 행동의 대한 결과
            oneGameOutputView.oneGameResult(gameResult);
            oneGameOutputView.oneGameUserAndComStatus(user, oneGames);

            // 게임의 승리 했을시, 사용자의 등급 업 및 유저를 저장
            if (WIN.getResult().equals(gameResult)) {
                user.setStepRank(StepRank.BRONZE);
                userRepository.add(user);

                return;
            }
            oneGameCount++;

            // 게임에 완전히 패배 햇을 경우, 다시 시작을 묻는 로직.
            if (oneGameCount == ONE_GAME_LAST) {
                oneGameOutputView.gameLoseStatus(ONE_GAME_LAST);
                reStartAction(user);
            }

        } // while end

        totalGameOutputView.gameEndShow(user);
    }

    private String getUserName() {
        while (true) {
            try {
                String strNameInput = totalGameInputView.inputGameStart();
                String userName = UserNameValidate.start(strNameInput);

                return userName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void oneGameGuide() {
        while (true) {
            try {
                String guideInput = oneGameInputView.gameGuide();
                String oneGamedGuide = YesNoInputValidate.start(guideInput);

                boolean hasOneGameGuide = oneGamedGuide.equalsIgnoreCase("y");
                if (hasOneGameGuide) {
                    oneGameOutputView.gameGuide();
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
                String scissorsFromPaperInput = oneGameInputView.gameInput();

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

    private void reStartAction(User user) {

        while (true) {
            try {
                String reStartGameInput = totalGameInputView.inputReStartGame(user);
                String reStratGameResult = YesNoInputValidate.start(reStartGameInput);

                boolean hasReStartGame = reStratGameResult.equalsIgnoreCase("y");
                if (hasReStartGame) {
                    oneGameCount = 0;
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}