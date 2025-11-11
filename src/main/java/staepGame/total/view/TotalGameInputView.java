package staepGame.total.view;

import camp.nextstep.edu.missionutils.Console;

public class TotalGameInputView {

    public static final String MESSAGE_USER_NAME = "사용자의 이름을 입력 해주세요.";


    public String inputGameStart() {
        System.out.println(MESSAGE_USER_NAME);
        return Console.readLine();
    }
}
