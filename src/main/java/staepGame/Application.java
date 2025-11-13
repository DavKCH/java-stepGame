package staepGame;


import staepGame.level1.controller.OneGameController;
import staepGame.total.repository.UserRepository;

public class Application {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        OneGameController oneGameController = new OneGameController(userRepository);
        oneGameController.run();
        UserRepository repository = oneGameController.winUserRepository();


    }

}
