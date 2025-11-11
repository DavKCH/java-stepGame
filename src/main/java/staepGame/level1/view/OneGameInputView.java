package staepGame.level1.view;

import camp.nextstep.edu.missionutils.Console;

public class OneGameInputView {

    private static final String MESSAGE_ONE_GAME_GUIDE = "첫 번째 게임 설명을 들으 시겠습니까? (y,n)";
    private static final String MESSAGE_GAME_DESCRIPTION = "가위(1),바위(2),보(3)를 입력 하시오 - (숫자만 가능)";

    public String gameGuide() {
        System.out.println(MESSAGE_ONE_GAME_GUIDE);
        return Console.readLine();
    }

    public String scissorsFromPaper() {
        System.out.println(MESSAGE_GAME_DESCRIPTION);
        return Console.readLine();
    }
}
