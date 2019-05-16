package service;

import dao.CreditDao;
import entities.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditService {
    @Autowired
    CreditDao dao;

    @Transactional
    public int add(Credit credit) {
        return dao.add(credit);
    }

    @Transactional
    public void update(Credit credit) {
        dao.update(credit);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Credit get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Credit> list() {
        return dao.getAll();
    }
}
