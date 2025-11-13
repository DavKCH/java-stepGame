package staepGame.level2.controller;


import staepGame.level2.view.TwoGameInputView;
import staepGame.level2.view.TwoGameOutputView;

import staepGame.total.repository.UserRepository;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

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