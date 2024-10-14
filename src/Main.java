import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playAgain = "Y";

        while (playAgain.equalsIgnoreCase("Y")) {
            String moveA = getPlayerMove(in, 'A');
            String moveB = getPlayerMove(in, 'B');

            String winner = determineWinner(moveA, moveB);
            displayResults(moveA, moveB, winner);

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = in.nextLine();
        }

        System.out.println("Thank you for playing!");
        in.close();
    }

    public static String getPlayerMove(Scanner in, char player) {
        String move = "";
        while (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
            System.out.print("Player " + player + ", enter your move (R, P, S): ");
            move = in.nextLine().toUpperCase();
            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        }
        return move;
    }


    public static String determineWinner(String moveA, String moveB) {
        if (moveA.equals(moveB)) {
            return "It's a tie!";
        } else if ((moveA.equals("R") && moveB.equals("S")) ||
                (moveA.equals("P") && moveB.equals("R")) ||
                (moveA.equals("S") && moveB.equals("P"))) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }

    public static void displayResults(String moveA, String moveB, String winner) {
        System.out.println("Player A: " + moveA + " vs Player B: " + moveB + " -> " + winner);

        if (moveA.equals("R") && moveB.equals("S")) {
            System.out.println("Rock breaks Scissors.");
        } else if (moveA.equals("P") && moveB.equals("R")) {
            System.out.println("Paper covers Rock.");
        } else if (moveA.equals("S") && moveB.equals("P")) {
            System.out.println("Scissors cuts Paper.");
        } else if (moveA.equals("R") && moveB.equals("R")) {
            System.out.println("Rock vs Rock, it's a Tie!");
        } else if (moveA.equals("P") && moveB.equals("P")) {
            System.out.println("Paper vs Paper, it's a Tie!");
        } else if (moveA.equals("S") && moveB.equals("S")) {
            System.out.println("Scissors vs Scissors, it's a Tie!");
        }
    }
}
