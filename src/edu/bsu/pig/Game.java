package edu.bsu.pig;

public final class Game {

    private static final int POINTS_TO_WIN = 100;

    private final Player player1;
    private final Player player2;
    private Player current;
    private Player winner;
    private boolean isOver = false;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.current = player1;
    }

    public Player currentPlayer() {
        return current;
    }

    public void endTurn() {
        if (this.current.getScore() >= POINTS_TO_WIN) {
            this.winner = this.current;
            this.isOver = true;
        }
        this.current = this.current.equals(player1) ? player2 : player1;
    }

    public boolean isOver() {
        return isOver;
    }

    public Player getWinner() {
        return winner;
    }
}
