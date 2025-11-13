package staepGame;


import staepGame.level1.controller.OneGameController;
import staepGame.level2.controller.TwoGameController;
import staepGame.total.repository.UserRepository;

public class Application {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

//        OneGameController oneGameController = new OneGameController(userRepository);
//        oneGameController.run();

        TwoGameController twoGameController = new TwoGameController(userRepository);
        twoGameController.run();
    }

}
