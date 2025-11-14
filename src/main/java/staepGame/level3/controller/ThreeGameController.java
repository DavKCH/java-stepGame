package staepGame.level3.controller;



import staepGame.level3.view.ThreeGameInputView;
import staepGame.level3.view.ThreeGameOutputView;

import staepGame.total.repository.UserRepository;

import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

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