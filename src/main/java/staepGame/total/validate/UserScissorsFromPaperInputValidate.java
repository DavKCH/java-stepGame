package staepGame.total.validate;

public abstract class UserScissorsFromPaperInputValidate {

    public static String start(String scissorsFromPaperInput) {

        userInputNullOrEmpty(scissorsFromPaperInput);
        userInputOutOfRange(scissorsFromPaperInput);

        return scissorsFromPaperInput;
    }

    private static void userInputNullOrEmpty(String scissorsFromPaperInput) {

        if (scissorsFromPaperInput == null) {
            throw new IllegalArgumentException();
        }

        scissorsFromPaperInput = scissorsFromPaperInput.trim();
        if (scissorsFromPaperInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void userInputOutOfRange(String scissorsFromPaperInput) {

        if (scissorsFromPaperInput.length() > 1){
            throw new IllegalArgumentException();
        }

        String trueStr = "^[1-3]*$";
        if (!scissorsFromPaperInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }
    }


}
