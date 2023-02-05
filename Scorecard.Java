/*
 *This class totals up the scores at the end of the game. 
*/

public class Scorecard{
    private int totalPoints; //probably will be used in next project.
    private int[] currentHand; //copy 

    public Scorecard(int[] handFromAllDice)
    {
        this.totalPoints = 0;
        //verify that the line below works.
        System.arraycopy(handFromAllDice, 0, currentHand, 0, handFromAllDice.length);
        currentHand.sort();
    }

    private sortHand()
    {
        currentHand.sort();
    }



    public calculateScores()
    {

    }


}