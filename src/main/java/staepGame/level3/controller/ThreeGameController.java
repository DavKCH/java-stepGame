package staepGame.level3.controller;



import staepGame.level3.view.ThreeGameInputView;
import staepGame.level3.view.ThreeGameOutputView;

import staepGame.total.model.Com;
import staepGame.total.model.StepRank;
import staepGame.total.model.User;
import staepGame.total.repository.UserRepository;

import staepGame.total.validate.YesNoInputValidate;
import staepGame.total.view.TotalGameInputView;
import staepGame.total.view.TotalGameOutputView;

import java.util.Optional;

public class ThreeGameController {

    private final TotalGameInputView totalGameInputView;
    private final TotalGameOutputView totalGameOutputView;

    private final ThreeGameInputView threeGameInputView;
    private final ThreeGameOutputView threeGameOutputView;

    private final UserRepository userRepository;

    private static final int THREE_GAME_LAST = 20;
    private boolean gameBeforeCheck = true;

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

}