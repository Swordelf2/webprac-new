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
public class ClientController {

    @Autowired
    ClientService service;

    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/clientList", method = RequestMethod.GET)
    public String clientList(ModelMap map) {
        List<Client> list = service.list();
        map.addAttribute("list", list);
        return "clientList";
    }

    @RequestMapping(value = "/clientList", method = RequestMethod.POST)
    public String clientList(ModelMap map, @RequestParam String name) {
        List<Client> list = service.getByName(name);
        map.addAttribute("list", list);
        return "clientList";
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String client(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "client";
    }

    @RequestMapping(value = "/clientEdit", method = RequestMethod.GET)
    public String clientEdit(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "clientEdit";
    }

    @RequestMapping(value = "/clientEdit", method = RequestMethod.POST)
    public String clientEdit(@ModelAttribute Client client) {
        service.update(client);
        return "redirect:client?id=" + client.getId();
    }

    @RequestMapping(value = "/serviceHistory", method = RequestMethod.GET)
    public String clientServiceHistory(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "serviceHistory";
    }

    @RequestMapping(value = "/clientAccount", method = RequestMethod.GET)
    public String clientAccount(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "clientAccount";
    }
}
