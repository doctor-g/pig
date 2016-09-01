package edu.bsu.pig;

import java.util.Scanner;

public final class ConsoleApplication {

    private static Player player1 = new Player("Bonnie");
    private static Player player2 = new Player("Clyde");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game(player1,player2);

        println("Welcome to the Game of Pig");
        while (!game.isOver()) {
           playOneTurn(game);
        }
        printScores();
        println("Game over! The winner is " + game.getWinner().getName());
    }

    private static void playOneTurn(Game game) {
        printScores();
        println("It is " + game.currentPlayer().getName() + "'s turn");
        println("This turn's score is " + game.currentTurn().getScore());
        println("Press enter to roll, q to end turn");
        String line = scanner.nextLine();
        if (line.startsWith("q")) {
            game.endTurn();
        } else {
            game.roll();
        }
    }

    private static void printScores() {
        println(player1.getName() + "'s score is " + player1.getScore());
        println(player2.getName() + "'s score is " + player2.getScore());
    }

    private static void println(String s) {
        System.out.println(s);
    }

}
