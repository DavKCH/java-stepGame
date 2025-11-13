package staepGame.level2.view;

import camp.nextstep.edu.missionutils.Console;

public class TwoGameInputView {

    private static final String MESSAGE_ONE_GAME_GUIDE = "두 번째 게임 설명을 들으 시겠습니까? (y,n)";
    private static final String MESSAGE_GAME_DESCRIPTION = "1 ~ 100 까지의 숫자를 입력해 주세요.";

    public String gameGuide() {
        System.out.println(MESSAGE_ONE_GAME_GUIDE);
        return Console.readLine();
    }

    public String numInput() {
        System.out.println(MESSAGE_GAME_DESCRIPTION);
        return Console.readLine();
    }
}
