package controllers;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class ProductsController {
    static HashMap<Integer, Product> productRepo = new HashMap<>();

    static {
        Product corn = new Product();
        corn.setId(1);
        corn.setCrop("corn");
        corn.setName("usa michigan corn");
        productRepo.put(1, corn);

        Product soy = new Product();
        soy.setId(2);
        soy.setCrop("soy");
        soy.setName("usa nebraska soy");
        productRepo.put(2, soy);
    }

    @RequestMapping("/")
    public String index() { return "index";}


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Product product)
    {
        ModelAndView modelandView = new ModelAndView();
        modelandView.setViewName("product-data");
        modelandView.addObject("product", product);
        return modelandView;
    }

    @RequestMapping(value="/viewById", method = RequestMethod.GET)
    public ModelAndView viewById( @RequestParam(value = "id", required = true) Integer id)
    {
        ModelAndView modelandView = new ModelAndView();
        modelandView.setViewName("product-data");
        modelandView.addObject("product", productRepo.get(id));
        return modelandView;
    }

}
