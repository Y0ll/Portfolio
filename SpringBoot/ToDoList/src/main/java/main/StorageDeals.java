package main;

import main.model.Deal;

import java.util.ArrayList;
import java.util.List;

public class StorageDeals
{
    private static ArrayList<Deal> deals = new ArrayList<>();

    public static String setDeals(Deal deal)
    {
        deals.add(deal);
        return "Done";
    }

    public static List<Deal> getDeals()
    {
        return deals;
    }

    public static String getDeal(String data)
    {
        for(Deal deal: deals)
        {
            if(deal.getData().equals(data))
            {return  deal.getDeal();}
        }
        return null;
    }


}
