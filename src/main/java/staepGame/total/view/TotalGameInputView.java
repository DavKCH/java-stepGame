package staepGame.total.view;

import java.util.Scanner;

public class TotalGameInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static final String MESSAGE_USER_NAME = "사용자의 이름을 입력 해주세요.";


    public String inputGameStart() {
        System.out.println(MESSAGE_USER_NAME);
        return scanner.nextLine();
    }
}
