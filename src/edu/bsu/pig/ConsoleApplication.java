package edu.bsu.pig;

import java.util.Scanner;

public final class ConsoleApplication {

    public static void main(String[] args) {
        Player player1 = new Player("Bonnie");
        Player player2 = new Player("Clyde");
        Game game = new Game(player1,player2);
        Scanner scanner = new Scanner(System.in);

        println("Welcome to the Game of Pig");
        while (!game.isOver()) {
            println("It is " + game.currentPlayer().getName() + "'s turn");
            println("Press enter to go on");
            scanner.nextLine();
            game.endTurn();
        }
    }

    private static void println(String s) {
        System.out.println(s);
    }

}
