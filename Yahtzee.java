import java.util.Scanner;

public class Yahtzee {
    //Yahtzee has a alldice. I think it needs static though I'm not sure.
    private static AllDice allDice;
    private static Scoring scoreCard;


    public static void main(String[] args) {
        allDice = new AllDice();
        scoreCard = new Scoring();
        Scanner sc = new Scanner(System.in);
        do{
            coreGameLoop(sc); //run this continuously for the thirteen rounds for actual game when i make it.
            System.out.println("Play Again? y/n");
        }
        while(sc.nextLine().equalsIgnoreCase("y"));
        sc.close();
    }



    public static void coreGameLoop(Scanner sc)
    {
        allDice.rollAll(); //get the game started

        //This should print the dice sides up, roll whatever dice the user didn't
        //want to keep, then update the sides up until the turn ends.
        for(int i = 0; i < 2; i++)
        {
            allDice.updateSidesUp();
            System.out.println("Choose which dice to keep (ex. ynyny to keep dice 1 3 and 5)");
            allDice.printAll();
            allDice.addToKeep(sc.nextLine());
            allDice.rollRemaining();
            allDice.clearList();
            System.out.println();
        }
        
        //This is here because if i let the for loop go again it would roll
        //an extra time and ask for which dice to keep.
        System.out.println("Final roll results:");
        allDice.updateSidesUp();
        allDice.printAll();
        allDice.clearList();
        System.out.println();
        
        //now that the round is over it's time to calculate potential scores.
        calculateScores();
        clearScoreBoard();
    }



    //resets the scoreboard for new game.
    public static void clearScoreBoard()
    {
        scoreCard = null;
        scoreCard = new Scoring();
    }
    


    public static void calculateScores()
    {
        scoreCard.addHand(allDice.getAllSides());
        scoreCard.calculateScores();
        scoreCard.dislpayScores();
    }
}
