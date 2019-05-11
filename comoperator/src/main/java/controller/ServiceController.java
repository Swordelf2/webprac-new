package controller;

import entities.Activatedservice;
import entities.Client;
import entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ActivatedserviceService;
import service.ClientService;
import service.ServiceService;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    ServiceService service;
    @Autowired
    ClientService clientService;
    @Autowired
    ActivatedserviceService activatedserviceService;

    @RequestMapping(value = "/serviceList", method = RequestMethod.GET)
    public String serviceList(ModelMap map) {
        List<Service> list = service.list();
        map.addAttribute("list", list);
        return "serviceList";
    }

    @RequestMapping(value = "/serviceList", method = RequestMethod.POST)
    public String serviceList(ModelMap map, @RequestParam String name, @RequestParam String description) {
        List<Service> list = service.getByNameAndDescription(name, description);
        map.addAttribute("list", list);
        return "serviceList";
    }

    @RequestMapping(value = "/newService", method = RequestMethod.GET)
    public String newService(ModelMap map, @RequestParam int id) {
        map.addAttribute("client", clientService.get(id));
        return "newService";
    }

    @RequestMapping(value = "/newService", method = RequestMethod.POST)
    public String newService(@RequestParam int clientId,
                             @RequestParam int serviceId,
                             @RequestParam String number,
                             @RequestParam String starttime,
                             @RequestParam String endtime) {
        activatedserviceService.add(new Activatedservice(
                clientService.get(clientId),
                number,
                service.get(serviceId),
                Timestamp.valueOf(starttime), Timestamp.valueOf(endtime)));
        return "redirect:serviceHistory?id=" + clientId;
    }
}
