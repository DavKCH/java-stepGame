package staepGame.total.validate;

public abstract class UserRcpActionValidate {

    public static int[] start(String userActionInput, String comActionInput) {

        actionNullOrEmpty(userActionInput);
        actionNotInt(userActionInput);

        int[] result = new int[2];
        result[0] = Integer.parseInt(userActionInput);
        result[1] = Integer.parseInt(comActionInput);

        return result;
    }

    private static void actionNullOrEmpty(String userActionInput) {
        if (userActionInput == null) {
            throw new IllegalArgumentException();
        }

        userActionInput = userActionInput.trim();
        if (userActionInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void actionNotInt(String userActionInput) {

        try {
            Integer.parseInt(userActionInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
