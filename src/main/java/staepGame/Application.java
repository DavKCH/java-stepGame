package staepGame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static staepGame.OneGame.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("========= stepGame start =========");
        System.out.println("단계 게임에 오신것을 환영 합니다.");
        System.out.println("사용자의 이름을 입력 해주세요.");
        String strNameInput = Console.readLine();

        User user = new User(strNameInput);

        System.out.println("첫 번째 게임 설명을 들으 시겠습니까? (y,n)");
        String strOneGameGuideInput = Console.readLine();
        boolean hasOneGameGuide = strOneGameGuideInput.toUpperCase().equals("Y");
        if (hasOneGameGuide) {
            GameGuide.stepOneGuide();
        }

        System.out.println("첫번째 게임을 시작합니다.");
        int oneGameCount = 0;
        while (oneGameCount != 3) {
            System.out.println("가위(1),바위(2),보(3)를 입력 하시오 - (숫자만 가능)");
            String scissorsFromPaper = Console.readLine();
            int userOneGameResult = Integer.parseInt(scissorsFromPaper);
            int comOneGameResult = Randoms.pickNumberInRange(1, 3);

            String gameResult = OneGame.gameResult(userOneGameResult, comOneGameResult);
            OneGame[] oneGames = OneGame.userAndGameAction(userOneGameResult, comOneGameResult);
            String userKoreaStr = oneGames[0].getKoreaStr();
            String comKoreaStr = oneGames[1].getKoreaStr();

            System.out.printf("%s\n", gameResult);
            System.out.printf("사용자: %s, 컴퓨터: %s\n", userKoreaStr, comKoreaStr);
            System.out.println();

            if (gameResult.equals("승리")) {
                break;
            }

            oneGameCount++;
        }

        if (oneGameCount == 3) {
            System.out.println("3번의 기회를 모두 잊어 버렸습니다.");
            System.out.println(user.getName() + "님의 등급은 " + user.getStepRank() + "입니다.");

            return;
        }
        System.out.println("축하 합니다!!!");
        System.out.println("사용자 등급 레벨 업!!");

        System.out.println(user.getName() +"님의 현재 등급: " + user.getStepRank());


    }
}
