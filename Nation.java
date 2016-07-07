package com.company;

import java.util.Random;

/**
 * Created by diegobustamante on 3/9/15.
 */
public class Nation{
    private int villagers;
    private int bushmaize;
    private int acres;
    private int landvalue;
    private int starved;
    private int villagersentered;
    private int villagersleft;
    private int rats;
    private int goodharvest;
    private int plantseed;
    private int harvestgenerator;
    private int added;
    private int feeded;


    public Nation(int villagers, int bushmaize, int acres, int landvalue)
    {
        this.villagers = villagers;
        this.bushmaize = bushmaize;
        this.acres = acres;
        this.landvalue = landvalue;

    }

    /**
     * This will return the harvest per acre
     * @return
     */
    public int getBushPerAcre()
    {
        return harvestgenerator;
    }

    /**
     * This will add acres that user bought
     * @param addacres
     */
    public void addAcres(int addacres)
    {
        added = addacres;
        acres = acres + addacres;
    }

    /**
     *This will sell users acres and add
     * bushels to bushels stored from the profit
     * @param sellacres
     */
    public void sellAcres(int sellacres)
    {
        acres = acres - sellacres;
        bushmaize = bushmaize + 2*acres;
    }

    /**
     *This adds the amount of the user planted seeds
     * @param plantseeds
     */
    public void plantSeeds(int plantseeds)
    {
        plantseed = plantseed + plantseeds;
    }

    /**
     * This returns the amount of bushels rats destroyed
     * @return
     */
    public int getRatsDestroyed()
    {
        return rats;
    }

    //
    public int getEntered()
    {
        return villagersentered;
    }

    /**
     * This returns the amount of villagers left
     * @return
     */
    public int getLefted()
    {
        return villagersleft;
    }

    /**
     * This returns the amount of villagers starved
     * @return
     */
    public int getStarved()
    {

        return starved;
    }

    /**
     * This returns amount user fed to villagers
     * @return
     */
    public int getFeed()
    {
        return feeded;
    }


    /**
     * This returns the amount of villagers
     * @return
     */
    public int getPopulation()
    {
        villagers = villagers - starved;
        villagers = villagers - villagersleft;
        villagers = villagers + villagersentered;
        return villagers;
    }

    /**
     * This returns the good harvest amount
     * @return
     */
    public int getGoodharvest()
    {
        return goodharvest;
    }

    /**
     * This returns amount of bushels stored
     * @return
     */
    public int getBushStored()
    {
        bushmaize = goodharvest + bushmaize;
        return bushmaize;
    }

    /**
     * This returns amount of acres
     * @return
     */
    public int getAcres()
    {
        return acres;
    }

    /**
     * This returns value of land
     * @return
     */
    public int getLandValue()
    {
        return landvalue;
    }

    /**
     *
     * @param feed
     */
    public void Update(int buy,int feed,int seed)
    {

        bushmaize = bushmaize -(2*added);
        Random generator = new Random();
        int randomInteger = generator.nextInt(15)+1;
        if(randomInteger == 15)
        {
            villagers = villagers*(70/100);
            villagersleft = villagersleft*(80/100);
            System.out.println("A bad a drought occurred this year. Which killed 30% of your " +
                    "villagers and 20% of your villagers left");
        }



        /**
         * Will update how many
         * villagers starved
         */
        int alive = (feed/20);
        starved = villagers - alive;
        feeded = feed;


        /**
         * Will update how many villagers
         * entered
         */
        if(bushmaize>4500 && starved == 0 )
        {
            villagersentered = (((20 * acres) + bushmaize)/(100 * villagers)) + (3);
        }

        /**
         * Will update how many villagers left
         */
        if(bushmaize<2000 && villagersentered == 0)
        {
            villagersleft = (((20 * acres) + bushmaize) / (100 * villagers)) + (3);
        }

        /**
         * Will generate the good harvest
         */
        int harvestgen = generator.nextInt(8) + 1;
        goodharvest =  plantseed * harvestgen;
        harvestgenerator = harvestgen;

        /**
         * Computes the the probability of rats destroying harvest
         * and computes the amount they destroyed
         */
        int ratinfestation = generator.nextInt(100)+1;
        if(ratinfestation < 50)
        {
            int ratamount = 4 + generator.nextInt(400)+1;
            int ratseats = (ratamount)*bushmaize;
            int ratseats2 = ratseats/1000;
            rats = bushmaize - ratseats2;
        }

        /**
         * Will update how much
         * the land value is
         */
        if(acres >= 1100)
        {
            landvalue = 26;
        }
        else if(acres >= 1085)
        {
            landvalue = 25;
        }
        else if(acres >= 1070)
        {
            landvalue = 24;
        }
        else if(acres >= 1055)
        {
            landvalue = 23;
        }
        else if(acres >= 1030)
        {
            landvalue = 22;
        }
        else if(acres >= 1010)
        {
            landvalue = 21;
        }
        else if (acres >= 1000)
        {
            landvalue = 20;
        }
        else if(acres <= 1000 && villagers <= 200)
        {
            landvalue = 19;
        }
        else if(acres <= 1000 && villagers <= 150)
        {
            landvalue = 18;
        }
        else if(acres <= 1000 && villagers <= 100)
        {
            landvalue = 17;
        }




    }
}
