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

            //승리
            // 가위 승리
            if (userOneGameResult == SCISSORS.getResult() && comOneGameResult == PAPER.getResult()) {
                System.out.println("이겼 습니다.");
                System.out.println("사용자: " + SCISSORS.getKoreaStr() + " 컴퓨터: " + PAPER.getKoreaStr());
                break;
            }

            // 묵 승리
            if ((userOneGameResult == ROCK.getResult()) && (comOneGameResult == SCISSORS.getResult())) {
                System.out.println("이겼 습니다.");
                System.out.println("사용자: " + ROCK.getKoreaStr() + " 컴퓨터: " + SCISSORS.getKoreaStr());
                break;
            }

            // 보 승리
            if ((userOneGameResult == PAPER.getResult()) && (comOneGameResult == ROCK.getResult())) {
                System.out.println("이겼 습니다.");
                System.out.println("사용자: " + PAPER.getKoreaStr() + " 컴퓨터: " + ROCK.getKoreaStr());
                break;
            }


            // 패배
            // 가위 패배
            if (userOneGameResult == SCISSORS.getResult() && comOneGameResult == ROCK.getResult()) {
                System.out.println("졌습니다.");
                System.out.println("사용자: " + PAPER.getKoreaStr() + ", 컴퓨터: " + ROCK.getKoreaStr());
            }

            // 묵 패배
            if ((userOneGameResult == ROCK.getResult()) && (comOneGameResult == PAPER.getResult())) {
                System.out.println("졌습니다");
                System.out.println("사용자: " + SCISSORS.getKoreaStr() + ", 컴퓨터: " + PAPER.getKoreaStr());
            }

            // 보 패배
            if ((userOneGameResult == PAPER.getResult()) && (comOneGameResult == SCISSORS.getResult())) {
                System.out.println("졌습니다");
                System.out.println("사용자: " + PAPER.getKoreaStr() + ", 컴퓨터: " + SCISSORS.getKoreaStr());
            }

            //무승부
            if (userOneGameResult == comOneGameResult) {
                System.out.println("비겼 습니다.");
                if (userOneGameResult == SCISSORS.getResult()) {
                    System.out.println("사용자: " + SCISSORS.getKoreaStr() + ", 컴퓨터: " + SCISSORS.getKoreaStr());
                }

                if (userOneGameResult == ROCK.getResult()) {
                    System.out.println("사용자: " + ROCK.getKoreaStr() + ", 컴퓨터: " + ROCK.getKoreaStr());
                }

                if (userOneGameResult == PAPER.getResult()) {
                    System.out.println("사용자: " + PAPER.getKoreaStr() + ", 컴퓨터: " + PAPER.getKoreaStr());
                }
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
