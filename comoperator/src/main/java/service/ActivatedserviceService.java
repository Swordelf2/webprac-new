package service;

import dao.ActivatedserviceDao;
import entities.Activatedservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivatedserviceService {
    @Autowired
    ActivatedserviceDao dao;

    public Activatedservice add(Activatedservice activatedservice) {
        return dao.add(activatedservice);
    }

    public void update(Activatedservice activatedservice) {
        dao.update(activatedservice);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Activatedservice get(int id) {
        return dao.get(id);
    }

    public List<Activatedservice> list() {
        return dao.getAll();
    }
}
