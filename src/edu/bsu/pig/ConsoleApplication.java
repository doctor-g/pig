package edu.bsu.pig;

import java.util.Scanner;

public final class ConsoleApplication {

    public static void main(String[] args) {
        Player player1 = new Player("Bonnie");
        Player player2 = new Player("Clyde");
        Game game = new Game(player1,player2);
        Scanner scanner = new Scanner(System.in);

        println("Welcome to the Game of Pig");
        Turn turn = new Turn(player1, new RolledDie());
        while (!game.isOver()) {
            println(player1.getName() + "'s score is " + player1.getScore());
            println(player2.getName() + "'s score is " + player2.getScore());
            println("It is " + game.currentPlayer().getName() + "'s turn");
            println("Press enter to roll");
            scanner.nextLine();
            turn.roll();

            game.endTurn();
        }

        println("Game over! The winner is " + game.getWinner().getName());
    }

    private static void println(String s) {
        System.out.println(s);
    }

}
