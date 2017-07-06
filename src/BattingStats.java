import java.util.Scanner;

/**
 * Created by michaelgleeson on 7/5/17.
 */
public class BattingStats {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String repeat = null;

        System.out.println("Let's calculate your Batting Average and Slugging Percentage!");


        do {
            System.out.print("What is the player's name?: ");
            String name = scnr.next();
            int atBats;

            System.out.print(name + ", How many at bats do you have? ");
            atBats = scnr.nextInt();
            while (atBats < 0) {
                System.out.print("Invalid Input. Please try again: ");
                atBats = scnr.nextInt();
            }

            int[] batsArray = new int[atBats];

            fillArray(scnr, batsArray);

            double basesTotal = 0;
            for (int i = 0; i < batsArray.length; i++) {
                basesTotal = basesTotal + batsArray[i];
            }

            double hits = 0;
            double hitsSingles = 0;
            double hitsDoubles = 0;
            double hitsTriples = 0;
            double hitsHR = 0;
            for (int j = 0; j < batsArray.length; j++) {
                if (batsArray[j] <=0) {

                } else {
                    hits += 1;
                }
                if (batsArray[j] == 1) {
                    hitsSingles = hitsSingles + 1;
                }
                if (batsArray[j] == 2) {
                    hitsDoubles += 1;
                }
                if (batsArray[j] == 3) {
                    hitsTriples += 1;
                }
                if (batsArray[j] == 4) {
                    hitsHR += 1;
                }
            }


              double batAvg = hits / atBats;


            //Formula for Slugging Percentage
//        ([Singles] + [Doubles x 2] + [Triples x 3] + [Home Runs x 4])/[At Bats]
            double slugPercent = ((hitsSingles) + (hitsDoubles * 2) + (hitsTriples * 3) + (hitsHR * 4)) / atBats;


            System.out.printf(name + ", your Batting average is: " + "%.3f", batAvg);
            System.out.println();

            System.out.printf("Your Slugging Percentage is: " + "%.3f", slugPercent);
            System.out.println();

            System.out.print("Would you like to find another player's stats? Y/N: ");
            repeat = scnr.nextLine();

            while (!repeat.equalsIgnoreCase("Y") && (!repeat.equalsIgnoreCase("N"))) {
                System.out.print("Invalid Input. Check another player's stats? Y/N: ");
                repeat = scnr.nextLine();
            }


        } while (repeat.equalsIgnoreCase("y"));
        System.out.println("Thanks for playing. Good bye!");

    }

    public static void fillArray(Scanner scnr, int[] batsArray) {
        int numOfBases = 0;
        System.out.println("0 - No bases\n1 - Single\n2 - Double\n3 - Triple\n4 - Home Run");
        for (int i = 0; i < batsArray.length; i++) {
            System.out.print("How many bases did you get during at-bat #" + (i + 1) + "?: ");
            numOfBases = scnr.nextInt();

            while (numOfBases < 0 | numOfBases > 4) {
                System.out.print("Invalid Input. Please try again: ");
                numOfBases = scnr.nextInt();
            }
            batsArray[i] = numOfBases;
        }
    }
}

