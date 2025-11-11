package staepGame;


import staepGame.level1.controller.OneGameController;

public class Application {

    public static void main(String[] args) {

        OneGameController oneGameController = new OneGameController();
        oneGameController.run();
    }

}
