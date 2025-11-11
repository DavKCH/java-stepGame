package staepGame.level1.controller;



import camp.nextstep.edu.missionutils.Randoms;

import staepGame.level1.model.OneGameAction;

import staepGame.level1.view.OneGameInputView;
import staepGame.level1.view.OneGameOutputView;

import staepGame.total.model.StepRank;
import staepGame.total.model.User;

import static staepGame.total.model.GameCompete.WIN;

import staepGame.total.repository.UserRepository;

import staepGame.total.validate.GameGuideInputValidate;
import staepGame.total.validate.UserNameValidate;
import staepGame.total.validate.UserRcpActionValidate;
import staepGame.total.validate.UserScissorsFromPaperInputValidate;

import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;




public class OneGameController {

    private final OneGameInputView oneGameInputView;
    private final OneGameOutputView oneGameOutputView;

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final UserRepository userRepository;

    private static int ONE_GAME_COUNT = 0;
    private static final int ONE_GAME_LAST = 3;


    public OneGameController() {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.oneGameInputView = new OneGameInputView();
        this.oneGameOutputView = new OneGameOutputView();

        this.userRepository = new UserRepository();
    }

    public void run() {

        totalGameOutputView.gameStartShow();

        String strNameInput = totalGameInputView.inputGameStart();
        String userName = UserNameValidate.start(strNameInput);
        User user = new User(userName);

        String guideInput = oneGameInputView.gameGuide();
        String oneGamedGuide = GameGuideInputValidate.start(guideInput);

        boolean hasOneGameGuide = oneGamedGuide.equalsIgnoreCase("y");
        if (hasOneGameGuide) {
            oneGameOutputView.gameGuideOne();
        }

        oneGameOutputView.oneGameStartBefore();

        while (ONE_GAME_COUNT != ONE_GAME_LAST) {

            String scissorsFromPaperInput = oneGameInputView.scissorsFromPaper();
            String userActionInput = UserScissorsFromPaperInputValidate.start(scissorsFromPaperInput);
            String comActionInput = String.valueOf(Randoms.pickNumberInRange(1, 3));


            int[] numResults = UserRcpActionValidate.start(userActionInput, comActionInput);
            int userOneGameResultNum = numResults[0];
            int comOneGameResultNum = numResults[1];

            String gameResult = OneGameAction.gameResult(userOneGameResultNum, comOneGameResultNum);
            OneGameAction[] oneGames = OneGameAction.userAndGameAction(userOneGameResultNum, comOneGameResultNum);

            oneGameOutputView.oneGameResult(gameResult);
            oneGameOutputView.oneGameUserAndComStatus(user, oneGames);


            if (WIN.getResult().equals(gameResult)) {
                user.setStepRank(StepRank.BRONZE);
                userRepository.add(user);

                return;
            }

            ONE_GAME_COUNT++;
        }

        oneGameOutputView.oneGameLoseStatus(ONE_GAME_LAST);
        totalGameOutputView.gameEndShow(user);
    }

}