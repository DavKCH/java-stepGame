package staepGame.total.validate;

public abstract class UserNameValidate {

    public static String start(String strNameInput) {

        nameNullOrEmpty(strNameInput);
        nameStartNotNum(strNameInput);
        nameInputInvalid(strNameInput);
        nameOutOfRange(strNameInput);

        return strNameInput;
    }

    private static void nameNullOrEmpty(String strNameInput) {

        if (strNameInput == null) {
            throw new IllegalArgumentException();
        }

        strNameInput = strNameInput.trim();
        if (strNameInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void nameStartNotNum(String strNameInput) {

        String falseStr = "^[0-9]*$";
        String strStartNameInput = strNameInput.substring(0, 1);
        if (strStartNameInput.matches(falseStr)) {
            throw new IllegalArgumentException();
        }

    }

    private static void nameInputInvalid(String strNameInput) {

        String replaceName = strNameInput.replace(" ", "");
        if (replaceName.length() != strNameInput.length()) {
            throw new IllegalArgumentException();
        }

        String trueStr = "^[a-zA-Z0-9]*$";
        if (!strNameInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }
    }

    private static void nameOutOfRange(String strNameInput) {
        if (strNameInput.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
