package staepGame;

public abstract class GameGuide {

    static void stepOneGuide() {
        System.out.println("∥=======================================∥");
        System.out.println("∥\t\t첫 번째 게임 : 가위 바위 보\t\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println("∥\t\t3판을 해서 한판 이라도 이기면 승리\t∥");
        System.out.println("∥\t\t3판을 모두 지면 게임 종료\t\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println();
    }

    static void stepTwoGuide() {
        System.out.println("∥=======================================∥");
        System.out.println("∥\t\t두 번째 게임 : UP and Down\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println("∥\t\t1 ~ 100 의 숫자중 하나 입력 한다.\t∥");
        System.out.println("∥\t\t컴퓨터 정답 에 따라서, 사용자의\t\t∥");
        System.out.println("∥\t\t입력한 숫자가 작으면 'up'을 출력\t∥");
        System.out.println("∥\t\t입력한 숫자가 높으면 'down'을 출력\t∥");
        System.out.println("∥\t\t그것을 반복하고 8번 만에 맞추면 승리\t∥");
        System.out.println("∥\t\t8번이 넘으면 게임이 종료된다.\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println();
    }

    static void stepThreeGuide() {
        System.out.println("∥\t\t세 번째 게임 : 계단 오르기\t\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println("∥\t\t\t가위 바위 보를 한다.\t\t\t∥");
        System.out.println("∥\t\t승리한 자가 3칸을 전진 한다. \t\t∥");
        System.out.println("∥\t\t진 사람은 1칸 뒤로 간다.\t\t\t∥");
        System.out.println("∥\t\t졋으나 처음 계단 이면 그대로 있는다.\t∥");
        System.out.println("∥\t\t총 20칸을 전진 하면 승리 한다.\t\t∥");
        System.out.println("∥=======================================∥");
        System.out.println();
    }
}
