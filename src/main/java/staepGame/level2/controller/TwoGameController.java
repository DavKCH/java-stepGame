package staepGame.level2.controller;


import camp.nextstep.edu.missionutils.Randoms;
import staepGame.level1.model.OneGameAction;
import staepGame.level1.view.OneGameInputView;
import staepGame.level1.view.OneGameOutputView;
import staepGame.level2.view.TwoGameInputView;
import staepGame.level2.view.TwoGameOutputView;
import staepGame.total.model.StepRank;
import staepGame.total.model.User;
import staepGame.total.repository.UserRepository;
import staepGame.total.validate.UserNameValidate;
import staepGame.total.validate.UserRcpActionValidate;
import staepGame.total.validate.UserScissorsFromPaperInputValidate;
import staepGame.total.validate.YesNoInputValidate;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import java.util.List;

import static staepGame.total.model.GameCompete.WIN;


public class TwoGameController {

    private final TwoGameInputView twoGameInputView;
    private final TwoGameOutputView twoGameOutputView;

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final UserRepository userRepository;

    private static final int TWO_GAME_LAST = 8;
    private int twoGameCount = 0;

    public TwoGameController(UserRepository userRepository) {

        this.totalGameInputView = new TotalGameInputView();
        this.totalGameOutputView = new TotalGameOutputView();

        this.twoGameInputView = new TwoGameInputView();
        this.twoGameOutputView = new TwoGameOutputView();

        this.userRepository = userRepository;
    }

    public void run() {
        
    }

}