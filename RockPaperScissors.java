import java.util.*;

public class RockPaperScissors {
    private static Random rand = new Random();
    private static Scanner sc = new Scanner(System.in);


    private static void ScoreCard(int p1, int p2, String name) {

        System.out.println("\n---- Score card ---- ");
        System.out.println(" " + name + " : " + p1);
        System.out.println("  Computer : " + p2 + "\n");
    }

    private static void result(int p1, int p2) {
        System.out.println("\n---- Result ----");
        if (p1 == p2) {
            System.out.println("Uh oh!");
            System.out.println("It's a Draw!!");
        }
        else if(p1>p2) {
            System.out.println("\tCongratultions!!!!");
            System.out.println("You've won the game by "  + (p1-p2) + "points!");
        }
        else{
            System.out.println("\tWhoopee!!!");
            System.out.println("You've lost the game by " + (p2-p1) + "points!");
            System.out.println("Better luck next time :)");
        }

        
    }

    private static String computerChoice() {

        int ra = (int) rand.nextInt(100, 1000);
        if(ra%10 == 0)
            return "Rock";
        else if (ra%6 == 0)
            return "Paper";
        else
            return "Scissor";

    }

    private static void start() throws InterruptedException {

        int computerPoint = 0;
        int playerPoint = 0;

        System.out.println("------------------------------------------------");
        System.out.println("\tLet's Play Rock, Paper, Scissors !");
        System.out.println("------------------------------------------------");
        Thread.sleep(2000);
        System.out.println("How should i call you?");
        String player = sc.next();
        System.out.println("How many rounds do you need to win " + player + "?");
        Thread.sleep(2000);
        int rounds = sc.nextInt();
        if(rounds<=0) {
            System.out.println("Next time think something positively :)");
            return;
        }
        System.out.println("\n(- Game will be of " + rounds + "rounds -)\n" );

        
        for(int i =1; i<=rounds; i++) {
            System.out.println("---- Round : " + i + " ----");
            System.out.println("\n[Rock, Paper, Scissor]\nType to choose!");
            String playerChoice = sc.next();
            String computerChoice = computerChoice();
            
            if(playerChoice.equalsIgnoreCase(computerChoice)) {
                computerPoint++;
                playerPoint++;
            }

            else if (playerChoice.equalsIgnoreCase("Rock")) {

                if(computerChoice.equalsIgnoreCase("Paper"))
                    computerPoint++;
                else if (computerChoice.equalsIgnoreCase("Scissor"))
                    playerPoint++;
            }

            else if (playerChoice.equalsIgnoreCase("Paper")) {

                if(computerChoice.equalsIgnoreCase("Rock"))
                    playerPoint++;
                else if (computerChoice.equalsIgnoreCase("Scissor"))
                    computerPoint++;
            }
            else if (playerChoice.equalsIgnoreCase("Scissor")) {

                if(computerChoice.equalsIgnoreCase("Paper"))
                    playerPoint++;
                else if (computerChoice.equalsIgnoreCase("Rock"))
                    computerPoint++;
            }
            else {
                System.out.println("Type correctly!");
                --i;
            }
            ScoreCard(playerPoint, computerPoint, player);
        }
        result(playerPoint,computerPoint);

        System.out.println("Do you want to play again?");
        String choice = sc.next();
        if(choice.startsWith("y") || choice.startsWith("Y"))
            start();
        else
            System.out.println("Thanks for playing");
    }

     public static void main(String[] args) throws InterruptedException {
            start();
            

            
     }
}