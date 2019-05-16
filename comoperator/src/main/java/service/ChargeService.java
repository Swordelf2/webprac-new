package service;

import dao.ChargeDao;
import entities.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChargeService {
    @Autowired
    ChargeDao dao;

    @Transactional
    public int add(Charge charge) {
        return dao.add(charge);
    }

    @Transactional
    public void update(Charge charge) {
        dao.update(charge);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Charge get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Charge> list() {
        return dao.getAll();
    }
}
