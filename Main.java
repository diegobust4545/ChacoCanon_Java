package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner level = new Scanner(System.in);
        System.out.println("Choose game difficulty of 1 for the easiest level, 2 for the medium difficulty or 3 for a challenge Hard");
        int leveldiff = level.nextInt();
        while(leveldiff<0)
        {
            System.out.println("Please select a value of 1-3 to choose your difficulty");
            int leveldiff2 = level.nextInt();
            leveldiff = leveldiff2;
        }
        while(leveldiff>3 || leveldiff<0)
        {
            System.out.println("Please select a value of 1-3 to choose your difficulty");
            int leveldiff3 = level.nextInt();
            leveldiff = leveldiff3;
        }
        if (leveldiff == 1)
        {
            /**
             * Prints out the directions for the game
             */
            System.out.println("Congratulations, you are the newest leader of ancient Chaco Canyon, elected\n" +
                    "for a ten year term of office. Your duties are to dispense food, direct\n" +
                    "farming, and buy and sell land as needed to support your people. Watch\n" +
                    "out for rat infestations and the drought! Maize is the general currency,\n" +
                    "measured in bushels. The following will help you in your decisions:\n" +
                    "\n" +
                    "  * Each person needs at least 20 bushels of maize per year to survive.\n" +
                    "\n" +
                    "  * Each person can farm at most 10 acres of land.\n" +
                    "\n" +
                    "  * It takes 2 bushels of maize to farm an acre of land.\n" +
                    "\n" +
                    "  * The market price for land fluctuates yearly.\n" +
                    "\n" +
                    "Rule wisely and you will be showered with appreciation at the end of \n" +
                    "your term. Rule poorly and you will be kicked out of office!");
            System.out.println();


            int year = 1000;
            Nation chaco = new Nation(100, 3000, 1000, 20);
            Scanner scan = new Scanner(System.in);

            /**
             * Implements the yearly loop cycle for the game
             * results for the game
             */
            for (int i = 0; i < 1001; i++) {
                System.out.println("O great Chaco Leader, I beg to report to you,");
                System.out.println("In the year " + year + " ,"
                        + chaco.getStarved() + " people starved to death,"
                        + chaco.getLefted() + " people left our nation,"
                        + chaco.getEntered() + " people \nentered our nation.");
                System.out.println("The population is now " + chaco.getPopulation() + ".");
                System.out.println("The nation now owns " + chaco.getAcres() + " acres.");
                System.out.println("We harvested " + chaco.getGoodharvest() + " bushels at " + chaco.getBushPerAcre() + " bushels per acre.");
                System.out.println("Rats destroyed " + chaco.getRatsDestroyed() + " bushels, leaving " + chaco.getBushStored() + " bushels in storage.");
                System.out.println("Land is currently worth " + chaco.getLandValue() + " bushels per acre.");
                System.out.println();

                /**
                 * Will ask the user an
                 * input of how man acres
                 * they wish to purchase
                 */
                System.out.println("How many acres do you wish to buy?: ");
                int acres = scan.nextInt();
                while ((chaco.getAcres() * 2) < (acres * 2) || (acres * 2) < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many acres do you wish to plant with seed?: ");
                    int acres2 = scan.nextInt();
                    acres = acres2;

                }

                chaco.addAcres(acres);


                /**
                 * If user enters zero
                 * he will be asked this
                 * follow up question
                 */
                if (acres == 0) {
                    System.out.println("How many acres do you wish to sell?: ");
                    int acressell = scan.nextInt();
                    chaco.sellAcres(acressell);
                }

                /**
                 * Will ask user an input of
                 * how many bushels of maize
                 * they wish to feed their people
                 */
                System.out.println("How many bushels of maize do you wish to feed your people?: ");
                int bushels = scan.nextInt();
                while (chaco.getBushStored() < bushels || bushels < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many bushels of maize do you wish to feed your people?: ");
                    int bushels2 = scan.nextInt();
                    bushels = bushels2;
                }

                /**
                 * Will ask user an input of
                 * how many acres
                 * they wish to plant
                 */
                System.out.println("How many acres do you wish to plant with seed?: ");
                int plantseeds = scan.nextInt();
                chaco.plantSeeds(plantseeds);


                System.out.println();

                /**
                 * This method will update all
                 * the variables after the year is complete
                 */
                chaco.Update(acres, bushels, plantseeds);


                /**
                 * If feed is less than 45% of
                 * what the villagers need, this will
                 * terminate the program
                 */
                if (chaco.getFeed() <= 900) {
                    System.out.println("45% or more of your village population has starved. Your current population is: " + chaco.getPopulation() +
                            " Your village has started a revolution and is throwing you out of office");
                    System.exit(0);
                }

                year = year + 1;
                i = i + 1;


                /**
                 * Once the year finally loops to
                 * 1010, this will give the user a
                 * final summary of his results and
                 * terminate the game
                 */
                if (year == 1010) {
                    System.out.println("Outstanding job!, You managed to obtain " + chaco.getAcres() + " acres of land," +
                            "grow your village to " + chaco.getPopulation() + " of villagers, and your land value is worth " +
                            +chaco.getLandValue() + ". You led your village well!");
                    System.exit(0);

                }

            }


        }
        if (leveldiff == 2)
        {
            /**
             * Prints out the directions for the game
             */
            System.out.println("Congratulations, you are the newest leader of ancient Chaco Canyon, elected\n" +
                    "for a ten year term of office. Your duties are to dispense food, direct\n" +
                    "farming, and buy and sell land as needed to support your people. Watch\n" +
                    "out for rat infestations and the drought! Maize is the general currency,\n" +
                    "measured in bushels. The following will help you in your decisions:\n" +
                    "\n" +
                    "  * Each person needs at least 20 bushels of maize per year to survive.\n" +
                    "\n" +
                    "  * Each person can farm at most 10 acres of land.\n" +
                    "\n" +
                    "  * It takes 2 bushels of maize to farm an acre of land.\n" +
                    "\n" +
                    "  * The market price for land fluctuates yearly.\n" +
                    "\n" +
                    "Rule wisely and you will be showered with appreciation at the end of \n" +
                    "your term. Rule poorly and you will be kicked out of office!");
            System.out.println();


            int year = 1000;
            Nation chaco = new Nation(750, 2000, 500, 20);
            Scanner scan = new Scanner(System.in);

            /**
             * Implements the yearly loop cycle for the game
             * results for the game
             */
            for (int i = 0; i < 1010; i++) {
                System.out.println("O great Chaco Leader, I beg to report to you,");
                System.out.println("In the year " + year + " ,"
                        + chaco.getStarved() + " people starved to death,"
                        + chaco.getLefted() + " people left our nation,"
                        + chaco.getEntered() + " people \nentered our nation.");
                System.out.println("The population is now " + chaco.getPopulation() + ".");
                System.out.println("The nation now owns " + chaco.getAcres() + " acres.");
                System.out.println("We harvested " + chaco.getGoodharvest() + " bushels at " + chaco.getBushPerAcre() + " bushels per acre.");
                System.out.println("Rats destroyed " + chaco.getRatsDestroyed() + " bushels, leaving " + chaco.getBushStored() + " bushels in storage.");
                System.out.println("Land is currently worth " + chaco.getLandValue() + " bushels per acre.");
                System.out.println();

                /**
                 * Will ask the user an
                 * input of how man acres
                 * they wish to purchase
                 */
                System.out.println("How many acres do you wish to buy?: ");
                int acres = scan.nextInt();
                while ((chaco.getAcres() * 2) < (acres * 2) || (acres * 2) < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many acres do you wish to plant with seed?: ");
                    int acres2 = scan.nextInt();
                    acres = acres2;

                }

                chaco.addAcres(acres);


                /**
                 * If user enters zero
                 * he will be asked this
                 * follow up question
                 */
                if (acres == 0) {
                    System.out.println("How many acres do you wish to sell?: ");
                    int acressell = scan.nextInt();
                    chaco.sellAcres(acressell);
                }

                /**
                 * Will ask user an input of
                 * how many bushels of maize
                 * they wish to feed their people
                 */
                System.out.println("How many bushels of maize do you wish to feed your people?: ");
                int bushels = scan.nextInt();
                while (chaco.getBushStored() < bushels || bushels < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many bushels of maize do you wish to feed your people?: ");
                    int bushels2 = scan.nextInt();
                    bushels = bushels2;
                }

                /**
                 * Will ask user an input of
                 * how many acres
                 * they wish to plant
                 */
                System.out.println("How many acres do you wish to plant with seed?: ");
                int plantseeds = scan.nextInt();
                chaco.plantSeeds(plantseeds);


                System.out.println();

                /**
                 * This method will update all
                 * the variables after the year is complete
                 */
                chaco.Update(acres, bushels, plantseeds);


                /**
                 * If feed is less than 45% of
                 * what the villagers need, this will
                 * terminate the program
                 */
                if (chaco.getFeed() <= 900) {
                    System.out.println("45% or more of your village population has starved: " + chaco.getPopulation() +
                            ". Your village has started a revolution and is throwing you out of office");
                    System.exit(0);
                }

                year = year + 1;
                i = i + 1;


                /**
                 * Once the year finally loops to
                 * 1010, this will give the user a
                 * final summary of his results and
                 * terminate the game
                 */
                if (year == 1010) {
                    System.out.println("Outstanding job!, You managed to obtain " + chaco.getAcres() + " acres of land," +
                            "grow your village to " + chaco.getPopulation() + " of villagers, and your land value is worth " +
                            +chaco.getLandValue() + ". You led your village well!");
                    System.exit(0);

                }

            }


        }
        if (leveldiff == 3)
        {
            /**
             * Prints out the directions for the game
             */
            System.out.println("Congratulations, you are the newest leader of ancient Chaco Canyon, elected\n" +
                    "for a ten year term of office. Your duties are to dispense food, direct\n" +
                    "farming, and buy and sell land as needed to support your people. Watch\n" +
                    "out for rat infestations and the drought! Maize is the general currency,\n" +
                    "measured in bushels. The following will help you in your decisions:\n" +
                    "\n" +
                    "  * Each person needs at least 20 bushels of maize per year to survive.\n" +
                    "\n" +
                    "  * Each person can farm at most 10 acres of land.\n" +
                    "\n" +
                    "  * It takes 2 bushels of maize to farm an acre of land.\n" +
                    "\n" +
                    "  * The market price for land fluctuates yearly.\n" +
                    "\n" +
                    "Rule wisely and you will be showered with appreciation at the end of \n" +
                    "your term. Rule poorly and you will be kicked out of office!");
            System.out.println();


            int year = 1000;
            Nation chaco = new Nation(50, 1000, 400, 20);
            Scanner scan = new Scanner(System.in);

            /**
             * Implements the yearly loop cycle for the game
             * results for the game
             */
            for (int i = 0; i < 1010; i++) {
                System.out.println("O great Chaco Leader, I beg to report to you,");
                System.out.println("In the year " + year + " ,"
                        + chaco.getStarved() + " people starved to death,"
                        + chaco.getLefted() + " people left our nation,"
                        + chaco.getEntered() + " people \nentered our nation.");
                System.out.println("The population is now " + chaco.getPopulation() + ".");
                System.out.println("The nation now owns " + chaco.getAcres() + " acres.");
                System.out.println("We harvested " + chaco.getGoodharvest() + " bushels at " + chaco.getBushPerAcre() + " bushels per acre.");
                System.out.println("Rats destroyed " + chaco.getRatsDestroyed() + " bushels, leaving " + chaco.getBushStored() + " bushels in storage.");
                System.out.println("Land is currently worth " + chaco.getLandValue() + " bushels per acre.");
                System.out.println();

                /**
                 * Will ask the user an
                 * input of how man acres
                 * they wish to purchase
                 */
                System.out.println("How many acres do you wish to buy?: ");
                int acres = scan.nextInt();
                while ((chaco.getAcres() * 2) < (acres * 2) || (acres * 2) < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many acres do you wish to plant with seed?: ");
                    int acres2 = scan.nextInt();
                    acres = acres2;

                }

                chaco.addAcres(acres);


                /**
                 * If user enters zero
                 * he will be asked this
                 * follow up question
                 */
                if (acres == 0) {
                    System.out.println("How many acres do you wish to sell?: ");
                    int acressell = scan.nextInt();
                    chaco.sellAcres(acressell);
                }

                /**
                 * Will ask user an input of
                 * how many bushels of maize
                 * they wish to feed their people
                 */
                System.out.println("How many bushels of maize do you wish to feed your people?: ");
                int bushels = scan.nextInt();
                while (chaco.getBushStored() < bushels || bushels < 0) {
                    System.out.println("O honorable leader, Think again, You only have\n" +
                            +chaco.getBushStored() + " bushels of maize.");
                    System.out.println("Now then, How many bushels of maize do you wish to feed your people?: ");
                    int bushels2 = scan.nextInt();
                    bushels = bushels2;
                }

                /**
                 * Will ask user an input of
                 * how many acres
                 * they wish to plant
                 */
                System.out.println("How many acres do you wish to plant with seed?: ");
                int plantseeds = scan.nextInt();
                chaco.plantSeeds(plantseeds);


                System.out.println();

                /**
                 * This method will update all
                 * the variables after the year is complete
                 */
                chaco.Update(acres, bushels, plantseeds);


                /**
                 * If feed is less than 45% of
                 * what the villagers need, this will
                 * terminate the program
                 */
                if (chaco.getFeed() <= 900) {
                    System.out.println("45% or more of your village population has starved: " + chaco.getPopulation() +
                            ". Your village has started a revolution and is throwing you out of office");
                    System.exit(0);
                }

                year = year + 1;
                i = i + 1;


                /**
                 * Once the year finally loops to
                 * 1010, this will give the user a
                 * final summary of his results and
                 * terminate the game
                 */
                if (year == 1010) {
                    System.out.println("Outstanding job!, You managed to obtain " + chaco.getAcres() + " acres of land," +
                            "grow your village to " + chaco.getPopulation() + " of villagers, and your land value is worth " +
                            +chaco.getLandValue() + ". You led your village well!");
                    System.exit(0);

                }

            }


        }
    }
}