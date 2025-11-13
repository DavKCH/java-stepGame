package staepGame.total.view;

import camp.nextstep.edu.missionutils.Console;
import staepGame.total.model.User;

public class TotalGameInputView {

    public static final String MESSAGE_USER_NAME = "사용자의 이름을 입력 해주세요.";
    private static final String MESSAGE_NAME_CHECK = "사용자를 확인 합니다.\n사용자의 이름을 입력 해주세요.";
    private static final String MESSAGE_NOT_NAME_RR_START = "잘못된 이름 입니다.\n다시 이름을 입력 하시 겠습니까? (y,n)";

    public String inputGameStart() {
        System.out.println(MESSAGE_USER_NAME);
        return Console.readLine();
    }

    public String inputReStartGame(User user) {
        System.out.printf("%s 님 다시 게임을 시작 하시겠습니까? (y,n)\n", user.getName());
        return  Console.readLine();
    }

    public String nameCheck() {
        System.out.println(MESSAGE_NAME_CHECK);
        return Console.readLine();
    }

    public String reInputName() {
        System.out.println(MESSAGE_NOT_NAME_RR_START);
        return Console.readLine();
    }

}
