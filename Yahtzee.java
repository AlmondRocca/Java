import java.util.Scanner;
public class Yahtzee {
    public static void main(String[] args) {
        AllDice allDice = new AllDice();
        Scanner sc = new Scanner(System.in);
        coreGameLoop(sc, allDice);

    }

    public static void coreGameLoop(Scanner sc, AllDice allDice)
    {
        String diceToKeep;
        for(int i = 0; i < 3; i++)
        {
            allDice.rollAll();
            System.out.println("Choose which dice to keep (ex. for dice 1, 3, 4 type 1 3 4)");
            allDice.printAll();
            diceToKeep = sc.nextLine();

        }
    }
}
