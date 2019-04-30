package controller;

import entities.Client;
import service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    ClientService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap map){
        List<Client> list = service.list();
        map.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(@RequestParam int id) {
        return "info";
    }
}
