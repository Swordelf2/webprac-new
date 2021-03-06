package controller;

import entities.*;
import org.hibernate.query.Query;
import service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientService service;
    @Autowired
    DepositService depositService;
    @Autowired
    CreditService creditService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    ServiceService serviceService;

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
        List<Activatedservice> servList = client.getActivatedservices();
        map.addAttribute("client", client);
        map.addAttribute("servList", servList);
        return "serviceHistory";
    }

    @RequestMapping(value = "/serviceHistory", method = RequestMethod.POST)
    public String clientServiceHistory(ModelMap map, @RequestParam String id,
                                                     @RequestParam String starttime,
                                                     @RequestParam String endtime) {
        Client client = service.get(Integer.valueOf(id));
        List<Activatedservice> initList = client.getActivatedservices();
        List<Activatedservice> servList = new ArrayList<Activatedservice>();
        Timestamp t1, t2;
        t1 = Timestamp.valueOf(starttime);
        t2 = Timestamp.valueOf(endtime);
        for (Activatedservice as : initList) {
            if ((as.getEndtime().after(t1) && as.getStarttime().before(t2))) {
                servList.add(as);
            }
        }
        map.addAttribute("client", client);
        map.addAttribute("servList", servList);
        return "serviceHistory";
    }

    @RequestMapping(value = "/clientAccount", method = RequestMethod.GET)
    public String clientAccount(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "clientAccount";
    }

    /* New deposit */

    @RequestMapping(value = "/newDeposit", method = RequestMethod.GET, params = "id")
    public String newDeposit(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "newDeposit";
    }

    @RequestMapping(value = "/newDeposit", method = RequestMethod.GET)
    public String newDeposit() {
        return "newDeposit";
    }

    @RequestMapping(value = "/newDeposit", method = RequestMethod.POST)
    public String newDeposit(@RequestParam int clientId,
                             @RequestParam String sum,
                             @RequestParam String time) {
        Client client = service.get(clientId);
        depositService.add(new Deposit(new BigDecimal(sum), Timestamp.valueOf(time), client));
        return "newDeposit";
    }

    /* New charge */

    @RequestMapping(value = "/newCharge", method = RequestMethod.GET, params = "id")
    public String newCharge(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "newCharge";
    }

    @RequestMapping(value = "/newCharge", method = RequestMethod.GET)
    public String newCharge() {
        return "newCharge";
    }

    @RequestMapping(value = "/newCharge", method = RequestMethod.POST)
    public String newCharge(@RequestParam int clientId,
                            @RequestParam String sum,
                            @RequestParam String time,
                            @RequestParam int serviceId) {
        Client client = service.get(clientId);
        chargeService.add(new Charge(new BigDecimal(sum), Timestamp.valueOf(time), client,
                    serviceService.get(serviceId)));
        return "newCharge";
    }

    /* New credit */

    @RequestMapping(value = "/newCredit", method = RequestMethod.GET, params = "id")
    public String newCredit(ModelMap map, @RequestParam int id) {
        Client client = service.get(id);
        map.addAttribute("client", client);
        return "newCredit";
    }

    @RequestMapping(value = "/newCredit", method = RequestMethod.GET)
    public String newCredit() {
        return "newCredit";
    }

    @RequestMapping(value = "/newCredit", method = RequestMethod.POST)
    public String newCredit(@RequestParam int clientId,
                            @RequestParam String sum,
                            @RequestParam String startdate) {
        Client client = service.get(clientId);
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.valueOf(startdate));
        cal.add(Calendar.DATE, client.getCredittime()); //minus number would decrement the days
        Date enddate = new Date(cal.getTimeInMillis());
        creditService.add(new Credit(new BigDecimal(sum), Date.valueOf(startdate),
                enddate, client));
        return "newCredit";
    }
}
