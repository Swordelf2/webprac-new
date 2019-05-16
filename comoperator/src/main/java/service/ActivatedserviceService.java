package service;

import dao.ActivatedserviceDao;
import entities.Activatedservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActivatedserviceService {
    @Autowired
    ActivatedserviceDao dao;

    @Transactional
    public Activatedservice add(Activatedservice activatedservice) {
        return dao.add(activatedservice);
    }

    @Transactional
    public void update(Activatedservice activatedservice) {
        dao.update(activatedservice);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Activatedservice get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Activatedservice> list() {
        return dao.getAll();
    }
}
