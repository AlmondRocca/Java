import java.util.Scanner;
public class Yahtzee {
    //Yahtzee has a alldice. I think it needs static though I'm not sure.
    private static AllDice allDice;

    public static void main(String[] args) {
        allDice = new AllDice();
        Scanner sc = new Scanner(System.in);
        while(sc.next().equalsIgnoreCase("y"))
        {
            coreGameLoop(sc); //run this continuously for the thirteen rounds for actual game when i make it.
            System.out.println("Play Again? y/n");
        }
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
            System.out.println("Choose which dice to keep (ex. ynyny to keep 1 3 and 5)");
            allDice.printAll();
            updateDiceToKeep(sc);
            allDice.rollRemaining();
            allDice.clearList();
            System.out.println();
        }
        
        //This is here because if i let the for loop go again it would roll
        //an extra time and ask for which dice to keep.
        System.out.println("Final roll results:");
        allDice.updateSidesUp();
        allDice.printAll();
        System.out.println();

        //ask the user which category to put their score into
    }

    

    public static void calculateScores()
    {

    }



    //This function takes the user input of which dice to keep and splits
    //it into an array using a space as a delimiter. It then sends
    //the value to the alldice object to update the diceToKeep arrayList.
    public static void updateDiceToKeep(Scanner sc)
    {
        String diceToKeep = sc.nextLine();
        int keep;
        String[] diceNumber = diceToKeep.split(" ");


        for(int i = 0; i < diceNumber.length; i++)
        {
            keep = Integer.parseInt(diceNumber[i]);
            allDice.addToKeep(keep);      
        }
    }
}
