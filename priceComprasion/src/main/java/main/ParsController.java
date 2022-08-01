package main;

import main.model.ParsingShop;
import main.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class ParsController
{
    @RequestMapping(value = "/setProduct/", method = RequestMethod.POST)
    public void GetProduct(String nameProduct) throws IOException, InterruptedException {
        Product product = new Product();
        product.setName(nameProduct);
        ParsingShop parsingShop = new ParsingShop(product.getName());

         Thread mvideo = new Thread(() ->
        {
            try {
                parsingShop.parsingMVIDEO();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

       Thread dns = new Thread(() ->
       {
           try {
               parsingShop.parsingDNS();
           } catch (IOException | InterruptedException e) {
               e.printStackTrace();
           }
       });
        mvideo.start();
        mvideo.join();
        dns.start();
        dns.join();

    }


}
