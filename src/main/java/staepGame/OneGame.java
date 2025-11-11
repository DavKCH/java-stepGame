package staepGame;


public enum OneGame {

    SCISSORS(1,"가위"),
    ROCK(2,"바위"),
    PAPER(3,"보");

    private final int result;
    private final String koreaStr;

    OneGame(int result, String koreaStr) {
        this.result = result;
        this.koreaStr = koreaStr;
    }

    public int getResult() {
        return result;
    }

    public String getKoreaStr() {
        return koreaStr;
    }


    public static String gameResult(int userResult, int comResult) {

        if (
                (userResult == SCISSORS.getResult()) && (comResult == PAPER.getResult())
                || (userResult == ROCK.getResult())     && (comResult == SCISSORS.getResult())
                || (userResult == PAPER.getResult())    && (comResult == ROCK.getResult()) ) {

            return "승리";
        }

        if (
                (userResult == SCISSORS.getResult()) && (comResult == ROCK.getResult())
                || (userResult == ROCK.getResult())     && (comResult == PAPER.getResult())
                || (userResult == PAPER.getResult())    && (comResult == SCISSORS.getResult()) ) {

            return "패배";
        }

        if (userResult == comResult) {
            return "무승부";
        }

        return null;
    }

    public static OneGame[] userAndGameAction(int userResult, int comResult) {
        OneGame[] values = values();
        OneGame[] valueResult = new OneGame[2];

        for (OneGame value : values) {
            // 사용자 가 무엇을 냈는지
            if (value.getResult() == userResult) {
                valueResult[0] = value;
            }
            // 컴퓨터 가 무엇을 냈는지
            if (value.getResult() == comResult) {
                valueResult[1] = value;
            }
        }

        return valueResult;
    }


}
