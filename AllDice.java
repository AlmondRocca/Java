public class AllDice {
    private Die die1; 
    private Die die2; 
    private Die die3; 
    private Die die4; 
    private Die die5; 
    private int diceSidesUp[];
    
    public AllDice()
    {
        this.die1 = new Die();
        this.die2 = new Die();
        this.die3 = new Die();
        this.die4 = new Die();
        this.die5 = new Die();
        diceSidesUp = new int[5];
    }

    public void rollAll()
    {
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
    }

    public int[] getAllSides()
    {
        diceSidesUp[0] = die1.getSideUp();
        diceSidesUp[1] = die2.getSideUp();
        diceSidesUp[2] = die3.getSideUp();
        diceSidesUp[3] = die4.getSideUp();
        diceSidesUp[4] = die5.getSideUp();
        return diceSidesUp;
    }

    public void printAll()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print(diceSidesUp[i] + "\t");
        }
    }

    //make this a generic function if possible
    public void roll1()
    {
        die1.roll();
    }

}
