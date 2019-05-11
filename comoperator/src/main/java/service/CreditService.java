package service;

import dao.CreditDao;
import entities.Credit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditService {
    @Autowired
    CreditDao dao;

    public int add(Credit credit) {
        return dao.add(credit);
    }

    public void update(Credit credit) {
        dao.update(credit);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Credit get(int id) {
        return dao.get(id);
    }

    public List<Credit> list() {
        return dao.getAll();
    }
}
