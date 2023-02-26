package main;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RockPaperScissors {

    private static final Logger logger = Logger.getLogger(RockPaperScissors.class.getName());

    public static void main(String[] args) {

        try {
            logger.setUseParentHandlers(false);
            FileHandler fileHandler = new FileHandler("bin/log/debug.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.info(String.format("Unable to create file to store logs: %s", e.getMessage()));
        }

        // Initialize the Scanner and print a welcome message
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("WELCOME TO ROCK, PAPER, SCISSORS!");
        System.out.println("*********************************");
        System.out.println("");

        String play = "yes";
        int attempts = 0, wins = 0, losses = 0, ties = 0;

        // Use a while loop and only break the loop if the user wants to quit
        while (!play.equals("no")) {

            // Get the user's move
            System.out.println(
                    "What is your move? To make a move, enter rock, paper, or scissors. To quit the game, enter quit.");
            String userMove = input.nextLine().toLowerCase();

            // Check if the user wants to quit the game
            if (userMove.equals("quit")) {
                logger.info("User wants to quit. Therefore, exiting..");
                break;
            }

            logger.info(String.format("User's move is %s", userMove));

            // Check if the user's move is valid (rock, paper, or scissors)
            if (!checkValidity(userMove)) {
                System.out.println("Your move is not valid! Try again..");
            } else {
                attempts++;
                // Get a random number in between 0 and 3 and convert it to an integer so that
                // the possibilities are 0, 1, or 2
                int rand = (int) (Math.random() * 3);

                // Convert the random number to a string using conditionals and print the
                // opponent's move
                String opponentMove;
                switch (rand) {
                    case 0:
                        opponentMove = "rock";
                        break;
                    case 1:
                        opponentMove = "paper";
                        break;
                    case 2:
                        opponentMove = "scissors";
                        break;
                    default:
                        opponentMove = "";
                }

                logger.info(String.format("Opponent move is %s", opponentMove));

                System.out.println("");
                System.out.println(String.format("Opponent move: %s", opponentMove));
                System.out.println("");

                // Print the results of the round: tie, lose, win
                int result = checkResult(userMove, opponentMove);
                if (result == 0) {
                    ties++;
                    System.out.println("IT'S A TIE!, Wanna play again? Enter yes if you do and no if you don't.");
                    play = input.nextLine().toLowerCase();
                } else if (result == 1) {
                    wins++;
                    System.out.println("YOU WON!, Wanna play again? Enter yes if you do and no if you don't.");
                    play = input.nextLine().toLowerCase();
                } else {
                    losses++;
                    System.out.println("SORRY, YOU LOST!, Wanna Play again? Enter yes if you do and no if you don't.");
                    play = input.nextLine().toLowerCase();
                }

                // Checking whether the user has given a valid input to continue
                while (!play.equals("yes") && !play.equals("no")) {
                    System.out.println("Invalid input! Enter yes if you want to continue playing and no if you don't");
                    play = input.nextLine().toLowerCase();
                }
            }
            if (play.equals("no")) {
                logger.info("User wants to stop playing. Therefore, exiting..");
            }
        }

        // Print a final message for the user
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println(String.format("Rounds played:     %s", attempts));
        System.out.println(String.format("Rounds won:        %s", wins));
        System.out.println(String.format("Rounds lost:       %s", losses));
        System.out.println(String.format("Rounds tied:       %s", ties));
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.println("THANK YOU FOR PLAYING ROCK, PAPER, SCISSORS! SEE YOU SOON..");

        input.close();
    }

    protected static int checkResult(String userMove, String opponentMove) {
        if (!checkValidity(userMove) || !checkValidity(opponentMove)) {
            throw new RuntimeException("Invalid move from either user or opponent or both");
        }
        if (userMove.equals(opponentMove)) {
            return 0;
        }
        if ((userMove.equals("rock") && opponentMove.equals("scissors"))
                || (userMove.equals("scissors") && opponentMove.equals("paper"))
                || (userMove.equals("paper") && opponentMove.equals("rock"))) {
            return 1;
        }
        return 2;
    }

    protected static boolean checkValidity(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

}