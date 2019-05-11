package service;

import dao.ChargeDao;
import entities.Charge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChargeService {
    @Autowired
    ChargeDao dao;

    public int add(Charge charge) {
        return dao.add(charge);
    }

    public void update(Charge charge) {
        dao.update(charge);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Charge get(int id) {
        return dao.get(id);
    }

    public List<Charge> list() {
        return dao.getAll();
    }
}
