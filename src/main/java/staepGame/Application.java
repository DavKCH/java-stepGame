package staepGame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Application {

    public static void main(String[] args) {
        System.out.println("========= stepGame start =========");
        System.out.println("단계 게임에 오신것을 환영 합니다.");
        System.out.println("사용자의 이름을 입력 해주세요.");
        String strNameInput = Console.readLine();
        String strUserName = nameValidate(strNameInput);

        User user = new User(strUserName);

        System.out.println("첫 번째 게임 설명을 들으 시겠습니까? (y,n)");
        String strOneGameGuideInput = Console.readLine();
        String oneGamedGuide = gameGuideInputValidate(strOneGameGuideInput);
        boolean hasOneGameGuide = oneGamedGuide.equalsIgnoreCase("Y");
        if (hasOneGameGuide) {
            GameGuide.stepOneGuide();
        }

        System.out.println("첫번째 게임을 시작합니다.");
        int oneGameCount = 0;
        while (oneGameCount != 3) {
            System.out.println("가위(1),바위(2),보(3)를 입력 하시오 - (숫자만 가능)");
            String scissorsFromPaperInput = Console.readLine();
            String userActionInput = userInputValidate(scissorsFromPaperInput);
            String comActionInput = String.valueOf(Randoms.pickNumberInRange(1, 3));

            int[] numResults = numValidate(userActionInput, comActionInput);
            int userOneGameResultNum = numResults[0];
            int comOneGameResultNum = numResults[1];

            String gameResult = OneGame.gameResult(userOneGameResultNum, comOneGameResultNum);
            OneGame[] oneGames = OneGame.userAndGameAction(userOneGameResultNum, comOneGameResultNum);
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

    private static String nameValidate(String strNameInput) {

        if (strNameInput == null) {
            throw new IllegalArgumentException();
        }

        strNameInput = strNameInput.trim();
        if (strNameInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String falseStr = "^[0-9]*$";
        String strStartNameInput = strNameInput.substring(0, 1);
        if (strStartNameInput.matches(falseStr)) {
            throw new IllegalArgumentException();
        }

        String replaceName = strNameInput.replace(" ", "");
        if (replaceName.length() != strNameInput.length()) {
            throw new IllegalArgumentException();
        }

        String trueStr = "^[a-zA-Z0-9]*$";
        if (!strNameInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }

        if (strNameInput.length() > 5){
            throw new IllegalArgumentException();
        }

        return strNameInput;
    }

    private static int[] numValidate(String userActionInput, String comActionInput) {
        int[] result = new int[2];

        if (userActionInput == null) {
            throw new IllegalArgumentException();
        }

        userActionInput = userActionInput.trim();
        if (userActionInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            result[0] = Integer.parseInt(userActionInput);
            result[1] = Integer.parseInt(comActionInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private static String userInputValidate(String scissorsFromPaperInput) {

        if (scissorsFromPaperInput == null) {
            throw new IllegalArgumentException();
        }

        scissorsFromPaperInput = scissorsFromPaperInput.trim();
        if (scissorsFromPaperInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (scissorsFromPaperInput.length() > 1){
            throw new IllegalArgumentException();
        }

        String trueStr = "^[1-3]*$";
        if (!scissorsFromPaperInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }

        return scissorsFromPaperInput;

    }

    private static String gameGuideInputValidate(String gameGuideInput) {

        if (gameGuideInput == null) {
            throw new IllegalArgumentException();
        }

        gameGuideInput = gameGuideInput.trim();
        if (gameGuideInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String trueStr = "^[ynYN]*$";
        if (!gameGuideInput.matches(trueStr)) {
            throw new IllegalArgumentException();
        }

        if (gameGuideInput.length() > 1){
            throw new IllegalArgumentException();
        }

        return gameGuideInput;
    }
}
