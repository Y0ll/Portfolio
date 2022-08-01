package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class DefaultController
{

    @RequestMapping(value = "/")
    public String index()
    {
        Date date = new Date();
        return "String";
    }

}
