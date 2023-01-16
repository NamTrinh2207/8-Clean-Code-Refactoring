public class TennisGame {

    public static String getScore(String playerOneName, String playerTwoName, int playerOneScore, int playerTwoScore) {

        boolean isDraw = playerOneScore == playerTwoScore;
        boolean isEnd = playerOneScore >= 4 || playerTwoScore >= 4;
        if (isDraw) return getGameDrawCalledScore(playerOneScore);
        if (isEnd) return getGameEndCalledScore(playerOneScore, playerTwoScore);

        return  getPlayerCalledScore(playerOneScore)
                +
                "-"
                +
                getPlayerCalledScore(playerTwoScore);
    }

    private static String getGameDrawCalledScore(int drawScore) {
        return switch (drawScore) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
    }

    private static String getGameEndCalledScore(int player1Score, int player2Score) {
        int finalScore = player1Score - player2Score;
        int minusResult = player1Score - player2Score;

        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private static String getPlayerCalledScore(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };

    }
}
