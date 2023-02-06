import java.util.Arrays;
//maybe do an else make pointsOfEachType 0 to prevent null errors
/*
 * This class takes care of the scoring.
*/
public class Scoring {
    private int totalPoints; //probably will be used in next project.
    private int[] currentHand;
    private int[] eachKind;
    private int[] pointsOfEachType;
    private boolean extraPoints; //next project

    public Scoring()
    {
        this.currentHand = new int[5];
        this.eachKind = new int[6];
        this.pointsOfEachType = new int[13];
        this.totalPoints = 0;
    }

    //addHand sorts the hand too.
    public void addHand(int[] handFromAllDice)
    {
        System.arraycopy(handFromAllDice, 0, currentHand, 0, handFromAllDice.length);
        sortHand();
    }

    private void sortHand()
    {
        Arrays.sort(currentHand);
    }



    public void calculateScores()
    {
        //makes an array with the quantity of each number. ex [3, 3, 4, 5, 6] = [0, 0, 2, 1, 1, 1]
        numOfEachKind();

        //points for each number
        oneThroughSixScores();

        //3 of a kind, 4 of a kind
        ofAKindScores();
        
        //3 of a kind, 2 of another
        fullHouseScores();

        //4 straight 5 straight
        straightsScores();
        
        //5 of a kind
        yahtzee();

        //sum of a hand
        chance();

        //if the first 6 things are >= 63
        //extraPoints(); for the next project probably
    }

    //These methods check for points of each category
    private void chance()
    {
        pointsOfEachType[12] = sumOfHand();
    }

    private int sumOfHand()
    {
        int sum = 0;
        for(int i = 0; i < 5; i++)
        {
            sum += currentHand[i];
        }
        return sum;
    }

    private void yahtzee()
    {
        for(int i = 0; i < 6; i++)
        {
            if(eachKind[i] == 5)
            {
                pointsOfEachType[11] = 50;
            }
        }
    }

    private void fullHouseScores()
    {
        boolean threeFound = false;
        boolean twoFound = false;
        for(int i = 0; i < 6; i++)
        {
            if(eachKind[i] == 3)
            {
                threeFound = true;
            }
            if(eachKind[i] == 2)
            {
                twoFound = true;
            }
        }
        if(twoFound && threeFound)
        {
            pointsOfEachType[8] = 25;
        }
    }

    private void oneThroughSixScores()
    {
        //This could be done in a for loop but why would I? Harder to read.
        pointsOfEachType[0] = eachKind[0];
        pointsOfEachType[1] = eachKind[1] * 2;
        pointsOfEachType[2] = eachKind[2] * 3;
        pointsOfEachType[3] = eachKind[3] * 4;
        pointsOfEachType[4] = eachKind[4] * 5;
        pointsOfEachType[5] = eachKind[5] * 6;
    }

    private void straightsScores()
    {
        //gets 4 and 5 straght
        boolean[] straight = straights();
        if(straight[0])
        {
            pointsOfEachType[9] = 30;
        }
        if(straight[1])
        {
            pointsOfEachType[10] = 40;
        }
    }

    //This adds the scores of 3 of a type and 4 of a type.
    private void ofAKindScores()
    {
        int sum = 0;
        if(threeOfAKind() != -1)
        {
            sum = sumOfHand();
            pointsOfEachType[6] = sum;
            sum = 0;
        }
        if(fourOfAKind() != -1)
        {
            sum = sumOfHand();
            pointsOfEachType[7] = sum;
        }
    }

    //I could comibne 3 and 4 of a kind into one method but that would
    //mean that i'd need to return an array which might make my
    //code more confusing to future me.
    private int fourOfAKind()
    {
        for(int i = 0; i < 6; i++)
        {
            if(eachKind[i] >= 4)
            {
                return i;
            }
        }
        return -1;
    }

    //basically same as four of A kind
    private int threeOfAKind()
    {
        for(int i = 0; i < 6; i++)
        {
            if(eachKind[i] >= 3)
            {
                return i;
            }
        }
        return -1;
    }

    //This should increase the eachKind value @ diceValue by one. If we have a hand
    //of [3,4,6,3,4] eachKind will become [0,0,2,2,0,1]. This is used to then see
    //that eachKind[value] has x number of dice with that side up.
    private void numOfEachKind()
    {
        int diceValue;
        for(int i = 0; i < 5; i++)
        {
            diceValue = currentHand[i];
            eachKind[diceValue - 1] += 1;
        }
    }

    //straight[0] is a straight of 4. straight[1] is a straight of 5
    private boolean[] straights()
    {
        boolean[] straight = {false, false};
        int total = 0;
        for(int i = 0; i < 6; i++)
        {
            if(eachKind[i] >= 1)
            {
                total += 1;
                if(total == 4)
                {
                    straight[0] = true;
                }
                if(total == 5)
                {
                    straight[1] = true;
                }
            }
            else
            {
                total = 0;
            }
        }
        return straight;
    }

    public void dislpayScores()
    {
        //I could make a final String array and use it for the ending text but I really couldn't care less.
        //each number scores
        for(int i = 0; i < 6; i++)
        {
            System.out.println("Score " + pointsOfEachType[i] + " on the " + (i+1) + " line");
        }

        //not even worth a for loop. Pitiful.
        System.out.println("Score " + pointsOfEachType[6] + " on the 3 of a kind line");
        System.out.println("Score " + pointsOfEachType[7] + " on the 4 of a kind line");

        System.out.println("Score " + pointsOfEachType[8] + " on the Full House line");

        System.out.println("Score " + pointsOfEachType[9] + " on the Small Straight line");
        System.out.println("Score " + pointsOfEachType[10] + " on the Large Straight line");

        System.out.println("Score " + pointsOfEachType[11] + " on the Yahtzee line");

        System.out.println("Score " + pointsOfEachType[12] + " on the Chance line");

        System.out.println();
    }
}
