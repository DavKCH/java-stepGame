package staepGame.level3.view;

import camp.nextstep.edu.missionutils.Console;
import staepGame.total.view.InputView;

public class ThreeGameInputView implements InputView {

    private static final String MESSAGE_THREE_GAME_GUIDE = "세 번째 게임 설명을 들으 시겠습니까? (y,n)";
    private static final String MESSAGE_GAME_DESCRIPTION = "가위(1),바위(2),보(3)를 입력 하시오 - (숫자만 가능)";

    @Override
    public String gameGuide() {
        System.out.println(MESSAGE_THREE_GAME_GUIDE);
        return Console.readLine();
    }

    @Override
    public String gameInput() {
        System.out.println(MESSAGE_GAME_DESCRIPTION);
        return Console.readLine();
    }
}
