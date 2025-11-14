package staepGame.level3.controller;


import camp.nextstep.edu.missionutils.Randoms;
import staepGame.level1.model.OneGameAction;
import staepGame.level1.view.OneGameInputView;
import staepGame.level1.view.OneGameOutputView;
import staepGame.level3.view.ThreeGameInputView;
import staepGame.level3.view.ThreeGameOutputView;
import staepGame.total.model.StepRank;
import staepGame.total.model.User;
import staepGame.total.repository.UserRepository;
import staepGame.total.validate.UserNameValidate;
import staepGame.total.validate.UserRcpActionValidate;
import staepGame.total.validate.UserScissorsFromPaperInputValidate;
import staepGame.total.validate.YesNoInputValidate;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import static staepGame.total.model.GameCompete.WIN;


public class ThreeGameController {

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final ThreeGameInputView threeGameInputView;
    private final ThreeGameOutputView threeGameOutputView;

    private final UserRepository userRepository;

    private static final int THREE_GAME_LAST = 3;
    private int threeGameCount = 0;

    public ThreeGameController(UserRepository userRepository) {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.threeGameInputView = new ThreeGameInputView();
        this.threeGameOutputView = new ThreeGameOutputView();

        this.userRepository = userRepository;
    }

    public void run() {


    }

}