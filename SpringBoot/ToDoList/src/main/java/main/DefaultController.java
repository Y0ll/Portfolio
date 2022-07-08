package main;

import main.model.Deal;
import main.model.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
@Controller
public class DefaultController
{
    @Autowired
    ToDoListRepository dealRepository;
    @RequestMapping(value = "/")
    public String index(Model model)
    {
        Iterable<Deal> deals = dealRepository.findAll();
        ArrayList<Deal> allDeals = new ArrayList<>();
        for(Deal deal : deals)
        {
            allDeals.add(deal);
        }
        model.addAttribute("alldeals", allDeals);
            return "index";
    }
}
