import java.util.ArrayList;

/*
 * This class takes all 5 dice at the same time to make things easier.
*/

public class AllDice {
    private Die die1; 
    private Die die2; 
    private Die die3; 
    private Die die4; 
    private Die die5; 
    private int diceSidesUp[];
    private ArrayList<Integer> diceToKeep;

    public AllDice()
    {
        this.die1 = new Die();
        this.die2 = new Die();
        this.die3 = new Die();
        this.die4 = new Die();
        this.die5 = new Die();
        diceSidesUp = new int[5];
        diceToKeep = new ArrayList<Integer>();
    }

    public void rollAll()
    {
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
    }

    //unsure if needed. Might use later.
    public int[] getAllSides()
    {
        return diceSidesUp;
    }

    public void updateSidesUp()
    {
        diceSidesUp[0] = die1.getSideUp();
        diceSidesUp[1] = die2.getSideUp();
        diceSidesUp[2] = die3.getSideUp();
        diceSidesUp[3] = die4.getSideUp();
        diceSidesUp[4] = die5.getSideUp();
    }

    public void printAll()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print(diceSidesUp[i] + "\t");
        }
        System.out.println();
    }




    //Roll each die individually
    private void roll1()
    {
        die1.roll();
    }

    private void roll2()
    {
        die2.roll();
    }

    private void roll3()
    {
        die3.roll();
    }

    private void roll4()
    {
        die4.roll();
    }

    private void roll5()
    {
        die5.roll();
    }




    //ArrayList section about diceToKeep
    public void addToKeep(int keep)
    {
        this.diceToKeep.add(keep);
    }
    
    //This function checks to see if diceToKeep DOESNT have a number. It then
    //Calls the rollRemainingSwitch to roll that specific die.
    public void rollRemaining()
    {
        for(int i = 1; i <= 5; i++)
        {
            if(!diceToKeep.contains(i))
            {
                rollRemainingSwitch(i);
            }
        }
    }

    private void rollRemainingSwitch(int i)
    {
        switch(i)
        {
            case 1:
                roll1();
                break;
            case 2:
                roll2();
                break;
            case 3:
                roll3();
                break;
            case 4:
                roll4();
                break;
            case 5:
                roll5();
                break;
        }
    }

    //reset the list after next roll.
    public void clearList()
    {
        this.diceToKeep.clear();
    }
}
