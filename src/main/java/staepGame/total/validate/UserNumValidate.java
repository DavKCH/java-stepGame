package staepGame.total.validate;

public abstract class UserNumValidate {

    public static int start(String strNumInput) {

        numNullOrEmpty(strNumInput);
        numInputInvalid(strNumInput);
        numOutOfRange(strNumInput);

        int num = Integer.parseInt(strNumInput);

        return num;
    }

    private static void numNullOrEmpty(String strNumInput) {

        if (strNumInput == null) {
            throw new IllegalArgumentException();
        }

        strNumInput = strNumInput.trim();
        if (strNumInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void numInputInvalid(String strNumInput) {

        String replaceNum = strNumInput.replace(" ", "");
        if (replaceNum.length() != strNumInput.length()) {
            throw new IllegalArgumentException();
        }

        if (strNumInput.startsWith("0")) {
            throw new IllegalArgumentException();
        }

        String trueStr = "^[0-9]*$";
        if (!strNumInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }
    }

    private static void numOutOfRange(String strNumInput) {
        int num = Integer.parseInt(strNumInput);

        if (!(num >= 1 && num <= 100)) {
            throw new IllegalArgumentException();
        }
    }
}
