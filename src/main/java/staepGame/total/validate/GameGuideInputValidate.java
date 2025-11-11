package staepGame.total.validate;

public abstract class GameGuideInputValidate {

    public static String start(String gameGuideInput) {
        guideInputNullOrEmpty(gameGuideInput);
        guideInputNotMatch(gameGuideInput);
        guidInputOutOfRange(gameGuideInput);

        return gameGuideInput;
    }

    private static void guideInputNullOrEmpty (String gameGuideInput) {
        if (gameGuideInput == null) {
            throw new IllegalArgumentException();
        }

        gameGuideInput = gameGuideInput.trim();
        if (gameGuideInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void guideInputNotMatch(String gameGuideInput) {
        String trueStr = "^[ynYN]*$";
        if (!gameGuideInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }
    }

    private static void guidInputOutOfRange(String gameGuideInput) {
        if (gameGuideInput.length() > 1){
            throw new IllegalArgumentException();
        }
    }
}

