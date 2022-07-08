package main;

import main.model.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.model.Deal;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoListController
{
    @Autowired
    private ToDoListRepository dealRepository;

    @RequestMapping(value = "/deals/", method = RequestMethod.GET)
    public List<Deal> getDeals()
    {
        Iterable<Deal> deals = dealRepository.findAll();
        ArrayList<Deal> allDeals = new ArrayList<>();
        for(Deal deal : deals)
        {
            allDeals.add(deal);
        }

        return allDeals;
    }

    @RequestMapping(value = "/deals/", method = RequestMethod.POST)
    public void setDeal(Deal newDeal)
    {

        dealRepository.save(newDeal);

    }
    @RequestMapping(value = "/deal/{data}", method = RequestMethod.GET)
    public String getOneDeal(@PathVariable String data)
    {

        return dealRepository.findByData(data).get(0).getDeal();
    }
    @DeleteMapping(value = "/deal/{data}")
    public void deleteDeal(@PathVariable String data)
    {
        Deal deal = dealRepository.findByData(data).get(0);
        dealRepository.delete(deal);
    }


}
